package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.CommonBrowser;
import constants.Test1_WebInfo;

public class FinbByLinkAndPartialText2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonBrowser cb = new CommonBrowser();
		WebDriver driver = cb.initChromeDriver("https://bepantoan.vn/");
		WebElement linkText = driver.findElement(By.linkText("Máy Hút Mùi"));
		System.out.println(linkText.getText());
		linkText.click();
		driver.navigate().back();
		WebElement paritallinkText = driver.findElement(By.partialLinkText("Bếp Từ"));
		System.out.println(paritallinkText.getText());
		
		cb.quitDriver(driver);

	}

}
