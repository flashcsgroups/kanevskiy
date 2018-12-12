package engine;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Utils {

    public static void browserMaximize() {
        getWebDriver().manage().window().maximize();
    }
}
