package Page_Objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home_Page extends Constructor {

	public Home_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (xpath = "(//*[@class='product-tab__title'])[1]")
	WebElement findDoctorsBtn;
	
	@FindBy (xpath = "(//*[@class='c-omni-searchbox c-omni-searchbox--large'])[1]")
	WebElement CitySearch;
	
	@FindBy (xpath = "(//*[@class='c-omni-searchbox c-omni-searchbox--large'])[2]")
	WebElement SpecialitySearch;
	
	@FindBy (xpath = "(//*[@class='c-omni-suggestion-item__content__title'])[1]")
	WebElement Bangalore_Btn;
	
	@FindBy (xpath = "((//*[@class='c-omni-suggestion-item__my_location_text'])[2])")
	WebElement EntireBangalore_Btn;
	
	@FindBy (xpath = "(//*[@class='c-omni-suggestion-item__content__title'])[1]")
	WebElement Dentist_Btn;
	
	@FindBy (xpath = "(//*[@class='c-omni-suggestion-item'])[1]")
	WebElement Dentist;
	
	@FindBy (xpath = "//*[@class='title']")
	WebElement Title;
	
	@FindBy (xpath = "(//*[@class='product-tab__title'])[5]")
	WebElement surgeriesBtn;
	
	public void clickFindDoctors() {
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(20));
		myWait.until(ExpectedConditions.visibilityOf(findDoctorsBtn)).click();
	}
	
	public boolean Search_city() {
		
		boolean ans = true;
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(20));
		myWait.until(ExpectedConditions.elementToBeClickable(CitySearch)).click();
		CitySearch.clear();
		CitySearch.sendKeys("Bangalore");
		
		try {
			EntireBangalore_Btn.isDisplayed();
			ans = true;
			System.out.println(EntireBangalore_Btn.getText());
			
			myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//*[@class='c-omni-suggestion-item__my_location_text'])[2])"))).click();
		}
		catch(Exception e) {
			
			try {
				Bangalore_Btn.isDisplayed();
				ans = true;
				System.out.println(Bangalore_Btn.getText());
				
				myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='c-omni-suggestion-item__content__title'])[1]"))).click();
			}
			catch(Exception e1) {
				ans =false;
			}
		}
		return ans;
	}
	
	public void SearchDentists() throws InterruptedException {
		
		SpecialitySearch.sendKeys("Dentist");;
		Thread.sleep(2000);
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(20));
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='c-omni-suggestion-item__content__title'])[1]"))).click();	
		System.out.println("Searching Dentists in Bangalore");
		System.out.println("--------------------");
	
	}

}