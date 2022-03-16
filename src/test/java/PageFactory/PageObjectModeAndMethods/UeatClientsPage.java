package PageFactory.PageObjectModeAndMethods;

import PageFactory.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UeatClientsPage extends BasePage {
	public UeatClientsPage(WebDriver driver) {
		super(driver);
	}

	// Page object model started with locators
	By companyType = By.xpath("//select[@data-cy='client_restaurant_companyTypeList']");
	By addClientPlusSign = By.xpath("//a[@data-cy='list_add_button']");
	By restaurantCode = By.xpath("//input[@data-cy='client_restaurant_code']");
	By restaurantName = By.xpath("//input[@data-cy='client_restaurant_name']");
	By saveButton = By.xpath("//button[@type='submit']");
	By successMessage = By.xpath("//p[contains(text(),\"The restaurant has been successfully saved.\")]");
	By languageLink = By.xpath("//a[text()='English']");
	
	public void clickOnAddClientButton() throws InterruptedException {
		click(addClientPlusSign);
		waits();
	}

	public void assertPageLinkOnAddClientPage() throws InterruptedException {
		waits();
		String actual = "https://staging.ueat.io/ueat/reseller/client/0";
		String expected = driver.getCurrentUrl();
		assertEquals(actual, expected);
	}

	public void selectCompanyType(String text) throws InterruptedException {
		selectByVisibleText(companyType, text);
		waits();
	}

	public void enterRestaurantCode(String rCode) throws InterruptedException {
		writeText(restaurantCode, rCode);
		waits();
	}

	public void enterRestaurantName(String rCode) throws InterruptedException {
		writeText(restaurantName, rCode);
		waits();
	}

	public void clickOnSaveButton() throws InterruptedException {
		click(saveButton);
		waits();
	}

	public void assertSuccessMessage() throws InterruptedException {

		String expectedLink = "The restaurant has been successfully saved.";
		String actualLink = driver.findElement(successMessage).getText();
		assertEquals(actualLink, expectedLink);
		waits();
	}
	
	public void chagneLanguageAddClient() throws InterruptedException {
		if (driver.findElement(languageLink).getText().equalsIgnoreCase("English"))
			click(languageLink);
		waits();
	}

}
