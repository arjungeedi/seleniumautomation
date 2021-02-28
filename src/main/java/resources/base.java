package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;

public class base {
public  WebDriver driver;
public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		 prop= new Properties();
		FileInputStream fis =new FileInputStream("C:\\Users\\srikg\\eclipse-workspace\\endtoendproject\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
	// String browsername=prop.getProperty("browser");
	   String browsername=System.getProperty("browser");
	 if(browsername.contains("chrome"))
	 {
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\srikg\\Downloads\\chromedriver_win32\\chromedriver.exe");
		 ChromeOptions co = new ChromeOptions();
		   if(browsername.contains("headless"))
		   {
			   co.addArguments("headless");
		   }
		 driver = new ChromeDriver(co);
	 }else if(browsername.equals("firefox"))
	 {
		 System.setProperty("webdriver.gecko.driver","C:\\Users\\srikg\\Downloads\\geckodriver-v0.29.0-win64\\geckodriver.exe");
		 driver = new FirefoxDriver();
	 }
	 else if(browsername.equals("IE"))
	 {
		 System.out.println("execute in IE");
	 }
	 
	 driver.manage().timeouts().pageLoadTimeout(15,TimeUnit.SECONDS);
	 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	 return driver;
	}
	
	public String takescreenshot(String testname, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String desfile=System.getProperty("user.dir")+"\\reports\\"+testname+".png";
		FileUtils.copyFile(src, new File(desfile));
		return desfile;
	}

}
