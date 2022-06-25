import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class AvitoStepTest {
    WebDriver driver;
    WebDriverWait wait;

    @Description("Инициализация драйвера, переход к сайта Avito")
    @Step("Подготовка к выполнению шагов")
    @BeforeClass
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://www.avito.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] captureScreenshot(Screenshot screenshot) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(screenshot.getImage(), "png", byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Attachment(value = "Результат вывода")
    public String saveStringResult(String res) {
        return res;
    }

    @Description("Поиск выпадающего списка категорий товара и выбор соответствующего значения")
    @Step("Выбор категории товаров")
    @Test(priority = 1)
    void selectCategory() {
        Select select = new Select(driver.findElement(By.cssSelector("#category")));
        select.selectByVisibleText("Оргтехника и расходники");

        Screenshot screen = new AShot().takeScreenshot(driver);
        captureScreenshot(screen);
    }

    @Description("Поиск поля ввода названия товаров и ввод соответвующего значения")
    @Step("Поиск товара")
    @Test(priority = 2)
    void searchProduct() {
        driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']")).sendKeys("Принтер");

        Screenshot screen = new AShot().takeScreenshot(driver);
        captureScreenshot(screen);
    }

    @Description("Поиск выпадающего списка с регионами")
    @Step("Список регионов")
    @Test(priority = 3)
    void selectRegion() {
        driver.findElement(By.xpath("//div[@data-marker='search-form/region']")).click();

        Screenshot screen = new AShot().takeScreenshot(driver);
        captureScreenshot(screen);
    }

    @Description("В полле ввода вписываем наименование региона и в выпадающем списке, выбираем самый первый вариант")
    @Step("Выбор региона из списка регионов")
    @Test(priority = 4)
    void searchRegion() {
        driver.findElement(By.xpath("//div/input[@data-marker='popup-location/region/input']")).sendKeys("Владивосток");
        WebElement searchRegion = driver.findElement(By.xpath("//li[@data-marker='suggest(0)']"));
        System.out.println(searchRegion.getText());

        Screenshot screen = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver);
        captureScreenshot(screen);

        wait.until(ExpectedConditions.visibilityOf(searchRegion));
        searchRegion.click();
        driver.findElement(By.xpath("//button[@data-marker='popup-location/save-button']")).click();
    }

    @Description("Поиск чекбокса")
    @Step("Товары с доставкой авито")
    @Test(priority = 5)
    void checkboxClick() {
        WebElement checkbox = driver.findElement(By.xpath("//input[@data-marker='delivery-filter/input']"));
        if (!checkbox.isSelected()) {
            checkbox.sendKeys(Keys.SPACE);
        }
        Screenshot screen = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver);
        captureScreenshot(screen);
        driver.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']")).click();
    }

    @Description("Поиск фильтра цен на товары и выбор соответствующего значения")
    @Step("Фильтрация по ценам")
    @Test(priority = 6)
    void selectFilter() {
        Select selectFilter = new Select(driver.findElement(By.xpath(
                "//div[contains(@class, 'index-content')]" +
                        "//select[contains(@class, 'select-select') and position()=1]")));
        selectFilter.selectByVisibleText("Дороже");

        Screenshot screen = new AShot().takeScreenshot(driver);
        captureScreenshot(screen);
    }

    @Description("Поиск дорогих товаров, сохранение найденных товаров и вывод первых трёх товаров в списке")
    @Step("Найти 3 самых дорогих товара")
    @Test(priority = 7)
    void searchAndSelectProduct() {
        By itemTitle = By.xpath(".//a[@data-marker='item-title']");
        By itemPrice = By.xpath(".//span[@data-marker='item-price']");

        List<WebElement> titleProduct = driver.findElements(itemTitle);
        List<WebElement> priceProduct = driver.findElements(itemPrice);

        for (int i = 0; i < 3; i++) {
            String result = "Наименование товара: " + titleProduct.get(i).getText() + "\n Цена товара: " + priceProduct.get(i).getText() + " (" + i + ")";
            System.out.println(result);
            saveStringResult(result);
        }

        Screenshot screen = new AShot().takeScreenshot(driver);
        captureScreenshot(screen);
    }

    @Description("После окончание шагов выходим из браузера")
    @Step("Выход из браузера")
    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
