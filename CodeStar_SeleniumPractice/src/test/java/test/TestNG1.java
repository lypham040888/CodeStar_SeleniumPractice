package test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.Date;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import common.CommonActions;
import common.CommonBrowser;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TestNG1 {
	WebDriver driver;
	CommonBrowser cb;
	CommonActions actions;

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeTest
	public void beforeTest() {
		cb = new CommonBrowser();
		actions = new CommonActions();
		// driver = cb.initChromeDriver("https://bepantoan.vn/")
		//driver =cb.initChromeDriver("https://alada.vn/thong-tin-ca-nhan");
		// cb.initChromeDriver("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
		driver = cb.initChromeDriver("https://alada.vn/tai-khoan/dang-ky.html");
	}

	@Test(priority = 2)
	@Ignore
	public void FindById() {
		WebElement divId = driver.findElement(By.id("__layout"));
		System.out.println(divId.getAttribute("innerHTML"));
	}

	@Test(priority = 3)
	@Ignore
	public void FindByLinkText() {
		WebElement linkText = driver.findElement(By.linkText("Máy Hút Mùi"));
		System.out.println(linkText.getText());
		linkText.click();
		driver.navigate().back();
		WebElement paritallinkText = driver.findElement(By.partialLinkText("Bếp Từ"));
		System.out.println(paritallinkText.getText());

	}

	@Test(priority = 1)
	@Ignore
	public void FillDataForHomework10() {

		WebElement txtFirstName = driver.findElement(By.id("txtFirstname"));
		actions.sendKeys(txtFirstName, "Jack Pham");
		cb.pause(3000);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");

		Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
		Random random = new Random();
		int number = random.nextInt(40);
		WebElement txtEmail = driver.findElement(By.id("txtEmail"));
		String email = "Jack" + String.valueOf(number) + sdf1.format(timestamp2) + ".pham@gmail.com";
		actions.sendKeys(txtEmail, email);
		WebElement txtCEmail = driver.findElement(By.id("txtCEmail"));
		actions.sendKeys(txtCEmail, email);
		WebElement txtPassword = driver.findElement(By.id("txtPassword"));
		actions.sendKeys(txtPassword, "123456789");
		WebElement txtCPassword = driver.findElement(By.id("txtCPassword"));
		actions.sendKeys(txtCPassword, "123456789");
		WebElement txtPhone = driver.findElement(By.id("txtPhone"));
		actions.sendKeys(txtPhone, "0978344222");
		WebElement btnSubmit = driver.findElement(By.xpath("//button[@type='submit']"));
		btnSubmit.click();
		cb.pause(1000);
		actions.takeScreenShotFullPage(driver);
		WebElement divThongbao = driver.findElement(By.id("thongbao"));
		String msgThongbao = divThongbao.getText();
		System.out.println(msgThongbao);

	}

	@Test(priority = 1)
	@Ignore
	public void FillDataForHomework10_2() {
		WebElement rdoMale = driver.findElement(By.xpath("//input[@type='radio' and @value='Male'][1]"));
		rdoMale.click();
		cb.pause(3000);
		WebElement ageGroup = driver
				.findElement(By.xpath("//input[@type='radio' and @value='0 - 5' and @name='ageGroup']"));
		ageGroup.click();
		cb.pause(3000);

	}

	@Test(priority = 1)
	public void CheckUserInformation() {
		WebElement lnkDangNhap = driver.findElement(By.xpath("//body[@class='main']//div[@class='login']//a[text()='Đăng Nhập']"));
		lnkDangNhap.click();
		cb.pause(3000);
		WebElement txtLoginUsername = driver.findElement(By.id("txtLoginUsername"));
		actions.sendKeys(txtLoginUsername, "Jack009.pham@gmail.com");
		WebElement txtLoginPassword = driver.findElement(By.id("txtLoginPassword"));
		actions.sendKeys(txtLoginPassword, "123456789");
		WebElement btnLogin = driver.findElement(By.xpath("//button[text()='ĐĂNG NHẬP' and @type='submit']"));
		btnLogin.click();
		cb.pause(1000);
		driver.navigate().to("https://alada.vn/thong-tin-ca-nhan");
		
		WebElement member_lastname = driver.findElement(By.id("member_lastname"));
		System.out.println("Ho:" + member_lastname.getText());
		WebElement member_firstname = driver.findElement(By.id("member_firstname"));
		System.out.println("Ten:" + member_firstname.getText());
	}

	@AfterTest
	public void afterTest() {
		cb.quitDriver(driver);
	}

	@BeforeSuite
	public void beforeSuite() {
	}

	@AfterSuite
	public void afterSuite() {
	}

}
