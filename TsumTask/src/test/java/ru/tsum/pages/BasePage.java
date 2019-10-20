package ru.tsum.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage extends PageObject {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".geo-popup")
    WebElement geoPopUp;

    @FindBy(css = ".geo-popup__close-icon")
    WebElement popUpCloseBtn;

    @FindBy(css = "button[type=\"submit\"]")
    WebElement confirmBtn;

    @FindBy(css = ".notice.error")
    WebElement errorMsg;

    public void submit() {
        confirmBtn.click();
    }

    public boolean isErrorDisplayed() {
        return errorMsg.isDisplayed();
    }

    public boolean isGeoDisplayed() {
        return geoPopUp.isDisplayed();
    }

    public void closeGeo() {
        if (isGeoDisplayed()) {
            popUpCloseBtn.click();
        }
    }
}
