package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
	WebDriverWait wait ;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElementToBeVisible(WebElement ele) {
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitForElementToBeClickable(WebElement ele) {
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public void waitForTextIsPrsentInElement(WebElement ele,String text) {
		wait.until(ExpectedConditions.textToBePresentInElement(ele, text));
	}

}
