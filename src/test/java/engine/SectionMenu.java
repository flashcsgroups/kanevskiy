package engine;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SectionMenu extends BaseShopForm{
    private static final String MAIN_LOCATOR = "//div[@id='Catalog']";
    private static final String title = "Main menu";
    public static final String menuItemLocator = MAIN_LOCATOR + "//span[@title='%s']";

    public SectionMenu() {
        super(MAIN_LOCATOR, title);
    }

    private String getFullMenuItemLocator(String menuName) {
        return String.format(menuItemLocator, menuName);
    }

    public void hoverOverMenu(String locator) {
        SelenideElement element = $(By.xpath(getFullMenuItemLocator(locator)));
        element.hover();
        element.click();
    }

}
