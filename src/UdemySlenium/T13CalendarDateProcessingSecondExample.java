package UdemySlenium;   //instructor's email: rahulonlinetutor@gmail.com

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class T13CalendarDateProcessingSecondExample {

	public static void main(String[] args) throws InterruptedException {
		// This is an example for calendar date processing.
		
		//WebDriver driver = new ChromeDriver();
		WebDriver driver;
	//	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
	//  driver = new FirefoxDriver();
	    System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver();
       // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  // Define Implicit wait time to ask Selenium to 
        //    Wait up until 5 seconds for each sentence to complete before raising exception error.
     //	String baseUrl = "https://www.path2usa.com/travel-companions";
     //	driver.get(baseUrl);
     	
     	driver.get("https://www.makemytrip.com/flights/");

     	driver.manage().window().maximize();
     	Thread.sleep(6000L);
     	driver.findElement(By.xpath("//input[@id='hp-widget__depart']")).click(); 

     	 //Selecting ur desierd month

     	List <WebElement> nextButtons = driver.findElements(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']/span[@class='ui-icon ui-icon-circle-triangle-e']"));
     	int count = nextButtons.size();
     	System.out.println("Total Next buttons: " +count); //above 3 lines added by hector.
     	
         for (int i = 0; i < count; i++) {     	
     	//    while(!driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")).getText().contains("JUNE"))
     	//    {
     	       //driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']/span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
     	       
     	//    }
     	    if (driver.findElement(By.xpath("//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month']")).getText().equalsIgnoreCase("SEPTEMBER")) {
     	       break;	
     	    } else if (nextButtons.size() > 0) {
     	    	nextButtons.get(i).click();
     	    	break;
     	    }
     	    
         }
     	 int count1=driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).size();
     	 System.out.println(count1);
     	  
     	for (int i=0;i<count1;i++)
     	 {
     	  String s1=driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).get(i).getText();
     	  System.out.println(s1);
     	  
     	  if (s1.equalsIgnoreCase("11"))
     	  {
     	  driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).get(i).click();
     	  break;
     	  }
     	  
     	 }
     	 
     	//RETURN DATE DATE
     	 
     	driver.findElement(By.xpath("//input[@id='hp-widget__return']")).click();
     	 
     	Thread.sleep(3000);
     	System.out.println(driver.findElement(By.xpath("(//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month'])[3]")).getText());
     	 
     	while(!driver.findElement(By.xpath("(//div[@class='ui-datepicker-title']/span[@class='ui-datepicker-month'])[3]")).getText().contains("OCTOBER"))
     	{
     	driver.findElement(By.xpath("(//span[text()='Next'])[2]")).click();
     	}
     	 
     	 
     	int count2=driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).size();
     	System.out.println(count2);
     	 
     	 
     	for (int i=0;i<count2;i++)
     	{
     	 String s2=driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).get(i).getText();
     	 System.out.println(s2);
     	 
     	 if (s2.equalsIgnoreCase("15"))
     	 {
     	 driver.findElements(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr/td/a[@class='ui-state-default']")).get(i).click();
     	 break;
     	 }
     	 
     	}

     	}
	
	}  

