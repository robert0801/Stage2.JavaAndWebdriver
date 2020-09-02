package test;


import BringItOn.CreatNewPasteOnPastebin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BringItOnTest {

    private final String PATH_CHROME_DRIVER = "src/test/resources/chromedriver.exe";
    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void pasteOnPastebin() {
        new CreatNewPasteOnPastebin(driver)
                .enterCodeOnPastebin()
                .syntaxHighlighting()
                .checkThe10Minutes()
                .insertPasteNameAndCreatPaste()
                .getInformationWithSettingFields();
    }

    @Test(dependsOnMethods = "pasteOnPastebin")
    public void checkCorrectTitle() {
        Assert.assertTrue(CreatNewPasteOnPastebin.titleOnPageWithInformationSettingFields.getText().equals("how to gain dominance among developers"),
                "The title of browser doesn't match the title on starting page.");
    }

    @Test(dependsOnMethods = "pasteOnPastebin")
    public void checkCorrectSyntax() {
        Assert.assertTrue(CreatNewPasteOnPastebin.syntaxHighlightingOnPageWithInformationSettingFields.getText().equals("Bash"),
                "The Syntax Highlighting on open page doesn't match the syntax on starting page.");
    }

    @Test(dependsOnMethods = "pasteOnPastebin")
    public void checkCorrectCode() {
        Assert.assertTrue(CreatNewPasteOnPastebin.codeOnPageWithInformationSettingFields.getText().equals
                        ("git config --global user.name  \"New Sheriff in Town\"\n" +
                                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                                "git push origin master --force"),
                "The code doesn't match that was insert on starting page.");
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
