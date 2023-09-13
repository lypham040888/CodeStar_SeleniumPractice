package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.CommonBrowser;

public class Homework8 {

	public static void main(String[] args) {
		CommonBrowser cb = new CommonBrowser();
		WebDriver driver = cb.initChromeDriver("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		cb.pause(3000);
		WebElement txtUserName = driver.findElement(By.id("userId"));
		
	}
}
