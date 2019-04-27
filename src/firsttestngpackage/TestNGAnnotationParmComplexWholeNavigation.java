package firsttestngpackage;

	import org.testng.annotations.*;
	import org.testng.Assert;
//	import org.openqa.selenium.WebDriver;
//	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
//	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.*;

// This whole test will execute below flow
// Go to the homepage and verify its title.
//	Click REGISTER and verify the title of its target page.
//	Go back to the homepage and verify if it still has the correct title.
//	Click SUPPORT and verify the title of its target page.
//	Go back to the homepage and verify if it still has the correct title.	
// The code below illustrates how @BeforeMethod and @AfterMethod are used to efficiently execute the 
// scenario mentioned above. 
// @BeforeMethod is executed prior to each method in each test cases (@Test) 
// @AfterMethod is executed after each method in each test cases (@Test)
	
public class TestNGAnnotationParmComplexWholeNavigation {
	public String baseUrl = "http://demo.guru99.com/selenium/newtours/";
	public String driverPath = "C:\\selenium-3.11.0\\geckodriver.exe";
	public WebDriver driver;
	public String expected = null;
	public String actual= null;
			  	
		
	  @BeforeTest  //this first test case, will execute before the Test.
	  public void launchBrowser() {
		  System.out.println("Launching the browser");
//		  System.setProperty("webdriver.gecko.driver", driverPath);
		  System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");  
//	    driver = new FirefoxDriver();
		  driver = new ChromeDriver();
		  driver.get(baseUrl);	  
	  }  
	  
	  @BeforeMethod    //below method will be executed before each test case (@test)
	  public void verifyHomePageTitle() {
		  expected = "Welcome: Mercury Tours";
		  actual = driver.getTitle();
		  Assert.assertEquals(actual, expected);
	  }
	  
	  @Test (priority = 0)
	  public void TestRegisterPageTitle() {
		  driver.findElement(By.linkText("REGISTER")).click();
		  expected = "Register: Mercury Tours";
	      actual = driver.getTitle();
		  Assert.assertEquals(actual, expected);  
	  }  //Note: Uncaught exceptions are automatically handled by TestNG without terminating the test prematurely.
	     //These exceptions are reported as failed steps in the report.
	  
	  @Test (priority = 1)
	  public void TestSupportPageTitle() {
		  driver.findElement(By.linkText("SUPPORT")).click();
		  expected = "Under Construction: Mercury Tours";
		  actual = driver.getTitle();
		  Assert.assertEquals(actual, expected);
	  }
	  
	  @AfterMethod  // below method will be executed after execution of each test case (@Test)
	  public void goBackHomepage () {
		  driver.findElement(By.linkText("Home")).click();
	  }
	  	  
	  @AfterTest  //this is the last test that will be executed.
	  public void terminateBrowser() {
		  driver.close();
	  }
	}
