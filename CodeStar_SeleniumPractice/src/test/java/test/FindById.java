package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.CommonBrowser;
import constants.Test1_WebInfo;

public class FindById {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonBrowser cb = new CommonBrowser();
		WebDriver driver = cb.initChromeDriver(Test1_WebInfo.testUrl);
		WebElement divId=  driver.findElement(By.id("__layout"));
		System.out.println(divId.getAttribute("innerHTML"));
		cb.quitDriver(driver);
			
	}

}
