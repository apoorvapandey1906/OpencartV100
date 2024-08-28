package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups={"sanity","master"})
	public void verify_login() {
		logger.info("**** Starting the TC002_LoginTest *****");
		
		try {
		HomePage homePage = new HomePage(driver);
		homePage.clickMyAccount();
		homePage.clickLogin();
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(p.getProperty("email"));
		loginPage.enterPassword(p.getProperty("password"));
		loginPage.clickLogin();
		
		MyAccountPage myAccountPage = new MyAccountPage(driver);
		Assert.assertTrue(myAccountPage.isMyAccountPageExists(),"Login Failed");
		
		}catch (Exception e) {
			Assert.fail();
		}
		
		logger.info("**** Finished TC002_LoginTest *****");
	}
}
