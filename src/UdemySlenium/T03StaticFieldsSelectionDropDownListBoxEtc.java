package UdemySlenium;   //instructor's email: rahulonlinetutor@gmail.com

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class T03StaticFieldsSelectionDropDownListBoxEtc {

	public static void main(String[] args) {
		// This is an example of using xpath and CSS for identifying the webelements.
		WebDriver driver;
	//	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
	//  driver = new FirefoxDriver();
	    System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver();
		String baseUrl = "http://spicejet.com/";    
		System.out.println("set base URL");
        driver.get(baseUrl);
        driver.manage().window().maximize();

        // Selecting values from static Dropdown list:
        Select s = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));	
        s.selectByValue("USD");
        s.selectByIndex(0);
        s.selectByVisibleText("AED");
        
        // Selecting values from dynamic Dropdown list: this example is related to an interview question, where there is 
        // a dynamic drop down list (cities) that is share by two fields (Departure and Return), in this case the city for 
        // the departure is successful accessed but when trying the return city the error "element not visible" is displayed
        // because after selecting the first field the list is closed, so to access the second one we need to use the index
        // of the xpath used by putting brackt to the xpath (//a[@value='value'])[2] and adding the index reference [2].
        // Example: first click on the first field to open the list:
        driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
        // Click to make the first selection on the list:
        driver.findElement(By.xpath("//a[@value='MAA']")).click();
        System.out.println("clicked origin...");
        // after selecting the first the page automatically open the list for the second field, so we have to make the second one
        // if we use below xpath (which is the one use with ChromPath or FirePath) the error "element not clickable" will be displayed.
        /* this is the error generated: Exception in thread "main" org.openqa.selenium.WebDriverException: unknown error: 
           Element <a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;
           " text="Vijayawada (VGA)" value="VGA">...</a> is not clickable at point (855, 579). Other element would receive 
           the click: <a href="#" class="" tooltip="" onclick="javascript:$CityDropDown.SetSelectedValue(this);return false;
           " text="Jharsuguda (JRG)" value="JRG">...</a>*/
  //      driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
  //      driver.findElement(By.xpath("//a[@value='VGA']")).click();  

      /*Assuming that the error occurred, the solution in using the index of the xpath to select the second field list value
         defined for id='ctl00_mainContent_ddl_destinationStation1_CTXT'.*/
       driver.findElement(By.xpath("(//a[@value='BOM'])[2]")).click();  /* THIS ONE worked without clicking to open the second field.
               because we are sing the [2] to indicate to use the second list or the list for the second field "(//a[@value='BOM'])[2]"}"
               this is select the value 'BOM' in the second list*/
              // *********** so below one is the solution for the error, the same as above:
 //      driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
 //      driver.findElement(By.xpath("(//a[@value='VTZ'])[2]")).click();
       
       //validate whether a checkbox field is selected by default.
       System.out.println(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());
       driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).click(); //click on the checkbox.
       System.out.println(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());
     //input[@name='ctl00$mainContent$chk_friendsandfamily']
	}  

}
