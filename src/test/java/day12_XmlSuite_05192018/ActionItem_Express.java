package day12_XmlSuite_05192018;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Created by Sumon.Kashem on 5/12/2018.
 */
public class ActionItem_Express {

    //define the global variables
    //webdriver
    WebDriver driver;
    //soft assert
    SoftAssert softAssert;

    @BeforeSuite
    public void defineBrowser() throws InterruptedException {
        //define the chrome driver using reusable method
        driver = reusables.reusableMethods.chromeDriver();
    }

    @AfterSuite
    public void closeDriver(){
        //driver.quit();
        softAssert.assertAll();
    }

    @Test(priority = 1)
    public void testCase1() throws InterruptedException {
        //define the softassert
        softAssert = new SoftAssert();
        //navigate to express.com
        driver.navigate().to("https://www.express.com");
        //hover over Women using reusable mouse action method
        reusables.reusableMethods.mouseHover(driver,"//*[@href='/womens-clothing']");
        //hover over accessories
        reusables.reusableMethods.mouseHover(driver,"//*[@class='subnav-target' and contains(@href,'/womens-clothing/accessories')]");
        //clicking on Jewelry
        reusables.reusableMethods.click(driver,"//*[contains(@href,'/womens-clothing/accessories/jewelry/')]");
        //click on earrings
        reusables.reusableMethods.click(driver,"//*[text()='Earrings']");
        //assert that i'm on the right page
        softAssert.assertEquals("Earrings for Women - Earrings",driver.getTitle(),"Should display Women's Earrings page");
        //hover over first image on the selection
        reusables.reusableMethods.mouseHover(driver,"//*[@class='active loaded']");
        //click on Express View
        reusables.reusableMethods.click(driver,"//*[@class='express-view']");
        //click on the second color
        Thread.sleep(2000);
        driver.findElements(By.xpath("//*[@class='color-swatch']")).get(1).click();
        //click on Add to bag
        reusables.reusableMethods.click(driver,"//*[text()='Add to Bag']");
        //hover over Bag icon
        reusables.reusableMethods.mouseHover(driver,"//*[@class='bag-icon']");
        //click on Checkout
        reusables.reusableMethods.click(driver,"//*[text()='CHECKOUT']");



    }//end of test case1

    @Test(dependsOnMethods = "testCase1")
    public void testCase2() throws InterruptedException {
        //waiting for the checkout page to load
        Thread.sleep(2500);
        //select quantity to 2
       // WebElement element = driver.findElement(By.xpath("//*[@id='qdd-0-quantity']"));
       // Select dropDown = new Select(element);
        //select second quanity
       // dropDown.selectByIndex(1);
        //click on the quantity drop down
        reusables.reusableMethods.click(driver,"//*[@id='qdd-0-quantity']");
        //click on the quantity value
        reusables.reusableMethods.click(driver,"//*[@value='2']");


    }





}
