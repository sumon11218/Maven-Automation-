package day9_testNG;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import reusables.reusableMethods;

import javax.swing.text.Utilities;

/**
 * Created by Sumon.Kashem on 5/5/2018.
 */
public class google_testNG {
     WebDriver driver;
     SoftAssert softAssert;
    @BeforeMethod
    public void openBrowser(){
        //define the chrome driver using reusable method
        driver = reusables.reusableMethods.chromeDriver();
    }

    @Test(priority = 1)
    public void testScenario(){
        softAssert = new SoftAssert();
        //navigate to google
        driver.navigate().to("https://www.google.com");
        //verify i'm on the right page by using assertion assertEquals()
        Assert.assertEquals("Gooooogle",driver.getTitle(),"should display title");
        //let's verify if the google image is displayed or not using assertTrue();
        softAssert.assertTrue(driver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed(),"Logo Should Appear");
        //entering name on search field
        reusables.reusableMethods.EnterSomething(driver,"//*[@name='q']","Brooklyn");
        //click on somewhere outside of the page to minimized the search dropdown
        reusables.reusableMethods.click(driver,"//*[@id='body']");
        //click on google search
        reusableMethods.click(driver,"//*[@type='submit']");
    }

    @AfterMethod
    public void closeBrowser(){
        //quitting the driver
        driver.quit();
        softAssert.assertAll();
    }


}//end of class
