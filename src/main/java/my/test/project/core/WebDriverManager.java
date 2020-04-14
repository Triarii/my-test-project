package my.test.project.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import static my.test.project.core.Config.*;

public class WebDriverManager {

    private WebDriver driver;
    private WebDriverWait driverWait;

    public void startWD() throws Throwable {
        this.driver = initDriver();
        this.driverWait = new WebDriverWait(driver, 5);
    }

    public void stopWD() {
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getWD() {
        if (driver == null) {
            throw new IllegalStateException("WebDriver не был проинициализирован");
        }
        return driver;
    }

    public WebDriverWait getWDWait() {
        if (driverWait == null) {
            throw new IllegalStateException("WebDriverWait не был проинициализирован");
        }
        return driverWait;
    }

    private WebDriver initDriver() throws Throwable {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(WD_BROWSER);
        capabilities.setVersion(WD_BROWSER_VERSION);
        capabilities.setCapability("screenResolution", WD_RESOLUTION);
        capabilities.setCapability("enableVNC", WD_GRID_VNC);
        capabilities.setCapability("name", WD_GRID_NAME);

        WebDriver wd;
        if (WD_LOCAL) {
            wd = new ChromeDriver();
        } else {
            wd = new RemoteWebDriver(URI.create(WD_GRID_HUB).toURL(), capabilities);
        }

        String[] screen = WD_RESOLUTION.split("x");
        wd.manage().window().setSize(new Dimension(Integer.parseInt(screen[0]), Integer.parseInt(screen[1])));

        wd.manage().timeouts().setScriptTimeout(50, TimeUnit.SECONDS);
        wd.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return wd;
    }
}
