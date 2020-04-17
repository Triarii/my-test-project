package my.test.project.core;

public class Config {
    public static final boolean WD_LOCAL = Boolean.parseBoolean(System.getProperty("config.selenium.local", "true"));
    public static final String WD_DRIVER_CHROME = System.getProperty("config.selenium.driver.chrome", "drivers/chromedriver");
    public static final String WD_BROWSER = System.getProperty("config.selenium.browser", "chrome");
    public static final String WD_BROWSER_VERSION = System.getProperty("config.selenium.browser.version", "");
    public static final String WD_RESOLUTION = System.getProperty("config.selenium.screen", "1920x1080x24");
    public static final boolean WD_GRID_VNC = Boolean.parseBoolean(System.getProperty("config.selenium.vnc", "true"));
    public static final String WD_GRID_NAME = System.getProperty("config.selenium.name", "default");
    public static final String WD_GRID_HUB = System.getProperty("config.selenium.hub", "http://localhost:4445/wd/hub");
    public static final int WD_SLEEP_EASY = Integer.parseInt(System.getProperty("config.selenium.sleep.easy", "5"));
    public static final int WD_SLEEP_MEDIUM = Integer.parseInt(System.getProperty("config.selenium.sleep.medium", "30"));
    public static final int WD_SLEEP_HARD = Integer.parseInt(System.getProperty("config.selenium.sleep.hard", "60"));
    public static final String TEST_USER_NAME = System.getProperty("config.test.user.name", "my-user-name");
    public static final String TEST_USER_PASSWORD = System.getProperty("config.test.user.password", "mypass");

    static {
        System.setProperty("webdriver.chrome.driver", WD_DRIVER_CHROME);
    }
}
