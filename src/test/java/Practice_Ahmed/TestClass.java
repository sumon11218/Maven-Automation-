package Practice_Ahmed;

import com.relevantcodes.extentreports.LogStatus;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Sumon.Kashem on 5/8/2018.
 */
public class TestClass extends AbstractClass{

    //(priority = 1)
    @Test
    public static void TrackTrace() throws IOException, BiffException, InterruptedException, WriteException {
        //line below will declare that test will be used in this extent report
        test = report.startTest("Track & Trace Test", "Corporate Website Sales");
        test.log(LogStatus.INFO, "Checking functionality for Track and Trace Page");

        //driver.navigate().to("http://atlassalesqa.wpengine.com/");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //Thread.sleep(3000);

        try {
            test.log(LogStatus.INFO, "Navigating to Corporate Website Sales Page");
            driver.navigate().to("http://atlassalesqa.wpengine.com/");

        } catch (Exception err) {
            test.log(LogStatus.FAIL, "Unable to navigate to Corporate Website Sales Page - " + err.getMessage());
            reusables.reusableLibrary.getScreenshot(driver, test, "src\\main\\java\\ExtentReport\\", "NavigationError");

        }

        try {
            test.log(LogStatus.INFO, "Inputting Tracking data in the first field");
            reusables.reusableLibrary.elementSendKeys(driver,"//*[@name='trackNum1']","123",report,test,"Input Tracking");
            //driver.findElement(By.name("trackNum1")).sendKeys("123");

        } catch (Exception err) {
            test.log(LogStatus.FAIL, "Unable to input Tracking data in the first field - " + err.getMessage());
            reusables.reusableLibrary.getScreenshot(driver, test, "src\\main\\java\\ExtentReport\\", "Input1Error");

        }

        try {
            test.log(LogStatus.INFO, "Inputting Tracking data in the second field");
            driver.findElement(By.name("trackNum2")).sendKeys("39423171");

        } catch (Exception err) {
            test.log(LogStatus.FAIL, "Unable to input Tracking data in the second field - " + err.getMessage());
            reusables.reusableLibrary.getScreenshot(driver, test, "src\\main\\java\\ExtentReport\\", "Input2Error");

        }

        try {
            test.log(LogStatus.INFO, "Clicking on the arrow icon");
            driver.findElement(By.className("btn btn-default")).click();

        } catch (Exception err) {
            test.log(LogStatus.FAIL, "Unable to click on the arrow icon - " + err.getMessage());
            reusables.reusableLibrary.getScreenshot(driver, test, "src\\main\\java\\ExtentReport\\", "ClickError");

        }

    }
}
