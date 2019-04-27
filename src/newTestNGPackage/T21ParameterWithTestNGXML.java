package newTestNGPackage;
/* As we create software, we always wish it should work differently with a different set of data. 
 * When it comes to Testing the same piece of software, we can't be unfair to test it with just one 
 * set of data. Here again, we need to verify that our system is taking all set of combinations 
 * which it expected to support.

Here comes Parameterization in the picture. To pass multiple data to the application at runtime, we 
need to parameterize our test scripts.
This concept which we achieve by parameterization is called Data Driven Testing.

Type of Parameterization in TestNG-
To make parameterization more clear, we will go through the parameterization options in one the 
most popular framework for Selenium Webdriver - TestNG.
There are two ways by which we can achieve parameterization in TestNG
1- With the help of Parameters annotation and TestNG XML file: @Paramters({"name", "searchKeys"});
2- With the help of DataProvider annotation. @DataProvider(name, "searchProvider");

Parameters from Testng.xml can be suite or test level
Parameter from DataProvider can take Method and ITestContext as the parameter.
Let's study them in detail -
Parameters annotation with Testng.xml
Select parameterization using annotations when you do want to deal with complexity & the number of 
input combinations are less. Let see how this works
Test Scenario
 * 
 * */

import org.testng.AssertJUnit;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;

	import org.testng.annotations.Optional;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

	public class T21ParameterWithTestNGXML {
		String driverPath = "C:\\selenium-3.11.0\\geckodriver.exe";
		WebDriver driver;
	    @Test
	    @Parameters({"ParmAuthor","ParmSearchKey"})
	    // Above two ParmXxxx are passed to the method at execution time.  
	    //public void testParameterWithXML( String author,String searchKey) throws InterruptedException{
	     public void testParameterWithXML( @Optional("Abc") String author,String searchKey) throws InterruptedException{ 	

	    	System.setProperty("webdriver.gecko.driver", driverPath);
	    	driver = new FirefoxDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get("https://google.com");

	        WebElement searchText = driver.findElement(By.name("q"));
	        //Searching text in google text box
	        searchText.sendKeys(searchKey);

	        System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
	        System.out.println("Thread will sleep now");
	        Thread.sleep(3000);
	        System.out.println("Value in Google Search Box = "+searchText.getAttribute("value") +" ::: Value given by input = "+searchKey);
	        //verifying the value in google search box
	        AssertJUnit.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));

	}
	}