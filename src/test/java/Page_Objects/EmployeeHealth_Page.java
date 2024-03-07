package Page_Objects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeeHealth_Page extends Constructor {

	public EmployeeHealth_Page(WebDriver driver) {
		super(driver);
	}
	@FindBy (xpath = "//*[@class='para cushion-right-large display-inline nav-items nav-items--additional-link hover-dark u-d-trigger dropdown-toggle']")
	WebElement ForCorporates_Btn;
	
	@FindBy (xpath = "//*[@class='u-d-item']//a")
	WebElement Health_Btn;
	
	@FindBy( xpath = "//*[@class='u-m-b--20 text-beta']")
	WebElement ScheduleDemo;
	
	@FindBy(xpath = "(//*[@id='name'])[1]")
	WebElement Name;
	
	@FindBy(xpath = "//*[@id='organizationName']")
	WebElement organizationName;
	
	@FindBy(xpath = "(//*[@id='contactNumber'])[1]")
	WebElement contactNumber;
	
	@FindBy(xpath = "(//*[@id='officialEmailId'])[1]")
	WebElement officialEmailId;

	@FindBy(xpath = "(//*[@id='organizationSize'])[1]")
	WebElement organizationSize;
	
	@FindBy(xpath = "(//*[@id='interestedIn'])[1]")
	WebElement interestedIn;
	
	@FindBy(xpath = "//button[@class='u-text--bold u-border-radius--8 text-white text-center u-m-t--5 u-p-v--12 width-per--100 u-cur--ptr bg-grey-3']")
	WebElement DemoBtn1;
	
	@FindBy(xpath = "//button[@class='u-text--bold u-border-radius--8 text-white text-center u-m-t--5 u-p-v--12 width-per--100 u-cur--ptr bg-blue']")
	WebElement DemoBtn2;
	
	@FindBy(xpath = "//*[@class='u-text--bold text-alpha']")
	WebElement ThankyouMsg;
	
	@FindBy(xpath = "//*[@id='rc-imageselect']")
	WebElement captcha;
	
	Select sc = new Select(organizationSize);
	Select sc1 = new Select(interestedIn);
	
	public void scrollToSheduleDemo() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", ScheduleDemo);
	}
	
	public void validate_IncorrectDetalis() {
		
		Name.sendKeys("Sowmithri");
		organizationName.sendKeys("CTS");
		contactNumber.sendKeys("6304542355");
		officialEmailId.sendKeys("qwerty.com");
		sc.selectByVisibleText("10001+");
		sc1.selectByVisibleText("Taking a demo");
		System.out.println("Passing incorrect Details");
		
	}
	
	public boolean clickDemo() {
		
		boolean present = true;
		if(DemoBtn1.isEnabled()) {
			present = false;
			System.out.println("Demo button is enabled");
		}
		else {
			present = true;
			System.out.println("Demo button is not enabled");
		}
		return present;
	}
	
	public void clearData() {
		
		Name.clear();
		organizationName.clear();
		contactNumber.clear();
		officialEmailId.clear();
	}
	
	public boolean validate_CorrectDetalis() {
		
		boolean present = true;
		
		Name.sendKeys("Sowmithri Naga");
		organizationName.sendKeys("Cognizant");
		contactNumber.sendKeys("6304542355");
		officialEmailId.sendKeys("qwerty@gmail.com");
		sc.selectByVisibleText("10001+");
		Select sc1 = new Select(interestedIn);
		sc1.selectByVisibleText("Referring someone");
		System.out.println("--------------------");
		System.out.println("Passing correct Details");
		
		if(DemoBtn2.isEnabled()) {
			present = true;
			System.out.println("Demo button is enabled");
		}
		else {
			present = false;
			System.out.println("Demo button is not enabled");
		}
		return present;
	}
	
	public boolean verifyThankYouMsg() {
		
		boolean present = true;
		if(ThankyouMsg.isDisplayed()) {
			present = true;
			System.out.println("THANK YOU Message is Displayed");
		}
		else {
			present = false;
			System.out.println("THANK YOU Message is not Displayed");
			}
		return present;
	}
	
	public boolean verifyResultMsg() throws InterruptedException {
		
		boolean present = true;
		EmployeeHealth_Page ty = new EmployeeHealth_Page(driver); 		
		DemoBtn2.click();
		try {
			ty.verifyThankYouMsg();
			}
		catch(Exception E) {
			
			WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(60));
			mywait.until(ExpectedConditions.visibilityOf(ThankyouMsg));
			ty.verifyThankYouMsg();
		}
		return present;
	}
}
