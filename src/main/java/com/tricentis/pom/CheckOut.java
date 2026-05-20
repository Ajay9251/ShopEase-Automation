package com.tricentis.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut {

	@FindBy(xpath = "//input[@value='Continue']")
	private List<WebElement> continuee;

	@FindBy(xpath = "//input[@value='Confirm']")
	private WebElement confirm;

	@FindBy(xpath = "//div[@class='title']/child::strong")
	private WebElement successMsg;

	public CheckOut(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickContinue(int index) {
		continuee.get(index).click();
	}

	public void clickConfirm() {
		confirm.click();
	}

	public String getSuccessMessage() {
		return successMsg.getText();
	}
}
