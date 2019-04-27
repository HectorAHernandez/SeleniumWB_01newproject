package UdemySlenium;   //instructor's email: rahulonlinetutor@gmail.com

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class T16UsingTables {

	public static void main(String[] args) throws InterruptedException {
		// This is an example Using Table for adding all the content in a column and compare the total value.
		
		WebDriver driver;
	//	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
	//  driver = new FirefoxDriver();
	    System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  // Define Implicit wait time to ask Selenium to 
        //    Wait up until 5 seconds for each sentence to complete before raising exception error.
     	String baseUrl = "http://www.cricbuzz.com/live-cricket-scorecard/19587/lancs-vs-yorks-north-group-royal-london-one-day-cup-2018";
     	driver.get(baseUrl);
     	
     	int sum = 0;
     	// Defining table as the scope of specific table that we want to cover with the program, or that our operations work on.
     	WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
     	//below count only the rows included in the scope defined with "table".
     	int rowCount = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']")).size();
     	System.out.println("rowCount = " + rowCount);                  
     	int rowCountForColumn3 = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
     	//above count the number of rows for column # 3, or the 3rd div tag ( div:nth-child(3) ) in the row. this div:nth-child(3)
     	// has the value 144. this is an example on how to traverse from Parent to child, using the div:nth-child(3).
     	System.out.println("rowCountForColumn3 is = " + rowCountForColumn3);  
     	
     	for (int i=0; i < rowCountForColumn3 - 2; i++) {  // -2 to not print the last two rows
     		System.out.println(table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText());
     		//above print the content of column 3 on each row.
     		String value = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
     		int integerValue = Integer.parseInt(value); //example of on to convert from text to integer.
     		sum = sum + integerValue;
     	}
     	System.out.println("Sum after the loop: " + sum);  
     	
     	// To print the next column or value beside the texts: Extras and Total by identifying the text first and then using the following
     	// sibling which is a div tagName. This is an example of how to traverse from sibling to sibling.
     	System.out.println("Extras = "+table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText());
     	System.out.println("Total = "+table.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText());
     	
     	String total = table.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
     	int totalValue = Integer.parseInt(total);
     	
     	int ExtrasValue = Integer.parseInt(table.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText());
     	sum = sum + ExtrasValue;
     	System.out.println("Sum after the adding Extras (Must be equal to Total): " + sum);  
     	
     	if (sum == totalValue) {
     		System.out.println("Test Passed");
     	}
     	else {
     		System.out.println("test Failed");
     	}
     	
	}		
}
