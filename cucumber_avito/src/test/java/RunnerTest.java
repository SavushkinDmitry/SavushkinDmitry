import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(monochrome = true, glue = { "steps" },
        plugin = {
                "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"
        },// Packagename
        features = { "src/test/java/features" } // FolderName
)
public class RunnerTest extends AbstractTestNGCucumberTests {

}
