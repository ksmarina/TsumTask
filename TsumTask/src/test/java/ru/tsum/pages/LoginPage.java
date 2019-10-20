package ru.tsum.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.tsum.ru/login/")
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".login-input")
    WebElement emailField;

    @FindBy(css = ".pwd-input")
    WebElement passwordField;

    @FindBy(css = "a.header__link.ng-star-inserted")
    WebElement userEmailLink;

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public String userEmailLink(){
        return userEmailLink.getText();
    }
}
