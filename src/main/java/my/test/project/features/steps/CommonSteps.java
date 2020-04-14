package my.test.project.features.steps;

import io.cucumber.java.en.And;
import my.test.project.core.WebDriverManager;
import my.test.project.pages.AuthPage;
import my.test.project.pages.MailPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static my.test.project.core.Config.TEST_USER_NAME;
import static my.test.project.core.Config.TEST_USER_PASSWORD;
import static org.junit.Assert.assertEquals;

public class CommonSteps {
    private final WebDriverManager wdm;
    private final AuthPage authPage;
    private final MailPage mailPage;

    public CommonSteps(WebDriverManager wdm, AuthPage authPage, MailPage mailPage) {
        this.wdm = wdm;
        this.authPage = authPage;
        this.mailPage = mailPage;
    }

    @When("Открыли сайт почты")
    public void openYaMailPage() {
        mailPage.open();
    }

    @And("Нажали войти")
    public void login() {
        mailPage.login();
    }

    @Then("Получаем страницу с формой логина")
    public void isAuthPage() {
        authPage.isAuthPageCheck();
    }

    @When("Авторизуемся")
    public void setLogin() {
        authPage.login(TEST_USER_NAME, TEST_USER_PASSWORD);
    }

    @Then("Получаем нашу страницу почты")
    public void isLoginSuccess() {
        mailPage.isMailPageCheck();
        assertEquals("Ожидаемый пользователь в шапке страницы", mailPage.getHeaderUserName(), TEST_USER_NAME);
    }
}
