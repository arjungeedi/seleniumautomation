package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingpage {
	
 public WebDriver driver;
	
By signin=	By.xpath("//a[contains(@href,'sign_in')]");
By featuredCoursesText=By.xpath("//h2[text()='Featured Courses']");
By navigationBar = By.xpath("//div[@role='navigation']");
By videoText=By.cssSelector("div[class*='video-banner'] h3");
	
public landingpage(WebDriver driver) {
	this.driver=driver;
}

public loginPage signIn()
{
	driver.findElement(signin).click();
	loginPage loginp= new loginPage(driver);
   return loginp;
}
public WebElement getFeaturedCoursesText()
{
	return driver.findElement(featuredCoursesText);
}
public WebElement getNavigationBar()
{
	return driver.findElement(navigationBar);
}
public WebElement getVideoText()
{
	return driver.findElement(videoText);
}
}
