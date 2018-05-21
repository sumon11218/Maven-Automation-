package day11_05122018;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Sumon.Kashem on 5/12/2018.
 */
public class ExtentReport_TestNG {
    WebDriver driver;
    ExtentReports report;
    ExtentTest logger;
    @BeforeSuite
    public void openDriver(){
        driver = reusables.reusableMethods.chromeDriver();
        //define the path of the Extent Report
        report = new ExtentReports("C:\\Users\\sumon.kashem\\Pictures\\ExtentReport\\ExtentReport.html",true);

    }
    @AfterSuite
    public void closeDriver(){
        //driver.quit();
        //line below will flush the report by adding all your log informations to the report
        report.flush();
        //line below will close & end your report
        report.close();
    }

    @Test
    public void testScenario() throws InterruptedException, IOException {
        //log test name using logger
        logger = report.startTest("Google Search");

        //navigate to google.com
        logger.log(LogStatus.INFO,"navigating to Google.com");
        driver.navigate().to("https://www.google.com");

        //wait few seconds for the page to load
        logger.log(LogStatus.INFO,"Waiting on google page to load");
        Thread.sleep(2500);

        //assert that title page is google
        logger.log(LogStatus.INFO,"Verify The title of the page is Google");
        //Assert.assertEquals("Google",driver.getTitle());
        //to use assertions with Extent report we should first store the getTitle as a variable
        String actualTitle = driver.getTitle();
        if(actualTitle.equalsIgnoreCase("gooogle")){
            logger.log(LogStatus.PASS,"Title of page is Google");
        } else {
            logger.log(LogStatus.FAIL,"Title of page is in not Google "+ actualTitle);
           //define the path of the image
            String ImagePath = "C:\\Users\\sumon.kashem\\Pictures\\ExtentReport\\googleTitle.png";
            //line below allows you to take screenshot(don't need to memorize the command)
            File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //Now you can do whatever you need to do with, for example copy somewhere
            FileUtils.copyFile(sourceFile, new File(ImagePath));
            String image = logger.addScreenCapture(ImagePath);
            logger.log(LogStatus.FAIL, "Verify Google Title", image);

        }

        //end the test
        report.endTest(logger);
    }





}
