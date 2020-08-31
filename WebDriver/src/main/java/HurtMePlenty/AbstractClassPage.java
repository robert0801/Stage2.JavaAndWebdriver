package HurtMePlenty;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract public class AbstractClassPage {
    protected WebDriver driver;

    public AbstractClassPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
