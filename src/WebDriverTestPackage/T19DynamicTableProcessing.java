package WebDriverTestPackage;
/* Example: Fetch number of rows and columns from Dynamic WebTable
When the table is dynamic in nature, we cannot predict its number of rows and columns.
Using Selenium web driver, we can find Number of Rows and columns of web table
X row or Y column's data.*/

import java.text.ParseException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.*;
//import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import java.text.NumberFormat;


public class T19DynamicTableProcessing {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
//	    System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
    	System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");  
//	  	WebDriver driver = new FirefoxDriver();
    	WebDriver driver = new ChromeDriver();
	  	String baseUrl = "http://money.rediff.com/gainers/bsc/dailygroupa?";
	  	driver.get(baseUrl);
	  	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	  	
        //No.of Columns
        List  col = driver.findElements(By.xpath(".//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
        System.out.println("No of cols are : " +col.size()); 
        //No.of rows 
        List  rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr/td[1]")); 
        System.out.println("No of rows are : " + rows.size());
      
/* Example: Fetch cell value of a particular row and column of the Dynamic 
 * Table Let's assume we need 3rd row of the table and its second cell's data. 
 * See the table below- */        
        WebElement baseTable = driver.findElement(By.tagName("table")); //get whole base table 
      //To find third row of table
		WebElement tableRow = baseTable.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]"));
		// above get the whole third row /tr[3]
        String rowtext = tableRow.getText();
		System.out.println("Third row of table : "+rowtext);
		    
		//to get 3rd row's 2nd column data: /tr[3]/td[2]
		WebElement cellIneed = tableRow.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]/td[2]"));
		String valueIneed = cellIneed.getText();
		System.out.println("Cell value is : " + valueIneed); 

/*Example: Get Maximum of all the Values in a Column of Dynamic Table
In this example, we will get the maximum of all values in a particular column 4 -current price. */
	    String max;
	    double m=0,r=0;
	    
// Get the first value on row 1 column 4 and assign it to the variable r:
	    max= driver.findElement(By.xpath("html/body/div[1]/div[5]/table/tbody/tr[1]/td[4]")).getText();
        NumberFormat f = NumberFormat.getNumberInstance(); 
        Number num = f.parse(max);
        max = num.toString();
        r = Double.parseDouble(max);
	    System.out.println("the first value is: " + r);
	    
	    for (int i =1;i<rows.size();i++)
        {   // below get the next value (i + 1) and move it to max. 
            max= driver.findElement(By.xpath("html/body/div[1]/div[5]/table/tbody/tr[" + (i+1)+ "]/td[4]")).getText();
            num = f.parse(max);
            max = num.toString();
            m = Double.parseDouble(max);
            if(m>r)
             {    
                r=m;
             }
        }
        System.out.println("Maximum current price is : "+ r);
        
/*Example: Get all the values of a Dynamic Table
Consider the following table http://demo.guru99.com/test/table.html
The number of columns for each row is different.
Here row number 1, 2 and 4 have 3 cells, and row number 3 has 2 cells, and row number 5 has 1 cell.
We need to get values of all the cells
 */        
        driver.get("http://demo.guru99.com/test/table.html");
    	//To locate table.
        WebElement mytable = driver.findElement(By.xpath("/html/body/table/tbody"));
    	//To locate rows of table. 
    	List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
    	//To calculate no of rows In table.
    	int rows_count = rows_table.size();
    	//Loop will execute till the last row of table.
    	for (int row = 0; row < rows_count; row++) {
    	    //To locate columns(cells) of that specific row.
    	    List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
    	    //To calculate no of columns (cells). In that specific row.
    	    int columns_count = Columns_row.size();
    	    System.out.println("Number of cells In Row " + row + " are " + columns_count);
    	    //Loop will execute till the last cell of that specific row.
    	    for (int column = 0; column < columns_count; column++) {
    	        // To retrieve text from that specific cell.
    	        String celtext = Columns_row.get(column).getText();
    	        System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celtext);
    	    }
    	    System.out.println("-------------------------------------------------- ");
    	}
		
  //      driver.close();
	
	}
}
