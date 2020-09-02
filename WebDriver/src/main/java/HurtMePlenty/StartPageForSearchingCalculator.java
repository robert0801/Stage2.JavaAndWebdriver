package HurtMePlenty;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class StartPageForSearchingCalculator extends AbstractForCloudCalculatorGoogle {

    private final String WEB_SITE = "https://cloud.google.com/";

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchLineCloud;
    @FindBy(xpath = "//a[@data-ctorig='https://cloud.google.com/products/calculator']")
    private WebElement searchResultsCloud;

    public StartPageForSearchingCalculator(WebDriver driver) {
        super(driver);
    }

    public StartPageForSearchingCalculator getToStartPageWithSearchingLine() {
        driver.get(WEB_SITE);
        waitForVisibility(searchLineCloud);
        searchLineCloud.sendKeys("Google Cloud Platform Pricing Calculator");
        searchLineCloud.sendKeys(Keys.ENTER);
        return this;
    }

    public PageWithSettingsCalculator choiceTheLinkWithCloudCalculatorPage() {
        click(searchResultsCloud);
        return new PageWithSettingsCalculator(driver);
    }
}
