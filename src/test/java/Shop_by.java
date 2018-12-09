import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class Shop_by {
    WebDriver driver;

    // Подключаюсь к интернету через раздачу вайфая от телефона. Оператор связи лайф 4G
    @BeforeClass
    public void initWebdriver() {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver123.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--kiosk");
        driver = new ChromeDriver(options);
    }

    @BeforeMethod
    public void startUp() {
        driver.get("https://shop.by/");
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

    @Test //Перейти к разделу "Компьютеры"
    public void Button() {

        WebElement button =
                driver.findElement(By.
                        xpath("//*[@id=\"cataloglink-944\"]"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        button.click();
        Assert.assertTrue(button.isDisplayed(), "computer button is not displayed");
    }


    @Test // и выбрать "Ноутбуки"
    public void Chek() {
        driver.get("https://shop.by/kompyutery/");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement button =
                driver.findElement(By.
                        xpath("//*[@id=\"cataloglink-846\"]/a/span"));
        button.click();

        Assert.assertTrue(button.isDisplayed(), "computer button is not displayed");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test // Задать параметры поиска:
    // - Производитель: Lenovo, Dell, HP
    // - Цена: от 700 руб. до 1500 руб.
    // - Размер экрана от 12 до 13.4 дюймов.
    // 5. Нажать кнопку Показать.
    public void Chek2() {
        driver.get("https://shop.by/noutbuki/");
        WebElement box =
                driver.findElement(By.
                        xpath("//*[@id=\"Attr_prof_1000\"]/div/div[1]/div/div[3]/a"));
        box.click();
        Assert.assertTrue(box.isDisplayed(), "box lenovo button is not displayed");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement box1 =
                driver.findElement(By.
                        xpath("//*[@id=\"Attr_prof_1000\"]/div/div[1]/div/div[5]/a/label"));
        box1.click();
        Assert.assertTrue(box1.isDisplayed(), "box Dell button is not displayed");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement box2 =
                driver.findElement(By.
                        xpath("//*[@id=\"Attr_prof_1000\"]/div/div[1]/div/div[4]/a/label"));
        box2.click();
        Assert.assertTrue(box2.isDisplayed(), "box HP button is not displayed");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement to_show =
                driver.findElement(By.
                        xpath("//*[@id=\"ModelFilter__NumModelWindow\"]/div[1]"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        to_show.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement page =
                driver.findElement(By.
                        xpath("//*[@id=\"Attr_prof_1000\"]/div"));
        Assert.assertTrue(page.isDisplayed(), "pick is not displayed");
    }

    @Test // 6. Определить количество элементов на странице.
    public void Chek3() {
        driver.get("https://shop.by/noutbuki/?data_mode=1&mode=find&essense_id=846&prof_1000=8991&prof_1000=1612&prof_1000=2023");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement amount_of_elements =
                driver.findElement(By.
                        xpath("/html/body/div[2]/div[1]/div/div[5]/div[2]/div[3]/div/div/div[1]/text()"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(amount_of_elements.isDisplayed(), "pick is not displayed");

    }

    @Test // 7. Отсортировать список по цене (по возрастанию).
    public void Chek4() {
        driver.get("https://shop.by/noutbuki/?data_mode=1&mode=find&essense_id=846&prof_1000=8991&prof_1000=1612&prof_1000=2023");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement price =
                driver.findElement(By.
                        xpath("//*[@id=\"selZDH_chzn\"]"));
        price.click();
        Assert.assertTrue(price.isDisplayed(), "price is not displayed");

        WebElement pricemin =
                driver.findElement(By.
                        xpath("//*[@id=\"selIF5_chzn_o_1\"]"));
        pricemin.click();
        Assert.assertTrue(pricemin.isDisplayed(), "price is not displayed");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}