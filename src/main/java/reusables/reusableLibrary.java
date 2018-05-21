package reusables;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

/**
 * Created by Sumon.Kashem on 5/8/2018.
 */
public class reusableLibrary {

    //reusable method for clicking an element
    public static void  elementClick(WebDriver driver, String locator, ExtentReports reports, ExtentTest logger, String elementName) throws InterruptedException {
        logger.log(LogStatus.INFO,"Clicking on an element " + elementName);
        WebDriverWait wait = new WebDriverWait(driver, 8);

        try {

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).click();
            logger.log(LogStatus.PASS, "Able to successfully click on element " + elementName);
        }catch (Exception e){
            System.out.println("Unable to click on an element... " + e);
            logger.log(LogStatus.FAIL,"Unable to click on element " + elementName);
            //Thread.sleep(800);
            //getScreenshot(driver,logger,elementName);
        }
    }

    //reusable method for using send key on an element with report
    public static void elementSendKeys(WebDriver driver, String locator, String userInput, ExtentReports report, ExtentTest logger, String elementName) throws InterruptedException {

        logger.log(LogStatus.INFO,"Entering value into element " + elementName);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).sendKeys(userInput);
            logger.log(LogStatus.PASS,"Able to successfully enter value into an element " +elementName);
        }catch (Exception e){
            System.out.println("Unable to click on an element... " + e);
            logger.log(LogStatus.FAIL," Unable to enter value into element " + elementName);
            //Thread.sleep(800);
            //getScreenshot(driver,logger,elementName);
        }
    }

    //reusable method for clearing value on an element with report
    public static void elementClear(WebDriver driver, String locator, ExtentReports report, ExtentTest logger, String elementName) throws InterruptedException {

        logger.log(LogStatus.INFO,"Clearing value in element" + elementName);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).clear();
            logger.log(LogStatus.PASS,"Able to successfully clear value on element" + elementName);
        }catch(Exception e){
            System.out.println("Unable to click on an element..." + e);
            logger.log(LogStatus.FAIL,"Unable to clear value on element " + elementName);
            //Thread.sleep(800);
            //getScreenshot(driver,logger,elementName);
        }
    }

    //click on element using mouse movement
    public static void clickByMouse(WebDriver driver, String locator, ExtentReports report, ExtentTest logger, String elementName) throws InterruptedException {

        logger.log(LogStatus.INFO,"Clicking on element using mouse movement" + elementName);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        Actions mouseHover = new Actions(driver);
        try{
            WebElement hoverElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            mouseHover.moveToElement(hoverElement).click().build().perform();
            logger.log(LogStatus.PASS,"Able to successfully click on element using mouse movement" + elementName);
        }catch(Exception e){
            System.out.println("Unable to click on an element..." + e);
            logger.log(LogStatus.FAIL,"Unable to click on element using mouse movement " + elementName);
            //Thread.sleep(800);
            //getScreenshot(driver,logger,elementName);
        }
    }

    //entering values on element using mouse movement
    public static void sendKeyByMouse(WebDriver driver, String locator, String userInput, ExtentReports report, ExtentTest logger, String elementName) throws InterruptedException {

        logger.log(LogStatus.INFO,"Entering value on element using mouse movement" + elementName);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        Actions mouseHover = new Actions(driver);
        try{
            WebElement hoverElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            mouseHover.moveToElement(hoverElement).sendKeys(userInput).build().perform();
            logger.log(LogStatus.PASS,"Able to successfully enter a value on element using mouse movement" + elementName);
        }catch(Exception e){
            System.out.println("Unable to click on an element..." + e);
            logger.log(LogStatus.FAIL,"Unable to enter a value on element using mouse movement " + elementName);
            //Thread.sleep(800);
            //getScreenshot(driver,logger,elementName);
        }
    }

    public static WebDriver wDriver(){
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        //Chrome options is a built in selenium command with java which allows you to pass additional
        //arguments before defining the driver.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //line below define the type of driver you are using by calling Web.
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }

    //line below will select element by visible text from 'select' tag name
    public static void selectElementFromDropDownByText(WebElement element, String visibleText){

        Select dropDown = new Select(element);
        dropDown.selectByVisibleText(visibleText);
    }
    //line below will select element by value from a 'select' tag name
    public static void selectElementFromDropDownByValue(WebElement element, String value ){

        Select dropDown = new Select(element);
        dropDown.selectByValue(value);
    }

    public static void scrollIntoElement(WebDriver driver, WebElement element) {

        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    //method below will define webdriverwait
    public static void  webDriverWait(WebDriver driver, int seconds, String xpathExpression){

        WebDriverWait wait = new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathExpression)));

    }

    //method below will take screenshot
    public static void getScreenshot(WebDriver wDriver, ExtentTest test, String path, String screenshotName) throws IOException, IOException {
        String fileName = screenshotName + ".png";
        File sourceFile = ((TakesScreenshot)wDriver).getScreenshotAs(OutputType.FILE);
        //Now you can do whatever you need to do with, for example copy somewhere
        FileUtils.copyFile(sourceFile, new File(path + fileName));
        //String imgPath = directory + fileName;
        String image = test.addScreenCapture(path + fileName);
        test.log(LogStatus.FAIL, "", image);

    }



}
