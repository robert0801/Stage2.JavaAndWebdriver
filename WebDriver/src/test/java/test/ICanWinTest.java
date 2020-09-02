package test;

import ICanWin.CreatNewPasteOnPastebin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ICanWinTest {
    private final String PATH_CHROME_DRIVER = "src/test/resources/chromedriver.exe";
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void pasteOnPastebin() {
        new CreatNewPasteOnPastebin(driver)
                .enterCodeOnPastebin()
                .checkThe10Minutes()
                .insertPasteName();
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
