package homework;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.CommonActions;
import common.CommonBrowser;
import page_locator.DashboardPageFactory;
import page_locator.LoginPageFactory;
import page_locator.RegisterPage;

public class Homework14 {
	CommonBrowser cb;
	WebDriver driver;
	CommonActions actions;

	@Test
	public void TC01_LoginSuccess() {
		RegisterPage register = new RegisterPage(driver);
		// register.registerNewAccount();
		register.registerNewAccount("emily", "codestar", "88888888", "0993933993");
		cb.pause(4000);

	}

	@BeforeTest
	public void beforeTest() {
		cb = new CommonBrowser();
		actions = new CommonActions();
		driver = cb.initChromeDriver(constants.Test1_WebInfo.aladaUrl);
		cb.pause(4000);
	}

	@AfterTest
	public void afterTest() {
		//cb.quitDriver(driver);
	}

}
