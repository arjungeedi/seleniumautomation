package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	public static ExtentReports reports;
	
	public static  ExtentReports getReporterObject()
	{
		String path = System.getProperty("user.dir")+"\\reports+\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("web automation results");
		reporter.config().setDocumentTitle("test results");
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("tester", "harshi");
		return reports;
	}
}
