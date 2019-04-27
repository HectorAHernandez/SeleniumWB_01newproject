package UdemySlenium;   //instructor's email: rahulonlinetutor@gmail.com

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class T08Actions {

	public static void main(String[] args) throws InterruptedException {
		// This is an example of using Java Alerts, or NOT in the HTML code so when ispecting the alert no code is displayed.
		WebDriver driver;
	//	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
	//  driver = new FirefoxDriver();
	    System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  // Define Implicit wait time to ask Selenium to 
        //    Wait up until 5 seconds for each sentence to complete before raising exception error.
     	String baseUrl = "https://www.amazon.com/";     
        driver.get(baseUrl);
        driver.manage().window().maximize();
        
        WebElement webElement01 = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
        WebElement webElement02 = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")); //search field.
        Actions action = new Actions(driver);
        action.moveToElement(webElement01).build().perform(); // move to the webelement
        //build() - To build the action and make it ready for execution.
        //perform() - To execute the action that was built.
        action.moveToElement(webElement02).click().keyDown(Keys.SHIFT).sendKeys("hello people").doubleClick().build().perform();
        //click() - to get into the field before start typing.
        //keyDown(Keys.SHIFT) - To press down the shift key in order to convert to upper case what is going to be typed.
        //sendkeys("xxx") - To type xxxx
        //doubleClick() - To select the last word that was typed. or the whole word if it was one.
        //build() - To build the action and make it ready for execution.
        //perform() - To execute the action that was built.
        
        action.moveToElement(webElement01).contextClick().build().perform();
        //contextClick() - To right Click on a webElement.
               
	}  
}
