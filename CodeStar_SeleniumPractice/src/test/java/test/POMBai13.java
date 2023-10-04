package test;

import org.testng.annotations.Test;

import common.CommonActions;
import common.CommonBrowser;
import page_locator.AdminPage;
import page_locator.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class POMBai13 {
	CommonBrowser cb;
	WebDriver driver;
	CommonActions actions;

	@Test
	public void LoginPOM() {
		LoginPage login = new LoginPage(driver);
		login.setUserNameValue();
		login.setPasswordValue();
		login.clickLogin();
		cb.pause(2000);
		login.clickAdminPage();
		AdminPage admin = new AdminPage(driver);
		

	}
	@Test
	public void Login() {
		WebElement userName = driver.findElement(By.name("username"));
		userName.sendKeys("Admin");
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");
		WebElement loginElement = driver.findElement( By.xpath("//button[@type='submit']"));
		loginElement.click();
		cb.pause(2000);
		WebElement adminLink = driver.findElement(By.xpath("//a[contains(@href,'viewAdminModule')]"));
		adminLink.click();
		loginElement.click();
		

	}

	@BeforeTest
	public void beforeTest() {
		cb = new CommonBrowser();
		actions = new CommonActions();
		driver = cb.initChromeDriver(constants.Test1_WebInfo.orangeUrl);
		cb.pause(4000);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
