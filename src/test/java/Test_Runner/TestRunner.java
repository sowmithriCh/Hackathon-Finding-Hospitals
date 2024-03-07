package Test_Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {".//Feature_Files/FindingHospitals.feature"},
		
		glue = "Step_Definitions",
		
		plugin= {"pretty",
				"html:Cucumber_Reports/myreport.html",
				"rerun:target/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		
		dryRun=false,
		
		monochrome=true,
		
		publish=true,
		
		tags="@smoke or @regression" 
		)

public class TestRunner {
	
}