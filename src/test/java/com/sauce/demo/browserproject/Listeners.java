package com.sauce.demo.browserproject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.ExtentReporterNG;
import resources.BaseClass;

/**
 * This class Implements the TestNG Listener Interface to pass the test execution status 
 * to extent reports and take screenshots on test failures
 * 
 * @author Sajesh Govindarajan
 * 22-May-2022
 */

public class Listeners extends BaseClass implements ITestListener 
{
	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	public static Logger log =LogManager.getLogger();
	public void onTestStart(ITestResult result) 
	{
		
		test= extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}

	//On test success pass the status to the extent report
	public void onTestSuccess(ITestResult result) 
	{
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	//On test failure pass the status to the extent reports and also capture screenshot
	public void onTestFailure(ITestResult result) 
	{
	
		extentTest.get().fail(result.getThrowable());
		WebDriver driver =null;
		String testMethodName =result.getMethod().getMethodName();
		
		try 
		{
			driver =(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try 
		{
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName,driver), result.getMethod().getMethodName());
			
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
		log.error("Test case failed @"+result.getTestClass() +" and @method "+testMethodName);
	}

	public void onTestSkipped(ITestResult result) 
	{
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
		
	}

	public void onStart(ITestContext context) 
	{
		
		
	}

	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}

}
