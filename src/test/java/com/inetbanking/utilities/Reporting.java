package com.inetbanking.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.util.*;


public class Reporting extends TestListenerAdapter{
	
    public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testcontest) {
		
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.HH.mm.ss").format(new Date());
		String repName = "Test-Report"+timestamp+".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/"+repName);
		try {
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Nmae", "localhost");
		extent.setSystemInfo("Envoronment", "QA");
		extent.setSystemInfo("user", "srinivas");
		
		htmlReporter.config().setDocumentTitle("inetBanking Test Project");
		htmlReporter.config().setReportName("Functional Test Report");
		//htmlReporter.config().setTestViewChartLocation();
		htmlReporter.config().setTheme(Theme.DARK);
	
	}
	
	public void onTestSuccess(ITestResult tr) {
		
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
		
	}
	
	public void onTestFailure(ITestResult tr) {
		
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		
		String screenshotpath=System.getProperty("user.dir")+"\\screenshots\\"+tr.getName()+".png";
		
		File f = new File(screenshotpath);
		
		if(f.exists()) {
			logger.fail("Screenshot is below: " + logger.addScreenCaptureFromPath(screenshotpath));
		}
	}
	
	public void onTestSkipped(ITestResult tr) {
		
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
         		
		
	}
	
	public void onFinish(ITestContext testcontest) {
		
		extent.flush();
		
	}

}
