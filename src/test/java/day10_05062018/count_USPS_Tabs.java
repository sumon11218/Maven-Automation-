package day10_05062018;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Sumon.Kashem on 5/6/2018.
 */
public class count_USPS_Tabs {

    @Test
    public void testScenario() throws InterruptedException {
        //open chrome driver
        WebDriver driver = reusables.reusableMethods.chromeDriver();
        //navigate to usps.com
        driver.navigate().to("https://www.usps.com");
        //wait few seconds
        Thread.sleep(2500);
        //get all the navigation tab counts
        List<WebElement> tabCount = driver.findElements(By.xpath("//*[@class='menuitem']"));
        System.out.println("tab count is " + tabCount.size());

        //iterate through each tab and get the name of the tab by printing
        for(int i=0;i<tabCount.size();i++){
            String getName = driver.findElements(By.xpath("//*[@class='menuitem']")).get(i).getText();
            System.out.println("my tab is " + getName);

        }//end of loop
    }//end of test method

}
