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
import resources.base;

public class ValidatetextTest extends base {
	public static Logger log= LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	public landingpage lp;
	@Test
	public void testFeaturedCoursesText() throws IOException
	{
		
		 lp = new landingpage(driver);
		System.out.println(lp.getFeaturedCoursesText().getText());
		Assert.assertEquals(lp.getFeaturedCoursesText().getText(),"FEATURED COURSES");
		log.info("successfully validated text message");
	}
	@Test
	public void testVideoText() throws IOException
	{
		
		System.out.println(lp.getVideoText().getText());
		Assert.assertEquals(lp.getVideoText().getText(),"AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info("successfully validated text message");
	}
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("navigated to home page");
	}
	
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}

}
