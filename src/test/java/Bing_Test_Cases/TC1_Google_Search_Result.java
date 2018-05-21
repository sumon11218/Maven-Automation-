package Bing_Test_Cases;

import PageObjectModal.AbstractMethods;
import org.testng.annotations.Test;

import java.io.IOException;

import static PageObjectModal.Bing.Bing_Homepage.bingSearchButton;
import static PageObjectModal.Bing.Bing_Homepage.bingSearchField;

/**
 * Created by Sumon.Kashem on 5/20/2018.
 */
public class TC1_Google_Search_Result extends AbstractMethods{
    @Test
    public void GoogleSearchResult() throws IOException {
        driver.navigate().to("https://www.bing.com");
        bingSearchField("Brooklyn");
        bingSearchButton();

    }



}
