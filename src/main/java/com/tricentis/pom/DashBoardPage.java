package com.tricentis.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

	@FindBy(className = "ico-login")
	private WebElement loginLink;
	
	@FindBy(className = "ico-cart")
	private WebElement cartLink;
	
	public DashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnLoginLink() {
		loginLink.click();
	}
	
	public void clickOnCartLink() {
		cartLink.click();
	}
}
