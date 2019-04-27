package UdemySlenium;   //instructor's email: rahulonlinetutor@gmail.com

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class T01UsingXpathAndCSS {

	public static void main(String[] args) {
		// This is an example of using xpath and CSS for identifying the webelements.
		WebDriver driver;
	//	System.setProperty("webdriver.gecko.driver","C:\\selenium-3.11.0\\geckodriver.exe");
	//    driver = new FirefoxDriver();
	    System.setProperty("webdriver.chrome.driver", "C:\\selenium-3.11.0\\chromedriver.exe");
        driver = new ChromeDriver();
		String baseUrl = "http://www.facebook.com";     
        driver.get(baseUrl);
        driver.manage().window().maximize();
        System.out.println("Page Title: "+driver.getTitle());

       
        // finding webElement using xpath. The xpath syntax:
        //      //tagName[@attribute='value'] or //*[@attribute='value'] (generic/any tagName *)
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("initial name");
        driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("password");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
    /*    
        //finding webElement using CSS. the CSS syntax:
                 //      tagName[attribute='value']
                 //      [attribute='value']  -- Generic only omitting the tagName.
        		 //      tagName#id     -- like input#username. user name was the value for the id attribute.
        		 //      #nameOfAttribute  eliminating the tagName only provide the id Exmple: #username, or #email.
        		 //      tagName.classname Example input.inputtext
        driver.get(baseUrl);*/
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("TagAttributeValue");
        driver.findElement(By.cssSelector("[name='email']")).sendKeys("AttributeValue");
        driver.findElement(By.cssSelector("input#email")).sendKeys("tagNameIdAttributeName");
        driver.findElement(By.cssSelector("#pass")).sendKeys("#nameofIdAttribute");
        driver.findElement(By.cssSelector("input[name='pass']")).sendKeys("tagNameAttributeValue");
        driver.findElement(By.cssSelector("[id='email']")).sendKeys("attributeValue");
   //     driver.findElement(By.cssSelector("input[value='Log In']")).click();
 
        // The format for the regular expresion with xpath is 
        //          //tagName[contains(@attribute,'substringValue')]
/*        driver.get(baseUrl);
        driver.findElement(By.xpath("//input[contains(@name,'ail')]")).sendKeys("xpathRegExpr");
        driver.findElement(By.xpath("//input[contains(@data-testid,'al_email')]")).sendKeys("xpathEmail2");     
        driver.findElement(By.xpath("//input[contains(@data-testid,'royal_em')]")).sendKeys("xpathEmail3");
        
        // Regular Expression syntax for CSS:
        //	   tagName[attribute*='substringValue'] --- the * indicate the attribute contains the substring indicated
        driver.findElement(By.cssSelector("input[id*='ass']")).sendKeys("CSSRegExprs");
        driver.findElement(By.cssSelector("input[name*='ass']")).sendKeys("CSSRegExprs");
        driver.findElement(By.cssSelector("input[data-testid*='royal_pa']")).sendKeys("CSSReg888Exprs");
     */   
 /*     <input type="email" class="inputtext" name="email" id="email" tabindex="1" data-testid="royal_email">
      <input type="password" class="inputtext" name="pass" id="pass" tabindex="2" data-testid="royal_pass">
      <input value="Log In" aria-label="Log In" tabindex="4" data-testid="royal_login_button" type="submit" id="u_0_2">
   */     
        driver.get("http://rediff.com");
        driver.findElement(By.cssSelector("a[title*='Sign in']")).click();
        driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("hello user");
        driver.findElement(By.cssSelector("input#password")).sendKeys("again");
        driver.findElement(By.cssSelector("input[name*='proceed']")).click();
        
  /*      driver.get("http://google.com");
        driver.findElement(By.xpath("//div[@class='lst-c']/div/div[2]/div/input")).sendKeys("xpathParentChild");
       // driver.findElement(By.xpath("//div[@class='sbibtd']/div[2]/div[1]/div/div[2]/div/input")).sendKeys("xpathParentChild");
       */
        // How to traverse to siblings webelements using xpath 
        //below code access all the siblings following one identified by the xpath; format:
        //    //*[@attribute='value']/following-sibling::siblingTagName[n]  where n is 1 for the first, 2 second... after.
        driver.get("http://www.qaclickacademy.com/interview.php");
        driver.findElement(By.xpath("//*[@id='tablist1-tab1']/following-sibling::li[1]")).click();
        driver.findElement(By.xpath("//*[@id='tablist1-tab1']/following-sibling::li[2]")).click();
        driver.findElement(By.xpath("//*[@id='tablist1-tab1']/following-sibling::li[3]")).click();
        
        // How to travel to a parent dynamic webelement from an static child. first we use the xpath of the static child, then add /parent::tagName 
        //   format:    //*[@attribute='value']/parent::tagName    -where tagName is the tagName of the dynamic parent.
        // Note: exam question: travel back to a parent can only be possible using xpath, CSS does not allow travel back to parent this is the main
        // difference between xpath and CSS. Example: //*[@id='tablist1-tab1']parent::ul
       // driver.findElement(By.xpath("//*[@id='tablist1-tab1']/parent::ul")).getAttribute("role");     
        
        // how to identify webelement with a text based? this is used when there is no other attribute that can be used or when in an Agile Team
        // we have to start creating the test cases and the design is not finished, but we can get the string that is going to be displayed for 
        // the webelement. we use the xpath format //*[text()='value']
        driver.findElement(By.xpath("//*[text()=' Selenium ']")).click();
        // another one: driver.findElement(By.xpath("//a[contains(text(),'Verify your account')]")); 
	}

}
