package firsttestngpackage;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestNG_DateTimePickerExample {
	String driverPath = "C:\\selenium-3.11.0\\geckodriver.exe";
	public WebDriver driver;
  @Test
  public void testNG_DateTimePicker() {
	  System.setProperty("webdriver.gecko.driver", driverPath);
	  System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");  
//     driver = new FirefoxDriver();
	   driver = new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.get("http://demo.guru99.com/selenium");
// Find the date time picker control
	   WebElement dateBox = driver.findElement(By.xpath("//html/body/form/input[1]"));
// same as above statement: WebElement dateBox = driver.findElement(By.xpath("//form//input[@name='bdaytime']"));

// Fill the date as mm/dd/yyy as 09/25/2013
	   dateBox.sendKeys("09252013");
// Press tab to shift focus to the time field
	   dateBox.sendKeys(Keys.TAB);
	   //Fill the time as 02:45 PM
	   dateBox.sendKeys("0245PM");
	   
  }
}
