package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	
	//Constructor
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Locators

	@FindBy(xpath="//input[@id='input-firstname']") WebElement FirstName;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement LastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement Email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement Telephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement Password;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement ConfirmPassword;
	@FindBy(xpath="//input[@name='agree']") WebElement PrivancycheckBox;
	@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement ConfirmationMessage;
	
	//Action methods
	public void setFirstName(String fname) {
		FirstName.sendKeys(fname);
	}
	
	public void setLastName(String str) {
		LastName.sendKeys(str);
	}
	
	public void setEmail(String str) {
		Email.sendKeys(str);
	}
	
	public void setTelephone(String str) {
		Telephone.sendKeys(str);
	}
	
	public void setPassword(String str) {
		Password.sendKeys(str);
	}
	public void setConfirmPassword(String str) {
		ConfirmPassword.sendKeys(str);
	}
	
	public void setPrivacyPolicy() {
		PrivancycheckBox.click();
	}
	public void setContinueButton() {
		btnContinue.click();
	}
	
	public String getCpnfirmationMessage() {
		return ConfirmationMessage.getText();
	}
}
