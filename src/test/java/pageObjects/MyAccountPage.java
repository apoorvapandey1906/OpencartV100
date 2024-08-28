package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@id='content']/h2[text()='My Account']")
	WebElement headingMyAccount;
	
	@FindBy(xpath="//a[@class='list-group-item' and text()='Logout']")
	WebElement linkLogout;

	
	public void clickLogout() {
		linkLogout.click();
	}
	
	public boolean isMyAccountPageExists() {
		try {
			return headingMyAccount.isDisplayed();
		}catch (Exception e) {
			return false;
		}
	}
}
