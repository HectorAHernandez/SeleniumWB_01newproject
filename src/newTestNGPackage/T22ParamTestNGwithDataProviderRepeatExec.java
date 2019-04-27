package newTestNGPackage;
/* Parameters using Dataprovider
@Parameters annotation is easy but to test with multiple sets of data we need to use Data Provider.
To fill thousand's of web forms using our testing framework we need a different methodology which 
can give us a very large dataset in a single execution flow.

This data driven concept is achieved by @DataProvider annotation in TestNG.
It has only one attribute 'name'. If you do not specify the name attribute then the DataProvider's 
name will be same as the corresponding method name.
Data provider returns a two-dimensional JAVA object to the test method and the test method, will 
invoke M times in a M*N type of object array. For example, if the DataProvider returns an array 
of 2*3 objects, the corresponding testcase will be invoked 2 times with 3 parameters each time.
 * */
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class T22ParamTestNGwithDataProviderRepeatExec {
    WebDriver driver;
    String driverPath = "C:\\selenium-3.11.0\\geckodriver.exe";

    @BeforeTest
    public void setup(){
        //Create firefox driver object
    	System.setProperty("webdriver.gecko.driver", driverPath);
         driver = new FirefoxDriver();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.get("https://google.com");
    }
 
    /** Test case to verify google search box
     * @param author
     * @param searchKey
     * @throws InterruptedException
     */

    @Test(dataProvider="SearchProvider")
    public void testMethod(String author,String searchKey) throws InterruptedException{
    {
        WebElement searchText = driver.findElement(By.name("q"));
        //search value in google searchbox
        searchText.sendKeys(searchKey);
        System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
        Thread.sleep(3000);
        String testValue = searchText.getAttribute("value");
        System.out.println(testValue +"::::"+searchKey);
        searchText.clear();
        //Verify if the value in google search box is correct
        Assert.assertTrue(testValue.equalsIgnoreCase(searchKey));
    }
    }
    /**
     * @return Object[][] where first column contains 'author'
     * and second column contains 'searchKey'
     */

    @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { "Guru99", "India" },
            { "Krishna", "UK" },
            { "Bhupesh", "USA" }
        };

    }

}



