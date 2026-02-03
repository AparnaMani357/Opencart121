package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseTest;
import utilities.DataProviders;

public class TC003_LoginTestDataDriven extends BaseTest{
	
	/*Login with Valid data ->Login Successful->TestCase Pass
	 *Login with Valid data ->Login UnSuccessfull->TestCase Fail 
	 */
	
	/*Login with Invalid data->Login Unsuccessful->TestCase Pass
	 *Login with Invalid data->Login Successful->TestCase Fail
	 */
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="Datadriven")
	public void verifyLoginPageDataDriven(String userName, String pwd, String expectedRes) {
		logger.info("*******Testing login page************");
		HomePage hp=new HomePage(driver);
		LoginPage lp= new LoginPage(driver);
		MyAccountPage mp=new MyAccountPage(driver);
		
		hp.clickMyAccount();
		hp.clickLogin();
		lp.setEmail(userName);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		if(expectedRes.equalsIgnoreCase("valid")) {
				if(mp.isMyAccountPageExists()==true) {
					mp.logout();
					Assert.assertTrue(true); //Pass the test case if Login with Valid data ->Login Successful->TestCase Pass
				}
				else if(mp.isMyAccountPageExists()==false) {
					Assert.assertTrue(false); //Fail the test case if Login with Valid data ->Login UnSuccessfull->TestCase Fail 
				}
		}else if(expectedRes.equalsIgnoreCase("invalid")) {
			if(mp.isMyAccountPageExists()==true) {
				mp.logout();
				Assert.assertTrue(false); //Fail the test case if Login with InValid data ->Login Successful->TestCase Fail
						}
			else if(mp.isMyAccountPageExists()==false) {
				Assert.assertTrue(true); //Pass the test case if Login with InValid data ->Login UnSuccessful->TestCase Pass
			}
		}
			
			
		logger.info("*******Completed Testing login page************");
	}

}
