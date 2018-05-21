package day13_05202018;

import PageObjectModal.AbstractMethods;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Sumon.Kashem on 5/20/2018.
 */
public class ExpressTest extends AbstractMethods {

    @Test
    public void expressCheckout() throws InterruptedException, IOException {
        //navigate to express.com
        logger.log(LogStatus.INFO,"Navigating to 'Express' url");
        driver.navigate().to("https://www.express.com");
        //hover over Women using reusable mouse action method
        reusables.reusableMethods_Report.mouseHover(driver,"//*[@href='/womens-clothing']",logger,"Women Tab");
        //hover over accessories
        reusables.reusableMethods_Report.mouseHover(driver,"//*[@class='subnav-target' and contains(@href,'/womens-clothing/accessories')]",logger,"Accessories Tab");
        //clicking on Jewelry
        reusables.reusableMethods_Report.click(driver,"//*[contains(@href,'/womens-clothing/accessories/jewelry/')]",logger,"Jewelry");
        //click on earrings
        reusables.reusableMethods_Report.click(driver,"//*[text()='Earrings']",logger,"Earrings Link");
        //assert that i'm on the right page
        String pageName = driver.getTitle();
        if(pageName.equalsIgnoreCase("Earrings for Women - Earring")){
            logger.log(LogStatus.PASS,"Page shows accurate title");
        } else {
            logger.log(LogStatus.FAIL,"Page title doesn't match.."+ pageName);
            reusables.reusableMethods_Report.getScreenshot(driver,logger);
        }
        //hover over first image on the selection
        reusables.reusableMethods_Report.mouseHover(driver,"//*[@class='active loaded']",logger,"First Image");
        //click on Express View
        reusables.reusableMethods_Report.click(driver,"//*[@class='express-view']",logger,"Express View Button");
        //click on Add to bag
        reusables.reusableMethods_Report.click(driver,"//*[text()='Add to Bag']",logger,"Add To Bag");
        //hover over Bag icon
        reusables.reusableMethods_Report.mouseHover(driver,"//*[@class='bag-icon']",logger,"Bag Icon");
        //click on Checkout
        reusables.reusableMethods_Report.click(driver,"//*[text()='CHECKOUT']",logger,"Checkout Button");

    }

    @Test(dependsOnMethods = "expressCheckout")
    public void addQuantity() throws IOException {
        //click on the quantity drop down
        reusables.reusableMethods_Report.click(driver,"//*[@id='qdd-0-quantity']",logger,"Quantity Dropdown");
        //click on the quantity value
        reusables.reusableMethods_Report.click(driver,"//*[@value='2']",logger,"Quantity Value");
    }

}
