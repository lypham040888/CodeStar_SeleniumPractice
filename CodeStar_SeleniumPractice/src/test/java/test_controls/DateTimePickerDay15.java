package test_controls;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.CommonActions;
import common.CommonBrowser;

public class DateTimePickerDay15 {
	CommonBrowser cb;
	WebDriver driver;
	CommonActions actions;

	@Test
	public void TestDateTimePicker() throws InterruptedException {
		driver = cb.initChromeDriver("https://techydevs.com/demos/themes/html/trizen-demo/trizen/index.html");
		Thread.sleep(2000);
		WebElement datetimePicker = driver.findElement(By
				.xpath("//label[text()='Departing']/following-sibling::div//input[@class='date-range form-control']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('readonly','readonly');", datetimePicker);
		datetimePicker.clear();
		datetimePicker.sendKeys("25092024");
		datetimePicker.sendKeys(Keys.TAB);
		System.out.println("Select date thành công");

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
