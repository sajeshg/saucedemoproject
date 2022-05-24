package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * This class configures the details required for generating the extent reports
 * 
 * @author Sajesh Govindarajan
 * 22-May-2022
 */
public class ExtentReporterNG 
{
	static ExtentReports extent;
	
	//Generate report based on the execution status of test cases and save in reports folder
	public static ExtentReports getReportObject()
	{
		
		String path =System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");		
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sajesh Govindarajan");
		return extent;
		
	}
}
