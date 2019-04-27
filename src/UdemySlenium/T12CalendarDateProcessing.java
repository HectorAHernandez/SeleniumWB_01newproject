package UdemySlenium;   //instructor's email: rahulonlinetutor@gmail.com

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class T12CalendarDateProcessing {

	public static void main(String[] args) throws InterruptedException {
		/* This is an example for calendar date processing. when the page is using the javaScrip <!-- Bootstrap 
		   Date-Picker Plugin --> in the header */
		WebDriver driver;
	//	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
	//  driver = new FirefoxDriver();
	    System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  // Define Implicit wait time to ask Selenium to 
        //    Wait up until 5 seconds for each sentence to complete before raising exception error.
     	String baseUrl = "https://www.path2usa.com/travel-companions";
     	driver.get(baseUrl);
     	driver.findElement(By.cssSelector("#travel_date")).click(); // to open the date field or start executing the 
     	// javaScript for the Date-Picker. The date to Define is August 23 2018.
     	// we start with the month. for this we enter in a loop while to click on the next button of the month calendar while
     	/* the month is not equal to the month we are looking for, August in this case. Below table name and class name are
     	 * the one from the date-picker javaScript, so we have to use the same. To see this table and class we have to click
     	 * on the field and then inspecting the page and using ChromePath. */
     	while(!driver.findElement(By.cssSelector("table[class=' table-condensed'] [class='datepicker-switch']")).getText().contains("August")){
     		  driver.findElement(By.cssSelector("table[class=' table-condensed'] th[class='next']")).click(); //click on the >> simbol/Webelement to get next month.
     	}
     	//this is another CSS locator that could be use in the while: [class='datepicker-days'] [class='datepicker-switch']
     	// After finding the month, go for the day
     	
     	//grab a common attribute to group all the days into a list for then iterate on them (this attribute is class's name=day). 
     	List <WebElement> days = driver.findElements(By.className("day"));  
     	//List days = (List) driver.findElements(By.className("day"));
     	// determine the size of the list.
     	//int count = driver.findElements(By.className("day")).size();
     	int count = days.size();
     	for (int i = 0; i < count; i++) {
     		//String day = driver.findElements(By.className("day")).get(i).getText();
     		String day = days.get(i).getText();
     	    if (day.equals("23")) {    //Select the day we are expect.
     	    	driver.findElements(By.className("day")).get(i).click();
     	    	break;
     	    } 	
     	}
     	     	
	}  
}
