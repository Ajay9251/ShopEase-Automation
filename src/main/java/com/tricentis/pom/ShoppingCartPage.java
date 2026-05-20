package com.tricentis.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	@FindBy(xpath = "//a[contains(text(),'14.1-inch')]/parent::td/following-sibling::td/input[@class='qty-input']")
	private WebElement quantity;

	@FindBy(id = "checkout")
	private WebElement chekout;

	@FindBy(id = "termsofservice")
	private WebElement termsOfService;

	public ShoppingCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickQuantity(String qty) {
		quantity.clear();
		quantity.sendKeys(qty);
	}

	public void clickCheckout() {
		chekout.click();
	}

	public void clicktermsOfService() {
		termsOfService.click();
	}

}
