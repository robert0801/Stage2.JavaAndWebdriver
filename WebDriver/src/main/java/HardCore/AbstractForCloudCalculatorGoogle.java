package HardCore;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class AbstractForCloudCalculatorGoogle {

    protected WebDriver driver;

    public AbstractForCloudCalculatorGoogle(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitForVisibility(WebElement element) {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    protected void click(WebElement element) {
        waitForVisibility(element);
        element.sendKeys(Keys.ENTER);
    }

    protected void getToTheFrame(){
        driver.switchTo().frame(0);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("myFrame"));
    }
}
