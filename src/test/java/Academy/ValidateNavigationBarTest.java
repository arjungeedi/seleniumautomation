package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageobjects.landingpage;
import pageobjects.loginPage;
import resources.base;

public class ValidateNavigationBarTest extends base {
	public static Logger log= LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@Test
	public void ValidateNavigationBarTest() throws IOException
	{
		landingpage lp = new landingpage(driver);
		System.out.println(lp.getNavigationBar().isDisplayed());
	Assert.assertTrue(lp.getNavigationBar().isDisplayed());
	log.info("navigation bar is displayed");
	}
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}

}
