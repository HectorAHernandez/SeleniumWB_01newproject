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


public class T11ScopeExercises {

	public static void main(String[] args) throws InterruptedException {
		// This is an exercises for section 71
		
		WebDriver driver;
	//	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
	//  driver = new FirefoxDriver();
	    System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  // Define Implicit wait time to ask Selenium to 
        //    Wait up until 5 seconds for each sentence to complete before raising exception error.
     	String baseUrl = "http://qaclickacademy.com/practice.php";
     	driver.get(baseUrl);
     	// below print the number of link in the entire page
     	System.out.println("Number of links on the entire page: " + driver.findElements(By.tagName("a")).size());

     	// Scope are used when we want to work or limited the execution of the command to certain area of the page, for 
     	// example the footer part of the page (to count the number of links on it.). To define an scope first we have to
     	// create a webElement for the section or group or panel that can define the scope we want to process.
     	WebElement newScopeDriver = driver.findElement(By.id("gf-BIG")); //this identify the div (footer) containing all the scope area.
     	// now we execute our commands using this newScopeDriver. For example the new link total only for the footer scope
     	System.out.println("Number of links on the scope (footer) section: " + newScopeDriver.findElements(By.tagName("a")).size());
        
     	// The footer section has four columns, so now we want to create another sub-scope for the first column, we can
     	// start from the previous newScopeDriver we defined.
     	WebElement firstColumnScopeDriver = newScopeDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
       // now we execute our commands using this firstColumnScopeDriver. the new link total only for the fist column
      	System.out.println("Number of links within the scope of the first column section: " 
                          + firstColumnScopeDriver.findElements(By.tagName("a")).size());
     	
       // Now we need to click on each link in first column, but the first one, so that they open in a new tab. (to open the 
       // link in a new tab we have to hold control key and then click on enter), If DO NOT open in a new tab, then we will
       // have to click on the back page button and this will be very time consuming.
      	for (int i=1; i < firstColumnScopeDriver.findElements(By.tagName("a")).size(); i++ ){
      		String clickLinkToGoToNewTab = Keys.chord(Keys.CONTROL, Keys.ENTER); // to hold control key and click ENTER key.
      		firstColumnScopeDriver.findElements(By.tagName("a")).get(i).sendKeys(clickLinkToGoToNewTab);
      		//above find/get the link (i) and click it with CONTROL key plus ENTER key
      		//Thread.sleep(3000L);
      	}	
      	
      	Set<String> windowIds = driver.getWindowHandles();  //Creates a set containing a handle or the window id for all 
        //windows opened so far. The parent window is located in the first row, then child in the order they are opened,
      	Iterator<String> itertor = windowIds.iterator(); // Create an iterator (itertor) to traverse through the set created.
 /*
//  *** FIRST method to print the Title on each tab.     	
      	// Save the id of each page in variables.
      	String parentWindowId = itertor.next();
      	String childWindowId01 = itertor.next();
      	String childWindowId02 = itertor.next();
      	String childWindowId03 = itertor.next();
      	String childWindowId04 = itertor.next();
      	// switch to each page and print the title.
      	driver.switchTo().window(parentWindowId);
      	System.out.println("Parent Window title is: " + driver.getTitle());
      	driver.switchTo().window(childWindowId01);  // also here/now we can process any other webelement in this page
      	System.out.println("first Window title is: " + driver.getTitle());
      	driver.switchTo().window(childWindowId02); // also here/now we can process any other webelement in this page
      	System.out.println("second window title is: " + driver.getTitle());
      	driver.switchTo().window(childWindowId03);
      	System.out.println("Third window title is: " + driver.getTitle());
      	driver.switchTo().window(childWindowId04);
      	System.out.println("fourth window title is: " + driver.getTitle());
  */    	
//  *** SECOND method to print the Title on each tab.
      	System.out.println("**** Now to print with the SECOND METHOD ****");
      	while (itertor.hasNext()) {
      		driver.switchTo().window(itertor.next()); // switch to the window with id indicated by itertor.next().
      		System.out.println("Page Title: "+driver.getTitle());    //print the page title
      	}
	}  
}
