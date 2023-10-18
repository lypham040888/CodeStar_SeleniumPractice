package page_locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RiseLoginPageFactory extends BasePageFactory {
	protected WebDriver driver;

	public RiseLoginPageFactory(WebDriver driver) {
		super(driver);

	}

	// Properties

	@FindBy(name = "email")
	WebElement txtUser;
	@FindBy(name = "password")
	WebElement txtPassword;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnLogin;
	@FindBy(xpath = "//div[contains(@class,'alert alert-danger')]")
	WebElement lbLErrorAuthenticate;

	public void setUserNameValue(String value) {
		// WebElement userName = driver.findElement(getTxtUser());
		txtUser.clear();
		txtUser.sendKeys(value);

	}

	public void setPasswordValue(String value) {
		// WebElement password = driver.findElement(getTxtPassword());
		txtPassword.clear();
		txtPassword.sendKeys(value);

	}

	public void clickLogin() {
		// WebElement loginElement = driver.findElement(getBtnLogin());

		btnLogin.clear();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clickLogin(String uservalue, String passwordvalue) {
		txtUser.clear();
		txtUser.sendKeys(uservalue);
		txtPassword.clear();
		txtPassword.sendKeys(passwordvalue);
		btnLogin.click();

	}

	public boolean checkExistedErrorAuthenticate() {
		boolean isExisted = false;
		if (lbLErrorAuthenticate.isDisplayed()) {
			isExisted = true;
		}
		return isExisted;

	}

	public String getMessageErrorAuthenticate() {
		String message = "";

		message = lbLErrorAuthenticate.getText();
		return message;

	}
}
