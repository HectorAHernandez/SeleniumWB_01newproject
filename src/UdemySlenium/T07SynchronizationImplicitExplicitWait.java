package UdemySlenium;   //instructor's email: rahulonlinetutor@gmail.com

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class T07SynchronizationImplicitExplicitWait {

	public static void main(String[] args) throws InterruptedException {
		// This is an example of using Java Alerts, or NOT in the HTML code so when ispecting the alert no code is displayed.
		WebDriver driver;
	//	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
	//  driver = new FirefoxDriver();
	    System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  // Define Implicit wait time to ask Selenium to 
        //    Wait up until 5 seconds for each sentence to complete before raising exception error.
     	String baseUrl = "https://alaskatrips.poweredbygps.com/g/pt/vacationpackages?MDPCID=ALASKA-US.TPS.BRAND.VACATIONPACKAGES.PACKAGE";     
        driver.get(baseUrl);
        driver.manage().window().maximize();
        
        driver.findElement(By.id("FH-origin")).sendKeys("nyc");
        driver.findElement(By.id("FH-origin")).sendKeys(Keys.TAB);
        driver.findElement(By.id("FH-destination")).sendKeys("Cancun");
        driver.findElement(By.id("FH-destination")).sendKeys(Keys.TAB);
        driver.findElement(By.id("FH-fromDate")).sendKeys(Keys.ENTER);
        
// Note: when the implicit wait is not defined (line 22), this error is generated "main" org.openqa.selenium.NoSuchElementException:
        //   no such element: Unable to locate element: {"method":"id","selector":"hotelNewSearchLnk"}"
        // And the reason is that the program was still searching and the DOM was not created for the next sentence to execute. so with
        // the wait allows this to happens.
 driver.findElement(By.id("hotelNewSearchLnk")).click();  // **** this works with the Implicit Wait. *****
        
        //Explicit Wait definition: This can work with and without the Implicit Wait.
        WebDriverWait driver222 = new WebDriverWait(driver, 20);  //define a wait of 20 seconds for any condition defined
         // using the driver222 WebDriverWait object. If it takes less then resume execution.
//        driver222.until(ExpectedConditions.elementToBeClickable(By.id("hotelNewSearchLnk")));  
//        driver.findElement(By.id("hotelNewSearchLnk")).click();  //after the wait then execute the click.
               
	}  
}
