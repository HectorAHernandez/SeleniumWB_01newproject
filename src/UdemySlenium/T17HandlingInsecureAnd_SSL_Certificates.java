package UdemySlenium;   //instructor's email: rahulonlinetutor@gmail.com

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class T17HandlingInsecureAnd_SSL_Certificates {

	public static void main(String[] args) throws InterruptedException {
		// This is an example how to handle Insecure Certificates and SSL certificates. This setup is for automatically respond with 
		// accept the popup with the Insecure Certificate or SSL certificate, when starting execution of the test case.
		
// **** START Definition of the desired capabilities and browser options.
		//General Chrome profile.
		DesiredCapabilities chromeDC = DesiredCapabilities.chrome();
		//chromeDC.acceptInsecureCerts();
		chromeDC.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);   //true indicate click accept.
		chromeDC.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);		  //true indicate click accept.
		
		//to the local browser
		ChromeOptions chroOpt = new ChromeOptions();
		chroOpt.merge(chromeDC);  //Merge the defined Desired Capabilities to the chromeOprion to be used in this browser session.
		
		WebDriver driver;
	    System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver(chroOpt); //instantiates a Chrome Webdriver session using the Chrome Options defined with the 
                                            // desired capabilities.
// **** END Definition of the desired capabilities and browser options.
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  // Define Implicit wait time to ask Selenium to 
        //    Wait up until 5 seconds for each sentence to complete before raising exception error.
     	String baseUrl = "http://www.cricbuzz.com/live-cricket-scorecard/19587/lancs-vs-yorks-north-group-royal-london-one-day-cup-2018";
     	driver.get(baseUrl);
     	
     	
     	
	}		
}
