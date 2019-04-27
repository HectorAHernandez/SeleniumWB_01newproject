package WebDriverTestPackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Iterator;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class TestToDelete {
	public static void main(String[] args) {
    	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
    	System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");  
	  	WebDriver driver = new FirefoxDriver();
//    	driver = new ChromeDriver();
      //  driver.get("http://demo.guru99.com/selenium/deprecated.html");
      //  driver.switchTo().frame("classFrame");
      //  driver.findElement(By.linkText("Deprecated")).click();
       // driver.close();
	  	
	  	driver.get("https://dev.www.tycois.com/");
	  	WebElement industries = driver.findElement(By.cssSelector("div.columns.three.alpha > ul"));
	  	List<WebElement> links = industries.findElements(By.tagName("li"));
	  	for (int i = 1; i < links.size(); i++)
	  	{
	  	    System.out.println(links.get(i).getText());
	  	}
	  	
    }
}
