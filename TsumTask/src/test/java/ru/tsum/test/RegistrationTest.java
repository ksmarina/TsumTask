package ru.tsum.test;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import ru.tsum.services.LoginGenerator;
import ru.tsum.steps.LoginSteps;
import ru.tsum.steps.RegistrationSteps;

import java.io.IOException;

@RunWith(SerenityRunner.class)
public class RegistrationTest {
    String newUserEmail;
    String newUserPwd = "qwerty123";
    String existUserEmail = "TestLogin1@mail.ru";

    @Steps
    RegistrationSteps registration;

    @Managed(driver = "chrome")
    WebDriver driver;

    @Before
    public void beforeTest() throws IOException {
        driver.manage().window().maximize();
        newUserEmail = LoginGenerator.getNewLogin();

        //GIVEN: go to registration page
        registration.openRegistrationPage();
    }

    @Test
    public void registerWithExistCredentials() {
        //WHEN: enter exist credentials
        registration.enterCredentials(existUserEmail, newUserPwd);

        //THEN: check error is displayed
        registration.checkErrorDisplayed();
    }

    @Test
    public void loginWithCorrectCredentials() {
        //WHEN: enter new credentials
        registration.enterCredentials(newUserEmail, newUserPwd);

        //THEN: check info message is displayed after registration
        registration.checkInfoMessageDisplayed();
    }
}
