package page_locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RiseLoginPage extends BasePage {
	protected WebDriver driver;

	public RiseLoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	// Properties

	By txtUser = By.name("email");
	By txtPassword = By.name("password");
	By btnLogin = By.xpath("//button[@type='submit']");
	By lbLErrorAuthenticate = By.xpath("//div[contains(@class,'alert alert-danger')]");

	public void setUserNameValue(String value) {
		// WebElement userName = driver.findElement(getTxtUser());
		WebElement userName = driver.findElement(txtUser);
		userName.sendKeys(value);

	}

	public void setPasswordValue(String value) {
		// WebElement password = driver.findElement(getTxtPassword());
		WebElement password = driver.findElement(txtPassword);
		password.sendKeys(value);

	}

	public void clickLogin() {
		// WebElement loginElement = driver.findElement(getBtnLogin());

		WebElement loginElement = driver.findElement(btnLogin);
		loginElement.click();

	}

	public void clickLogin(String uservalue, String passwordvalue) {
		// WebElement loginElement = driver.findElement(getBtnLogin());
		WebElement userName = driver.findElement(txtUser);
		userName.clear();
		userName.sendKeys(uservalue);
		WebElement password = driver.findElement(txtPassword);
		password.clear();
		password.sendKeys(passwordvalue);

		WebElement loginElement = driver.findElement(btnLogin);
		loginElement.click();

	}

	public boolean checkExistedErrorAuthenticate() {
		boolean isExisted = false;
		WebElement errorMessage = driver.findElement(lbLErrorAuthenticate);
		if (errorMessage.isDisplayed()) {
			isExisted = true;
		}
		return isExisted;

	}

	public String getMessageErrorAuthenticate() {
		String message = "";
		WebElement errorMessage = driver.findElement(lbLErrorAuthenticate);
		message = errorMessage.getText();
		return message;

	}
}
