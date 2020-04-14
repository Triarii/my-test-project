package my.test.project.pages;

import my.test.project.core.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.CoreMatchers.containsString;

public class MailPage extends BasePage {
    private final static By loginButton = By.xpath("//a//*[contains(text(),'Войти')]/..");
    private final static By headerElement = By.xpath("//h1[contains(@class,'mail-Logo')]");
    private final static By headerUserNameElement = By.xpath("//*[@class='mail-User-Name']");

    public MailPage(WebDriverManager wdm) {
        super(wdm);
    }

    public void open() {
        wdm.getWD().get("https://mail.yandex.ru/");
    }

    public void login() {
        wdm.getWDWait().until(ExpectedConditions.elementToBeClickable(loginButton));
        wdm.getWD().findElement(loginButton).click();
    }

    public void isMailPageCheck() {
        wdm.getWD().findElement(headerElement);
        Assert.assertThat("Проверка страницы по тайтлу",
                wdm.getWD().getTitle(),
                containsString("Яндекс.Почта"));
    }

    public String getHeaderUserName() {
        return wdm.getWD().findElement(headerUserNameElement).getText();
    }
}
