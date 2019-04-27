package StepDefinition2;
/* Creating Step Definition script.
Now here we create 'StepDefinition' package and then 'Steps.java' script file 
under it. Here we actually write a selenium script to carry out the test under
Cucumber methods.

the class is created with the name 'Steps.' Cucumber annotation is used to "map" with 
the MyTest.feature file in folder "Features", from this feature file, Each annotation method
is defined:
@Given annotation define method to: "open firefox and launch the application"
@When annotation define method to: "enter the username and password"
@Then annotation define method to: "reset the credential"
Look at the method's name, it is same as the annotation content with "_" instead of space.
Under each method, for now, we are only printing a message.

* Note: Step definition is nothing but the steps you want to perform under this cucumber method.
*/
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.firefox.FirefoxDriver;		

import cucumber.api.java.en.Given;		
import cucumber.api.java.en.Then;		
import cucumber.api.java.en.When;		

public class Steps2 {				

    WebDriver driver;	
    String driverPath = "C:\\selenium-3.11.0\\geckodriver.exe";
    		
    @Given("^Open the Firefox and launch the application$")					
    public void open_the_Firefox_and_launch_the_application() throws Throwable							
    {		
       System.setProperty("webdriver.gecko.driver", driverPath);					
       driver= new FirefoxDriver();					
       driver.manage().window().maximize();			
       driver.get("http://demo.guru99.com/v4");
    }		

    @When("^Enter the Username \"(.*)\" and Password \"(.*)\"$")			
    public void enter_the_Username_and_Password(String username,String password) throws Throwable 							
    {		
       driver.findElement(By.name("uid")).sendKeys(username);					
       driver.findElement(By.name("password")).sendKeys(password);					
    }		

    @Then("^Reset the credential$")					
    public void	Reset_the_credential() throws Throwable 							
    {		
       driver.findElement(By.name("btnReset")).click();					
    }		
}