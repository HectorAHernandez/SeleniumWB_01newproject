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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class T04Wait_CommandsType {
	   public static void main(String[] args) {
		    System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
	    	System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");  
		  	WebDriver driver = new FirefoxDriver();
//	    	driver = new ChromeDriver();
// To define implicit wait, only need below command:
		  	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// To define Explicit wait, we have to declare a WebDriverWait variable, like hectorWaitVar 
		  	WebDriverWait hectorWaitVar = new WebDriverWait(driver, 10);
	        
	        driver.get("http://newtours.demoaut.com");
// Use Explicit wait on the "username" (Mercury Tours Homepage) input before typing the text "tutorial" onto it.
	        hectorWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.name("userName")));
	        driver.findElement(By.name("userName")).sendKeys("tutorial");
	       	       
	      // driver.quit();
	       
	    }
}
