package test;

import ICanWin.CreatNewPasteOnPastebin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class ICanWinTest {
    private WebDriver driver;
    private final String PATH_CHROME_DRIVER = "src/test/resources/chromedriver.exe";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void pasteOnPastebin() {
        new CreatNewPasteOnPastebin(driver)
                .enterCodeOnPastebin()
                .checkThe10Minutes()
                .insertPasteName();
    }


    @AfterTest(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
        driver = null;
    }
}
