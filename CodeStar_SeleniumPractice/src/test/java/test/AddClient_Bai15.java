package test;

import org.testng.annotations.Test;

import common.CommonActions;
import common.CommonBrowser;
import page_locator.AddClientPageFactory;
import page_locator.ClientPageFactory;
import page_locator.RiseDashboardPageFactory;
import page_locator.RiseLoginPageFactory;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class AddClient_Bai15 {
	CommonBrowser cb;
	WebDriver driver;
	CommonActions actions;

	@Test
	public void AddClientInform() {
		driver = cb.initFirefoxDriver("https://rise.fairsketch.com/signin");
		RiseLoginPageFactory rLogin = new RiseLoginPageFactory(driver);
		rLogin.clickLogin("admin@demo.com", "riseDemo");
		RiseDashboardPageFactory dashboard = new RiseDashboardPageFactory(driver);
		dashboard.navigateClient();
		ClientPageFactory client = new ClientPageFactory(driver);
		client.addClient();
		AddClientPageFactory addClientForm = new AddClientPageFactory(driver);
		addClientForm.saveNewClient("ABC Limit Compay", "NewYork", "", "", "");
		

	}

	@BeforeTest
	public void initStep() {
		cb = new CommonBrowser();
		actions = new CommonActions();
		// driver = cb.initChromeDriver(constants.Test1_WebInfo.prodwebURL);
		cb.pause(4000);
	}

	@AfterTest
	public void quitAddClient() {
		//cb.quitDriver(driver);
	}
}
