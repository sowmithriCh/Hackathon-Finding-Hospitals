package Test_Cases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import Base_Page.Test_Base;
import Page_Objects.Doctors_Page;
import Page_Objects.EmployeeHealth_Page;
import Page_Objects.Home_Page;
import Page_Objects.Surgeries_Page;
import Utilities.excel;

public class Finding_Hospitals extends Test_Base {	
	
//public class Finding_Hospitals{
//WebDriver driver;
	
	Home_Page Hp;
	Doctors_Page Dp;
	EmployeeHealth_Page Ep;
	Surgeries_Page Sp;
	
//	public Logger logger; 
	
//	@BeforeClass
//	public void driverSetup() {
//		
//		logger = LogManager.getLogger(this.getClass());
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://www.practo.com/");
//		driver.manage().window().maximize();
//		System.out.println("Stared");
//		System.out.println("--------------------");	
//	}
	
	@Test(priority = 0, groups= {"smoke"})
	public void Search_City() throws InterruptedException {
		
		logger.info("--------Started--------");
		try {
		Hp = new Home_Page(driver);
		Hp.clickFindDoctors();
		boolean ans = Hp.Search_city();
		Assert.assertEquals(ans, true);
		logger.info(" Searching City ");
		}
		catch(Exception e) {
			
			logger.error("Test Failed");
			Assert.fail();
		}
	}
	
	@Test(priority = 1, groups= {"regression_1"})
	public void Search_Dentists() throws InterruptedException {
		try {
		Hp = new Home_Page(driver);
		
		Hp.SearchDentists();
		logger.info(" Searching dentists ");
		}
		catch(Exception e) {
			
			logger.error("Test Failed");
			Assert.fail();
		}
		
	}
	
	@Test(priority = 2, groups= {"regression_2"})
	public void select_PatientStories() throws InterruptedException {
		
		logger.info("--------Appling Fiters--------");
		try {
		Dp = new Doctors_Page(driver);
		Dp.selectPatientStories();	
		logger.info(" Selecting 30+ Patient Stories ");
		}
		catch(Exception e) {
			
			logger.error("Test Failed");
			Assert.fail();
		}
	}
	
	@Test(priority = 3, groups= {"regression_2"})
	public void select_Experience() throws InterruptedException {
		
		try {
		Dp = new Doctors_Page(driver);
		Dp.selectExperience();
		logger.info(" Selectong 10+ years experience ");
		}
		catch(Exception e) {
			
			logger.error("Test Failed");
			Assert.fail();
		}
	}
	
	@Test(priority = 4, groups= {"regression_2"})
	public void applyFilters() throws InterruptedException {
		
		try {
		Dp = new Doctors_Page(driver);
		Dp.selectFilters_1();
		logger.info(" Selecting fee above 500 ");
		}
		catch(Exception e) {
			
			logger.error("Test Failed");
			Assert.fail();
		}
	}
	
	@Test(priority = 5, groups= {"regression_2"})
	public void applyFilters_1() throws InterruptedException {
		
		try {
		Dp = new Doctors_Page(driver);
		Dp.selectFilters_2();
		logger.info(" Selecting Doctors those who available tomorrow ");
		}
		catch(Exception e) {
			
			logger.error("Test Failed");
			Assert.fail();
		}
	}
	
	
	
	
	@Test(priority = 6, groups= {"regression_2"})
	public void applyFilters_2() throws InterruptedException {
		
		try {
		logger.info("--------Sorting--------");
		Dp = new Doctors_Page(driver);
		Dp.sort();	
		logger.info(" Sorting High to low ");
		}
		catch(Exception e) {
			
			logger.error("Test Failed");
			Assert.fail();
		}
	}
	
	@Test(priority = 7, groups= {"smoke"})
	public void get_DoctorDetails() throws InterruptedException {
		
		try {
		Dp = new Doctors_Page(driver);
		Dp.getDoctorDetails();
		logger.info(" Getting top 5 Doctor details ");
		}
		catch(Exception e) {
			
			logger.error("Test Failed");
			Assert.fail();
		}
	}
	
