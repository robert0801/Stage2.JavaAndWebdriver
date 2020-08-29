package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import HurtMePlenty.*;
import static java.util.concurrent.TimeUnit.*;


public class HurtMePlentyTest {
    private WebDriver driver;
    private final String PATH_CHROME_DRIVER = "src/test/resources/chromedriver.exe";
    private final int VALUE_TIMEOUT = 20;

    @BeforeTest(alwaysRun = true)
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(VALUE_TIMEOUT, SECONDS);
        driver.manage().timeouts().implicitlyWait(VALUE_TIMEOUT, SECONDS);
        driver.manage().window().maximize();
    }

    @Test(description = "Create new calculator")
    public void openPage() {
        CloudCalculatorPage cloudGoogle = new CloudHomePage(driver)
                .cloudStartPage()
                .cloudSearchPage()
                .activateComputeEngine()
                .checkNumberOfInstances()
                .checkOperatingSystem()
                .checkMachineClass()
                .checkInstanceType()
                .checkAddGPU()
                .checkLocalSSD()
                .checkCenterLocation()
                .checkCommittedUsage()
                .addToEstimate();
    }



    @Test(dependsOnMethods = "openPage")
    public void checkVMClass(){
        WebElement testVMClass = driver
                .findElement(By.xpath("//md-list-item/div[contains(text(),'VM class')]"));
        Assert.assertTrue(testVMClass.getText().contains("VM class"), "Wrong VM Class");
    }

    @Test(dependsOnMethods = "openPage")
    public void checkInstanceType(){
        WebElement testInstanceType = driver
                .findElement(By.xpath("//md-list-item/div[contains(text(),'Instance type')]"));
        Assert.assertTrue(testInstanceType.getText().contains("n1-standard-8"), "Wrong Instance Type");
    }

    @Test(dependsOnMethods = "openPage")
    public void checkRegion(){
        WebElement testRegion = driver
                .findElement(By.xpath("//md-list-item/div[contains(text(),'Region')]"));
        Assert.assertTrue(testRegion.getText().contains("Frankfurt"), "Wrong Region");
    }

    @Test(dependsOnMethods = "openPage")
    public void checkLocalSSD(){
        WebElement testLocalSSD = driver
                .findElement(By.xpath("//md-list-item/div[contains(text(),'local SSD')]"));
        Assert.assertTrue(testLocalSSD.getText().contains("2x375"), "Wrong Local SSD");
    }

    @Test(dependsOnMethods = "openPage")
    public void checkCommitmentTerm(){
        WebElement testCommitmentTerm = driver
                .findElement(By.xpath("//md-list-item/div[contains(text(),'Commitment term')]"));
        Assert.assertTrue(testCommitmentTerm.getText().contains("1 Year"), "Wrong Commitment Term");
    }

    @Test(dependsOnMethods = "openPage")
    public void checkEstimatedComponentCost(){
        WebElement testEstimatedComponentCost = driver
                .findElement(By.xpath("//md-content[@id='compute']//b"));
        Assert.assertTrue(testEstimatedComponentCost.getText().contains("1,082.77"), "Wrong Cost");
    }


    @AfterTest (alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
        driver = null;
    }
}
