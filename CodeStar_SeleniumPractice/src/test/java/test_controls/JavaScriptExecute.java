package test_controls;

import org.testng.annotations.Test;

import common.CommonActions;
import common.CommonBrowser;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecute {
	CommonBrowser cb;
	WebDriver driver;
	CommonActions actions;

	@Test
	@Ignore
	public void jsExecutorDemo01() throws InterruptedException {
		driver = cb.initChromeDriver("https://anhtester.com/");
		Thread.sleep(1000);
		// Creating the JavascriptExecutor interface object
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Click on "Website Testing" module using JavascriptExecutor
		WebElement button = driver.findElement(By.xpath("//h3[normalize-space()='Website Testing']"));
		// button.click();
		js.executeScript("arguments[0].click();", button);
		Thread.sleep(1000);
		// Get page title and Domain using JavascriptExecutor
		String titleText = js.executeScript("return document.title;").toString();
		System.out.println("Page Title is: " + titleText);
		String domainName = js.executeScript("return document.domain;").toString();
		System.out.println("Domain is: " + domainName);
		// Add Alert window using JavascriptExecutor
		js.executeScript("alert('Successfully Logged In');");
		Thread.sleep(2000);
	}

	@Test
	@Ignore
	public void jsExecutorDemo02() throws InterruptedException {
		driver = cb.initChromeDriver("https://rise.fairsketch.com/signin?redirect=https://rise.fairsketch.com/clients");
		Thread.sleep(1000);
		// Creating the JavascriptExecutor interface object
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("document.getElementById('email').setAttribute('value','admin02@mailinator.com');");
		js.executeScript("document.getElementById('password').setAttribute('value','123456');");
		js.executeScript("document.getElementsByClassName('btn-primary')[0].click()");
		Thread.sleep(2000);

	}

	@Test
	public void jsExecutorDemo03() throws InterruptedException {
		driver = cb.initChromeDriver("https://rise.fairsketch.com/signin?redirect=https://rise.fairsketch.com/clients");
		Thread.sleep(1000);
		// Creating the JavascriptExecutor interface object
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("document.getElementById('email').setAttribute('value','admin@demo.com');");
		js.executeScript("document.getElementById('password').setAttribute('value','riseDemo');");
		js.executeScript("document.getElementsByClassName('btn-primary')[0].click()");
		Thread.sleep(2000);

		WebElement webElement = driver.findElement(By.xpath("//span[normalize-space()='Store']"));
		js.executeScript("arguments[0].scrollIntoView(true);", webElement);
		Thread.sleep(1000);
		// Nếu dùng dòng này đơn thuần sẽ không click được
		// webElement.click();
		// Scroll to element and click

		js.executeScript("arguments[0].scrollIntoView(true);", webElement);
		Thread.sleep(1000);
		// js.executeScript("arguments[0].click();", webElement);
		// Thread.sleep(2000);

	}

	@Test
	@Ignore
	public void localStorage() throws InterruptedException {
		driver = cb.initChromeDriver("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
		Thread.sleep(1000);
		String localGetVar = "";

		// Creating the JavascriptExecutor interface object
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Gọi lại hàm login
		jsExecutorDemo02();

		// Set giá trị
		js.executeScript("window.localStorage.setItem(arguments[0],arguments[1])", "age", "30");
		Thread.sleep(1000);
		// Get giá trị
		localGetVar = (String) js.executeScript("return window.localStorage.getItem(arguments[0])", "age");

		System.out.println(localGetVar);

		Thread.sleep(1000);

	}

	@BeforeTest
	public void beforeTest() {
		cb = new CommonBrowser();
		actions = new CommonActions();
		cb.pause(4000);
	}

	@AfterTest
	public void afterTest() {
		// cb.closeDriver(driver);
	}

}
