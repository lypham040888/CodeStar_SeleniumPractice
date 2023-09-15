package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.CommonActions;
import common.CommonBrowser;

public class Homework8 {

	public static void main(String[] args) {
		CommonBrowser cb = new CommonBrowser();
		WebDriver driver = cb.initChromeDriver("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		cb.pause(3000);
		//WebElement txtUserName = driver.findElement(By.id("userId"));
		WebElement txtUserName = driver.findElement(By.name("email"));
		// Xoa text cu
		//txtUserName.clear();
		// truyền giá trị vào ô textbox
		//txtUserName.sendKeys("test-selenium@gmail.com");
		CommonActions actions = new CommonActions();
		actions.sendKeys(txtUserName, "test-selenium@gmail.com");
		WebElement txtPassword = driver.findElement(By.id("pass"));
		actions.sendKeys(txtPassword, "1234556");
		WebElement txtCompany = driver.findElement(By.name("company"));
		
		WebElement txtMobile = driver.findElement(By.name("mobile number"));
		
		WebElement linkUserName = driver.findElement(By.linkText("Garry.White"));
		
	}
}
