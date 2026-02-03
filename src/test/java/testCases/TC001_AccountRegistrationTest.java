package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseTest;

public class TC001_AccountRegistrationTest extends BaseTest {
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
		
		
		try {
		logger.info("*****Starting test case001******");
		HomePage hp= new HomePage(driver);
		AccountRegistrationPage register= new AccountRegistrationPage(driver);
		hp.clickMyAccount();
		logger.info("*****Clicked on My Account Link******");
		hp.clickRegister();
		logger.info("*****Clicked on Register Link******");
		String password=getAlphanumeric();
		
		logger.info("*****Providing customer details******");
		register.setFirstName(getRandomString());
		register.setLastName(getRandomString());
		register.setEmail(getRandomString()+"@gmail.com");
		register.setTelephone(getRandomNumber());
		register.setPassword(password);
		register.setConfirmPassword(password);
		register.setPrivacyPolicy();
		register.setContinueButton();
		
		String expectedSuccessMessage="Your Account Has Been Created!";
		if(expectedSuccessMessage.equals(register.getCpnfirmationMessage()))
		{
			Assert.assertTrue(true);
			logger.info("*****Validating expected Success message******");
		}
		else
		{
			Assert.assertTrue(false);
			logger.error("Test Failed");
			logger.debug("Debug logs");
		}
		
		//Assert.assertEquals("Yourrr Account Has Been Created!", register.getCpnfirmationMessage());
		}
		catch (Exception e) {
			
			Assert.fail();
		}
		logger.info("*****Completed test case TC001******");
	}

	

}
