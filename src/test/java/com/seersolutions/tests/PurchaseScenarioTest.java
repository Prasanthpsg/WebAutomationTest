package com.seersolutions.tests;

import com.seersolutions.basetest.BaseTest;
import com.seersolutions.pages.*;
import com.seersolutions.utility.DataProviderUtils;
import com.seersolutions.utility.ReuseableMethods;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class PurchaseScenarioTest extends BaseTest {

    @Test(dataProvider  = "loginData" , dataProviderClass = DataProviderUtils.class)
    public void verifyPurchaseFlow(String userName, String password)  {
        driver.navigate().to("https://www.saucedemo.com/v1/");

        //Login using credentials stored in an external file
        LoginPage login = new LoginPage(driver);
        login.login(userName,password);

        //Add the first two products to the cart
        InventoryPage products = new InventoryPage(driver);
        List<String> listoftwoproducts = products.getInventoryDetails();
        products.addFirstTwoProducts();
        products.goToCart();

        //verify both products are listed and do checkout
        CartPage cart = new CartPage(driver);
        cart.verifyItemsInCart(2);
        cart.verifyAddedItems(cart.getCartDetails(),listoftwoproducts);
        cart.clickCheckout();

        CheckOutPage checkout = new CheckOutPage(driver);
        checkout.fillDetailsAndFinish();

        //Assert the final confirmation message
        ConfirmationPage confirmation = new ConfirmationPage(driver);
        confirmation.verifyOrderMessage("THANK YOU FOR YOUR ORDER");

    }

    @Test(dataProvider  = "loginData" , dataProviderClass = DataProviderUtils.class)
    public void verifyPurchaseErrorFlow(String userName, String password) {
        driver.navigate().to("https://www.saucedemo.com/v1/");

        //Login using credentials stored in an external file
        LoginPage login = new LoginPage(driver);
        login.login(userName,password);

        //Add the first two products to the cart
        InventoryPage products = new InventoryPage(driver);
        products.addFirstTwoProducts();
        products.goToCart();

        //verify both products are listed and do checkout
        CartPage cart = new CartPage(driver);
        cart.verifyItemsInCart(2);
        cart.clickCheckout();

        CheckOutPage checkout = new CheckOutPage(driver);
        checkout.fillDetailsAndFinish();

        //Assert the final confirmation message
        ConfirmationPage confirmation = new ConfirmationPage(driver);
        confirmation.verifyOrderMessage("THANK YOU FOR YOUR");
    }
}
