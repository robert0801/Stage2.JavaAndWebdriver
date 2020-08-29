package HardCore;

import HurtMePlenty.CloudSearchPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleComPage extends AbstractForCloudGoogle{

    private final String WEB_SITE = "https://cloud.google.com/";

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchLineCloud;

    public CloudGoogleComPage(WebDriver driver) {
        super(driver);
    }

    public PageWithSettings getToStartPage(){
        driver.get(WEB_SITE);
        WebElement searchLine = driver.findElement(By.xpath("//input[@type='text']"));
        searchLine.sendKeys("Google Cloud Platform Pricing Calculator");
        searchLine.sendKeys(Keys.ENTER);
        WebElement linkCloudGooglePage = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-ctorig='https://cloud.google.com/products/calculator']")));
        linkCloudGooglePage.click();
        return new PageWithSettings(driver);
    }
}
