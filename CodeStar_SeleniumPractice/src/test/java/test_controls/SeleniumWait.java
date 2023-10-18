package test_controls;

import org.testng.annotations.Test;

import common.CommonActions;
import common.CommonBrowser;

import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class SeleniumWait {
	CommonBrowser cb;
	WebDriver driver;
	CommonActions actions;

	@Test
	public void Test1_ImplicitWait() {
		driver = actions.initChromeDriver("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		WebElement txtUserName = driver.findElement(By.name("username"));

		txtUserName.sendKeys("ABC");

	}

	@Test
	public void Test2_ExplicitWait() {
		actions.sendKeys(By.name("username"), "testuser");
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		WebElement txtUser = wait.until(ExpectedConditions.elementToBeClickable(By.name("username")));
//		txtUser.sendKeys("DEF");
//		WebElement txtPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
//		txtPassword.sendKeys("DDDD");
		actions.sendKeys(By.name("password"), "password");

		// WebElement btnLogin =
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("username")));
		// btnLogin.click();

		actions.click(By.xpath("//button[@type='submit']"));
	}

	@BeforeTest
	public void beforeTest() {
		cb = new CommonBrowser();
		actions = new CommonActions();
		cb.pause(4000);
	}

	@AfterTest
	public void afterTest() {
		// actions.closeDriver(driver);
	}

}
