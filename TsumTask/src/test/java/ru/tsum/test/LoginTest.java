package ru.tsum.test;

import net.serenitybdd.junit.runners.SerenityRunner;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import ru.tsum.steps.LoginSteps;

import java.io.IOException;

@RunWith(SerenityRunner.class)
public class LoginTest {
    String correctUserEmail = "TestLogin1@mail.ru";
    String correctUserPwd = "qwerty123";
    String incorrectUserEmail = "testmail123@mail.ru";
    String incorrectUserPwd = "123";

    @Steps
    LoginSteps login;

    @Managed(driver = "chrome")
    WebDriver driver;

    @Before
    public void beforeTest() {
        driver.manage().window().maximize();

        //GIVEN: go to login page
        login.openLoginPage();
    }

    @Test
    public void loginWithIncorrectCredentials() {
        //WHEN: enter incorrect credentials
        login.enterCredentials(incorrectUserEmail, incorrectUserPwd);

        //THEN: check error is displayed
        login.checkErrorDisplayed();
    }

    @Test
    public void loginWithCorrectCredentials() {
        //WHEN: enter correct credentials
        login.enterCredentials(correctUserEmail, correctUserPwd);

        //THEN: check user email is displayed after login
        login.checkUserEmailAfterLogin(correctUserEmail);
    }
}
