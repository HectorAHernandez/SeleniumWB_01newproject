package UdemySlenium;   //instructor's email: rahulonlinetutor@gmail.com

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class T04RadioButtons {

	public static void main(String[] args) {
		// This is an example of using xpath and CSS for identifying the webelements.
		WebDriver driver;
		
	//	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
	//  driver = new FirefoxDriver();
	    System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver();
		String baseUrl = "http://echoecho.com/htmlforms10.htm";     
        driver.get(baseUrl);
        driver.manage().window().maximize();
       
        //click on radio button using value attribute.
        driver.findElement(By.xpath("//input[@value='Milk']")).click();
        driver.findElement(By.cssSelector("input[value='Beer']")).click();
        
        /* to count the number of radio buttons in a radio button group/section use the .size() method with findElements 
         and the name attribute, which is normally used to group WebElemens) */
        driver.findElements(By.xpath("//input[@name='group1']")).size();
        System.out.println("Total Radio buttons is: " + driver.findElements(By.xpath("//input[@name='group1']")).size());
       
        // clicking on a radio button without using the value attribute (clicking all the radio button):
        int count = driver.findElements(By.xpath("//input[@name='group1']")).size();
        for (int i=0; i < count; i++) {
        	// below get the content of the value attribute:
        	String attributeContent = driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value");
        	if (attributeContent.equals("Cheese")) {
        		driver.findElements(By.xpath("//input[@name='group1']")).get(i).click();
        	}
        }     
	}  
}
