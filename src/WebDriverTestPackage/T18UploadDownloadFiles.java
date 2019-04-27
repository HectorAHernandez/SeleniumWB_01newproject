package WebDriverTestPackage;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T18UploadDownloadFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
    	System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");  
//	  	WebDriver driver = new FirefoxDriver();
    	WebDriver driver = new ChromeDriver();
	  	String baseUrl = "http://demo.guru99.com/selenium/upload/";
	  	driver.get(baseUrl);
	
	  	// Check the "I accept the terms of service" check box.
	  	driver.findElement(By.id("terms")).click();
	 	
	  	WebElement uploadElement = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/form/div[2]/div[1]/div/div/input"));
	  	//WebElement uploadElement = driver.findElement(By.name("uploadfile_0"));
	  	// Enter the file path onto the file-selection input field.
	  	uploadElement.sendKeys("c:\\Selenium%20Tutorial\\HTML_Files\\newhtml.html");
	   	
	  	// click the "UploadFile" button.
	  	driver.findElement(By.name("send")).click();
	  	
	  	// download part. Need to import java.io.IOException;
	  	baseUrl = "http://demo.guru99.com/selenium/yahoo.html";
	  	driver.get(baseUrl);
	  	
	  	// Use getCssAttribute() to obtain the "href" value of the download link and save it as a String variable. 
	  	//In this case, we named the variable as "sourceLocation".
	  	WebElement downloadButton = driver.findElement(By.id("messenger-download"));
	  	String sourceLocation = downloadButton.getAttribute("href");
	  	
	  	//Set-up the syntax for wget using the following command.
	  	// wget64.exe is the version for 64 bits, for 32 bits is wget.exe. Below download to c:\ directory.
	//  	String wgetCommand = "cmd /c  C:\\Wget\\wget64.exe -P C: --no-check-certificate " + sourceLocation;
	  	// below downlaod to c:\Wget directory
	 	String wgetCommand = "cmd /c  C:\\Wget\\wget64.exe -P C:\\Wget\\ --no-check-certificate " + sourceLocation;
	  	System.out.println("source location: " + sourceLocation);
	  	
	  	//Initiate the download process by calling wget from our WebDriver code.
	  	try {
	  		Process exec = Runtime.getRuntime().exec(wgetCommand); //call Wget and supply the command.
	  		int exitVal = exec.waitFor();  // waitFor() is used to wait until Wget completes the download.
	  		System.out.println("Exit value: " + exitVal);
	  	} catch (InterruptedException | IOException ex) {
	  		System.out.println(ex.toString());
	  	}
	 driver.close(); 	
	}

}
