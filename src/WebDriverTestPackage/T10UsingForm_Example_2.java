package WebDriverTestPackage;



	import org.openqa.selenium.By;		
	import org.openqa.selenium.WebDriver;	
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.*;		
	//To use Explicit wait below two package must be imported
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	
	public class T10UsingForm_Example_2 {				
	    public static void main(String[] args) {									
	    		
	    	// declaration and instantiation of objects/variables		
	    	WebDriver driver ;
	    	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
	    	System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");  
//	      	driver = new FirefoxDriver();
	    	driver = new ChromeDriver();      

// To define Explicit wait, we have to declare a WebDriverWait variable, like hectorWaitVar 
		  	WebDriverWait hectorWaitVar = new WebDriverWait(driver, 1000);
	    	
	        String baseUrl = "http://demo.guru99.com/selenium/webform/login.html";					
	        driver.get(baseUrl);					

	        // Get the WebElement corresponding to the Email Address(TextField)		
	        WebElement email = driver.findElement(By.id("email"));							

	        // Get the WebElement corresponding to the Password Field		
	        WebElement password = driver.findElement(By.name("passwd"));							

	        email.sendKeys("abcd@gmail.com");					
	        password.sendKeys("abcdefghlkjl");					
	        System.out.println("Text Field Set");					

	        // Use Explicit wait on the "email" input.
	        hectorWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
	        
	        // Deleting values in the text box		
	        email.clear();			
	        password.clear();			
	        System.out.println("Text Field Cleared");					

	        // Find the submit button		
	        WebElement login = driver.findElement(By.id("SubmitLogin"));							
	                    		
	        // Using click method to submit form		
	        email.sendKeys("abcd@gmail.com");					
	        password.sendKeys("abcdefghlkjl");					
	        login.click();			
	        System.out.println("Login Done with Click");					
	        		
	        //using submit method to submit the form. Submit used on password field		
	        driver.get(baseUrl);					
	        driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");							
	        driver.findElement(By.name("passwd")).sendKeys("abcdefghlkjl");							
	        driver.findElement(By.id("SubmitLogin")).submit();					
	        System.out.println("Login Done with Submit");					
	         
	        driver.get("http://demo.guru99.com/selenium/webform/radio.html");					
	        WebElement radio1 = driver.findElement(By.id("vfb-7-1"));							
	        WebElement radio2 = driver.findElement(By.id("vfb-7-2"));							
	        		
	        //Radio Button1 is selected		
	        radio1.click();			
	        System.out.println("Radio Button Option 1 Selected");					
	        		
	        //Radio Button1 is de-selected and Radio Button2 is selected		
	        radio2.click();			
	        System.out.println("Radio Button Option 2 Selected");					
	        		
	        // Selecting CheckBox		
	        WebElement option1 = driver.findElement(By.id("vfb-6-0"));							

	        // This will Toggle the Check box 		
	        option1.click();			

	        // Check whether the Check box is toggled on 		
	        if (option1.isSelected()) {					
	            System.out.println("Checkbox is Toggled On");					

	        } else {			
	            System.out.println("Checkbox is Toggled Off");					
	        }		
	         
	        		
	        //Selecting Checkbox and using isSelected Method		
	        driver.get("http://demo.guru99.com/selenium/facebook.html");					
	        WebElement chkFBPersist = driver.findElement(By.id("persist_box"));							
	        for (int i=0; i<2; i++) {											
	            chkFBPersist.click (); 			
	            System.out.println("Facebook Persists Checkbox Status is -  "+chkFBPersist.isSelected());							
	        }		
			//driver.close();		
	        		
	    }		
	}
