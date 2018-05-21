package day12_XmlSuite_05192018;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * Created by Sumon.Kashem on 5/19/2018.
 */
public class Parallel_Testing {
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;
    /*@BeforeSuite
    public void defineReport(){
        reports = new ExtentReports("C:\\Users\\sumon.kashem\\Pictures\\ExtentReport\\ExtentReport " + UUID.randomUUID() + ".html",true);
    }*/

    @AfterSuite
    public void closeReport(){
        reports.flush();
        reports.close();
    }

    @Parameters("browser")
    @BeforeMethod
    public void getMethod(Method method, String browser){
        reports = new ExtentReports("C:\\Users\\sumon.kashem\\Pictures\\ExtentReport\\ExtentReport " + UUID.randomUUID() + ".html",true);
        logger = reports.startTest(method.getName());
        if(browser.equalsIgnoreCase("firefox")){
            //defining the path for geckodriver
            System.setProperty("webdriver.gecko.driver","src\\main\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
            //maximize firefox
            driver.manage().window().maximize();
        } else if(browser.equalsIgnoreCase("chrome")){
            //defining the path for chrome driver
            System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");
            //define the chrome option
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized","incognito");
            driver = new ChromeDriver(options);
        }
    }

    @AfterMethod
    public void endTest(){
        //end the test
        reports.endTest(logger);
    }

    @Test(priority = 1)
    public void bingSearch() throws InterruptedException, IOException {
        //logger.
        logger.log(LogStatus.INFO,"Navigating to 'Bing'.com");
        driver.navigate().to("https:www.bing.com");
        Thread.sleep(2500);
        //click on image using click reusable method with logger & screenshot
        reusables.reusableMethods_Report.click(driver,"//*[@id='scpl']",logger,"Image");
    }

    @Test(priority = 2)
    public void BingLogin(){
        logger.log(LogStatus.INFO,"Navigating to 'Bing'.com");
        driver.navigate().to("https:www.bing.com");
    }


}// end of class
