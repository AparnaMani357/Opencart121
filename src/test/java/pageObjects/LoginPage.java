package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	
	//Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators
	
	@FindBy(xpath ="//input[@id='input-email']") WebElement userName; 
	@FindBy(xpath ="//input[@id='input-password']") WebElement password; 
	@FindBy(xpath ="//input[@value='Login']") WebElement loginButton; 
	
	//Actions methods
	public void setEmail(String str) {
		userName.sendKeys(str);
	}

	public void setPassword(String str) {
		password.sendKeys(str);
	}
	
	public void clickLogin() {
		loginButton.click();
	}
}
