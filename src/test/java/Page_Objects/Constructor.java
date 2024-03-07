//Constructor
package Page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Constructor {
	
	public WebDriver driver;
	
	public Constructor(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

}
