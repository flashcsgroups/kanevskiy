package engine;

public class MainShopForm extends BaseShopForm {

    private static final String MAIN_LOCATOR = "//div[@id='Header__Authentication']";
    private static final String title = "main shop.by page";

    public MainShopForm() {
        super(MAIN_LOCATOR, title);

    }

    SectionMenu sectionMenu = new SectionMenu();

    public void selectMenuItem(String menuItem) {
        sectionMenu.hoverOverMenu(menuItem);
    }

}
