package WebDriverTestPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class T15ImageLink {
 public static void main(String[] args) { 
    	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
    	System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");     	
	  	WebDriver driver = new FirefoxDriver();
//    	WebDriver driver = new ChromeDriver();
// B .	  	
	  	String baseUrl = "https://www.facebook.com/login/identify?ctx=recover";
		driver.get(baseUrl);
	//click on the "Facebook" logo on the upper left portion
        driver.findElement(By.cssSelector("a[title=\"Go to Facebook Home\"]")).click();

        //verify that we are now back on Facebook's homepage
        if (driver.getTitle().equals("Facebook - Log In or Sign Up")) {
            System.out.println("We are back at Facebook's homepage");
        } else {
            System.out.println("We are NOT in Facebook's homepage");
        }
        //driver.close();
    }
}