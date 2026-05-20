package com.tricentis.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(id = "Email")
	private WebElement username;

	@FindBy(id = "Password")
	private WebElement pasword;

	@FindBy(className = "login-button")
	private WebElement loginButton;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String un) {
		username.sendKeys(un);
	}

	public void enterPassword(String pwd) {
		pasword.sendKeys(pwd);
	}


	public void clickLoginButton() {
		loginButton.click();
	}
}
