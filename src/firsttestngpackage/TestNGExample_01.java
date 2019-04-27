package firsttestngpackage;

import org.testng.annotations.*;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

public class TestNGExample_01 {
	public String baseUrl = "http://demo.guru99.com/selenium/newtours/";
	public String driverPath = "C:\\selenium-3.11.0\\geckodriver.exe";
	public WebDriver driver;
		  	
// This whole program will check if Mercury Tours' home page title is correct.
	
  @BeforeTest  //this first test case, will execute before the Test @Test.
  public void setBaseURL() {
      System.setProperty("webdriver.gecko.driver", driverPath);
	  System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");  
//    driver = new FirefoxDriver();
	  driver = new ChromeDriver();
	  System.out.println("Launching the browser");
	  driver.get(baseUrl);	  
  }  
  
  @Test
  public void verifyHomepageTitle() {
	  String expectedTitle = "Welcome: Mercury Tours";
      String actualTitle = driver.getTitle();
	  Assert.assertEquals(actualTitle, expectedTitle);  
  }  //Note: Uncaught exceptions are automatically handled by TestNG without terminating the test prematurely.
     //These exceptions are reported as failed steps in the report.
  
  @AfterTest
  public void endSession() {
	  driver.close();
  }
}
