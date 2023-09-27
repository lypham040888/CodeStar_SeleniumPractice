package test;

import org.testng.annotations.Test;

import common.CommonActions;
import common.CommonBrowser;
import constants.Test1_WebInfo;
import io.netty.handler.codec.http.websocketx.WebSocket00FrameDecoder;

import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.asynchttpclient.webdav.WebDavResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.AfterTest;

public class xPathAxes {
	CommonBrowser cb;
	CommonActions actions;
	WebDriver driver;

	@Test
	@Ignore
	public void FindAscentor() {
		// System.out.println("This is Test1");
		// WebElement divMayRuaChen = driver.findElement(By.xpath("//h4[text()='Máy Rửa
		// Bát Âm Toàn Phần Bosch .SMV6ZCX42E Series 6']/ancestor::div"));
		// System.out.println(divMayRuaChen.getText());
		List<WebElement> anccestor = driver.findElements(
				By.xpath("//h4[text()='Máy Rửa Bát Âm Toàn Phần Bosch .SMV6ZCX42E Series 6']/ancestor::div"));
		for (WebElement webElement : anccestor) {
			System.out.println(webElement.getText());
		}

	}

	@Test
	@Ignore
	public void FindAscentor2() {

		List<WebElement> anccestor = driver.findElements(By.xpath("//p[@class='title_login']/ancestor::div"));
		for (WebElement webElement : anccestor) {

			System.out.println(webElement.getText());
		}

	}

	@Test
	@Ignore
	public void FindDescendant() {
		List<WebElement> descendant = driver
				.findElements(By.xpath("//div[@class='columm login_col_4']/descendant::div"));
		for (WebElement webElement : descendant) {

			System.out.println(webElement.getText());
		}

	}
	@Ignore
	public void FindPreceding() {
		List<WebElement> preceding = driver
				.findElements(By.xpath("//input[@id='txtPassword']/preceding::input[@class='text form-control']"));
		for (WebElement webElement : preceding) {
			System.out.println(webElement.getAttribute("placeholder"));
		}

	}
	
	@Test(priority = 2)
	@Ignore
	public void FindFollowing() {
		List<WebElement> following = driver
				.findElements(By.xpath("//input[@id='txtPassword']/following::input[@class='text form-control']"));
		for (WebElement webElement : following) {
			System.out.println(webElement.getAttribute("placeholder"));
		}

	}
	@Test
	public void FindPrecedingSibling() {
		List<WebElement> preceding = driver
				.findElements(By.xpath("//input[@id='txtPassword']/preceding-sibling::label"));
		for (WebElement webElement : preceding) {
			System.out.println(webElement.getText());
		}

	}
	
	@Test(priority = 2)
	public void FindFollowingSibling() {
		List<WebElement> following = driver
				.findElements(By.xpath("//input[@id='txtPassword']/following-sibling::label"));
		for (WebElement webElement : following) {
			System.out.println(webElement.getText());
		}

	}
	

	@BeforeMethod
	public void beforeMethod() {
		// System.out.println("This is before Method");
	}

	@AfterMethod
	public void afterMethod() {
		// System.out.println("This is after Method");
	}

	@BeforeTest
	public void initBrowser() {
		cb = new CommonBrowser();
		// driver = cb.initChromeDriver(Test1_WebInfo.bepAntoanUrl);
		driver = cb.initChromeDriver("https://alada.vn/tai-khoan/dang-ky.html");
		// System.out.println("This is beforeTest ");
	}

	@AfterTest
	public void closeBrowser() {
		// System.out.println("This is afterTest ");
		cb.quitDriver(driver);
	}

}
