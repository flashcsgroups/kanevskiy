
import org.junit.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriverService;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.open;

import static com.codeborne.selenide.Selenide.screenshot;





public class GoogleSearchTest {

    private static final String CHROME_BINARY = "DRIVER/GoogleChromePortable.exe";
    private static final String PATH_TO_CHROMEDRIVER_EXE ="DRIVER/chromedriver.exe";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", PATH_TO_CHROMEDRIVER_EXE);
        Configuration.browser = "chrome";
        Configuration.timeout = 5000;
        ChromeOptions options = new ChromeOptions();
        options.setBinary(CHROME_BINARY);

        WebDriverRunner.setWebDriver(new ChromeDriver(ChromeDriverService.createDefaultService(),options));
    }

    private Logger logger = LoggerFactory.getLogger(GoogleSearchTest.class);
    @Test
    public void testGoogleSearch(){

        open("http://google.com/ncr");
        screenshot("open");
        search("selenium");
        screenshot("selenium");
        assertTextOnPage("https://www.seleniumhq.org/");
        $(byXpath("//g-header-menu/a")).click();
        $(".f9UGee q qs AchQod").click();



    }


    private static void search(String searchText) {
        $(By.name("q")).setValue(searchText).pressEnter();
    }
    public void assertTextOnPage(String text){ $(".iUh30").shouldHave(text(text));     }




    @After
    public void tearDown() {
        WebDriverRunner.getWebDriver().close();
        WebDriverRunner.getWebDriver().quit();
    }
}
