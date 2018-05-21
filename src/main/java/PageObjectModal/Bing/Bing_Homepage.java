package PageObjectModal.Bing;

import PageObjectModal.AbstractMethods;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static reusables.reusableMethods_Report.getScreenshot;

/**
 * Created by Sumon.Kashem on 5/20/2018.
 */
public class Bing_Homepage extends AbstractMethods{
    //public static WebDriver driver;
    public Bing_Homepage(WebDriver driver, ExtentTest logger) {
        this.driver = driver;
        this.logger = AbstractMethods.logger;
    }

    @FindBy(xpath = "//*[@name='q']")
    public static WebElement searchField;
    @FindBy(xpath = "//*[@name='go']")
    public static WebElement searchButton;

    public static Bing_Homepage bingSearchField(String textValue) throws IOException {
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            //driver.findElement(By.xpath(locator)).sendKeys(textValue);
            logger.log(LogStatus.INFO,"Enter a value " +textValue+ " on 'Bing' search");
            wait.until(ExpectedConditions.visibilityOf(searchField)).sendKeys(textValue);
        } catch (Exception e) {
            System.out.println("Unable to enter usre value on sendKeys " + e);
            logger.log(LogStatus.FAIL,"Unable to enter info on 'Bing' search");
            getScreenshot(driver,logger);
        }

        return new Bing_Homepage(driver,logger);
    }

    public static Bing_Homepage bingSearchButton() throws IOException {
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            //driver.findElement(By.xpath(locator)).sendKeys(textValue);
            logger.log(LogStatus.INFO,"Clickon on 'Bing' search button");
            wait.until(ExpectedConditions.visibilityOf(searchButton)).click();
        } catch (Exception e) {
            System.out.println("Unable to click on 'Bing' Search Button " + e);
            logger.log(LogStatus.FAIL,"Unable to click on 'Bing' search button");
            getScreenshot(driver,logger);
        }

        return new Bing_Homepage(driver,logger);//abc
    }





}

