package engine;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

class FilterMenu extends BaseShopForm {
    private static final String MAIN_LOCATOR = "//div[@class='ModelFilter__ParamBlock']";
    private static final String title = "filter";
    private static final String menuItemLocator = MAIN_LOCATOR + "//a//label[text()='%s']";
    private static final String filterMinValueLocator = MAIN_LOCATOR + "//input[@id='minnum_45']";
    private static final String filterMaxValueLocator = MAIN_LOCATOR + "//input[@id='maxnum_45']";
    private static final String showResultsButtonLocator = "//div[@id='ModelFilter__NumModelWindow']//div[@data-ga='podbor']";
    public static final String btnExtendManufacturersLocator = MAIN_LOCATOR + "//span[@data-idgroup='prof_1000']";
    public static final String btnExtendScreenSizesLocator = MAIN_LOCATOR + "//span[@data-idgroup='prof_5828']";

    FilterMenu() {
        super(MAIN_LOCATOR, title);
    }



    private String getFullMenuItemLocator(String menuName) {
        return String.format(menuItemLocator, menuName);
    }

    void setFilter(String locator) {
        SelenideElement element = $(By.xpath(getFullMenuItemLocator(locator)));
        element.hover();
        element.click();
    }

    void setfilterMinPrice(String minPrice) {
        SelenideElement filterMinPrice = $(By.xpath(filterMinValueLocator));
        filterMinPrice.setValue(minPrice);
    }

    void setfilterMaxPrice(String maxPrice) {
        SelenideElement filterMaxPrice = $(By.xpath(filterMaxValueLocator));
        filterMaxPrice.setValue(maxPrice);
    }

    void showResultsButtonClick() {
        SelenideElement btnShowResults = $(By.xpath(showResultsButtonLocator));
        btnShowResults.click();
    }

    void extendManufacturersList() {
        SelenideElement btnExtendManufacturers = $(By.xpath(btnExtendManufacturersLocator));
        btnExtendManufacturers.click();
    }

    void extendScreenSizesList() {
        SelenideElement btnExtendScreenSizes = $(By.xpath(btnExtendScreenSizesLocator));
        btnExtendScreenSizes.click();
    }

}