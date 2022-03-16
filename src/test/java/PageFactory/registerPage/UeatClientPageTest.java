package PageFactory.registerPage;

import PageFactory.PageObjectModeAndMethods.UeatClientsPage;
import PageFactory.PageObjectModeAndMethods.UeatLoginPageLocators;
import PageFactory.com.utilities.PropertyFileOperations;
import PageFactory.com.utilities.RandomStringGenerator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class UeatClientPageTest extends BaseClass {

	@BeforeTest
	@Parameters("URL")
	public void setupUrl(String applicationURL) {

		setup(applicationURL);

	}

	@Test
	public void addClientPage() throws InterruptedException {
		UeatClientsPage ueatClientsPage = new UeatClientsPage(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		login();
		ueatClientsPage.chagneLanguageAddClient();
		ueatClientsPage.clickOnAddClientButton();
		ueatClientsPage.assertPageLinkOnAddClientPage();
		ueatClientsPage.selectCompanyType("Reseller");
		ueatClientsPage.enterRestaurantCode(RandomStringGenerator.randomNumGenerator());
		ueatClientsPage.enterRestaurantName(RandomStringGenerator.randomNumGenerator());
		ueatClientsPage.clickOnSaveButton();
		ueatClientsPage.assertSuccessMessage();
	}

	public void login() throws InterruptedException {
		
		UeatLoginPageLocators ueatLoginPageLocators = new UeatLoginPageLocators(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		ueatLoginPageLocators.chagneLanguage();
		ueatLoginPageLocators.enterUsername(PropertyFileOperations.readPropertyFile().getProperty("username"));
		ueatLoginPageLocators.enterPassword(PropertyFileOperations.readPropertyFile().getProperty("password"));
		ueatLoginPageLocators.clickOnLoginButton();
		ueatLoginPageLocators.verifyPageLinkAfterLogin();

	}
	
	

	@AfterTest
	public void testend() throws Exception {
		tearDown();
	}
}
