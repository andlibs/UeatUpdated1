package PageFactory.registerPage;

import PageFactory.PageObjectModeAndMethods.UeatClientsPage;
import PageFactory.PageObjectModeAndMethods.UeatLoginPageLocators;
import PageFactory.com.utilities.PropertyFileOperations;
import PageFactory.com.utilities.RandomStringGenerator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class UeatLoginPage extends BaseClass {

	@BeforeTest
	@Parameters("URL")
	public void setupUrl(String applicationURL) {

		setup(applicationURL);

	}

	@Test
	public void verifyLogInPage() throws InterruptedException {
		UeatLoginPageLocators ueatLoginPageLocators = new UeatLoginPageLocators(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
