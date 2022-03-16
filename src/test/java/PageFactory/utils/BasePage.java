package PageFactory.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    //Wait Wrapper Method
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    //Click Method
    public void click(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    //Find Element
    public void find(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy);
    }

    //Sleep
    public void waits() throws InterruptedException {
        Thread.sleep(3000);
    }

    //Write Text
    public void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    //clearText Text
    public void clearText(By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).clear();
    }

    //Read Text
    public String readText(By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    //Assert
    public void assertEquals(By elementBy, String expectedText) {
        waitVisibility(elementBy);
        Assert.assertEquals(readText(elementBy), expectedText);
    }

    public void assertEquals(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    //get Current URL
    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    //Select value from Dropdown
    public void selectByVisibleText(By elementBy,String text){
        Select sel = new Select(driver.findElement(elementBy));
        sel.selectByVisibleText(text);
    }

}
