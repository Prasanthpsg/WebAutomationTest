package com.seersolutions.pages;

import com.seersolutions.basetest.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

    private WebDriver driver;

    @FindBy(className = "inventory_item_name")
    List<WebElement> cartItems;

    @FindBy(xpath = "//a[text()='CHECKOUT']")
    WebElement checkoutBtn;

    @FindBy(xpath = "(//div[@class='cart_item_label']//a/div)[1]")
    WebElement cartItems1;

    @FindBy(xpath = "(//div[@class='cart_item_label']//a/div)[2]")
    WebElement cartItems2;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyItemsInCart(int expectedCount) {
        Assert.assertEquals(cartItems.size(), expectedCount, "Cart item count mismatch!");
    }

    public List<String> getCartDetails(){
        List<String> cartitems =  new ArrayList<>();
        cartitems.add(cartItems1.getText().trim());
        cartitems.add(cartItems2.getText().trim());
        return cartitems;
    }

    public void verifyAddedItems(List<String> actualList, List<String> expectedList){
        Assert.assertEquals(actualList, expectedList, "Added items name does not match");
    }

    public void clickCheckout() {
        checkoutBtn.click();
    }
}
