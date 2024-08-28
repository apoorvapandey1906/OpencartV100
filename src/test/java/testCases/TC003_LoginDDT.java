package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	/*
	 * Case1 - Data is valid - login success - test pass - logout Case2 - Data is
	 * valid - login failed - test fail
	 * 
	 * Case3 - Data is invalid - login success - test fail - logout Case4 - Data is
	 * invalid - login failed - test pass
	 */

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups={"datadriven","master"})
	public void verify_loginDDT(String email, String password, String expectedResult) {
		logger.info("**** Starting the TC003_LoginDDT *****");

		try {
			HomePage homePage = new HomePage(driver);
			homePage.clickMyAccount();
			homePage.clickLogin();

			LoginPage loginPage = new LoginPage(driver);
			loginPage.enterEmail(email);
			loginPage.enterPassword(password);
			loginPage.clickLogin();

			MyAccountPage myAccountPage = new MyAccountPage(driver);
			boolean targetPage = myAccountPage.isMyAccountPageExists();

			if (expectedResult.equalsIgnoreCase("Valid")) {

				if (targetPage == true) {
					myAccountPage.clickLogout();
					Assert.assertTrue(true, "TC has passed !!");

				} else {
					Assert.assertTrue(false, "TC has failed !!");
				}
			} else if (expectedResult.equalsIgnoreCase("Invalid")) {

				if (targetPage == true) {

					myAccountPage.clickLogout();
					Assert.assertTrue(false, "TC has failed !!");

				} else {
					Assert.assertTrue(true, "TC has passed !!");
				}
			}

		} catch (Exception e) {
			Assert.fail();
		}
		
		logger.info("**** Finishing the TC003_LoginDDT *****");

	}
}
