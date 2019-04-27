package newTestNGPackage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.Guru99HomePage;   //This pages are created in the "pages" folder or package
import pages.Guru99Login;      //This pages are created in the "pages" folder or package

public class UsingPOM_01_Simple {
    WebDriver driver;
    Guru99Login objLogin;       //This pages are created in the "pages" folder or package
    Guru99HomePage objHomePage; //This pages are created in the "pages" folder or package 

    @BeforeTest
    public void setup(){
    	System.out.println("Launching the browser");
		System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");  
//	    driver = new FirefoxDriver();
		driver = new ChromeDriver();  
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/");
    }

    /**
     * This test case will login in http://demo.guru99.com/V4/
     * Verify login page title as guru99 bank
     * Login to application
     * Verify the home page using Dashboard message
     */

    @Test(priority=0)
    public void test_Home_Page_Appear_Correct(){
    //Create Login Page object
    objLogin = new Guru99Login(driver);
    //Verify login page title
    String loginPageTitle = objLogin.getLoginTitle();
    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

    //login to application
    objLogin.loginToGuru99("mgr123", "mgr!23");
    // go the next page or create the object for the next page.
    objHomePage = new Guru99HomePage(driver);
    //Verify home page
    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
    }
}

