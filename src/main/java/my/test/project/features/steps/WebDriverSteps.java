package my.test.project.features.steps;

import my.test.project.core.WebDriverManager;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class WebDriverSteps {
    private final WebDriverManager wdm;

    public WebDriverSteps(WebDriverManager wdm) {
        this.wdm = wdm;
    }

    @Given("Запуск браузера")
    public void webDriverInit() throws Throwable {
        wdm.startWD();
    }

    @After
    public void screenOnFail(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) wdm.getWD()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }

    @After
    public void webDriverTearDown() {
        wdm.stopWD();
    }
}
