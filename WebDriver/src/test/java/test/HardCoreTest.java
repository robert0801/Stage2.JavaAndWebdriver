package test;

import HardCore.GenerateMailPage;
import HardCore.PageWithSettingsOfCalculator;
import HardCore.StartPageForSearchingCalculator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class HardCoreTest {
    private final String PATH_CHROME_DRIVER = "src/test/resources/chromedriver.exe";
    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
        PageFactory.initElements(driver, this);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void openPage() {
        PageWithSettingsOfCalculator cloudPage = new StartPageForSearchingCalculator(driver)
                .getToStartPage()
                .activateComputeEngine()
                .settingValueNumberOfInstances()
                .settingValueOperatingSystem()
                .settingValueMachineClass()
                .settingValueMachineType()
                .settingAddGPU()
                .settingValueLocalSSD()
                .settingValueDatacenterLocation()
                .settingValueCommittedUsage()
                .clickOnTheButtonAddToEstimate()
                .createNewTab();

        GenerateMailPage mailPage = new GenerateMailPage(driver)
                .getToGenerateMailPage()
                .copyMail();
        cloudPage
                .clickOnButtonEmailEstimate()
                .insertGeneratingMailInFieldInputMail()
                .clickOnTheButtonSendEmail()
                .getPriceInCalculatorPage();
        mailPage
                .clickToOpenMail()
                .getPriceOnGenerateMailPage();
    }

    @Test(dependsOnMethods = "openPage")
    public void checkCost() {
        Assert.assertEquals(PageWithSettingsOfCalculator.priceOnCalculatorPage, GenerateMailPage.priceOnGenerateMailPage,
                "The price in the sent email does not match the price on the calculator creation page.");
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
