package com.seersolutions.tests;

import com.seersolutions.basetest.BaseTest;
import com.seersolutions.pages.*;
import com.seersolutions.utility.ReuseableMethods;
import org.testng.annotations.Test;

import java.util.List;

public class PurchaseScenarioTest extends BaseTest {

    @Test
    public void verifyPurchaseFlow()  {
        driver.navigate().to("https://www.saucedemo.com/v1/");

        String filePath = "testdata/credentials.xlsx";

        //Login using credentials stored in an external file
        LoginPage login = new LoginPage(driver);
        login.login(ReuseableMethods.readExcelData(filePath, "Sheet1", 0, 0),
                ReuseableMethods.readExcelData(filePath, "Sheet1", 0, 1));

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

    @Test
    public void verifyPurchaseErrorFlow() {
        driver.navigate().to("https://www.saucedemo.com/v1/");

        String filePath = "testdata/credentials.xlsx";

        //Login using credentials stored in an external file
        LoginPage login = new LoginPage(driver);
        login.login(ReuseableMethods.readExcelData(filePath, "Sheet1", 0, 0),
                ReuseableMethods.readExcelData(filePath, "Sheet1", 0, 1));

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
