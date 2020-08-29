package HurtMePlenty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CloudSearchPage extends AbstractClassPage {
    @FindBy (xpath = "//a[@data-ctorig='https://cloud.google.com/products/calculator']")
    private List<WebElement> searchResultsCloud;

      public CloudSearchPage(WebDriver driver) {
        super(driver);
    }

    public CloudCalculatorPage cloudSearchPage() {
        searchResultsCloud.get(0).click();
        return new CloudCalculatorPage(driver);
    }
}
