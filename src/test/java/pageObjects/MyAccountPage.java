package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	
	//Constructor
	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Locator
	@FindBy(xpath ="//h2[normalize-space()='My Account']") WebElement myAccountHeader; 
	@FindBy(xpath ="//div[@class='list-group']//a[text()='Logout']") WebElement logOutButton; 
	
	
	//Action method
	public boolean isMyAccountPageExists() {
		return myAccountHeader.isDisplayed();
	}
	
	public void logout() {
		logOutButton.click();
	}
}
