package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.CommonBrowser;

public class FindByClassName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonBrowser cb = new CommonBrowser();
		WebDriver driver = cb.initChromeDriver("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		cb.pause(3000);
		WebElement divLoginForm = driver.findElement(By.className("orangehrm-login-form"));

		System.out.println(divLoginForm.getText());

		WebElement btnLogin = driver.findElement(By.tagName("button"));

		btnLogin.click();
		cb.pause(2000);

		cb.quitDriver(driver);
	}

}
