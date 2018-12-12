package engine;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NotebookForm extends BaseShopForm implements ResultsGrabber {
    private static final String MAIN_LOCATOR = "//div[@id='Header__Authentication']";
    private static final String title = "notebook page";
    private static final String resultsLocator = "//div[@class='ModelList']//div[@class='ModelList__ModelBlockRow']";
    private static final String itemNameLocator = "//span[@itemprop='name']";
    private static final String itemPriceLocator = "//span[@class='PriceBlock__PriceValue'][1]//span";
    private static final String sortMenuLocator = "//div[@class='PanelSetUp__SortBlock']//span[contains(@id, '_chzn')]";
    private static final String sortLowPriceHighPriceLocator = "//li[contains(.,'цене (с дорогих)')]";
    private static final String sortHighPriceLowPriceLocator = "//li[contains(.,'цене (с дешевых)')]";
    private static final String paginatorsLocator = "//a[@class='Paging__PageLink ']";


    public NotebookForm() {
        super(MAIN_LOCATOR, title);

    }

    private FilterMenu filterMenu = new FilterMenu();

    public void setFilterForNotebookPage(String menuItem) {
        filterMenu.setFilter(menuItem);
    }

    public void setMinPriceNotebookPage(String minPrice) {
        filterMenu.setfilterMinPrice(minPrice);
    }

    public void setMaxPriceNotebookPage(String maxPrice) {
        filterMenu.setfilterMaxPrice(maxPrice);
    }

    public void clickShowResultsButton() {
        filterMenu.showResultsButtonClick();
    }

    public void clickToExtendManufacturers() {
        filterMenu.extendManufacturersList();
    }

    public void clickToExtendScreenSizes() {
        filterMenu.extendScreenSizesList();
    }

    private List<String> getResultsNames() {
        List<String> resultNames = new ArrayList<>();
        List<SelenideElement> resultNamesElements;
        resultNamesElements = $$(By.xpath(resultsLocator + itemNameLocator));
        for (int i = 0; i <= resultNamesElements.size() - 1; i++) {
            resultNames.add(resultNamesElements.get(i).getText());
        }
        return resultNames;
    }

    private List<String> getResultsPrices() {
        List<String> resultPrices = new ArrayList<>();
        List<SelenideElement> resultPricesElements;
        resultPricesElements = $$(By.xpath(resultsLocator + itemPriceLocator));
        for (int i = 0; i < resultPricesElements.size(); i++) {
            resultPrices.add(resultPricesElements.get(i).getText());
        }
        return resultPrices;
    }


    @Override
    public List<SelenideElement> getResultsList() {
        return $$(By.xpath(resultsLocator));
    }

    @Override
    public void getItemFromList(int position) {

    }

    @Override
    public List<Item> serializeItems(List<SelenideElement> searchResults) {
        List<String> names = getResultsNames();
        List<String> prices = getResultsPrices();
        List<Item> resultItemList = new ArrayList<>();
        for (int i = 0; i < searchResults.size(); i++) {
            resultItemList.add(
                    new Item(
                            names.get(i),
                            prices.get(i)
                    )
            );
        }
        return resultItemList;
    }

    public void openSortMenu() {
        $(By.xpath(sortMenuLocator)).click();
    }

    public void sortLowPriceHighPrice() {
        $(By.xpath(sortHighPriceLowPriceLocator)).click();
    }

    public void sortHighPriceLowPrice() {
        $(By.xpath(sortLowPriceHighPriceLocator)).click();
    }

    public SelenideElement getLastPagePagination() {
        List<SelenideElement> paginators = $$(By.xpath(paginatorsLocator));
        return paginators.get(paginators.size()-1);
    }

}
