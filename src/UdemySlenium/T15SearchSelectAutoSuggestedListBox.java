package UdemySlenium;   //instructor's email: rahulonlinetutor@gmail.com

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class T15SearchSelectAutoSuggestedListBox {

	public static void main(String[] args) throws InterruptedException {
		// This is an example Searching and Selecting On Auto-Suggested list box. we will enter BENG, traverse to the list and then
		// verifying that an specific airport is include in the list.
		
		WebDriver driver;
	//	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
	//  driver = new FirefoxDriver();
	    System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  // Define Implicit wait time to ask Selenium to 
        //    Wait up until 5 seconds for each sentence to complete before raising exception error.
     	String baseUrl = "http://ksrtc.in/oprs-web/";
     	driver.get(baseUrl);
        
     	// Enter BENG and traverse the list, with DOWN key.
     	driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("BENG");
// *******   Original way, for learning: 

     	driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
     	driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
     	driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
     	System.out.println("fromPlaceName is: "+driver.findElement(By.xpath("//input[@id='fromPlaceName']")).getText()); 
     	//Above won't work, will display empty, because this field is hidden. so we will need to use JavaScript.Executor, see below
     	// when the Parent class definition contains class ='xxx-eeeee-hidden-accessible', we won't be able to get he content of the field using the
   //getText() method (driver.findElement(By.xpath("xxxxxx")).getText()), so we will need to use the "javascript executor or JavaScript HTML DOM". 
   //this is usually found when searching an AutoSuggested list box. See T15SearchAutosuggesstedLitbox.java.
   //With HTML DOM (Object Document Model), JavaScript can access and change all the elements in an HTML document, including the hidden ones. 
   //we have to use JavaScrip HTML DOM, because Selenium cannot identify hidden WebElements in an HTML document.  
   //We will need to investigate the properties of the element to see if it has hidden text. 
   //We are running Selenium with Java; but the way to execute JavaScript in Java is using the JavaScript.executor() method.
   //In the console, this command allow to getText() from the field: 
   //       document.getElementByClassName('class-name').value        ---> JavaScript
   //       document.getElementByTagName('tag-name').value        ---> JavaScript
   //       document.getElementById('fromPlaceName').value        ---> JavaScript
   //       driver.findElement(By.id('idText-name')).getText()    ---> in Selenium-Java 
   //       document.xxx displays all the get options, similare to driver.xxx  
    	     	
     	JavascriptExecutor js = (JavascriptExecutor)driver;  //instantiate the JavaScript executor class.
     	String script = "return document.getElementById('fromPlaceName').value;";  //build the script to be executed.
     	//String script = "return document.getElementById(\"fromPlaceName\").value;";  // \" to accept the ".
     	String text = (String) js.executeScript(script); // execute the script and return result in String type.
     	System.out.println("Hidden Text is: " + text);   // Now we have access to the hidden text.
     	

// *******   Final way, for implementation:     	
//     	String script = null;
//	    String text = "Initial";
	    int i=0;
	    JavascriptExecutor js2 = (JavascriptExecutor)driver;    //instantiate the JavaScript executor class.
     	while (!text.equalsIgnoreCase("BENGALURU DARSHINI")) {
        //while (!text.equalsIgnoreCase("BENGALURU AIRPORT")) {	
     		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
     		script = "return document.getElementById('fromPlaceName').value;";  //build the script to be executed.
         	//String script = "return document.getElementById(\"fromPlaceName\").value;";  // \" to accept the ".
         	text = (String) js2.executeScript(script); // execute the script and return result in String type. 
         	i++;
         	if (i > 12) {  //exit the while loop after 10 search and not found.
         		break;
         	}
     	} 
     	if (i > 12) {    //text not found
     	    System.out.println("**** Text NOT FOUND ****"); 
     	} 
     	else {
     		System.out.println("Hidden Text is: " + text);   // Now we have access to the hidden text, and it is in the text variable.
     		
     	}
     	
	}		
}
