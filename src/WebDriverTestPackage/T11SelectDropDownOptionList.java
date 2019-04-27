package WebDriverTestPackage;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.By;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;

	public class T11SelectDropDownOptionList {
	 public static void main(String[] args) { 
	    	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
	    	System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");  
	    	String baseUrl = "http://newtours.demoaut.com/mercuryregister.php";
		  	WebDriver driver = new FirefoxDriver();
//	    	WebDriver driver = new ChromeDriver();
			driver.get(baseUrl);

			Select drpCountry = new Select(driver.findElement(By.name("country")));
			drpCountry.selectByVisibleText("ANTARCTICA");

			//Selecting Items in a Multiple SELECT elements
			driver.get("http://jsbin.com/osebed/2");
			Select fruits = new Select(driver.findElement(By.id("fruits")));
			fruits.selectByVisibleText("Banana");
			fruits.selectByIndex(2);
			fruits.selectByIndex(3);
			//driver.close();
	 }
	}