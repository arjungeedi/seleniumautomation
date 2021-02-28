package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.ForgotPasswordPage;
import pageobjects.landingpage;
import pageobjects.loginPage;
import resources.base;

public class HomepageTest extends base {
	public static Logger log= LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		
	}
	
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
	@Test(dataProvider="getdata")
	public void testSignIn(String username,String password,String text) throws IOException
	{
		driver.get(prop.getProperty("url"));
		landingpage lp=new landingpage(driver);
		loginPage loginp=lp.signIn();
		loginp.getEmail().sendKeys(username);
		loginp.getPassword().sendKeys(password);
		log.info(text);
	    loginp.clickLogIn().click();
		System.out.println(text);
		ForgotPasswordPage fpp=loginp.clickForgotPassword();
		fpp.validateForgotPassword();
	}
	
	@DataProvider
	public Object[][] getdata()
	{
		Object data[][]=new Object[2][3];
		data[0][0]="abc@gmail.com";
		data[0][1]="pass12";
		data[0][2]="test1";
		data[1][0]="abcd@gmail.com";
		data[1][1]="pass123";
		data[1][2]="test2";
		
		return data;
		
	}

}
