package ru.tsum.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import ru.tsum.pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage;

    @Step
    public void openLoginPage() {
        loginPage.open();
        loginPage.closeGeo();
    }

    @Step
    public void enterCredentials(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.submit();
    }

    @Step
    public void checkErrorDisplayed() {
        Assert.assertTrue(loginPage.isErrorDisplayed());
    }

    @Step
    public void checkUserEmailAfterLogin(String userEmail) {
        Assert.assertTrue(loginPage.userEmailLink().contains(userEmail));
    }
}
