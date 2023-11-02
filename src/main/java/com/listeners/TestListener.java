package com.listeners;
//

import org.openqa.selenium.OutputType	;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;





public class TestListener implements ITestListener {
	WebDriver driver;
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
		
	}
	//
	
	@Override
	public void onTestStart(ITestResult result) {
   System.out.println("on test start"+ result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {

	}

	

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

}