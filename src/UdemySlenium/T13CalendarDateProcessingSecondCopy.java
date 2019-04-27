package UdemySlenium;   //instructor's email: rahulonlinetutor@gmail.com

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class T13CalendarDateProcessingSecondCopy {

	public static void main(String[] args) throws InterruptedException {
		// This is an example for calendar date processing.
		
		//WebDriver driver = new ChromeDriver();
		WebDriver driver;
	//	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
	//  driver = new FirefoxDriver();
	    System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver();
       // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  // Define Implicit wait time to ask Selenium to 
        //    Wait up until 5 seconds for each sentence to complete before raising exception error.
     //	String baseUrl = "https://www.path2usa.com/travel-companions";
     //	driver.get(baseUrl);
     	
     	driver.get("https://www.makemytrip.com/flights/");

     	driver.manage().window().maximize();
     	Thread.sleep(3000L);
 //    	driver.findElement(By.xpath("//input[@id='hp-widget__depart']")).click(); 

     	 //Selecting your desired month:

  /*   	
     // original code for selecting the month.     	
          	    while(!driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")).getText().contains("JANUARY"))
          	  //while(!driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")).getText().contains("JUNE"))	
          	    {
          	    	driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-circle-triangle-e'])[1]")).click(); // this is the one working.
          	    //	driver.findElement(By.xpath("(//span[text()='Next'])[1]")).click(); // this is the one working.
          	    }                               
*/
/*
  // Below was an EXAMPLE of HOW to use the "findFrameNumber(driver, WebElement) (See method at the bottom) to find the WebElement in a frame, but
  // it did not work because the field is not in a frame. (This page has 6 frames.)
     	int number = 0;
       	number = findFrameNumber(driver, By.xpath("(//span[text()='Next'])[1]")); 
       	//number = findFrameNumber(driver, By.xpath("//a[@class='ui-datepicker-next ui-corner-all']/span[@class='ui-icon ui-icon-circle-triangle-e']"));
       	 // above find the number/order of the frame containing the indicated WebElement By.xpath(). as parameter.
       	if (number > 0) { //if a frame was found containing the indicated WebElement
         	driver.switchTo().frame(number);    //switch to the frame containing the frame number
         	while(!driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")).getText().contains("DECEMBER"))	
     	    {
     	    	driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']/span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); 
     	    // above click on the WebElement found on the frame.
     	    }       	
       	} 
       	else {
       	    System.out.println(" ***No Frame found with indicated Webelement: (//span[text()='Next'])[1] *** ");
       	}
*/    
     	
// To select the day.     	    
     	 int count1= driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).size();
     	 System.out.println(count1);
     	  
     	for (int i=0;i<count1;i++)
     	 {
     	  String s1=driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).get(i).getText();
     	  System.out.println(s1);
     	  
     	  if (s1.equalsIgnoreCase("24"))
     	  {
     	  driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).get(i).click();
     	  break;
     	  }
     	  
     	 }
     	 
     	//RETURN DATE DATE
     	 
     	driver.findElement(By.xpath("//input[@id='anotherDeparture 0']")).click();
     	// Original: driver.findElement(By.xpath("//input[@id='hp-widget__return']")).click();
     	 
     	Thread.sleep(3000);
     	System.out.println(driver.findElement(By.xpath("(//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month'])[3]")).getText());
     	 
     	while(!driver.findElement(By.xpath("(//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month'])[3]")).getText().contains("JANUARY"))
     //	while(!driver.findElement(By.xpath("(//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month'])[3]")).getText().contains("OCTOBER"))	
     	{
     	driver.findElement(By.xpath("(//span[text()='Next'])[2]")).click();
     	}
     	 
     	 
     	int count2=driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).size();
     	System.out.println(count2);
     	 
     	 
     	for (int i=0;i<count2;i++)
     	{
     	 String s2=driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).get(i).getText();
     	 System.out.println(s2);
     	 
     	 if (s2.equalsIgnoreCase("25"))
     	 {
     	 driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).get(i).click();
     	 break;
     	 }
     	 
     	}

     	}
	
	// Create the reusable method or function. to receive, as parameters, the driver and field to search as present in one of the frames
		// contained in the driver. And return the number (order) of the frame containing the field. Note: the Frames are independent. Not parent/child.
		public static int findFrameNumber (WebDriver driver, By by )  { // to have access to the driver defined in the main module, (driver is received as
			                                              // a parameter of type WebDriver)
		//public void findFrameNumber (WebDriver driver )  { // we started the method with "void" as not returning the frame number, and then 
			                                                 // changed to "int" to return the frame number. Also added the By by, to received
			       // the field we want to find in the frame
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
				i = 0;
			}
		    return i;  //return the frame number.
		}
	
	}  

