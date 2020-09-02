package test;

import HurtMePlenty.PageWithSettingsCalculator;
import HurtMePlenty.StartPageForSearchingCalculator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class HurtMePlentyTest {
    private final String PATH_CHROME_DRIVER = "src/test/resources/chromedriver.exe";
    private WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test(description = "Create new calculator")
    public void openPage() {
        PageWithSettingsCalculator cloudGoogle = new StartPageForSearchingCalculator(driver)
                .getToStartPageWithSearchingLine()
                .choiceTheLinkWithCloudCalculatorPage()
                .activateComputeEngine()
                .settingValueNumberOfInstances()
                .settingValueOperatingSystem()
                .settingValueMachineClass()
                .settingValueInstanceType()
                .settingAddGPU()
                .settingValueLocalSSD()
                .settingValueCenterLocation()
                .settingValueCommittedUsage()
                .clickOnTheButtonAddToEstimate();
    }

    @Test(dependsOnMethods = "openPage")
    public void checkVMClass() {
        WebElement testVMClass = driver
                .findElement(By.xpath("//md-list-item/div[contains(text(),'VM class')]"));
        Assert.assertTrue(testVMClass.getText().contains("VM class"), "The calculator has the VM Class," +
                "that doesn't match creating options.");
    }

    @Test(dependsOnMethods = "openPage")
    public void checkInstanceType() {
        WebElement testInstanceType = driver
                .findElement(By.xpath("//md-list-item/div[contains(text(),'Instance type')]"));
        Assert.assertTrue(testInstanceType.getText().contains("n1-standard-8"), "The calculator has the Instance Type," +
                "that doesn't match creating options.");
    }

    @Test(dependsOnMethods = "openPage")
    public void checkRegion() {
        WebElement testRegion = driver
                .findElement(By.xpath("//md-list-item/div[contains(text(),'Region')]"));
        Assert.assertTrue(testRegion.getText().contains("Frankfurt"), "The calculator has the Region," +
                "that doesn't match creating options.");
    }

    @Test(dependsOnMethods = "openPage")
    public void checkLocalSSD() {
        WebElement testLocalSSD = driver
                .findElement(By.xpath("//md-list-item/div[contains(text(),'local SSD')]"));
        Assert.assertTrue(testLocalSSD.getText().contains("2x375"), "The calculator has Local SSD," +
                "that doesn't match creating options.");
    }

    @Test(dependsOnMethods = "openPage")
    public void checkCommitmentTerm() {
        WebElement testCommitmentTerm = driver
                .findElement(By.xpath("//md-list-item/div[contains(text(),'Commitment term')]"));
        Assert.assertTrue(testCommitmentTerm.getText().contains("1 Year"), "The calculator has Commitment Term," +
                "that doesn't match creating options.");
    }

    @Test(dependsOnMethods = "openPage")
    public void checkEstimatedComponentCost() {
        WebElement testEstimatedComponentCost = driver
                .findElement(By.xpath("//md-content[@id='compute']//b"));
        Assert.assertTrue(testEstimatedComponentCost.getText().contains("1,082.77"), "The calculator has Cost" +
                "that doesn't match the result manual testing.");
    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
        driver = null;
    }
}
