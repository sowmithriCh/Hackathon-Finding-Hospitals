package Step_Definitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Base_Page.Base_Class;
import Page_Objects.EmployeeHealth_Page;
import io.cucumber.java.en.*;

public class Valid_Demo {
	
	public static String path;
	WebDriver driver;
	EmployeeHealth_Page Ep;
	
	@When("user user enters correct details")
	public void user_user_enters_correct_details() throws IOException {
		
		Ep = new EmployeeHealth_Page(Base_Class.getDriver());
		Ep.validate_CorrectDetalis();
		path = Base_Class.screenshot(Base_Class.getDriver(), "ValidateCorrectDetails");
	    
	}
	
	@Then("user validates the Thank you message")
	public void user_validates_the_thank_you_message() throws InterruptedException, IOException {
		
		Ep = new EmployeeHealth_Page(Base_Class.getDriver());
		boolean ans = Ep.verifyResultMsg();
		Assert.assertEquals(ans, true);
		path = Base_Class.screenshot(Base_Class.getDriver(), "VerifyResult");
	    
	}

}
