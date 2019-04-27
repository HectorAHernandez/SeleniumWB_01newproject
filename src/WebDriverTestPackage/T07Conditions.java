package WebDriverTestPackage;
// There are two type of Waits, Implicit Wait: Define default waiting time throughout the program.
//                              Explicit Wait: Set the waiting time for a particular instance (of the browser) only. 
// To use implicit wait below package must be imported
import java.util.concurrent.TimeUnit;
//To use Explicit wait below two package must be imported
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
// more
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class T07Conditions {
	   public static void main(String[] args) {
		    System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
	    	System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");  
		  	WebDriver driver = new FirefoxDriver();
//	        WebDriver driver = new ChromeDriver();
// To define Explicit wait, we have to declare a WebDriverWait variable, like hectorWaitVar 
		  	WebDriverWait hectorWaitVar = new WebDriverWait(driver, 10);
	        driver.get("http://newtours.demoaut.com");
// Using Explicit wait on the "userName" input before typing the text "tutorial" onto it.
//	        hectorWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.name("userName")));
//	        driver.findElement(By.name("userName")).sendKeys("tutorial");

// Using the isEnabled() condition, repeating the same above (with wait), now without wait but using the isEnabled() condition. For convenience 
// saved the element with id "userName" as an instance of WebElement class.
	        WebElement WS_txtbox_username = driver.findElement(By.name("userName"));
	        if (WS_txtbox_username.isEnabled()) {
	        	WS_txtbox_username.sendKeys("tutorial");
	        }
//using isDisplayed() condition: When we want to whether a certain element is displayed or not before executing a command.
//	        do {
//	        	driver.findElement(By.name("password")).sendKeys("tutorial");
//	        	driver.findElement(By.name("login")).click();
//	         } while (driver.findElement(By.name("userName")).isDisplayed()); 
// Above the while did not work because after the click a new page is displayed and the userName in not found or unknown.

// using Expected conditions to replace above isEnable. Because the expected condition "elementToBeClickable" waits until an element
// is visible and, at the same time, enabled.
	     	 WebElement WS_txtbox_password = hectorWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("password")));
	     	 WS_txtbox_password.sendKeys("tutorial");  
// this is another way:       driver.findElement(By.name("password")).sendKeys("tutorial");
        	driver.findElement(By.name("login")).click();
               
	        
// Use Explicit wait on the "Radio button for Trip Type" (on new page displayed "find a Flight Mercury Tours:") before executing below command.
	   //     hectorWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='tripType'][value='roundtrip']")));	        
// using isSelected(), when we want to verify whether a certain Check box, radio button, or option in a drop down box is selected. it 
// , isSelected(), does not work on other elements.
	// with Ratio button with name = tripType and value "roundtrip" and "oneway" in page "find a Flight Mercury Tours:"        
	       if (driver.findElement(By.cssSelector("input[name='tripType'][value='roundtrip']")).isSelected()) {
	    	   driver.findElement(By.cssSelector("input[name='tripType'][value='oneway']")).click();
	    	   System.out.println("***** Clicked oneway radio button"); 
	       }
	         
	      // driver.quit();
	       
	    }
}