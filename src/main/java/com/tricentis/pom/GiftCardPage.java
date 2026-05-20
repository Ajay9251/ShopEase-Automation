package com.tricentis.pom;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftCardPage {

	@FindBy(xpath = "//h2[@class='product-title']//child::a")
	private WebElement virtualGiftcard;

	public GiftCardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnVirtualGiftcard() {
		virtualGiftcard.click();
	}
}
