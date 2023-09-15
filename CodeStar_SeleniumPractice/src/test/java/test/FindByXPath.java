package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import common.CommonActions;
import common.CommonBrowser;

public class FindByXPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CommonBrowser cb = new CommonBrowser();
		CommonActions actions = new CommonActions();
		WebDriver driver = cb.initChromeDriver("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		cb.pause(3000);
		WebElement divLoginForm = driver.findElement(By.className("orangehrm-login-form"));

		System.out.println(divLoginForm.getText());
		// WebElement txtUserName = driver.findElement(By.name("username"));
		WebElement txtUserName = driver.findElement(By.xpath("//input[@name='username']"));
		actions.sendKeys(txtUserName, "Admin");
		// WebElement txtPassword = driver.findElement(By.name("password"));
		WebElement txtPassword = driver.findElement(By.xpath("//input[@type='password']"));
		actions.sendKeys(txtPassword, "admin123");
		WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));
		btnLogin.click();
		cb.pause(4000);
		String actualResult = driver.getCurrentUrl();
		System.out.println(actualResult);
		String expectResult = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		if (actualResult.equals(expectResult)) {
			System.out.println("Login success");
		} else {
			System.out.println("Login failed");
		}
		cb.quitDriver(driver);

	}

}
