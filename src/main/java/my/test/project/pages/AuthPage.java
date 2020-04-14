package my.test.project.pages;

import io.qameta.allure.Step;
import my.test.project.core.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;

public class AuthPage extends BasePage {
    private final static By loginInput = By.id("passp-field-login");
    private final static By passwordInput = By.id("passp-field-passwd");
    private final static By loginButton = By.xpath("//button//*[contains(text(),'Войти')]/..");

    public AuthPage(WebDriverManager wdm) {
        super(wdm);
    }

    public void isAuthPageCheck() {
        Assert.assertEquals("Проверка страницы по тайтлу", "Авторизация", wdm.getWD().getTitle());
    }

    public void login(String login, String password) {
        wdm.getWD().findElement(loginInput).sendKeys(login);
        wdm.getWD().findElement(loginButton).click();
        wdm.getWD().findElement(passwordInput).sendKeys(password);
        wdm.getWD().findElement(loginButton).click();
    }
}
