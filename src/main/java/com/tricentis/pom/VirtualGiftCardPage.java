package com.tricentis.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VirtualGiftCardPage {

	@FindBy(id = "giftcard_1_RecipientName")
	private WebElement recipientName;

	@FindBy(id = "giftcard_1_RecipientEmail")
	private WebElement recipientEmail;

	@FindBy(id = "giftcard_1_SenderName")
	private WebElement senderName;

	@FindBy(id = "giftcard_1_SenderEmail")
	private WebElement senderEmail;

	@FindBy(id = "giftcard_1_Message")
	private WebElement message;
	
	@FindBy(id = "add-to-cart-button-1")
	private WebElement addTocart;

	public VirtualGiftCardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterRecipientName(String name) {
		recipientName.sendKeys(name);
	}

	public void enterRecipientEmail(String email) {
		recipientEmail.sendKeys(email);
	}

	public void enterSenderName(String name) {
		senderName.sendKeys(name);
	}

	public void enterSenderEmail(String email) {
		senderEmail.clear();
		senderEmail.sendKeys(email);
	}

	public void enterMessage(String msg) {
		message.sendKeys(msg);
	}
	
	public void clickOnAddtoCart() {
		addTocart.click();
	}
}
