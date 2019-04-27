package UdemySlenium;   //instructor's email: rahulonlinetutor@gmail.com

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class T10ElementsInFrame_DragDrop {

	public static void main(String[] args) throws InterruptedException {
		// This is an example of using elements in a frame and drag and drop
/*  what is a frame: In the context of a web browser, a frame is a part of a web page or browser window which displays 
 * content independent of its container or the webpage containing it, with the ability to load content independently. 
 * The HTML or media elements that go in a frame may or may not come from the same web site as the other elements of 
 * content on display. This means that before accessing a webelement in a frame, we have to tell Selenium to switch to 
 * the frame containing the webelement:
     driver.switchTo().frame(int index) // if we can find an index to identify the frame.
            driver.switchTo().frame(0)  // for the first frame.
            driver.switchTo().frame(2)  // for the third frame.
     driver.switchTo().frame(String)  // if we can find the id to identify the frame.
     driver.switchTo().frame(WebElement) // if we can use any other attribute like class, for example:
            driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
            driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame))); //using the class's name
                    driver.findEl.
 Note: for a webelement within a frame, when using Chropath to confirm the location of the webelement, it will return that
       "0 matching node found" but we have the right xpath or CSS. So this is and indicator that the webelement belong to 
       a frame. */		
		
		WebDriver driver;
	//	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
	//  driver = new FirefoxDriver();
	    System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  // Define Implicit wait time to ask Selenium to 
        //    Wait up until 5 seconds for each sentence to complete before raising exception error.
     	String baseUrl = "http://jqueryui.com/droppable";     
        driver.get(baseUrl);
     // to identify the number of frame in a page we can use this:
        System.out.println("Number of Frames in page: "+driver.findElements(By.tagName("iframe")).size());
        // now that we know the number of frames, we can access the frame using the index, (this is a good method when
        // there is no way how to identify the different frames.
        //driver.switchTo().frame(0);  // this switch to the first frame.
        
        //below switch to the frame by using an attribute (class's name) of the iframe webelement definition
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
        //driver.findElement(By.id("draggable")).click();
        //Below are for executing the drag and drop of one webElement to another.
        WebElement webElemSource = driver.findElement(By.id("draggable")); //define the location of source WebElem
        WebElement webElemTarget = driver.findElement(By.id("droppable")); //define the location of Target WebElem
        Actions action = new Actions(driver);   // Define the action class
        action.dragAndDrop(webElemSource, webElemTarget).build().perform();  //define, build and execute the action.
        
        // now to go back to the original page so that we can access the other webelement on the original/default page
        // we have to switch back to the default. If not those other webelement won't be recognized:
        driver.switchTo().defaultContent(); 
     //   driver.findElement(By.xpath("//a[contains(text(),'Visual feedback')]")).click(); // this link is outside the iframe.   
	}  
}
