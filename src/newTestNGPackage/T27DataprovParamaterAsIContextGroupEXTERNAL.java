package newTestNGPackage;
/* This program uses Parameter with DataProvider containing parameters. The types of Parameters supported by
 * Dataprovider are two type: 
 *       1- a Method or 
 *       2- ITestContext- It can use to create different parameters for test cases based on groups.
Below example uses ITestContext, for a situation where we need to use to create different parameters for 
test cases based on groups.
In real-life, you can use ITestContext to vary parameter values based on Test Methods, hosts, configurations of the test. 

In the following code example
We have 2 groups A & B
Each test method is assigned to a group
If value of group is A, a particular data set is returned
If value of group is B, another data set is returned
 */
/* Note this test DataProvider EXTERNAL to the test in class 
 * "DataproviderWithMethodAsItTestContextParameterClass"  * in directory "newTestNGPackage".
 * And must be ran from the external XML parameters file "TestNGDataProviderITestcontexEXTERNAL.xml" 
 * Located in directory "SeleniumXML", because the groups are defined there as parameters, also there
 * is where it is indicated which tests are going to be included OR excluded.
 * */

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class T27DataprovParamaterAsIContextGroupEXTERNAL {
	WebDriver driver;
	String driverPath = "C:\\selenium-3.11.0\\geckodriver.exe";
	@BeforeTest(groups={"A","B"})
	public void setup(){
		System.setProperty("webdriver.gecko.driver", driverPath);
		  	driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://google.com");
	}
	
	@Test(dataProvider="SearchProviderExternalAsITestContext",groups="A",dataProviderClass=DataproviderWithITestContextAsParameterClass.class)
	// Each row in the groupArray defined in the EXTERNAL dataProvider is passed to the testMethodA at execution time. 
	// Groups="A" is used to include this test in the XML used to call all the tests to execute, and also to select 
	// groupArray set of data, in the dataProvider, to use for this test execution.
	public void testMethodA(String DataProvAuthor,String DataProvSearchKey) throws InterruptedException{
	//@Test(dataProvider="SearchProvider",groups="A")
	//public void testMethodA(String author,String searchKey) throws InterruptedException{
		{
		  //search google textbox
			WebElement searchText = driver.findElement(By.name("q"));
			//search a value on it
			searchText.sendKeys(DataProvSearchKey);
			System.out.println("Welcome -> "+DataProvAuthor+" Your search key is-> "+DataProvSearchKey);
			Thread.sleep(3000);
			String testValue = searchText.getAttribute("value");
			System.out.println(testValue +"::::"+DataProvSearchKey);
			searchText.clear();
			//verify correct value in searchbox
			Assert.assertTrue(testValue.equalsIgnoreCase(DataProvSearchKey));
	}
	}
	
	@Test(dataProvider="SearchProviderExternalAsITestContext",groups="B",dataProviderClass=DataproviderWithITestContextAsParameterClass.class)
	// Each row in the groupArray defined in the EXTERNAL dataProvider is passed to the method at execution time. 
	// Groups="B" is used to include this test in the XML used to call all the tests to execute, and also to select 
	// groupArray set of data, in the dataProvider, to use for this test execution.
	//@Test(dataProvider="SearchProvider",groups="B")
	public void testMethodB(String DataProvSearchKey) throws InterruptedException{
		{
		  //find google search box
			WebElement searchText = driver.findElement(By.name("q"));
			//search a value on it
			searchText.sendKeys(DataProvSearchKey);
			System.out.println("Welcome ->Unknown user Your search key is-> "+DataProvSearchKey);
			Thread.sleep(3000);
			String testValue = searchText.getAttribute("value");
			System.out.println(testValue +" :::: "+DataProvSearchKey);
			searchText.clear();
			//verify correct value in searchbox
			Assert.assertTrue(testValue.equalsIgnoreCase(DataProvSearchKey));
	   }
	}
	
	/**
	 * Here the DAtaProvider will provide Object array on the basis on ITestContext
	 * @param c
	 * @return
	 */
/*
	@DataProvider(name="SearchProvider") 
	public Object[][] getDataFromDataprovider(ITestContext c){
		 
		Object[][] groupArray = null;
		for (String group : c.getIncludedGroups()) {
			System.out.println("Group to Process is: "+group);
		    if(group.equalsIgnoreCase("A")){
		       groupArray = new Object[][] { 
					{ "Guru99", "India" }, 
					{ "Krishna", "UK" }, 
					{ "Bhupesh", "USA" } 
			   };
		       break;	
		       
		    }
			else if(group.equalsIgnoreCase("B"))  {
			   groupArray = new Object[][] { 
						{  "Canada" }, 
						{  "Russia" }, 
						{  "Japan" } 
			   };
			   break;
			 }   
	}
	return groupArray;		
	}
*/	
}