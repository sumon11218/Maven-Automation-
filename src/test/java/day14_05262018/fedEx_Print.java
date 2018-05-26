package day14_05262018;

import PageObjectModal.AbstractMethods;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * Created by Sumon.Kashem on 5/26/2018.
 */
public class fedEx_Print extends AbstractMethods {

    @Test
    public void fedExPrint() throws IOException, InterruptedException, AWTException {
        driver.navigate().to("https://www.fedex.com/en-us/home.html");
        //open printing service menu
        reusables.reusableMethods_Report.click(driver, "//*[@aria-label='Open Printing Services Menu']", logger, "Printing Menu Tab");
        //click on start online print order
        reusables.reusableMethods_Report.click(driver, "//*[text()='Start Online Printing Order']", logger, "Printing Order Link");
        //click on start order button
        reusables.reusableMethods_Report.click(driver, "//*[text()='Start Order']", logger, "Start Order Button");
        //cancel pop up
        reusables.reusableMethods_Report.click(driver, "//*[@shape='rect' and @alt='no']", logger, "Pop UP Box");
        //verify you are on right page FedEx Office Print Online
        //click on single sheet file
        reusables.reusableMethods_Report.click(driver, "//*[@title='Single Sheet File']", logger, "Single Sheet File Link");
        //click on Upload to file button
        reusables.reusableMethods_Report.click(driver, "//*[@name='upload-files-button']", logger, "Upload File Button");
        Thread.sleep(3000);
        //uploading a file
        reusables.reusableMethods_Report.upLoadFielWithRobot(driver,"C:\\Users\\sumon.kashem\\Desktop\\FedExImage.jpg",logger);
        //click on add to card
        reusables.reusableMethods_Report.click(driver,"//*[@name='update_quanity-addToCart-lbl']",logger,"Add To Cart Button");


    }

}
