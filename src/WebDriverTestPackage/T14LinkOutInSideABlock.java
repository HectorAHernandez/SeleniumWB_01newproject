package WebDriverTestPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class T14LinkOutInSideABlock {
 public static void main(String[] args) { 
    	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
    	System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");     	
	  	WebDriver driver = new FirefoxDriver();
//    	WebDriver driver = new ChromeDriver();
// Below code is for using inside Link.	  	
	  	String baseUrl = "file://c:/Selenium%20Tutorial%20Code/HTML_Files/Links%20Outside%20and%20Inside%20%20Block.html";
		driver.get(baseUrl);
//		driver.findElement(By.partialLinkText("Inside")).click();
//		System.out.println("Inside link is: " + driver.getTitle());
		
// Below code is for using Outside Link.	  	
	  	driver.findElement(By.linkText("Outside a block-level tag.")).click();
		System.out.println("outside Link is: " + driver.getTitle());

		driver.quit();
 }
}