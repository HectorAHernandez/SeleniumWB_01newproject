package WebDriverTestPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//To use Explicit wait below two package must be imported
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class T06SwitchingBetweenPopupWindows {
	   public static void main(String[] args) {
	    	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
	    	System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");  
		  	WebDriver driver = new FirefoxDriver();
//	    	WebDriver driver = new ChromeDriver();
	        String alertMessage = "";
	      
// To define Explicit wait, we have to declare a WebDriverWait variable, like hectorWaitVar 
		  	WebDriverWait hectorWaitVar = new WebDriverWait(driver, 10);

	        driver.get("http://jsbin.com/usidix/1");
	     //   driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
	        driver.findElement(By.cssSelector("input[value='Go!']")).click();
// Above in value=\"Go!\" , the \ is to indicate that the " is valid, or that they donot indicate the end of the selector definition
	        
// Using Expected Conditions "alertIsPresent() to make sure the alert was displayed before getText() the alert msg.
	        if (hectorWaitVar.until(ExpectedConditions.alertIsPresent()) != null) {
	           alertMessage = driver.switchTo().alert().getText();
	           System.out.println("The Alert is present, before accept: ");
	           driver.switchTo().alert().accept();
	           System.out.println("The message in the Alert is: "+alertMessage);
	        }
	       // driver.quit();
	       
	    }
}
