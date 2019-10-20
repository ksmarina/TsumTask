package ru.tsum.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import ru.tsum.pages.RegistrationPage;

public class RegistrationSteps {

    RegistrationPage registrationPage;

    @Step
    public void openRegistrationPage() {
        registrationPage.open();
        registrationPage.closeGeo();
    }

    @Step
    public void enterCredentials(String email, String password) {
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(password);
        registrationPage.submit();
    }

    @Step
    public void checkErrorDisplayed() {
        Assert.assertTrue(registrationPage.isErrorDisplayed());
    }

    @Step
    public void checkInfoMessageDisplayed() {
        Assert.assertTrue(registrationPage.isInfoMsgDisplayed());
    }
}
