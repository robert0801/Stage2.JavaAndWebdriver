package ICanWin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatNewPasteOnPastebin extends AbstractClassForPastebin{
    @FindBy (xpath = "//textarea[@name='PostForm[text]']")
    private WebElement areaForNewPaste;
    @FindBy (xpath = "//select[@name='PostForm[expiration]']/parent::div")
    private WebElement pasteExpiration;
    @FindBy (xpath = "//li[text()='10 Minutes']")
    private WebElement pasteExpiration10Minutes;
    @FindBy (xpath = "//input[@name='PostForm[name]']")
    private WebElement pasteNameForNewPaste;

    public CreatNewPasteOnPastebin(WebDriver driver) {
        super(driver);
    }

    public CreatNewPasteOnPastebin enterCodeOnPastebin() {
        driver.get(webSite);
        areaForNewPaste.sendKeys("Hello from WebDriver");
        return this;
    }

    public CreatNewPasteOnPastebin checkThe10Minutes() {
        pasteExpiration = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(pasteExpiration));
        pasteExpiration.click();
        pasteExpiration10Minutes.click();
        return this;
    }

    public CreatNewPasteOnPastebin insertPasteName() {
        pasteNameForNewPaste = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(pasteNameForNewPaste));
        pasteNameForNewPaste.sendKeys("helloweb");
        return this;

    }

}


