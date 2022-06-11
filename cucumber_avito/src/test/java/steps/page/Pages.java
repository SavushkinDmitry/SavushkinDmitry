package steps.page;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.Duration;

public class Pages {

    public static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] captureScreenshot(Screenshot screenshot) {
        //Создаём объект в котором будут записаны данные в массив байтов
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            //Записываем скриншот, указываем формат и куда будет записываться наш скриншот
            // (в начало текущего указателя потока)
            ImageIO.write(screenshot.getImage(), "png", byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //С помощью toByteArray получаем данные
        return byteArrayOutputStream.toByteArray();
    }

    public static void saveScreen(WebDriver driver) {
        Screenshot screen = new AShot().takeScreenshot(driver);
        captureScreenshot(screen);
    }

    @Attachment(value = "Результат вывода в консоль")
    public static String saveStringResult(String result) {
        return result;
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
