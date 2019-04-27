package UdemySlenium;   //instructor's email: rahulonlinetutor@gmail.com

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class T05Alerts {

	public static void main(String[] args) {
		// This is an example of using Java Alerts, or NOT in the HTML code so when ispecting the alert no code is displayed.
		WebDriver driver;
	//	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
	//  driver = new FirefoxDriver();
	    System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver();
		String baseUrl = "http://www.tizag.com/javascriptT/javascriptalert.php";     
        driver.get(baseUrl);
        driver.manage().window().maximize();
       
        driver.findElement(By.cssSelector("input[value='Confirmation Alert']")).click();
        System.out.println("The alert is: " + driver.switchTo().alert().getText()); // to get the text in the alert.
        //driver.switchTo().alert().sendKeys("This is the response to the Alert"); // if the alert has an edit field for type in.
        driver.switchTo().alert().accept(); // to give a positive response like: Ok, yes, Done, etc.
    //    driver.switchTo().alert().dismiss(); // to give a negative response like: Cancel, not, dismiss etc
	}  
}
