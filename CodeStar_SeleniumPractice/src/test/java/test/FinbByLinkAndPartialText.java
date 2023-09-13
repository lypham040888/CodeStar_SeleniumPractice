package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.CommonBrowser;
import constants.Test1_WebInfo;

public class FinbByLinkAndPartialText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonBrowser cb = new CommonBrowser();
		WebDriver driver = cb.initChromeDriver("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		cb.pause(3000);
		WebElement linkText = driver.findElement(By.linkText("OrangeHRM, Inc"));

		System.out.println(linkText.getText());

		WebElement paritallinkText = driver.findElement(By.partialLinkText("OrangeHRM"));

		System.out.println(paritallinkText.getText());
		linkText.click();
		cb.quitDriver(driver);

	}

}
