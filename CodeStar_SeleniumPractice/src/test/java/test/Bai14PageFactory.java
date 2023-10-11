package test;

import org.testng.annotations.Test;

import common.CommonActions;
import common.CommonBrowser;
import page_locator.DashboardPageFactory;
import page_locator.LoginPageFactory;
import page_locator.RiseDashboard;
import page_locator.RiseLoginPage;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Bai14PageFactory {
	CommonBrowser cb;
	WebDriver driver;
	CommonActions actions;

	@Test
	public void TC01_LoginSuccess() {
		LoginPageFactory rLogin = new LoginPageFactory(driver);
		rLogin.clickLogin("admin@demo.com", "riseDemo");
		cb.pause(2000);
		DashboardPageFactory pDashboard = new DashboardPageFactory(driver);
		assertTrue(pDashboard.checkExistedUserName());

	}

	@Test
	public void TC02_LoginFailed_IncorrectPassword() {

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
		cb.quitDriver(driver);
	}

}
