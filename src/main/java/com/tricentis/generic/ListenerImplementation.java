package com.tricentis.generic;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerImplementation extends BaseClass implements ITestListener {

	@Override
	public void onTestSuccess(ITestResult result) {
		String name = result.getName();
		Reporter.log(name + " has been passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name = result.getName();
		String now = LocalDateTime.now().toString().replace(":", "-");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/" + name + now + ".png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getName();
		Reporter.log(name + " has been skipped");
	}
}
