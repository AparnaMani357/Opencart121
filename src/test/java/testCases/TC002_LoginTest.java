package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;

public class TC002_LoginTest extends BaseTest {

	@Test(groups={"Sanity","Master"})
	public void verifyLoginPage() {
		logger.info("*******Testing login page************");
		HomePage hp=new HomePage(driver);
		LoginPage lp= new LoginPage(driver);
		MyAccountPage mp=new MyAccountPage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		lp.setEmail(pr.getProperty("email"));
		lp.setPassword(pr.getProperty("password"));
		lp.clickLogin();
		Assert.assertTrue(mp.isMyAccountPageExists());
		logger.info("*******Completed Testing login page************");
	}
}
