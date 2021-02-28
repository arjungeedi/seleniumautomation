package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	 public WebDriver driver;
		
	 By email=	By.id("user_email");
	 By password=	By.id("user_password");
	 By logIn=	By.xpath("//input[@value='Log In']");
	 By forgotPassword= By.linkText("Forgot Password?");
	 	
	 public loginPage(WebDriver driver) {
	 	this.driver=driver;
	 }
	 public WebElement getEmail()
	 {
	 	return driver.findElement(email);
	 }
	 public WebElement getPassword()
	 {
	 	return driver.findElement(password);
	 }
	 public WebElement clickLogIn()
	 {
	 	return driver.findElement(logIn);
	 }
	 public ForgotPasswordPage clickForgotPassword()
	 {
		 driver.findElement(forgotPassword).click();
		 return new ForgotPasswordPage(driver);
	 }
}
