package BringItOn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

abstract public class AbstractClassForPastebin {
    protected WebDriver driver;
    protected final String webSite = "https://pastebin.com";

    protected AbstractClassForPastebin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
