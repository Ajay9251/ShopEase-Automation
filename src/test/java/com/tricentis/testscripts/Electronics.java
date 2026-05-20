package com.tricentis.testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tricentis.generic.BaseClass;
import com.tricentis.generic.FileLib;
import com.tricentis.pom.CheckOut;
import com.tricentis.pom.HomePage;
import com.tricentis.pom.ShoppingCartPage;

@Listeners(com.tricentis.generic.ListenerImplementation.class)
public class Electronics extends BaseClass {

	@Test
	public void electronic() throws InterruptedException, IOException {

		FileLib fl 	= new FileLib();

		String sheet = "electronics";

		String homePageTitle = fl.getExcelData(sheet, 14, 4);
		assertEquals(driver.getTitle(), homePageTitle, "Home page is not displayed");

		HomePage hp = new HomePage(driver);
		String productName = fl.getExcelData(sheet, 15, 3);

		hp.searchBox(productName);
		hp.clickOnLaptop();

		assertEquals(driver.getTitle().contains(productName), true, "Laptop page not opened");

		hp.clickOnAddToCart();
		hp.clickOnShoppingCart();

		String shoppingCartTitle = fl.getExcelData(sheet, 18, 4);
		assertEquals(driver.getTitle(), shoppingCartTitle, "Shopping cart page not displayed");

		ShoppingCartPage sc = new ShoppingCartPage(driver);
		String quantity = fl.getExcelData(sheet, 19, 3);
		sc.clickQuantity(quantity);
		sc.clicktermsOfService();
		sc.clickCheckout();

		assertEquals(driver.getTitle().contains("Checkout"), true, "Checkout page not opened");

		CheckOut co = new CheckOut(driver);
		for (int i = 0; i < 5; i++) {
			co.clickContinue(i);
		}
		co.clickConfirm();

		String successMessage = fl.getExcelData(sheet, 20, 4);
		assertEquals(co.getSuccessMessage(), successMessage, "Order success message mismatch");
	}

}