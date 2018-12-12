package engine;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

class BaseShopForm {

    BaseShopForm(final String locator, final String title) {
        try {
            SelenideElement element = $(By.xpath(locator));
        } catch (ElementNotFound elementNotFound) {
            System.out.println("Page " + title + " not found. Test failed");
        }
    }
}
