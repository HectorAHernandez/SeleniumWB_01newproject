package newTestNGPackage;
/* This program uses Parameter with DataProvider containing parameters. The types of Parameters supported by
 * Dataprovider are two type: 
 *       1- a Method or 
 *       2- ITestContext- It can use to create different parameters for test cases based on groups.
Below example uses Method, for a situation where the SAME DataProvider should behave differently with different 
@test methods, so we have to use the DataProvider with method as parameter, MAINLY WE USE THE METHOD OPTION WHEN WE
WANT TO SELECT THE PARAMETERS SET OF ROWS, in the returned object[][], depending on WHAT METHOD CALLED THE DATAPROVIDER: 
Also this example has the dataProvider EXTERNAL to the test in class "DataproviderWithMethodAsParameterClass" in
directory "newTestNGPackage"
NOTE: FOR EXECUTING THIS WE DON'T NEED TO CALL THE TEST FROM ANOTHER XML. JUST RUNNING THIS ONE.
 */
	import java.lang.reflect.Method;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.Assert;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	public class T25DataproviderWithParamaterAsMethodEXTERNAL {

	    WebDriver driver;
	    String driverPath = "C:\\selenium-3.11.0\\geckodriver.exe";
	     
	    @BeforeTest
	    public void setup(){
	    	System.setProperty("webdriver.gecko.driver", driverPath);
	    	driver = new FirefoxDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get("https://google.com");
	    }
        @Test(dataProvider="SearchProviderExternalAsMethod",dataProviderClass=DataproviderWithMethodAsParameterClass.class)
	    public void testMethodA(String dataProvAuthor,String dataProvSearchKey) throws InterruptedException{
	        
	    	WebElement searchText = driver.findElement(By.name("q"));
	        //Search text in search box
	        searchText.sendKeys(dataProvSearchKey);
	        //Print author and search string
	        System.out.println("Welcome ->"+dataProvAuthor+" Your search key is->"+dataProvSearchKey);
	        Thread.sleep(3000);
	        String testValue = searchText.getAttribute("value");
	        System.out.println(testValue +"::::"+dataProvSearchKey);
	        searchText.clear();
	        //Verify if google text box is showing correct value
	        Assert.assertTrue(testValue.equalsIgnoreCase(dataProvSearchKey));
	    }
	      
        @Test(dataProvider="SearchProviderExternalAsMethod",dataProviderClass=DataproviderWithMethodAsParameterClass.class)
	    public void testMethodB(String dataProvSearchKey) throws InterruptedException{
	        {
	        	WebElement searchText = driver.findElement(By.name("q"));
	            //Search text in search box
	            searchText.sendKeys(dataProvSearchKey);
	            //Print only search string
	            System.out.println("Welcome ->Unknown user Your search key is->"+dataProvSearchKey);
	            Thread.sleep(3000);
	            String testValue = searchText.getAttribute("value");
	            System.out.println(testValue +"::::"+dataProvSearchKey);
	            searchText.clear();
	            //Verify if google text box is showing correct value
	            Assert.assertTrue(testValue.equalsIgnoreCase(dataProvSearchKey));
	        }
	    }    

	}
