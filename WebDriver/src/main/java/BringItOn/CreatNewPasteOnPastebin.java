package BringItOn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatNewPasteOnPastebin extends AbstractClassForPastebin{
    private String pasteName = "how to gain dominance among developers";
    private String areaName = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private String selectPaste = "10 Minutes";
    private String syntaxName = "Bash";


    @FindBy (xpath = "//textarea[@name='PostForm[text]']")
    private WebElement areaForNewPaste;

    @FindBy (xpath = "//select[@name='PostForm[expiration]']/parent::div")
    private WebElement pasteExpiration;

    @FindBy (xpath = "//li[text()='10 Minutes']")
    private WebElement pasteExpiration10Minutes;

    @FindBy (xpath = "//select[@name='PostForm[format]']/parent::div")
    private WebElement syntaxHighlighting;

    @FindBy (xpath = "//li[text()='Bash']")
    private WebElement syntaxHighlightingBash;

    @FindBy (xpath = "//input[@name='PostForm[name]']")
    private WebElement pasteNameForNewPaste;

    @FindBy(xpath = "//button[contains(text(), Create)]")
    private WebElement createNewPasteBtn;

    public CreatNewPasteOnPastebin(WebDriver driver) {
        super(driver);
    }
    public CreatNewPasteOnPastebin enterCodeOnPastebin() {
        driver.get(webSite);
        areaForNewPaste.sendKeys(areaName);
        return this;
    }

    public CreatNewPasteOnPastebin syntaxHighlighting() {
        checkOptionInSelect(syntaxHighlighting, syntaxHighlightingBash);
        return this;
    }


    public CreatNewPasteOnPastebin checkThe10Minutes() {
        checkOptionInSelect(pasteExpiration, pasteExpiration10Minutes);
        return this;
    }

    public CreatNewPasteOnPastebin insertPasteNameAndCreatPaste() {
        pasteNameForNewPaste.sendKeys(pasteName);
        createNewPasteBtn.click();
        return this;
    }

    private void checkOptionInSelect(WebElement select, WebElement option){
        select = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(select));
        select.click();
        option = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(option));
        option.click();
    }

}