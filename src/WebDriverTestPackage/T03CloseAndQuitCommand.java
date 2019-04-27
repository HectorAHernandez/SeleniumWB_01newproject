package WebDriverTestPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class T03CloseAndQuitCommand {
	public static void main(String[] args) {
        // declaration and instantiation of objects/variables
    	WebDriver driver ;
    	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
    	System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
//    	driver = new ChromeDriver();
    	driver = new FirefoxDriver();
        String baseUrl = "http://www.popuptest.com/popuptest2.html";
        
        // launch Fire fox or Chrome and direct it to the Base URL
        driver.get(baseUrl);

        //With close only the parent browser window is closed, the two popup stay open.
        //driver.close();
        //With quit() ALL windows and popup are closed.
        driver.quit();
        
        // exit the program explicitly
        //    System.exit(0);
    }
}
