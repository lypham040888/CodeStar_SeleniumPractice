package test;

import org.testng.annotations.Test;

import common.CommonActions;
import common.CommonBrowser;
import page_locator.RiseDashboard;
import page_locator.RiseLoginPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class Bai14 {
	CommonBrowser cb;
	WebDriver driver;
	CommonActions actions;

	@Test
	public void TC01_LoginSuccess() {
		RiseLoginPage rLogin = new RiseLoginPage(driver);
		rLogin.clickLogin("admin@demo.com", "riseDemo");
		cb.pause(2000);
		// WebElement userSpan = driver.findElement(RiseDashboard.userLogged);
		// assertTrue(userSpan.isDisplayed());
		RiseDashboard rDashboard = new RiseDashboard(driver);
		assertTrue(rDashboard.checkExistedUserName());
		assertEquals(rDashboard.getUserLogged(), "John Doe");
	}

	@Test
	public void TC02_LoginFailed_IncorrectPassword() {
		RiseLoginPage rLogin = new RiseLoginPage(driver);
		rLogin.clickLogin("admin@demo.com", "riseDemo1");
		cb.pause(2000);

		assertTrue(rLogin.checkExistedErrorAuthenticate());
		assertEquals(rLogin.getMessageErrorAuthenticate(), "Authentication failed!");
	}

	@Test
	public void TC03_LoginFailed_IncorrectUser() {

	}

	@BeforeMethod
	public void beforeMethod() {
		driver = cb.initChromeDriver(constants.Test1_WebInfo.prodwebURL);
	}

	@AfterTest
	public void afterMethod() {
		cb.quitDriver(driver);
	}

	@BeforeTest
	public void beforeTest() {
		cb = new CommonBrowser();
		actions = new CommonActions();
		// driver = cb.initChromeDriver(constants.Test1_WebInfo.prodwebURL);
		cb.pause(4000);
	}

	@AfterTest
	public void afterTest() {
		// cb.quitDriver(driver);
	}

}
