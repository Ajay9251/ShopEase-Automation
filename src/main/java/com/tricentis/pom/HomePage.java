package com.tricentis.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(className = "ico-logout")
	private WebElement logout;

	@FindBy(id = "small-searchterms")
	private WebElement search;

	@FindBy(xpath = "(//a[contains(text(),'14.1-inch ')])[2]")
	private WebElement laptop;

	@FindBy(id = "add-to-cart-button-31")
	private WebElement addToCart;

	@FindBy(xpath = "//span[text()='Shopping cart']")
	private WebElement shoppingCart;

	@FindBy(xpath = "(//a[contains(text(),'Gift Cards')])[1]")
	private WebElement giftCart;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void logoutButton() {
		logout.click();
	}

	public void searchBox(String product) {
		search.sendKeys(product);
	}

	public void clickOnLaptop() {
		laptop.click();
	}

	public void clickOnAddToCart() {
		addToCart.click();
	}

	public void clickOnShoppingCart() {
		shoppingCart.click();
	}
	
	public void clickOnGiftCart() {
		giftCart.click();
	}
}
