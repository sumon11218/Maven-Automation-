package reusables;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

/**
 * Created by Sumon.Kashem on 4/29/2018.
 */
public class reusableMethods {
    //static variable which can be used on your method classes. for example, explicit timeout session
    public static int timeout = 7;

    //chromedriver method needs to be a return class to be used on your execution class
    public static WebDriver chromeDriver(){
        // connecting to chrome driver
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        //defining chrome option
        ChromeOptions options = new ChromeOptions();
        //adding an argument to the option to maximize the browser
        options.addArguments("start-maximized","incognito","disable-extensions");
        //defining the chrome driver and passing the option argument to the driver
        WebDriver driver = new ChromeDriver(options);
        //we are returning the driver variable because it's storing the chromdriver(option)
        return driver;
    }

    //method below allows you to create a reusable method to click on an element
    //and you are passing two arguments one is webdriver you are using & the locator
    //you are locating the element with
    public static void click(WebDriver driver, String locator){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).click();
        } catch (Exception e) {
            System.out.println("Unable to click on an element " + e);
        }

    }//end fo click method


    //this is for sendkeys
    public static void EnterSomething(WebDriver driver, String locator, String textValue){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        try{
            //driver.findElement(By.xpath(locator)).sendKeys(textValue);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).sendKeys(textValue);

        } catch (Exception e) {
            System.out.println("Unable to enter usre value on sendKeys " + e);
        }

    }//end of send keys method


    //method for getText
    public static String getContent(WebDriver driver, String locator){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        String message = null;
        try{
            message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).getText();
        }catch (Exception e){
            System.out.println("Unable to capture the text value " + e);
        }

        return message;
    }



    //reusable method for mouseHover
    public static void mouseHover (WebDriver driver, String locator ){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions Hover = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            Hover.moveToElement(element).build().perform();
        }catch(Exception e){
            System.out.println("unable to hover over element " +e);
        }
    }//end of method

    //reusable method for Mouse double click
    public static void mouseDblClick (WebDriver driver, String locator ){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        Actions Hover = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            Hover.moveToElement(element).doubleClick().build().perform();
        }catch(Exception e){
            System.out.println("unable to doubl click on element " +e);
        }
    }//end of method

    public static void scrollIntoElement(WebDriver driver, String locator){
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            jse.executeScript("arguments[0].scrollIntoView(true);", element);
        }catch(Exception e){
            System.out.println("unable to scroll into element " +e);
        }
    }

    public static void getScreenshot(WebDriver driver, ExtentTest logger, String screenshotName) throws IOException {
        // String path = "C:\\Users\\sumon.kashem\\Desktop\\Screenshots\\";
        String path = "src\\main\\java\\externalFiles\\ScreenShots\\";
        String fileName = screenshotName + ".png";
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //Now you can do whatever you need to do with, for example copy somewhere
        FileUtils.copyFile(sourceFile, new File(path + fileName));
        //String imgPath = directory + fileName;
        String image = logger.addScreenCapture("ScreenShots\\" + fileName);
        logger.log(LogStatus.FAIL, "", image);
    }




}//end of class

