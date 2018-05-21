package day10_05062018;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import reusables.reusableMethods;

/**
 * Created by Sumon.Kashem on 5/6/2018.
 */
public class Express_Action_Item {
    WebDriver driver;
    SoftAssert softAssert;
    @BeforeMethod
    public void openBrowser(){
        //define the chrome driver using reusable method
        driver = reusables.reusableMethods.chromeDriver();
    }

    @Test(priority = 1)
    public void testScenario() throws InterruptedException {
        softAssert = new SoftAssert();
        //navigate to google
        driver.navigate().to("https://www.express.com");
        //Hover over to Woemen's tab
        reusableMethods.mouseHover(driver,"//*[contains(@aria-label,'Women')]");
        //click twice on accessories
        reusableMethods.click(driver,"//*[@class='subnav-target' and contains(@href,'womens-clothing/accessories')]");
        reusableMethods.click(driver,"//*[@class='subnav-target' and contains(@href,'womens-clothing/accessories')]");

        //click on jewelry
        reusableMethods.click(driver,"//*[contains(@href,'womens-clothing/accessories/jewelry')]/span");
        //hover to first image
        reusableMethods.mouseHover(driver,"//*[contains(@class,'swatch-images')]");
        //click on Express View
        reusableMethods.click(driver,"//*[@class='express-view']");
        //click on Add to Bag
        reusableMethods.click(driver,"//*[text()='Add to Bag']");
        //hover over bag icon
        reusableMethods.mouseHover(driver,"//*[@class='bag-icon']");
        //click on Check Out Button
        reusableMethods.click(driver,"//*[text()='CHECKOUT']");
        //click on quantity drop down
        reusableMethods.click(driver,"//*[@id='qdd-0-quantity']");
        //click on quantity as 2 value
        reusableMethods.click(driver,"//*[text()='2']");
        //click on continue to check out
        reusableMethods.click(driver,"//*[@id='continue-to-checkout']");
        //click on Check out as guest
        reusableMethods.click(driver,"//*[text()='Continue as Guest']");





        Thread.sleep(3000);
    }

    @AfterMethod
    public void closeBrowser(){
        //quitting the driver
        //driver.quit();
        softAssert.assertAll();
    }






}
