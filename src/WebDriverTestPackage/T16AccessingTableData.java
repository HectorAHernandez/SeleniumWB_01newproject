package WebDriverTestPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T16AccessingTableData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
    	System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");  
	  	WebDriver driver = new FirefoxDriver();
//    	WebDriver driver = new ChromeDriver();
	  	String baseUrl = "file://c:/Selenium%20Tutorial%20Code/HTML_Files/Table2By2.html";
	  	driver.get(baseUrl);
	  	String innerTextCell = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]")).getText();
	  	System.out.println("First table: "+innerTextCell);
	  	 
	  	// to access an inner table, the second column in the first row:
	  	baseUrl = "file://c:/Selenium%20Tutorial%20Code/HTML_Files/TableNested.html";
	  	driver.get(baseUrl);
	  	String innerTextCellInnerTable = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/table/tbody/tr/td[2]")).getText();
	  	System.out.println("the table cell content is: "+innerTextCellInnerTable);
	  	// below get the same cell
		 innerTextCellInnerTable = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[2]")).getText();
	  	System.out.println("the table cell content is: "+innerTextCellInnerTable);
	  
// If the element is written deep within the HTML code such that the number to use for the predicate is very difficult
//	  	to determine, we can use that element's unique attribute instead. For example the unique width of 270 of the table
	  	baseUrl = "http://newtours.demoaut.com/";
	  	driver.get(baseUrl);
	  	innerTextCell = driver.findElement(By.xpath("//table[@width=\"270\"]/tbody/tr[4]/td[1]")).getText();
	  	System.out.println("the cell with attribute predicate, the roundtrip is: "+innerTextCell);
	  	innerTextCell = driver.findElement(By.xpath("//table[@width=\"270\"]/tbody/tr[4]/td[2]")).getText();
	  	System.out.println("the cell with attribute predicate, the price is: "+innerTextCell);
	  	
// Shortcut using "Copy XPath from Firebug: 1- Inspect the element, 2- click on the highlighted area and the right click
// 	3- Click on "Copy XPath" option, 4- paste it and eliminate all characters before the first table word.
// 5- insert "//" infront of the table. 6- now it is ready to use in the findElement(By.xPath(.....)
// using same previous website:
	  	innerTextCell = driver.findElement(By.xpath("//table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[2]/tbody/tr[3]/td[2]/font")).getText();
	  	System.out.println("the cell using \"Copy XPath\", the tip#93 is: "+innerTextCell);
	  		
	 // 	driver.quit();
	}
	
}
