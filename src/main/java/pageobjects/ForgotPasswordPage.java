package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	
 public WebDriver driver;
	
By emailAddress=	By.id("user_email");
By sendMeInstruction=By.xpath("//input[@name='commit']");

	
public ForgotPasswordPage(WebDriver driver) {
	this.driver=driver;
}

public ForgotPasswordPage  validateForgotPassword()
{
	driver.findElement(emailAddress).sendKeys("abc123@gmail.com");
	driver.findElement(sendMeInstruction).click();
	return new ForgotPasswordPage(driver);
   
}

}
