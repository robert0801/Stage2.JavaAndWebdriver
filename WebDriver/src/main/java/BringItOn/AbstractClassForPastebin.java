package BringItOn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract public class AbstractClassForPastebin {
    protected final String webSite = "https://pastebin.com";
    protected WebDriver driver;

    protected AbstractClassForPastebin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
