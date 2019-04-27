package WebDriverTestPackage;

import java.util.List;     // to work with the list 
import java.util.concurrent.TimeUnit;  // to define the wait time of 5 seconds.
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class T13AllLinksInAPageValidation {
 public static void main(String[] args) { 
    	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
    	System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");  
//	  	WebDriver driver = new FirefoxDriver();
//    	WebDriver driver = new ChromeDriver();

    	String baseUrl = "http://newtours.demoaut.com/";
    	String expected = "null";
    	String actual = "null";
        WebDriver driver = new FirefoxDriver();
        String underConsTitle = "Under Construction: Mercury Tours"; // Title of the error page when link not implemented
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // Define the time to wait, 5 seconds, after clicking the link.

        driver.get(baseUrl);
        List<WebElement> hectorLinkElements = driver.findElements(By.tagName("a")); // Create a list of WebElements containing all the LINK elements in the page.
        String[] array_linkTexts = new String[hectorLinkElements.size()]; // Create an String array, linkTexts, the size of the LINK elements list.

 //       String[] arrayLinkName = new String[hectorLinkElements.size()]; 
        		
        String[] arrayLinkName = new String[] {"Home", "Flights", "Hotels", "Car Rentals", "Cruises", "Destinations",
        	"Vacations", "SIGN-ON", "REGISTER", "SUPPORT", "CONTACT", "your destination",
        	"featured vacation destinations", "Register here", "Business Travel @ About.com",
        	"Salon Travel"};
       // for (int i = 0; i < arrayLinkName.length; i++) {
       // 	System.out.println(" Link Name: " + arrayLinkName[i]);
       // }
        
        
        String[] arrayPageName = new String[] {"Welcome: Mercury Tours", "Welcome: Mercury Tours", "Under Construction: Mercury Tours",
        	 "Under Construction: Mercury Tours", "Cruises: Mercury Tours", "Under Construction: Mercury Tours",
        	 "Under Construction: Mercury Tours", "Sign-on: Mercury Tours",  "Register: Mercury Tours",
        	 "Under Construction: Mercury Tours", "Under Construction: Mercury Tours",
        	 "Under Construction: Mercury Tours", "Under Construction: Mercury Tours",
        	 "Register: Mercury Tours",  "404 Not Found",  "Salon: in-depth news, politics, business, technology & culture"};
        	 
      // for (int i = 0; i < arrayPageName.length; i++) {
      //  	System.out.println(" Page Name: " + arrayPageName[i] +" And Link: " + arrayLinkName[i]);
      //  }
        
          
        int i = 0;
        //extract the link texts of each link element
        for (WebElement e : hectorLinkElements) {   
        	//this is a foreach structure that define "e" a WebElement and in the loop 
        	//access all the elements in the list until end.
            array_linkTexts[i] = e.getText();   
            // assign the text of each link element to the array.
            i++;
        }

        
        //list all the link moved
       // for (String ws_link : array_linkTexts) {       // another foreach loop
       //      System.out.println("\"" + ws_link + "\"" + " is one of the link.");
       //      }   

        
        for (int j = 0; j < hectorLinkElements.size(); j++) {
        	WebElement  ws_element = driver.findElements(By.tagName("a")).get(j); 
        	//assign the linkElement(j) to the ws_element WebElement.
        	String linkText = ws_element.getText();   
        	//copy the text of the ws_element to the linkText string varialbe
        	//System.out.println("\"" + linkText + "\"" + " ******** link to Test."); 
        	// to see the link before the error on "Register here"
        	ws_element.click();  // click on the link save in the element webElement.
        	//System.out.println("---**** url: " + driver.getCurrentUrl());
        	//System.out.println(linkText+": "+ "\""+driver.getTitle()+"\"" );
            
        	actual = driver.getTitle();
        	//System.out.println("---**** url: " + driver.getCurrentUrl());
        	boolean found = false;
        	
        	for (int n = 0; n < arrayLinkName.length; n ++) {
                if (linkText.equals(arrayLinkName[n])) {  // v.
            	   expected = arrayPageName[n];
            	   found = true;
                }
        	}
        	if (!found) { expected = null;}
        	
        	System.out.println("actual: " + actual +" expected: " + expected);
        	
        	/*if (driver.getTitle().equals(underConsTitle)) {  
            	// verify if the link is under construction.
                System.out.println("\"" + linkText + "\""
                        + " is under construction.");
            } else {
                System.out.println("\"" + linkText + "\""
                        + " is working.");
            }*/
            
            driver.navigate().back();
        }
       // driver.close();       
    }
}    	
//for (String t : linkTexts) {       // another foreach loop
//	System.out.println("\"" + t + "\"" + " ******** link to Test."); // to see the link before the error on "Register here"
// //   driver.findElement(By.linkText(t)).click();  // click on each link in the page.
//    driver.findElement(By.partialLinkText(t)).click();  // click on each link in the page.
//    if (driver.getTitle().equals(underConsTitle)) {  // verify if the link is under construction.
//        System.out.println("\"" + t + "\""
//                + " is under construction.");
//    } else {
//        System.out.println("\"" + t + "\""
//                + " is working.");
//    }
//    driver.navigate().back();
//}
    	