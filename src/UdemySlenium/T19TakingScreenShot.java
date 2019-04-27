package UdemySlenium;   //instructor's email: rahulonlinetutor@gmail.com
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.apache.commons.io.FileUtils;
             
public class T19TakingScreenShot {
	public static void main(String[] args) throws IOException {
		// This is an example how to handle Taking screenshot with Selenium
		WebDriver driver;
	    System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver();         
        driver.manage().window().maximize(); //Maximize the Browser before opening it in driver.get(baseUrl);
             
        WindowsUtils.killByName("excel.exe"); //kill or close the opened Excel session.  
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  // Define Implicit wait time to ask Selenium to 
        //    Wait up until 5 seconds for each sentence to complete before raising exception error.
     	String baseUrl = "http://www.google.com";
     	driver.get(baseUrl);
     	// below cast the driver to take screenshot ((TakesScreenshot)driver) using the method getScreenshotAs with outputype of FILE.
       File source =  ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(source, new File("C:\\Users\\ssshh\\screenCopyHH.png"));   
       
     //  File src=(File)driver.getScreenshotAs(OutputType.FILE);
     //  Files.copy(src,new File("d://screen.jpg"));
	}			
}

/*
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class T19TakingScreenShot {
    public static void main(String[] args) throws IOException {
    	System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();         
        driver.manage().window().maximize(); //Maximize the Browser before opening it in driver.get(baseUrl);
    	
    	//WebDriver driver = new FirefoxDriver();
        driver.get("http://google.com");
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("C:\\users\\ssshh\\screenshot.png"));
    }
}
*/