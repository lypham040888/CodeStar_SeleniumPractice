package common;

import static common.TestLogger.info;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
}
