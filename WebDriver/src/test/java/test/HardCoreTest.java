package test;

import HardCore.CloudGoogleComPage;
import HardCore.GenerateMailPage;
import HardCore.PageWithSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;


public class HardCoreTest {
    private final int VALUE_TIMEOUT = 20;
    private final String PATH_CHROME_DRIVER = "src/test/resources/chromedriver.exe";
    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
        PageFactory.initElements(driver, this);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(VALUE_TIMEOUT, SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void openPage() {
        PageWithSettings cloudPage = new CloudGoogleComPage(driver)
                .getToStartPage()
                .checkNumberOfInstances()
                .checkOperatingSystem()
                .checkMachineClass()
                .checkMachineType()
                .checkAddGPU()
                .checkLocalSSD()
                .checkDatacenterLocation()
                .checkCommittedUsage()
                .addToEstimate()
                .emailEstimate()
                .createNewTab();

        GenerateMailPage mailPage = new GenerateMailPage(driver)
                .getToMailPage()
                .copyMail();
        cloudPage
                .checkInputMail()
                .checkSendEmail()
                .getPriceInCalculator();
        mailPage
                .clickToOpenMail()
                .getPriceOnGenerateMailPage();
    }

    @Test(dependsOnMethods = "openPage")
    public void checkCost() {
        Assert.assertEquals(PageWithSettings.priceOnCalculatorPage, GenerateMailPage.priceOnGenerateMailPage,
                "Price in sent email doesn't match price on the page of generate calculator.");
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
