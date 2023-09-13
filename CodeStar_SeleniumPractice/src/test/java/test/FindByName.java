package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.CommonBrowser;

public class FindByName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonBrowser cb = new CommonBrowser();
		String hrmUrl= "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		WebDriver driver = cb.initChromeDriver(hrmUrl);
		WebElement txtUserName =  driver.findElement(By.name("username"));
		txtUserName.clear();
		txtUserName.sendKeys("Admin");
		WebElement txtPassword =  driver.findElement(By.name("password"));
		txtPassword.clear();
		txtPassword.sendKeys("admin123");
	
		cb.pause(3000);
		cb.quitDriver(driver);

	}

}
