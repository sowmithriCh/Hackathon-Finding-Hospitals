package Page_Objects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base_Page.Test_Base;

public class Surgeries_Page extends Constructor {

	public Surgeries_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	List<String> Surgeries = new ArrayList<String>();
	
	@FindBy (xpath = "(//*[@class='product-tab__title'])[5]")
	WebElement surgeriesBtn;
	
	@FindBy (xpath = "//*[@class='text-module_base__1vdUh mt-24px text-16px font-bold text-gray-2 mb-20px SurgicalSolutions-module_listHeader__jOkUi']")
	WebElement title;
	
	@FindBy (xpath = "//*[@class='mt-12px AilmentItem-module_itemText__XvCHL']")
	List<WebElement> surgeries;
	
	@FindBy (xpath = "//*[@class='practo-logo']")
	WebElement Logo;
	
	@FindBy (xpath = "//*[@class='para cushion-right-large display-inline nav-items nav-items--additional-link hover-dark u-d-trigger dropdown-toggle']")
	WebElement ForCorporates_Btn;
	
	@FindBy (xpath = "//*[@class='u-d-item']//a")
	WebElement Health_Btn;
	

	public void click_Surgeries() {
		
		surgeriesBtn.click();
	}
	
	public void scrollDown() {
		
		System.out.println("Navigated To Surgeries Page");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		System.out.println("--------------------");
		System.out.println("Surgeries :");
		System.out.println("          ");
	}
	
	public List<String> getSurgerynames(){
		
		for(int i=0;i< surgeries.size();i++)
		{
			String surgery_Name = surgeries.get(i).getText();
			System.out.println(surgery_Name);
			Test_Base.addData("           ");
			Test_Base.addData("Surgery Names");
			Test_Base.addData("           ");
			Test_Base.addData(surgery_Name);
			Surgeries.add(surgery_Name);
		}
		return Surgeries;	
	}
	
	public void scrollUp() {
		
		System.out.println("--------------------");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", ForCorporates_Btn);
		}
	
	public void navigateToHealthPage() throws InterruptedException {
		
		ForCorporates_Btn.click();
		Health_Btn.click();
		Thread.sleep(5000);
		}
}
