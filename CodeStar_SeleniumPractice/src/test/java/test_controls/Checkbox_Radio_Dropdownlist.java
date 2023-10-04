package test_controls;

import org.testng.annotations.Test;

import common.CommonActions;
import common.CommonBrowser;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Checkbox_Radio_Dropdownlist {
	CommonBrowser cb;
	WebDriver driver;
	CommonActions actions;

	@Test
	public void checkRadio() {
		driver = cb.initChromeDriver("http://demo.seleniumeasy.com/basic-radiobutton-demo.html");
		System.out.println("Page Title");
		System.out.println(driver.getTitle());
		assertEquals(driver.getTitle(), "Selenium Easy Demo - Radio buttons demo for Automation");
		System.out.println("Page Source");
		System.out.println(driver.getPageSource());
		System.out.println("getWindowHandle");
		
		System.out.println(driver.getWindowHandle());
		//driver.navigate().to("https://www.w3schools.com/html/html_basic.asp");
		driver.navigate().refresh();
		//driver.navigate().back();
		
		
		
		List<WebElement> radioMale = driver.findElements(By.xpath("//input[@type='radio' and @value='Male']"));
		for (WebElement webElement : radioMale) {
			if (!webElement.isSelected()) {
				webElement.click();

			}
		}
		cb.pause(2000);

	}

	@Test
	@Ignore
	public void checkCheckbox() {
		driver = cb.initChromeDriver("http://demo.seleniumeasy.com/basic-checkbox-demo.html");
		List<WebElement> checkboxMale = driver.findElements(By.xpath("//input[@type='checkbox']"));
		for (WebElement webElement : checkboxMale) {
			if (!webElement.isSelected()) {
				webElement.click();

			}
		}

		cb.pause(2000);
	}

	@Test
	@Ignore
	public void checkDropDownlist() {
		driver = cb.initChromeDriver("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
		WebElement option3 = driver.findElement(By.xpath("//option[@value='Tuesday']"));
		option3.click();
		cb.pause(5000);
	}

	@Test
	@Ignore
	public void checkDropDownlist2() {
		driver = cb.initChromeDriver("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
		Select selectDay = new Select(driver.findElement(By.id("select-demo")));
		selectDay.selectByIndex(5);
		selectDay.selectByValue("Monday");
		cb.pause(5000);
	}

	@Test
	@Ignore
	public void checkDropDownlis3() {
		driver = cb.initChromeDriver("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
		WebElement selectDay = driver.findElement(By.id("select-demo"));
		selectDay.sendKeys("Monday");
		cb.pause(5000);
	}

	@BeforeTest
	public void beforeTest() {
		cb = new CommonBrowser();
		actions = new CommonActions();
		cb.pause(4000);
	}

	@AfterTest
	public void afterTest() {
		cb.closeDriver(driver);
	}

}
