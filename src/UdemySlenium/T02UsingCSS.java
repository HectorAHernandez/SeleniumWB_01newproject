package UdemySlenium;   //instructor's email: rahulonlinetutor@gmail.com

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class T02UsingCSS {

	public static void main(String[] args) {
		// This is an example of using xpath and CSS for identifying the webelements.
		WebDriver driver;
	//	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
	//  driver = new FirefoxDriver();
	    System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver();
		String baseUrl = "https://login.salesforce.com/";     
        driver.get(baseUrl);
        driver.manage().window().maximize();
        System.out.println("Page Title: "+driver.getTitle());
        driver.findElement(By.cssSelector("[class='input r4 wide mb16 mt8 username']")).sendKeys("using CSS");
        driver.findElement(By.cssSelector("input[id='username']")).sendKeys("other user CSS");
        driver.findElement(By.cssSelector("input[id='password']")).sendKeys("password3333");
       // driver.findElement(By.xpath("//input[@id='Login']")).click();     // xpath
        driver.findElement(By.cssSelector("input[id='Login']")).click();  // CSS    
        driver.findElement(By.cssSelector("#Login")).click();  // identifying using # for the id attribute. #idName.
        //using the . for identifying class. in this case if the className has space, replace it with .
        // example for CSS = .input.r4.wide This is for the class name, start with a dot .
        driver.findElement(By.cssSelector(".input.r4.wide")).sendKeys("For class name with ."); //this could find multiple 
           // webElements so we need to refine it to make it unique.
	
	}  

}
