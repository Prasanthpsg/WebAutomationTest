package com.seersolutions.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
    private WebDriver driver;

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(xpath = "//input[@value='CONTINUE']")
    WebElement continueBtn;

    @FindBy(xpath = "//a[text()='FINISH']")
    WebElement finishBtn;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillDetailsAndFinish() {
        firstName.sendKeys("Test firstname");
        lastName.sendKeys("Test lastname");
        postalCode.sendKeys("638503");
        continueBtn.click();
        finishBtn.click();
    }
}
