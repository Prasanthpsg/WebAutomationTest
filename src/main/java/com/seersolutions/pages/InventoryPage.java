package com.seersolutions.pages;

import com.seersolutions.basetest.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class InventoryPage {


    private WebDriver driver;

    @FindBy(xpath = "(//div[@class='pricebar']//button)[1]")
    WebElement firstProduct;

    @FindBy(xpath = "(//div[@class='pricebar']//button)[2]")
    WebElement secondProduct;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    @FindBy(xpath = "(//div[@class='inventory_item_label']//a/div)[2]")
    WebElement inventoryTitle2;

    @FindBy(xpath = "(//div[@class='inventory_item_label']//a/div)[1]")
    WebElement inventoryTitle1;


    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addFirstTwoProducts() {
        firstProduct.click();
        secondProduct.click();
    }

    public void goToCart() {
        cartIcon.click();
    }

    public List<String> getInventoryDetails(){
        List<String> inventory =  new ArrayList<>();
        inventory.add(inventoryTitle1.getText().trim());
        inventory.add(inventoryTitle2.getText().trim());
        return inventory;
    }
}
