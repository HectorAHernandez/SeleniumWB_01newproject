package UdemySlenium; 
/* Commands in Hub Machine
1.Setting Up Hub: (in directory c:\Selenium-3.11.0
	java -jar selenium-server-standalone-3.12.0.jar -role hub
2.Validating Hub started 
	http://localhost:4444/grid/console

Commands in Node Machine
	3.Accessing Hub from Node Machine
		http://iporhostnameofHub:4444/grid/console 
	4.Registering Node with Hub
		Java -Dwebdriver.chrome.driver="C:\chromedriver.exe" –jar selenium-server-standalone-3.12.0.jar –role webdriver –hub http://iporhostnameofHub:4444/grid/register -port 5566
						A
	A---> defines the webdriver to be used as Chrome and indicate the directory, in the node server machine, where the "chrome.exe" is stored,
	      this must be the same directory where the selenium-server-standalone-3.12.0.jar is saved in this node machine.
	       
Code in Hub Machine

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
 */

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class T20SeleniumGridMultiBrowser01 {

public static void main(String[] args) throws MalformedURLException {
// TODO Auto-generated method stub
//Automated- chrome,firefox,ie,safari

	DesiredCapabilities dc= new DesiredCapabilities();
	dc.setBrowserName("chrome");
	dc.setPlatform(Platform.WINDOWS);
	//dc.se

	//Webdriver driver=new ChromeDriver();
	WebDriver driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),dc); // first parameter indicate to use the WebDriver in
	         // the hub (using the indicated URL) the second parameter indicate to use the desired capabilities defined in lines 34...37.
	driver.get("http://rediff.com");
    //The test steps go below:


// 
}

}