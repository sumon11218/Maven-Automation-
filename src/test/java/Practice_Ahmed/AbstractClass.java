package Practice_Ahmed;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

/**
 * Created by Sumon.Kashem on 5/8/2018.
 */
public class AbstractClass {

    public static WebDriver driver;
    public static ExtentReports report;
    public static ExtentTest test;
    public static String reportPath = null;

    @BeforeSuite
    public static void openBrowser() throws InterruptedException, IOException {
        reportPath = "src\\main\\java\\ExtentReport\\extentReport.html";
        report = new ExtentReports(reportPath, true);
        //command below is used to set the chrome driver path for webdriver.
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        //Chrome options is a built in selenium command with java which allows you to pass additional
        //arguments before defining the driver.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //line below define the type of driver you are using by calling Web.
        driver = new ChromeDriver(options);
        //driver.navigate().to("http://atlassalesqa.wpengine.com/");
        //Thread.sleep(3000);
    }

    @AfterSuite
    public static void closeBrowser() {
        //to end extent test you need to call the command below
        report.endTest(test);
        //line below will flush the report
        report.flush();
        //line below will close the report
        //report.close();

        //line below will open the report
        driver.get("C:\\Users\\sumon.kashem\\Desktop\\Maven_Selenium_Automation\\" + reportPath);

        //line below will close the report
        //report.close();

        // driver.quit();
    }




}
