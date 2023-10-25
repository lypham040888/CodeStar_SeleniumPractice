package test_controls;

import org.testng.annotations.Test;

import common.CommonActions;
import common.CommonBrowser;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class IframeControl {
	WebDriver driver;
	CommonActions actions;

	@Test
	@Ignore
	public void handeIframe1() {
		driver = actions.initChromeDriver("https://codestar.vn/");
		List<WebElement> iframeDangKy = driver.findElements(By.xpath("//iframe[contains(@src,'form')]"));

		driver.switchTo().frame(iframeDangKy.get(iframeDangKy.size() - 1));
		WebElement accountName = driver.findElement(By.name("account_name"));
		accountName.sendKeys("ABC DEF");
		WebElement phone = driver.findElement(By.name("account_phone"));
		phone.sendKeys("0976557889");
		WebElement email = driver.findElement(By.name("account_email"));
		email.sendKeys("testiframe1@gmail.com");
		WebElement btnDangKy = driver.findElement(By.xpath("//button[text()='Đăng ký ngay']"));
		btnDangKy.click();

		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		// Tìm tất cả các iframe
		List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
		for (WebElement webElement : iframeList) {
			System.out.println("Iframe item link: " + webElement.getAttribute("src"));

		}
		for (int i = 0; i < iframeList.size(); i++) {
			// Chuyen to frame
			driver = driver.switchTo().frame(i);
			System.out.println("Current frame: " + driver.getTitle());
			driver.switchTo().defaultContent();

		}

	}

	@Test
	@Ignore
	public void handeIframe2() {

		driver = actions.initChromeDriver("https://codestar.vn/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		actions.scrollToElement(By.xpath("//h2[text()='Đội ngũ giảng viên']"));
		driver.switchTo().frame(1);
		WebElement phone = driver.findElement(By.name("account_phone"));
		phone.sendKeys("0976557889");
		WebElement email = driver.findElement(By.name("account_email"));
		email.sendKeys("testiframe1@gmail.com");
		WebElement btnDangKy = driver.findElement(By.xpath("//button[text()='Gửi ngay']"));
		btnDangKy.click();
		actions.acceptAlert();
		driver.switchTo().defaultContent();

	}
	@Test
	public void handeIframe3() {

		driver = actions.initChromeDriver("https://dantri.com.vn/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='sidebar']//iframe")));
		WebElement item = driver.findElement(By.xpath("////div[contains(@class,'product-box')]//a[contains(@data-asoch-targets,'product0')]"));
		item.click();
		

	}

	@BeforeTest
	public void beforeTest() {

		actions = new CommonActions();
	}

	@AfterTest
	public void afterTest() {
		actions.quitDriver();
	}

}
