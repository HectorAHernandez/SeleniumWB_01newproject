package WebDriverTestPackage;
// Catching Exceptions
// When using isEnabled(), isDisplayed(), and isSelected(), WebDriver assumes that the element already exists on the page. 
// Otherwise, it will throw a NoSuchElementException. To avoid this, we should use a try-catch block so that the program
//  
// To use implicit wait below package must be imported
import java.util.concurrent.TimeUnit;
//To use Explicit wait below two package must be imported
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
// more
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class T08CatchingExcpetionElemtNotExist {
	   public static void main(String[] args) {
		    System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
	    	System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");  
		  	WebDriver driver = new FirefoxDriver();
//	        WebDriver driver = new ChromeDriver();
// To define Explicit wait, we have to declare a WebDriverWait variable, like hectorWaitVar 
		  	WebDriverWait hectorWaitVar = new WebDriverWait(driver, 5);
	        driver.get("http://newtours.demoaut.com");

// Using the isEnabled() condition, repeating the same above (with wait), now without wait but using the isEnabled() condition. For convenience 
// saved the element with id "userName" as an instance of WebElement class.
	        WebElement WS_txtbox_username = driver.findElement(By.name("userName"));
	        if (WS_txtbox_username.isEnabled()) {
	        	WS_txtbox_username.sendKeys("tutorial");
	        }
// using Expected conditions to replace above isEnable. Because the expected condition "elementToBeClickable" waits until an element
// is visible and, at the same time, enabled.
	     	 WebElement WS_txtbox_password = hectorWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("password")));
	     	 WS_txtbox_password.sendKeys("tutorial");  
// this is another way:       driver.findElement(By.name("password")).sendKeys("tutorial");
        	driver.findElement(By.name("login")).click();
// After above .click() a new page is displayed that does not contains the "userName" WebElement, so if we try to use it the 
// exception will be generated:
        	System.out.println("To get the username second time");
        
        	try {
           		WebElement WS_txtbox_username2 = driver.findElement(By.name("userName"));
        //		if (driver.findElement(By.name("userName")).isEnabled()){
            	if (WS_txtbox_username2.isEnabled()){        	
        //			driver.findElement(By.name("userName")).sendKeys("tutorial");
           		WS_txtbox_username2.sendKeys("tutorial");
        		}
        	}
	        catch (NoSuchElementException nsee){
	        	System.out.println("***** Exception program catch: "+nsee.toString());
	        }
 // To catch a TimeoutException     	
        	try {
        		hectorWaitVar.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name("password")));   	
        			driver.findElement(By.name("password")).sendKeys("tutorial");
              	}
	        catch (TimeoutException toe){
	        	System.out.println("****** TimeOutException program catch: "+toe.toString());
	        }
	       driver.quit();
	       
	    }
}