package HardCore;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloudGoogleComPage extends AbstractForCloudGoogle {

    private final String WEB_SITE = "https://cloud.google.com/";

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchLineCloud;
    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchLine;
    @FindBy(xpath = "//a[@data-ctorig='https://cloud.google.com/products/calculator']")
    private WebElement linkCloudGooglePage;

    public CloudGoogleComPage(WebDriver driver) {
        super(driver);
    }

    public PageWithSettings getToStartPage() {
        driver.get(WEB_SITE);
        waitForVisibility(searchLine).sendKeys("Google Cloud Platform Pricing Calculator");
        searchLine.sendKeys(Keys.ENTER);
        click(linkCloudGooglePage);
        return new PageWithSettings(driver);
    }
}
