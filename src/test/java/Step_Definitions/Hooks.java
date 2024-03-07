package Step_Definitions;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Base_Page.Base_Class;
import io.cucumber.java.Scenario;


public class Hooks {

	 WebDriver driver;
	 Properties p;
     
	@BeforeTest
    public void setup() throws IOException
    {
    	driver=Base_Class.initilizeBrowser();
    	    	
    	p=Base_Class.getProperties();
    	driver.get(p.getProperty("appURL"));
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       			
	}
		   
    @AfterTest
    public void tearDown(Scenario scenario) {
        		
       driver.quit();  
    }
}
