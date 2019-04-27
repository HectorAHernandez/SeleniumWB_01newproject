package WebDriverTestPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
public class T01MyClass { 

	public static void main(String[] args) {
        // declaration and instantiation of objects/variables
    	WebDriver driver ;
    	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
    	driver = new FirefoxDriver();
    	//comment the above 2 lines and uncomment below 2 lines to use Chrome    	
    	//System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
        //driver = new ChromeDriver();

        String baseUrl = "http://newtours.demoaut.com";
        // below is another alternative to the demo application, we won't use it because it is not stable.
        //String baseUrl = "http://demo.guru99.com/test/newtours/";
        
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // launch Fire fox or Chrome and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed, yeah!");
        } else {
            System.out.println("Test Failed");
        }
       
        //close Fire fox or Chorme: this close the browser window.
        driver.close();
       
        // exit the program explicitly: if we use this exit(0) command without closing ALL
        // browser windows first, the java program will end while leaving the browser 
        // window opened.
        System.exit(0);
    }

}