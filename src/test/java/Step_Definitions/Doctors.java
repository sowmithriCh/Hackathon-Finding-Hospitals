package Step_Definitions;

import java.io.IOException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Base_Page.Base_Class;
import Page_Objects.Doctors_Page;
import Page_Objects.Home_Page;
import Page_Objects.Surgeries_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Doctors {
	
	WebDriver driver;
	Home_Page Hp;
	Doctors_Page Dp;
	Surgeries_Page Sp;
	Hooks hk ;
	TakesScreenshot ts;
	public static String path;
	
	@Given("the user navigates to home page")
	public void the_user_navigates_to_home_page() throws IOException {
		
		Hp=new Home_Page(Base_Class.getDriver());
		
		Hooks hk =new Hooks();
		hk.setup();
	}

	@When("user Searches Dentists in Bangalore")
	public void user_searches_dentists_in_bangalore() throws InterruptedException {
		
		Hp = new Home_Page(Base_Class.getDriver());
		
		Hp.clickFindDoctors();
		boolean ans = Hp.Search_city();
		Assert.assertEquals(ans, true);
		Hp.SearchDentists();
	    
	}

	@When("user applied filters")
	public void user_applied_filters() throws InterruptedException {
		
		Dp = new Doctors_Page(Base_Class.getDriver());
		Dp.selectPatientStories();
		Dp.selectExperience();
		Dp.selectFilters_1();
		Dp.selectFilters_2();;
		Dp.sort();	
	
	}

	@Then("user gets the top five doctor details")
	public void user_gets_the_top_five_doctor_details() throws InterruptedException, IOException {
		
		Dp = new Doctors_Page(Base_Class.getDriver());
		Dp.getDoctorDetails();
		path = Base_Class.screenshot(Base_Class.getDriver(), "doctorDetails");
	}
	
}
