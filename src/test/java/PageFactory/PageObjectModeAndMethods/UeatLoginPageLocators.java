package PageFactory.PageObjectModeAndMethods;

import PageFactory.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UeatLoginPageLocators extends BasePage {
	public UeatLoginPageLocators(WebDriver driver) {
		super(driver);
	}

	// Page object model started with locators
	By ueatUsername = By.xpath("//input[@type='text']");
	By ueatPassword = By.xpath("//input[@type='password']");
	By ueatSubmitbutton = By.xpath("//button[@type='submit']");
	By ueatChangeLanguage = By.xpath("//a[@class='_1eMMV']");

	public void chagneLanguage() throws InterruptedException {
		if (driver.findElement(ueatChangeLanguage).getText().equalsIgnoreCase("en"))
			click(ueatChangeLanguage);
		waits();
	}

	public void enterUsername(String userName) throws InterruptedException {
		writeText(ueatUsername, userName);
		waits();
	}

	public void enterPassword(String password) throws InterruptedException {
		writeText(ueatPassword, password);
		waits();
	}

	public void clickOnLoginButton() throws InterruptedException {
		click(ueatSubmitbutton);
		waits();
	}

	public void verifyPageLinkAfterLogin() throws InterruptedException {
		waits();
		String expectedLink = "https://staging.ueat.io/ueat/reseller/client";
		String actualLink = getCurrentURL();
		assertEquals(actualLink, expectedLink);

	}

}
