package UdemySlenium;   //instructor's email: rahulonlinetutor@gmail.com

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class T06FormMethods {

	public static void main(String[] args) throws InterruptedException {
		// This is an example of using Java Alerts, or NOT in the HTML code so when inspecting the alert no code is displayed.
		WebDriver driver;
	//	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
	//  driver = new FirefoxDriver();
	    System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver();
		String baseUrl = "https://www.makemytrip.com/";     
        driver.get(baseUrl);
        driver.manage().window().maximize();
        // .isDisplayed() method: it is used to verify if a webelement is hidden or displayed. This means that the 
        // webelement is defined in the html code, but it is not visible at a given time.
        // below validate if certain webelement is displayed depending on clicking another webelement.
        System.out.println("Is \"Add City\" button present before clicking on \"Multi City\" button? ");
//        System.out.println(driver.findElement(By.cssSelector("button[id='addModifyBtn']")).isDisplayed());
        driver.findElement(By.cssSelector("label[for='switch__input_3']")).click();
        System.out.println("Is \"Add City\" button present AFTER clicking on \"Multi City\" button? ");
        System.out.println(driver.findElement(By.cssSelector("button[id='addModifyBtn']")).isDisplayed());
        
        // the webelement for xpath("//label[@for='switch__input_3']/spam" is not defined on the page; so if I want
        // to use the isDisplayed method it will generate the error: "no such element: Unable to locate
        //element: {"method":"xpath","selector":"//label[@for='switch__input_3']/spam"} 
       // driver.findElement(By.xpath("//label[@for='switch__input_3']/spam")).isDisplayed();
        
        // so, to validate if a webelement is present or defined in the webpage, (to verify if it has not been deleted) we
        // have to use below logic.
        int count = driver.findElements(By.xpath("//label[@for='switch__input_3']/spam")).size();
        if (count == 0) {
        	System.out.println("Element is not present in the page ");
        }
        // this is a continuation on where to use above logic: Assuming that we are navigating from Home page to Contact page
        // so, in order to make sure that the contact page is completely loaded, we can check if one of the webelements in
        // the home page is not present (count==0) then if true I can start executing the code for Contact page. Note, another
        // way is by getting the pageTitle and verifying that it is the one for the contact page.
        
        //below make the execution wait for 3 seconds so that the page complete loading.
        Thread.sleep(3000L);
        
        //getText() method is used to get the text from specific place on the web page.
        System.out.println("getText() value is: " + driver.findElement(By.xpath("//h2[contains(text(),'Discover Hot Deals')]")).getText());
        
	}  
}
