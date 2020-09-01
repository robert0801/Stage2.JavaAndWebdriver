package HurtMePlenty;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CloudHomePage extends AbstractClassPage {

    private final String WEB_SITE = "https://cloud.google.com/";

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchLineCloud;
    @FindBy(xpath = "//a[@data-ctorig='https://cloud.google.com/products/calculator']")
    private WebElement searchResultsCloud;

    public CloudHomePage(WebDriver driver) {
        super(driver);
    }

    public CloudHomePage cloudStartPage() {
        driver.get(WEB_SITE);
        waitForVisibility(searchLineCloud);
        searchLineCloud.sendKeys("Google Cloud Platform Pricing Calculator");
        searchLineCloud.sendKeys(Keys.ENTER);
        return this;
    }

    public CloudCalculatorPage cloudSearchPage() {
        click(searchResultsCloud);
        return new CloudCalculatorPage(driver);
    }
}
