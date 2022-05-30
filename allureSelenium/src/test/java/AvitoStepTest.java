import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;

import java.time.Duration;
import java.util.List;

public class AvitoStepTest {
    WebDriver driver;
    AShot shot;

    @Attachment(value = "Attachment Screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    @Step("Подготовка драйвера и переход в сайту avito")
    @BeforeClass
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://www.avito.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        shot = new AShot();
    }

    @AfterMethod
    void screenStep() {
        makeScreenshot();
    }

    @Step("Выбор категории")
    @Test(priority = 1)
    void selectCategory() {
        Select select = new Select(driver.findElement(By.cssSelector("#category")));
        select.selectByVisibleText("Оргтехника и расходники");
        shot.takeScreenshot(driver);
    }

    @Step("Поиск продукта")
    @Test(priority = 2)
    void searchProduct() {
        driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']")).sendKeys("Принтер");
        shot.takeScreenshot(driver);
    }

    @Step("Выбор региона")
    @Test(priority = 3)
    void selectRegion() {
        driver.findElement(By.xpath("//div[@data-marker='search-form/region']")).click();
        driver.findElement(By.xpath("//div/input[@data-marker='popup-location/region/input']")).sendKeys("Владивосток");
        shot.takeScreenshot(driver);
    }

    @Step("Поиск объявлении по выбранному региону")
    @Test(priority = 4)
    void searchRegion() {
        WebElement searchRegion = driver.findElement(By.xpath("//li[@data-marker='suggest(0)']"));
        System.out.println(searchRegion.getText());
        searchRegion.click();
        driver.findElement(By.xpath("//button[@data-marker='popup-location/save-button']")).click();
        shot.takeScreenshot(driver, searchRegion);
    }

    @Step("Поиск чекбокса и нажатие по нему")
    @Test(priority = 5)
    void checkboxClick() {
        WebElement checkbox = driver.findElement(By.xpath("//input[@data-marker='delivery-filter/input']"));
        if (!checkbox.isSelected()) {
            checkbox.sendKeys(Keys.SPACE);
        }
        driver.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']")).click();
        shot.takeScreenshot(driver, checkbox);
    }

    @Step("Поиск фильтра и выбор значения")
    @Test(priority = 6)
    void selectFilter() {
        Select selectFilter = new Select(driver.findElement(By.xpath(
                "//div[contains(@class, 'index-content')]" +
                        "//select[contains(@class, 'select-select') and position()=1]")));
        selectFilter.selectByVisibleText("Дороже");
    }

    @Step("Сохранение найденных продуктов и вывод первых трёх")
    @Test(priority = 7)
    void searchAndSelectProduct() {
        List<WebElement> selectProduct = driver.findElements(By.xpath("//div[@data-marker='catalog-serp']" +
                "/div[@data-marker='item']"));

        //Итерируемся по элементам в List
        for (int i = 0; i < 3; i++) {
            System.out.println(selectProduct.get(i).findElement(By.xpath(".//a[@data-marker='item-title']")).getText());
            System.out.println(selectProduct.get(i).findElement(By.xpath(".//span[@data-marker='item-price']")).getText());
        }
    }



    @Step("Выход из драйвера")
    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
