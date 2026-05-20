package com.tricentis.testscripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tricentis.generic.BaseClass;
import com.tricentis.generic.FileLib;
import com.tricentis.pom.CheckOut;
import com.tricentis.pom.DashBoardPage;
import com.tricentis.pom.GiftCardPage;
import com.tricentis.pom.HomePage;
import com.tricentis.pom.ShoppingCartPage;
import com.tricentis.pom.VirtualGiftCardPage;

@Listeners(com.tricentis.generic.ListenerImplementation.class)
public class GiftCards extends BaseClass {

	@Test
	public void gift() throws IOException {
		FileLib fl = new FileLib();
		
		String sheet = "giftcards";

		HomePage hp = new HomePage(driver);
		hp.clickOnGiftCart();
		String giftCard = fl.getExcelData(sheet, 12, 3);
		assertEquals(driver.getTitle().contains(giftCard), true, "gist card page is not displaying");

		GiftCardPage gcp = new GiftCardPage(driver);
		gcp.clickOnVirtualGiftcard();
		String virtualGiftCardTitle = fl.getExcelData(sheet, 15, 4);
		assertEquals(driver.getTitle().contains(virtualGiftCardTitle), true, "Virtual Gift Card page is not opened");

		VirtualGiftCardPage vgcp = new VirtualGiftCardPage(driver);

		vgcp.enterRecipientName(fl.getProperty("recipientName"));
		vgcp.enterRecipientEmail(fl.getProperty("recipientEmail"));
		vgcp.enterSenderName(fl.getProperty("SenderName"));
		vgcp.enterSenderEmail(fl.getProperty("email"));
		vgcp.enterMessage(fl.getExcelData("giftcards", 20, 3));
		vgcp.clickOnAddtoCart();

		DashBoardPage db = new DashBoardPage(driver);
		db.clickOnCartLink();

		String shoppingCartTitle = fl.getExcelData(sheet, 23, 4);
		assertEquals(driver.getTitle(), shoppingCartTitle, "Shopping cart page is not displayed");

		ShoppingCartPage sc = new ShoppingCartPage(driver);
		sc.clicktermsOfService();
		sc.clickCheckout();

		CheckOut co = new CheckOut(driver);
		for (int i = 0; i < 3; i++) {
			co.clickContinue(i);
		}

		co.clickConfirm();

		String successMessage = fl.getExcelData(sheet, 24, 4);
		assertEquals(co.getSuccessMessage(), successMessage, "Order success message mismatch");
	}

}