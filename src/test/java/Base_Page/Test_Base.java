package Base_Page;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;

public class Test_Base {
	
	public static WebDriver driver;
	public static List<String> data=new ArrayList<String>();
	
	public static void addData(String str) {
	data.add(str);
	
	}
	
	public Logger logger; 
	
	@BeforeClass(alwaysRun = true)
	@Parameters({"browser"})
	public void Setup_Browser(String browser) {
		
		System.out.println("Started");
		
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		
		logger = LogManager.getLogger(this.getClass());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.practo.com/");
		driver.manage().window().maximize();
	} 
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public static WebDriver getDriver(){
		return driver;
	}
	
	
	
	public String captureScreen(String tname)throws IOException{
		
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\Screenshots\\" + tname +"-"  + ".png";
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}

}
