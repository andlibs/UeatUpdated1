package PageFactory.registerPage;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;


import java.util.concurrent.TimeUnit;

public class BaseClass {
    public WebDriver driver;
  

    public void setup(String applicationUrl) {
       
       System.setProperty("webdriver.chrome.driver", "D://Selenium workspace//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(applicationUrl);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    public void tearDown() {
        driver.quit();
    }
}
