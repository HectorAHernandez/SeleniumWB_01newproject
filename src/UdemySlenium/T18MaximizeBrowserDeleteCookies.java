package UdemySlenium;   //instructor's email: rahulonlinetutor@gmail.com

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class T18MaximizeBrowserDeleteCookies {

	public static void main(String[] args) throws InterruptedException {
		// This is an example how to handle Insecure Certificates and SSL certificates. This setup is for automatically respond with 
		// accept the popup with the Insecure Certificate or SSL certificate, when starting execution of the test case.
		
		WebDriver driver;
	    System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver(); 
        
        driver.manage().window().maximize(); //Maximize the Browser before opening it in driver.get(baseUrl);
        driver.manage().deleteAllCookies();  //Delete ALL the cookies before opening the browser.
        driver.manage().deleteCookieNamed("sessionKey"); //Delete the cookie named sessionkey. if this sessionkey is defined in the page,
                                                // then after deletion, when clicking any link it will ave to display the login page.
                                                // this is a good verification to implement.
    //    driver.manage().addCookie(arg0); //add a cookie before opening the browser. Note, this is very rare.
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  // Define Implicit wait time to ask Selenium to 
        //    Wait up until 5 seconds for each sentence to complete before raising exception error.
     	String baseUrl = "http://www.cricbuzz.com/live-cricket-scorecard/19587/lancs-vs-yorks-north-group-royal-london-one-day-cup-2018";
     	driver.get(baseUrl);
     	
     	
     	
	}		
}
