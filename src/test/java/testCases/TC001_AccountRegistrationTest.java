package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"regression","master"})
	public void verify_account_registration() {
		
		try {
		logger.info("Starting the testcase");
		HomePage homePage = new HomePage(driver);
		homePage.clickMyAccount();
		homePage.clickRegister();

		logger.info("Entered the registration page");
		AccountRegistrationPage rePage = new AccountRegistrationPage(driver);
		rePage.enterFirstName(randomString().toUpperCase());
		rePage.enterLastName(randomString().toUpperCase());
		rePage.enterEmail(randomString() + "@gmail.com"); // generating random email id everytime.
		rePage.enterTelephone(randomNumber());

		String password = randomAlphanumeric();
		rePage.enterPassword(password);
		rePage.enterConfirmPassword(password);
		rePage.clickcheckBoxAgree();
		rePage.clickContinue();
		logger.info("Entered all the details and clicked on Continue button");

		String message = rePage.getConfirmationMessage();
		logger.info("Account has been created");
		if(message.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}else {
			logger.error("Test Failed " );
			logger.debug("Debug logs => ");
			Assert.assertTrue(false);
		}

		
		}catch (Exception e) {
		
			Assert.fail();  //In case Assert for message check failed , then it will also print it here.
		}
	}

}
