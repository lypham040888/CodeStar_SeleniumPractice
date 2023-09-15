package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.CommonActions;
import common.CommonBrowser;
import constants.Test1_WebInfo;

public class FindByXpath2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Bật browser và gọi common
		CommonBrowser cb = new CommonBrowser();
		CommonActions actions = new CommonActions();

		WebDriver driver = cb.initChromeDriver(Test1_WebInfo.bepAntoanUrl);
		cb.pause(2000);
		// Mở trang Máy hút mùi
		WebElement mayhutMuiLink = driver.findElement(By.xpath("//a[text()='Máy Hút Mùi']"));
		// mayhutMuiLink.click();
		cb.pause(1000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", mayhutMuiLink);
		cb.pause(5000);
		// Mở một product trong danh mục máy hút mùi
		// WebElement firstProduct = driver
		// .findElement(By.xpath("//div[@class='flex flex-wrap
		// product-list']//a[1]//div//div//img"));

		WebElement firstProduct = driver.findElement(By.xpath("//img[@class='block object-contain w-full h-full'][1]"));
		// firstProduct.click();
		cb.pause(2000);
		executor.executeScript("arguments[0].click();", firstProduct);
		cb.pause(5000);
		String actualUrl = driver.getCurrentUrl();
		System.out.println("Actual Url: "+ actualUrl);
		String expectUrl = "https://bepantoan.vn/may-hut-mui-kinh-cong-kainer-ka-270c";

		WebElement productTitle = driver
				.findElement(By.xpath("//h5[@class='text-base text-grey-800 font-bold uppercase mb-0.5']"));
		cb.pause(1000);
		String expectTite = "MÁY HÚT MÙI KÍNH CONG KAINER KA-270C";
		String innerTitle = productTitle.getAttribute("innerHTML");
		System.out.println("innerTitle Title: "+ innerTitle);
		if (actualUrl.equals(expectUrl) && innerTitle.contains(expectTite)) {
			System.out.println("Test case passed");
		} else {
			System.out.println("Test case Failed");
		}
		cb.quitDriver(driver);

	}

}
