package WebDriverTestPackage;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
public class T17keyboardAndMouseEvents {
	public static void main(String[] args) {
	    System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
    	System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");  
	  	WebDriver driver = new FirefoxDriver();
//    	WebDriver driver = new ChromeDriver();

        String baseUrl = "http://demo.guru99.com/selenium/newtours/";
       
                driver.get(baseUrl);           
                WebElement link_Home = driver.findElement(By.linkText("Home"));
                WebElement td_Home = driver
                        .findElement(By
                        .xpath("//html/body/div"
                        + "/table/tbody/tr/td"
                        + "/table/tbody/tr/td"
                        + "/table/tbody/tr/td"
                        + "/table/tbody/tr"));    
                 
                Actions builder = new Actions(driver);
                Action mouseOverHome = builder
                        .moveToElement(link_Home)
                        .build();
                 
                String bgColor = td_Home.getCssValue("background-color");
                System.out.println("Before hover: " + bgColor);        
                mouseOverHome.perform();        
                bgColor = td_Home.getCssValue("background-color");
                System.out.println("After hover: " + bgColor);
        
// below build a series of multiple Actions:
	baseUrl = "http://www.facebook.com/";
	driver.get(baseUrl);
	WebElement txtUsername = driver.findElement(By.id("email"));
	
	Actions builder2 = new Actions(driver);
	Action seriesOfActions = builder2
			.moveToElement(txtUsername)
			.click()
			.keyDown(txtUsername, Keys.SHIFT) //this will type "hello" in uppercase
			.sendKeys(txtUsername, "hello")
			.keyUp(txtUsername, Keys.SHIFT)
			.doubleClick(txtUsername)         // this will highlight the text "HELLO"
			.contextClick()                    // this will bring up the context menu.
			.build();
	seriesOfActions.perform();
//  driver.close();
	}
}


		//*[@id="leftcontainer"]/table/thead/tr/th[1]
		//*[@id="leftcontainer"]/table/tbody/tr[1]/td[2]
