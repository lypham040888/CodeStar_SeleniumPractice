package test_controls;

import org.testng.annotations.Test;

import common.CommonActions;
import common.CommonBrowser;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class AlertControl {

	WebDriver driver;
	CommonActions actions;

	@BeforeMethod

	public void beforMethod() {
	}

	@AfterMethod

	public void afterMethod() {
		// actions.quitDriver();

	}

	@Test
	public void TestAlertOK() {
		driver = actions.initChromeDriver("https://demo.automationtesting.in/Alerts.html");
		actions.click(By.xpath("//button[@class='btn btn-danger']"));
		//Alert alertForm = driver.switchTo().alert();
		//String alertText = alertForm.getText();
		//alertForm.accept();
		actions.acceptAlert();

	}

	@Test
	@Ignore
	public void TestAlertConfirm() {
		driver = actions.initChromeDriver("https://demo.guru99.com/test/delete_customer.php");
		actions.sendKeys(By.name("cusid"), "12334465");
		actions.click(By.name("submit"));
		Alert alertForm = driver.switchTo().alert();
		String alertText = alertForm.getText();
		alertForm.accept();
		alertForm.accept();
		// alertForm.dismiss();
	}

	@Test
	public void TestAlertSendKey() {
		driver = actions.initChromeDriver("https://demo.automationtesting.in/Alerts.html");
		actions.click(By.xpath("//a[@href='#Textbox']"));
		actions.click(By.xpath("//button[@class='btn btn-info']"));
		
		Alert alertForm = driver.switchTo().alert();
		String alertText = alertForm.getText();
		// Input text
		alertForm.sendKeys("ABCDEFFFFFFFFF");
		// Click OK 
		alertForm.accept();
		String inputAlertText = actions.getText(By.id("demo1"));
		assertEquals(inputAlertText, "Hello ABCDEFFFFFFFFF How are you today");
		// Click Cancel
		// alertForm.dismiss();
	}

	@BeforeTest
	public void beforeTest() {

		actions = new CommonActions();
	}

	@AfterTest
	public void afterTest() {
		// actions.quitDriver();
	}

}
