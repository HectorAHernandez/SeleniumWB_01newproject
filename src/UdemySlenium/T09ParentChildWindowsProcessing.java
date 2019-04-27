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


public class T09ParentChildWindowsProcessing {

	public static void main(String[] args) throws InterruptedException {
		// This is an example of using parent and child windows.
		WebDriver driver;
	//	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
	//  driver = new FirefoxDriver();
	    System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  // Define Implicit wait time to ask Selenium to 
        //    Wait up until 5 seconds for each sentence to complete before raising exception error.
     	String baseUrl = "https://accounts.google.com/signup";     
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"initialView\"]/footer/ul/li[1]/a")).click(); //click on the "Help" link to
                      // open a child window.
        System.out.println("Before switching");
        System.out.println("Page Title is: " + driver.getTitle()); // this will display the parent page title because Selenium
              // stick to the parent page. And if we need to access the webelements in the child page we need to switch to 
              // the child page.
        // below is for testing what happen if I try to access one of the fields in the child page displayed:
 //       driver.findElement(By.xpath("//input[@placeholder='Describe your issue']")).sendKeys("The best issue in town");
        /* the result is this error "Exception in thread "main" org.openqa.selenium.NoSuchElementException: no such element:
        Unable to locate element: {"method":"xpath","selector":"//input[@placeholder='Describe your issue']"}"
        because Selinium is still stick with the parent page. So we have to execute the below piece of code to switch 
        to the child page/windows and then being able to use all the fields in the child page.*/
        
        // to switch to the child window(s) we have to execute below sentences:
        Set<String> windowIds = driver.getWindowHandles(); //Creates a set containing a handle or the window id for all 
                  //windows opened so far. The parent window is located in the first row, then child in the order they are opened,
        Iterator<String> iterat = windowIds.iterator(); // Create an iterator (iterat) to traverse through the set created.
        String parentId = iterat.next(); // define a variable and assign the first element in the set. (the parent)
        String childId01 = iterat.next(); // create a variable and assign the second element in the set (the first child)
        driver.switchTo().window(childId01); //switch to the first child window, now all the webelement in there as accessible.
        System.out.println("After switching to child");
        System.out.println("Page Title is: " + driver.getTitle()); // this will display the first child page title. 
        
        driver.findElement(By.xpath("//input[@placeholder='Describe your issue']")).sendKeys("The best issue in town"); // type on first child page.
        driver.findElement(By.xpath("//a[contains(text(),'Verify your account')]")).click(); // to go to another child
        driver.switchTo().window(parentId); //switching back to the parent windows.
        System.out.println("After switching back To Parent windows");
        System.out.println("Page Title is: " + driver.getTitle());                        
	}  
}
