package UdemySlenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testCase2_Empty {

	public static void main(String[] args) {
		// This is an example of using xpath and CSS for identifying the webelements.
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
	//   System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
		 driver = new FirefoxDriver(); 
//		 driver = new ChromeDriver();
		String baseUrl = "http://www.facebook.com";     
        driver.get(baseUrl);
        driver.manage().window().maximize();
        System.out.println("Page Title: "+driver.getTitle());
        // finding webElement using xpath. The xpath syntax:
        //      //tagName[@attribute='value'] or //*[@attribute='value'] (generic/any tagName *)
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("initial name");
        driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("password");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        
        //finding webElement using CSS. the CSS syntax:
                 //      tagName[attribute='value']
                 //      [attribute='value']  -- Generic only omitting the tagName.
        		 //      tagName#id     -- like input#username. user name was the value for the id attribute.
        		 //      #nameOfAttribute  eliminating the tagName only provide the id Exmple: #username, or #email.
        		 //      tagName.classname Example input.inputtext
        driver.get(baseUrl);
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("TagAttributeValue");
        driver.findElement(By.cssSelector("[name='email']")).sendKeys("AttributeValue");
        driver.findElement(By.cssSelector("input#email")).sendKeys("tagNameIdAttributeName");
        driver.findElement(By.cssSelector("#pass")).sendKeys("#nameofIdAttribute");
        driver.findElement(By.cssSelector("input[name='pass']")).sendKeys("tagNameAttributeValue");
        driver.findElement(By.cssSelector("[id='email']")).sendKeys("attributeValue");
        driver.findElement(By.cssSelector("input[value='Log In']")).click();
 
        // The format for the regular expresion with xpath is 
        //          //tagName[contains(@attribute,'substringValue')]
        driver.get(baseUrl);
        driver.findElement(By.xpath("//input[contains(@name,'ail')]")).sendKeys("xpathRegExpr");
        driver.findElement(By.xpath("//input[contains(@data-testid,'al_email')]")).sendKeys("xpathEmail2");     
        driver.findElement(By.xpath("//input[contains(@data-testid,'royal_em')]")).sendKeys("xpathEmail3");
        
        // Regular Expression syntax for CSS:
        //	   tagName[attribute*='substringValue'] --- the * indicate the attribute contains the substring indicated
        driver.findElement(By.cssSelector("input[id*='ass']")).sendKeys("CSSRegExprs");
        driver.findElement(By.cssSelector("input[name*='ass']")).sendKeys("CSSRegExprs");
        driver.findElement(By.cssSelector("input[data-testid*='royal_pa']")).sendKeys("CSSReg888Exprs");
        
 //     <input type="email" class="inputtext" name="email" id="email" tabindex="1" data-testid="royal_email">
 //     <input type="password" class="inputtext" name="pass" id="pass" tabindex="2" data-testid="royal_pass">
 //     <input value="Log In" aria-label="Log In" tabindex="4" data-testid="royal_login_button" type="submit" id="u_0_2">
        
	}

}
