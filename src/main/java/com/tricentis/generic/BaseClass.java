package com.tricentis.generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.tricentis.pom.DashBoardPage;
import com.tricentis.pom.HomePage;
import com.tricentis.pom.LoginPage;

public class BaseClass {

	public static WebDriver driver;
	FileLib fl;

	@BeforeClass
	public void launch() throws IOException {
		driver = new ChromeDriver();
		fl = new FileLib();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(fl.getProperty("url"));
	}

	@BeforeMethod
	public void login() throws IOException {
		DashBoardPage db = new DashBoardPage(driver);
		db.clickOnLoginLink();
		LoginPage lp = new LoginPage(driver);
		fl = new FileLib();
		lp.enterUsername(fl.getProperty("email"));
		lp.enterPassword(fl.getProperty("password"));
		lp.clickLoginButton();
	}

	@AfterMethod
	public void logout() {
		HomePage hp = new HomePage(driver);
		hp.logoutButton();
	}

	@AfterClass()
	public void closeBrowser() {
		driver.quit();
	}
}