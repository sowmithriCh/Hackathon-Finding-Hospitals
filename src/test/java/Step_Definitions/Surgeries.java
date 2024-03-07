package Step_Definitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Base_Page.Base_Class;
import Page_Objects.Surgeries_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Surgeries {
	
	WebDriver driver;
	Surgeries_Page Sp;
	public static String path;
	
	@Given("the user navigates to Surgeries page")
	public void the_user_navigates_to_surgeries_page() throws IOException {
		
		Sp = new Surgeries_Page(Base_Class.getDriver());
		Sp.click_Surgeries();
		path = Base_Class.screenshot(Base_Class.getDriver(), "SurgeryPage");
	}

	@When("user scrolls down to surgeries")
	public void user_scrolls_down_to_surgeries() {
		
		Sp = new Surgeries_Page(Base_Class.getDriver());
		Sp.scrollDown();   
	}

	@When("user gets the list of surgeries")
	public void user_gets_the_list_of_surgeries() throws IOException {
		
		Sp = new Surgeries_Page(Base_Class.getDriver());
		Sp.getSurgerynames();  
		path = Base_Class.screenshot(Base_Class.getDriver(), "SurgeryNames");
	}

	@Then("user gets to top of the page")
	public void user_gets_to_top_of_the_page() throws InterruptedException {
		
		Sp = new Surgeries_Page(Base_Class.getDriver());
		Sp.scrollUp();

	}

}
