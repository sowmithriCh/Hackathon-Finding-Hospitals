package Utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Base_Page.Test_Base;

public class ExtentReportManager  implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	WebDriver driver;

	String rep_Name;
	
	public void onStart(ITestContext testContext ) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		Date dt = new Date();
		String Time_stamp = sdf.format(dt);
		rep_Name = "Test_report - " + Time_stamp + ".html" ;
		
		sparkReporter = new ExtentSparkReporter(".\\extentReport\\" + rep_Name);
		
		sparkReporter.config().setDocumentTitle("Hackathon Project Report"); // TiTle of report
		sparkReporter.config().setReportName("Finding Hospitals"); // name of the report
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer Name","ThinkPad");
		extent.setSystemInfo("Environment","QEA");
		extent.setSystemInfo("Tester Name","Sowmithri Challakonda");
		extent.setSystemInfo("os","Windows10");
		extent.setSystemInfo("Browser name","Chrome,Firefox,Edge");
		
		
		String os = testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);
		
		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);
	}
	
	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, "Test case PASSED is: " + result.getName());
		try {
			String imgPath = new Test_Base().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void onTestFailure(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test case got Failed:" + result.getName());
		test.log(Status.INFO, result.getThrowable().getMessage());
		try {
			String imgPath = new Test_Base().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		
		test = extent.createTest(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test case got Skipped:" + result.getName());
		test.log(Status.INFO, result.getThrowable().getMessage());
		try {
			String imgPath = new Test_Base().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}

}
