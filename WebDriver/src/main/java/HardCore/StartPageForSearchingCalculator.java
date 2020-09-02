package HardCore;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StartPageForSearchingCalculator extends AbstractForCloudCalculatorGoogle {

    private final String WEB_SITE = "https://cloud.google.com/";

    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchLine;
    @FindBy(xpath = "//a[@data-ctorig='https://cloud.google.com/products/calculator']")
    private WebElement linkCloudGooglePage;

    public StartPageForSearchingCalculator(WebDriver driver) {
        super(driver);
    }

    public PageWithSettingsOfCalculator getToStartPage() {
        driver.get(WEB_SITE);
        waitForVisibility(searchLine).sendKeys("Google Cloud Platform Pricing Calculator");
        searchLine.sendKeys(Keys.ENTER);
        click(linkCloudGooglePage);
        return new PageWithSettingsOfCalculator(driver);
    }
}
