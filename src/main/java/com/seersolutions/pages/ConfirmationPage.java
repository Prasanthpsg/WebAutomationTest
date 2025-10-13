package com.seersolutions.pages;

import com.seersolutions.basetest.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ConfirmationPage  {

    private WebDriver driver;

    @FindBy(className = "complete-header")
    WebElement confirmationMessage;

    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyOrderMessage(String expectedmessage) {
        Assert.assertEquals(confirmationMessage.getText().trim(), expectedmessage);
    }
}
