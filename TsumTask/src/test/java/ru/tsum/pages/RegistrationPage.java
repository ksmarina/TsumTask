package ru.tsum.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.tsum.ru/registration/")
public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".notice.info")
    WebElement infoMsg;

    @FindBy(css = "input[type=\"email\"].ui-input")
    WebElement emailField;

    @FindBy(css = "input[type=\"password\"]")
    WebElement passwordField;

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public boolean isInfoMsgDisplayed() {
        waitFor(infoMsg);
        return infoMsg.isDisplayed();
    }
}
