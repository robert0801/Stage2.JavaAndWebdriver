package HurtMePlenty;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

public class CloudCalculatorPage extends AbstractClassPage {

    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']")
    private WebElement iconComputeEngine;

    @FindBy(xpath = "//input[contains(@ng-model,'quantity')]")
    private WebElement numberOfInstances;

    @FindBy (xpath = "//md-option[@value='free']")
    private WebElement optionFree;

    @FindBy(xpath = "//label[text()='Operating System / Software']/../md-select")
    private WebElement operatingSystem;

    @FindBy(xpath = "//md-select[@placeholder='VM Class']")
    private WebElement machineClass;

    @FindBy(xpath = "//md-select-menu[@style=contains(text(), '')]/descendant::md-option[@value='regular']")
    private WebElement optionRegular;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    private WebElement machineType;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    private WebElement optionMachineType;

    @FindBy(xpath = "//*[contains(@ng-model,'GPU')]")
    private WebElement checkAddGPU;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPU;

    @FindBy(xpath = "//div[normalize-space()='1']/parent::md-option")
    private WebElement checkNumberOfGPU;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement typeOfGPU;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement checkTypeOfGPU;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement localSSD;

    @FindBy(xpath = "//div[normalize-space()='2x375 GB']/parent::md-option")
    private WebElement typeLocalSSD;

    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
    private WebElement location;

    @FindBy(xpath = "//md-select-menu[@class='md-overflow']/descendant::div[contains(text(), 'Frankfurt')]/parent::md-option")
    private WebElement typeLocation;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement committedUsage;

    @FindBy(xpath = "//md-select-menu[contains(@style, 'transform-origin')]//div[text()='1 Year']/parent::md-option")
    private WebElement typeCommittedUsage;

    public CloudCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CloudCalculatorPage activateComputeEngine() {
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        waitForVisibility(iconComputeEngine);
        iconComputeEngine.click();
        return this;
    }

    public CloudCalculatorPage checkNumberOfInstances() {
        waitForVisibility(numberOfInstances);
        numberOfInstances.sendKeys("4");
        return this;
    }

    public CloudCalculatorPage checkOperatingSystem(){
        click(operatingSystem);
        click(optionFree);
        return this;
    }

    public CloudCalculatorPage checkMachineClass() {
        click(machineClass);
        click(optionRegular);
        return this;
    }

    public CloudCalculatorPage checkInstanceType(){
        click(machineType);
        click(optionMachineType);
        return this;
    }

    public CloudCalculatorPage checkAddGPU(){
        click(checkAddGPU);
        click(numberOfGPU);
        click(checkNumberOfGPU);
        click(typeOfGPU);
        click(checkTypeOfGPU);
        return this;
    }

    public CloudCalculatorPage checkLocalSSD(){
        click(localSSD);
        click(typeLocalSSD);
        return this;
    }

    public CloudCalculatorPage checkCenterLocation(){
        click(location);
        click(typeLocation);
        return this;
    }

    public CloudCalculatorPage checkCommittedUsage(){
        click(committedUsage);
        click(typeCommittedUsage);
        return this;
    }

    public CloudCalculatorPage addToEstimate(){
        List<WebElement> addToEstimate = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[@aria-label='Add to Estimate']")));
        addToEstimate.get(0).sendKeys(Keys.ENTER);
        return this;
    }


    private void waitForVisibility(WebElement element){
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOf(element));
    }

    private void click(WebElement element){
        waitForVisibility(element);
        element.sendKeys(Keys.ENTER);
    }
}

