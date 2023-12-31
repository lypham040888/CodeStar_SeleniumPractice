package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.CommonBrowser;

public class FindByCssSelector {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonBrowser cb = new CommonBrowser();
		WebDriver driver = cb.initChromeDriver("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		cb.pause(3000);
		// Find css selector by class 
		WebElement divLoginForm = driver.findElement(By.cssSelector(".orangehrm-login-form"));

		System.out.println(divLoginForm.getText());
		
		// Find css selector by id 
		WebElement divLoginId = driver.findElement(By.cssSelector("#app"));
		System.out.println(divLoginId.getText());

		WebElement btnLogin = driver.findElement(By.tagName("button"));

		btnLogin.click();
		cb.pause(2000);

		cb.quitDriver(driver);
	}

}
