package Step_Definitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import Base_Page.Base_Class;
import Page_Objects.EmployeeHealth_Page;
import Page_Objects.Surgeries_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Invalid_Demo {
	
	WebDriver driver;
	public static String path;
	EmployeeHealth_Page Ep;
	Surgeries_Page Sp;

	@Given("the user navigates to Health and Wellness  page")
	public void the_user_navigates_to_health_and_wellness_page() throws InterruptedException, IOException {
		
		Sp = new Surgeries_Page(Base_Class.getDriver());
		Sp.navigateToHealthPage();
		path = Base_Class.screenshot(Base_Class.getDriver(), "health_and_wellness_page");
	    Thread.sleep(6000);
	}

	@When("user enters incorrect details")
	public void user_enters_incorrect_details() {
		
		Ep = new EmployeeHealth_Page(Base_Class.getDriver());
		Ep.validate_IncorrectDetalis();
	    
	}
	
	@Then("user tries to click the demo button")
	public void user_tries_to_click_the_demo_button() {
		
		Ep = new EmployeeHealth_Page(Base_Class.getDriver());
		Ep.clickDemo();
		Ep.clearData();
    
	}
}
