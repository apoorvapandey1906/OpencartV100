package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="input-firstname")
	WebElement txtFirstName;
	
	@FindBy(id="input-lastname")
	WebElement txtLastName;
	
	@FindBy(id="input-email")
	WebElement txtEMail;
	
	@FindBy(id="input-telephone")
	WebElement txtTelephone;
	
	@FindBy(id="input-password")
	WebElement txtPassword;

	@FindBy(id="input-confirm")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement checkBoxAgree;
	
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement msgConfirmation;
	
	public void enterFirstName(String firstName) {
		txtFirstName.sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		txtLastName.sendKeys(lastName);
	}
	
	public void enterEmail(String email) {
		txtEMail.sendKeys(email);
	}
	
	public void enterTelephone(String telephone) {
		txtTelephone.sendKeys(telephone);	}
	
	public void enterPassword(String pass) {
		txtPassword.sendKeys(pass);
	}
	
	public void enterConfirmPassword(String confirmPass) {
		txtConfirmPassword.sendKeys(confirmPass);
	}
	
	public void clickcheckBoxAgree() {
		waitForElementToBeClickable(checkBoxAgree);
		checkBoxAgree.click();
	}
	
	public void clickContinue() {
		waitForElementToBeClickable(btnContinue);
		btnContinue.click();
	}
	
	public String getConfirmationMessage() {
		try {
			waitForElementToBeVisible(msgConfirmation);
			return msgConfirmation.getText();
		}catch (Exception e) {
			return e.getMessage();
		}
	}

	
}
