package UdemySlenium;   //instructor's email: rahulonlinetutor@gmail.com

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class T14MultiFramesProcessing {

	public static void main(String[] args) throws InterruptedException {
		// This is an example accessing multiple frame defining a reusable method.
		
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
	    driver = new FirefoxDriver();
	//    System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
    //    driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  // Define Implicit wait time to ask Selenium to 
        //    Wait up until 5 seconds for each sentence to complete before raising exception error.
     	String baseUrl = "https://www.google.com/recaptcha/api2/demo";
     	driver.get(baseUrl);

     	/* Note: when dealing with frames, If I'm in the main page, move to a frame, then if I want to move to another 
     	 * sibling/independent frame then I need to return to the main page with driver.switchto().defaultContent() and then 
     	 * switching to the desired frame with driver.switchTo().frame(xxxx). But If I want to move to a child or
     	 *  parent frame then I can directly by using the driver.switchTo().frame(zzzz)*/
     	int number = 0;
      	number = findFrameNumber(driver, By.xpath("//*[@id='recaptcha-anchor']/div[5]")); // find the number/order of the frame 
       	                                  // containing the indicated WebElement By.xpath(). as parameter.
       	System.out.println("Frame Number where element was found  = "+ number);
       	if (number != 9999) { //if a frame  found containing the indicated WebElement
       		driver.switchTo().frame(number);    //switch to the frame containing the WebElement
        	driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[5]")).click();;  // Now click on the WebElement found on the frame.
       	} 
       	else {
       		System.out.println(" ***No Frame found with indicated Webelement: //*[id='recaptcha-anchor']/div[5] *** ");
       	}
   
       	//now to click on a button on a new frame triggered by the previous one
       	driver.switchTo().defaultContent();  // to move back to the main page from the accessed frame, this is because these two frames
       	          // are siblings or independent. If they were in a parent/child relationship, then this sentence was not needed, only go
       	          // and switch to the frame directly, as in line #47.
    	number = findFrameNumber(driver, By.xpath("//*[@id='recaptcha-verify-button']")); // find the number/order of the frame containing
           // the indicated WebElement By.xpath(). as parameter.
    	//System.out.println("Number 2 = "+ number);
    	if (number != 9999) {  //if a frame was found containing the indicated WebElement
    		driver.switchTo().frame(number);    //switch to the frame containing the frame number
    		driver.findElement(By.xpath("//*[@id='recaptcha-verify-button']")).click();;  // Now click on the WebElement found on the frame.
    	} 
    	else {
    		System.out.println(" ***No Frame found with indicated Webelement ///*[@id=\"recaptcha-verify-button\"] *** ");
    	}

	}  
	
	/* Create the reusable method or function. to receive, as parameters: the driver and field to search as present in one of 
	 * the frames contained in the driver. And return the number (order) of the frame containing the field. Note: the 
	 * Frames are independent. Not parent/child.*/
	public static int findFrameNumber (WebDriver driver, By by )  { // to have access to the driver defined in the main 
		                                              // module, (driver is received as a parameter of type WebDriver)
	//public void findFrameNumber (WebDriver driver )  { // we started the method with "void" as not returning the frame number, and then 
		        // changed to "int" to return the frame number. Also added the By by, to received
		       // the field we want to find in the frame. "By" is special when findBy (by.xpath() or by.cssSelector()) is 
		       // passed as parameter */
	    int i = 0;
	    int elementsCount = 0;
		int frameCount = driver.findElements(By.tagName("iframe")).size();  //determine the number of frame in the driver.
		if (frameCount > 0) { 
			System.out.println("frameCount = "+frameCount);
			System.out.println("**** by = "+by);
		 
		    // Create a loop to traverse throw all existing frame in the driver so that we can try to find the elements in the frame we want.
	        for (i = 0; i < frameCount; i++) {
	        	//Thread.sleep(6000L);
	        	driver.switchTo().frame(i);    // switch to the frame (i).
	            
	            elementsCount = driver.findElements(by).size(); //findElements: finds ALL the WebElements, this help to determine
	              // if the Webelement is present in the frame, (size() > 0 indicates that the webElement if present in the frame).
	            System.out.println("Frame: " + i + " elementsCount = "+elementsCount);
	            if  (elementsCount > 0 ) {   //found
	           	// driver.findElement(by).click();  //Started with click when found element; BUT then changed to make the 
	                            // click in the main or calling program, or because now we have a generic method.
	            	System.out.println("WebElements FOUND on Frame: " +i);
	            	driver.switchTo().defaultContent();// Get back to main page, because the frames are independent, and to avoid exception "no such frame"
	            	break;      //so only break/exit when found the WebElement.
	            } 
	            else {
	        	    System.out.println("continue looping...");
	            }
	            driver.switchTo().defaultContent();// Get back to main page, because the frames are independent, and to avoid exception "no such frame" 
	         }
		}
		else {
	    	System.out.println("*** This Page does not contain any Frame *****");
    	}
	  	if (elementsCount == 0) {  //If the WebElement was NOT FOUND.
	  	    System.out.println("***  ELEMENT NOT FOUND  ***");
			i = 9999;
		}
	    return i;  //return the frame number.
	}
	
	
}
