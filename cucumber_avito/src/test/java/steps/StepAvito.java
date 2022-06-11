package steps;

import enums.PriceCategory;
import enums.ProductCategory;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import steps.page.Pages;

import java.time.Duration;
import java.util.List;

public class StepAvito {

    //@Step("Открывается ресурс авито")
    @Пусть("открыт ресурс авито")
    public void openResource() {
        Pages.driver.get("https://www.avito.ru/");
        WebDriverWait wait = new WebDriverWait(Pages.driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='app']")));

        Pages.saveScreen(Pages.driver);
    }

    @ParameterType(".*")
    public ProductCategory categoryProduct(String name) {
        return ProductCategory.valueOf(name);
    }

    //@Step("И в выпадающем списке категорий выбрана категория товаров")
    @И("в выпадающем списке категорий выбрана {categoryProduct}")
    public void selectCategory(ProductCategory categoryProduct) {
        Select sCategory = new Select(Pages.driver.findElement(By.cssSelector("#category")));
        sCategory.selectByVisibleText(categoryProduct.getName());

        Pages.saveScreen(Pages.driver);
    }

    //@Step("И в поле поиска введено наименование товара")
    @И("в поле поиска введено значение {word}")
    public void searchProduct(String nameProduct) {
        WebElement inputSearchProduct = Pages.driver.findElement(By.xpath("//input[@data-marker='search-form/suggest']"));
        inputSearchProduct.sendKeys(nameProduct);

        Pages.saveScreen(Pages.driver);
    }

    //@Step("И активирован чекбокс только с фотографией")
    @И("активирован чекбокс только с фотографией")
    public void checkboxWithPhoto() {
        WebElement checkbox = Pages.driver.findElement(By.xpath("//input[@data-marker='search-form/with-images']"));
        if (!checkbox.isSelected()) {
            checkbox.sendKeys(Keys.SPACE);
        }

        Pages.saveScreen(Pages.driver);
    }

    //@Step("Тогад нужно кликнуть по выпадающему списку региона")
    @Тогда("кликнуть по выпадающему списку региона")
    public void clickListRegion() {
        Pages.driver.findElement(By.xpath("//div[@data-marker='search-form/region']")).click();

        Pages.saveScreen(Pages.driver);
    }

    //@Step("Тогда в поле регион нужно ввести название региона")
    @Тогда("в поле регион введено значение {word}")
    public void searchRegion(String nameRegion) {
        WebElement inputSearchRegion =  Pages.driver.findElement(By.xpath("//div/input[@data-marker='popup-location/region/input']"));
        inputSearchRegion.sendKeys(nameRegion);

        Pages.saveScreen(Pages.driver);

        WebDriverWait wait = new WebDriverWait(Pages.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-marker='suggest(0)']"))).click();
    }

    //@Step("И нужно нажать кнопку показать объявление")
    @И("нажата кнопка показать объявления")
    public void clickAds() {
        Pages.driver.findElement(By.xpath("//button[@data-marker='popup-location/save-button']")).click();

        Pages.saveScreen(Pages.driver);
    }

    //@Step("Тогда открылась страница результата по запросу")
    @Тогда("открылась страница результата по запросу {word}")
    public void checkVerifyPage(String namePage) {
        WebElement resultRequest = Pages.driver.findElement(By.xpath("//h1[@data-marker='page-title/text']"));
        Assert.assertEquals(resultRequest.getText(), "Объявления по запросу «" + namePage + "» во Владивостоке");

        Pages.saveScreen(Pages.driver);
    }

    @ParameterType(".*")
    public PriceCategory priceCategory(String name) {
        return PriceCategory.valueOf(name);
    }

    //@Step("И в выпадающем списке сортировки по ценам выбрать категорию")
    @И("в выпадающем списке сортировка выбрано значение {priceCategory}")
    public void selectPriceCategory(PriceCategory priceCategory) {
        Select selectCPrice = new Select(Pages.driver.findElement(By.xpath("//div[contains(@class, 'index-content')]//select[contains(@class, 'select-select') and position()=1]")));
        selectCPrice.selectByVisibleText(priceCategory.getName());

        Pages.saveScreen(Pages.driver);
    }

    //@Step("И в консоль вывести наименование и цену выбранных товаров")
    @И("в консоль выведено значение названия и цены {int} первых товаров")
    public void searchAndSelectProduct(int count) {
        By itemTitle = By.xpath(".//a[@data-marker='item-title']");
        By itemPrice = By.xpath(".//span[@data-marker='item-price']");

        List<WebElement> titleProduct = Pages.driver.findElements(itemTitle);
        List<WebElement> priceProduct = Pages.driver.findElements(itemPrice);

        for (int i = 0; i < count; i++) {
            String result = "Наименование товара: " + titleProduct.get(i).getText() +
                    "\n Цена товара: " + priceProduct.get(i).getText() + " (" + i + ").";
            System.out.println(Pages.saveStringResult(result));
        }
        Pages.saveScreen(Pages.driver);
    }

}
