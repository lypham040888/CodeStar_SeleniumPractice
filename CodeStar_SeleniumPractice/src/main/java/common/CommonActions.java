package common;

import static common.TestLogger.info;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.apache.commons.io.FileUtils; // FileUtils thực hiện các chức năng đọc, ghi, copy, so sánh file 
import org.openqa.selenium.OutputType; // Thực hiện capture screenshot và lưu trữ tại nơi chỉ định
import org.openqa.selenium.TakesScreenshot;

public class CommonActions {
	/**
	 * click on an element
	 */
	public WebDriver driver;

	public void click(Object locator) {
		By xPath = locator instanceof By ? (By) locator : By.xpath(locator.toString());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement elementClick = wait.until(ExpectedConditions.elementToBeClickable(xPath));
		elementClick.click();
	}

	public void click(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public void draganddrop(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public void selectByText(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public void selectByIndex(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();
	}

	public void sendKeys(WebElement element, String value) {
		
		element.clear();
		element.sendKeys(value);

	}

	/**
	 * switch to a frame
	 * 
	 * @param locator
	 * @param opParams
	 */
//	public void switchToFrame(Object locator, Object... opParams) {
//		info("Switch to frame " + locator);
//		int notDisplay = (Integer) (opParams.length > 0 ? opParams[0] : 0);
//		try {
//			driver.switchTo().frame(getElementPresent(locator, DEFAULT_TIMEOUT, 1, notDisplay));
//		} catch (Exception e) {
//			switchToFrame(locator, notDisplay);
//		}
//	}

	/**
	 * back to main frame
	 */
	public void switchToParentFrame() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			switchToParentFrame();
		}
	}

	/**
	 * accept unexpected alert
	 */
	public void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();

		} catch (NoAlertPresentException ex) {
			info("No Alert present");
			;
		}
	}

	/**
	 * 
	 * @param locator
	 * @param opParams
	 */
//	public void scrollToElement(Object locator, Object... opParams) {
//		int notDisplay = (Integer) (opParams.length > 0 ? opParams[0] : 0);
//		WebElement element = getElementPresent(locator, DEFAULT_TIMEOUT, 1, notDisplay);
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//	}

	/**
	 * check field is null = ""
	 * 
	 * @param s
	 */
	public void verifyNull(String s) {
		if (!s.equalsIgnoreCase("")) {
			Assert.fail("Du lieu khong null");
		}
	}
	public void takeScreenShotFullPage(WebDriver driver) {
		String dirPath = System.getProperty("user.dir");
		// Capture full page screenshot - selenium 3 & 4
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(dirPath + "\\screenshots\\fullpage.png");
		try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
