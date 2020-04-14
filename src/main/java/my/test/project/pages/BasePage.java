package my.test.project.pages;

import my.test.project.core.WebDriverManager;

public class BasePage {
    protected WebDriverManager wdm;
    public BasePage(WebDriverManager wdm) {
        this.wdm = wdm;
    }
}
