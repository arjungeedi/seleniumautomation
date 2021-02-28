package Academy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.base;

public class Listener extends base implements ITestListener {
	ThreadLocal<ExtentTest> tl = new ThreadLocal<ExtentTest>();
	ExtentReports report=	ExtentReporterNG.getReporterObject();
	ExtentTest test;
	@Override
	public void onTestFailure(ITestResult result) {
		tl.get().fail(result.getThrowable());
		WebDriver driver =null;
		
		// TODO Auto-generated method stub
	String testmethodname=	result.getMethod().getMethodName();
	try {
		driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	} catch(Exception e)
	{
		
	}
	try {
		tl.get().addScreenCaptureFromPath(takescreenshot(testmethodname,driver), result.getMethod().getMethodName());
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	 
	@Override
	public void onTestStart(ITestResult result) {
		
	test=report.createTest(result.getMethod().getMethodName());
	tl.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		tl.get().log(Status.PASS,"test is passed");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}


}
