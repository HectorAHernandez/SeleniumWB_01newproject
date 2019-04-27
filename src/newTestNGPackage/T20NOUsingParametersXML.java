package newTestNGPackage;


	import org.testng.annotations.Test;
	import org.testng.AssertJUnit;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.firefox.FirefoxDriver;

	public class T20NOUsingParametersXML {
		public String driverPath = "C:\\selenium-3.11.0\\geckodriver.exe";
		WebDriver driver;
	    
	    @Test
	    public void testNoParameter() throws InterruptedException{
	        String author = "guru99";
	        String searchKey = "india";
	        
			  System.setProperty("webdriver.gecko.driver", driverPath);
		//	  System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");  

	        //System.setProperty("webdriver.firefox.marionette", driverPath);        
	        driver= new FirefoxDriver();
	        //driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
	        driver.get("https://google.com");
	        WebElement searchText = driver.findElement(By.name("q"));
	        //Searching text in google text box
	        searchText.sendKeys(searchKey);
	        
	        System.out.println("Welcome ->"+author+" Your search key is->"+searchKey);
	                System.out.println("Thread will sleep now");
	        
	        Thread.sleep(3000);
	        System.out.println("Value in Google Search Box = "+searchText.getAttribute("value") +" ::: Value given by input = "+searchKey);
	        //verifying the value in google search box
	        AssertJUnit.assertTrue(searchText.getAttribute("value").equalsIgnoreCase(searchKey));
	}
	}