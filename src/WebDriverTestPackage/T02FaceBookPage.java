package WebDriverTestPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T02FaceBookPage {
    public static void main(String[] args) {
    	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
    	System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
    	//Webdriver driver;  //if uncommenting this then to instantiate the browser we have 
    	//driver = new ChromeDriver();   // to use on of these two commands.
    	//driver = new FirefoxDriver();
    	WebDriver driver = new FirefoxDriver();  //another way to instantiate the browser.
    	//WebDriver driver = new ChromeDriver();
        String baseUrl = "http://www.facebook.com";
        String tagName = "";
        
        driver.get(baseUrl);
        tagName = driver.findElement(By.id("email")).getTagName();
        System.out.println("***** Tag name/type for email is input and we got: "+tagName);
/* Locating GUI Elements or element displayed in the browser:
Locating elements in WebDriver is done by using the "findElement(By.locator())" method. 
The "locator" part of the code is same as any of the locators previously discussed in the 
Selenium IDE chapters of these tutorials.*/
        
        //locates elements based on the value of the name attribute:
        tagName = driver.findElement(By.name("pass")).getTagName();
        System.out.println("***** find elements based on the value of the name attribute, Tag name/type is input for password and got: "+tagName);
//locates elements based on the value of a "id" attribute:
        tagName = driver.findElement(By.id("month")).getTagName();
        System.out.println("***** find elements based on the value of a id attribute, Tag name/type for month is select and got: "+tagName);
        tagName = driver.findElement(By.name("websubmit")).getTagName();
        System.out.println("***** Tag name for Sign up button is button and got: "+tagName);
//find elements based on the value of a "class" attribute:
        tagName = driver.findElement(By.className("inputtext")).getTagName();
        System.out.println("***** find elements based on the value of a class attribute,Tag name is: "+tagName);
//find elements based on the driver's underlying CSS selector engine, using id:
//        tagName = driver.findElement(By.cssSelector("input#u_0_e")).getTagName();
//        System.out.println("***** find elements based on the driver's underlying CSS selector engine, Tag name is: "+tagName);
//find a link elements by the exact text it displays,:
        tagName = driver.findElement(By.linkText("Facebook")).getTagName();
        System.out.println("***** find a link elements by the exact text it displays, Facebook link, Tag name/type is a and got: "+tagName);
//Locates the elements that contain the PARTIAL link text,:
        tagName = driver.findElement(By.partialLinkText("book")).getTagName();
        System.out.println("***** Locate the elements that contain the PARTIAL link text, Facebook link, Tag name/type is a and got: "+tagName);
//Locates the elements by their tag name,:
        tagName = driver.findElement(By.tagName("Div")).getTagName();
        System.out.println("***** Locate their Tag Name, Tag Div, Tag name is: "+tagName);       
//Locates elements via XPath:
//        tagName = driver.findElement(By.xpath("//html/body/div[1]/div[2]/div[1]/div/div/div/div/div[2]/h2")).getTagName();
//        System.out.println("***** Locates elements via XPath, For Sing Up header, Tag name is: "+tagName);       


// Instantiating WebElements to access a particular element without using the "driver.findElement(By.locator())"  
        WebElement HectorElement = driver.findElement(By.id("email")); /*using the id attribute, find the 
                   location of the email field in the browser and pass it to the new WebElement HectorElement, from now on
                   any action we want to take over the GUI element we can do it through this new WebElement HectorElement. */
        HectorElement.sendKeys("hectorTest@gmail.com");  /* provision the email field in the browser with the 
                                   value "hectorTest@gmai.com */
        System.out.println("***** Content/value of instantiated WebElement HectorElement is: "+HectorElement.getAttribute("value"));
        System.out.println("***** Content/value of original element  email is: "+driver.findElement(By.id("email")).getAttribute("value"));
        System.out.println("***** the inner text of original element  email is: "+driver.findElement(By.id("email")).getText());
/* this command: driver.findElement(By.id("email")).getAttribute("value") acces the value of a UI field and then it can be
 * moved to the another field like "actual" to compare against "expected". Note DO NOT use getText() */
// To refresh the current page.
//        driver.navigate().refresh();
// Getting the title of the current page.
        System.out.println("***** The Title of the current page is : "+driver.getTitle());
// Getting the page source code of the current page.
//        System.out.println("***** The Source code of the current page is : "+driver.getPageSource());
// Getting the current URL that the browser is looking at.
      System.out.println("***** The current URL that the browser is looking at is : "+driver.getCurrentUrl());

/* common command:
 * Instantiating Web Elements
Instead of using the long "driver.findElement(By.locator())" syntax every time you will access a particular element, we can
instantiate a WebElement object for it. The WebElement class is contained in the "org.openqa.selenium.*" package. */      
      WebElement hectorElement = driver.findElement(By.name("firstname"));
      hectorElement.sendKeys("Hector");
      
// Clicking on an Element:
      driver.findElement(By.id("loginbutton")).click();  
// To navigate Back one page on the browser history
      driver.navigate().back();
// To navigate Forward one page on the browser history
//      driver.navigate().forward();
      
// To close ONLY the browser window that WebDriver is currently controlling use the close() method.
    driver.close();
// To close ALL the browser windowsthat WebDriver has opened use the quit() method.
//      driver.quit();
      
     System.exit(0);
}
}