	@Test(priority = 8, groups= {"regression_1"})
	public void navigateToSurgeries() {
		
		try {
		logger.info("-------- Navigating To Surgeries Page --------");
		Sp = new Surgeries_Page(driver);
		Sp.click_Surgeries();
		logger.info(" Clicked on Surgeries button ");
		}
		catch(Exception e) {
			
			logger.error("Test Failed");
			Assert.fail();
		}
	}
	
	
	@Test(priority = 9, groups= {"regression_2"})
	public void ScrollToSurgeries(){
		
		try {
		Sp = new Surgeries_Page(driver);
		Sp.scrollDown();
		logger.info(" Scrolling down to list of surgeries ");
		}
		catch(Exception e) {
			
			logger.error("Test Failed");
			Assert.fail();
		}
	}
	
	@Test(priority = 10, groups= {"regression_1"})
	public void sugeryNames() {
		
		try {
		Sp = new Surgeries_Page(driver);
		Sp.getSurgerynames();
		logger.info(" Getting list of surgeries into a list ");
		}
		catch(Exception e) {
			
			logger.error("Test Failed");
			Assert.fail();
		}
	}
	
	@Test(priority = 11, groups= {"regression_2"})
	public void ScrollToTop() {
		
		try {
		Sp = new Surgeries_Page(driver);
		Sp.scrollUp();
		logger.info(" Scrolling back to top of the page ");
		}
		catch(Exception e) {
			
			logger.error("Test Failed");
			Assert.fail();
		}
		
	}
	
	@Test(priority = 12, groups= {"regression_1"})
	public void navigatioToHealth_Page() {
		
		logger.info("-------- Navigating To Health and wellness Page --------");
		try {
		Sp = new Surgeries_Page(driver);
		Sp.navigateToHealthPage();
		logger.info(" Navigated to Health and wellness Page ");
		}
		catch(Exception e) {
			
			logger.error("Test Failed");
			Assert.fail();
		}
		
	}
	
	@Test(priority = 13, groups= {"regression_2"})
	public void scrollToDemoBtn() {
		
		try {
		logger.info("-------- Validating demo button --------");
		Ep = new EmployeeHealth_Page(driver);
		Ep.scrollToSheduleDemo();
		logger.info(" Scrolling down to Schedule demo button ");
		}
		catch(Exception e) {
			
			logger.error("Test Failed");
			Assert.fail();
		}
	}
	
	@Test(priority = 14, groups= {"regression_1"})
	public void verifyDemoBtn_1() {
		
		try {
		logger.info("-------- Validating demo button --------");
		Ep = new EmployeeHealth_Page(driver);
		Ep.validate_IncorrectDetalis();
		logger.info(" Entering incorrect detials to validate demo button ");
		}
		catch(Exception e) {
			
			logger.error("Test Failed");
			Assert.fail();
		}
	}
	
	
	@Test(priority = 15, groups= {"smoke"})
	public void ClickDemoBtn() {
		
		try {
		logger.info("-------- Validating demo button --------");
		Ep = new EmployeeHealth_Page(driver);
		boolean ans = Ep.clickDemo();
		Assert.assertEquals(ans, true);	
		logger.info(" Validating demo button with incorrect details ");
		}
		catch(Exception e) {
			
			logger.error("Test Failed");
			Assert.fail();
		}
	}
	
	@Test(priority = 17, groups= {"regression_2"})
	public void ClearingData() {
		
		try {
		Ep = new EmployeeHealth_Page(driver);
		Ep.clearData();
		logger.info(" clearing the previous data ");
		}
		catch(Exception e) {
			
			logger.error("Test Failed");
			Assert.fail();
		}
		
	}
	
	@Test(priority = 18, groups= {"smoke"})
	public void verifyDemoBtn_2() {
		
		try {
		Ep = new EmployeeHealth_Page(driver);
		boolean ans = Ep.validate_CorrectDetalis();
		Assert.assertEquals(ans, true);	
		logger.info(" Validating demo button with correct details ");
		excel e= new excel();
		e.createExcel();
		}
		catch(Exception e) {
			
			logger.error("Test Failed");
			Assert.fail();
		}
	}
	
	@Test(priority = 19, groups= {"regression_2"})
	public void Verify_ResultMsg() throws InterruptedException {
		
		try {
		Ep = new EmployeeHealth_Page(driver);
		boolean ans = Ep.verifyResultMsg();
		Assert.assertEquals(ans, true);	
		logger.info(" Verifying Thank you message ");
		}
		catch(Exception e) {
			
			logger.error("Test Failed");
			Assert.fail();
		}
	}
	
//	@AfterClass
//	public void tearDown() {
//	//	driver.quit();
//	}
	
}
	

