package page_locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
	protected WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
	}

	// Properties

	By txtUser = By.name("username");

	By txtPassword = By.name("password");
	By btnLogin = By.xpath("//button[@type='submit']");
	By lnkAdmin = By.xpath("//a[contains(@href,'viewAdminModule')]");
//	public By getTxtUser() {
//		setTxtUser(txtUser);
//		return txtUser;
//	}
//
//	public void setTxtUser(By txtUser) {
//		this.txtUser = By.name("username");
//	}
//
//	public By getTxtPassword() {
//		setTxtPassword(txtPassword);
//		return txtPassword;
//	}
//
//	public void setTxtPassword(By txtPassword) {
//		this.txtPassword = By.name("password");
//	}
//
//	public By getBtnLogin() {
//		setBtnLogin(btnLogin);
//		return btnLogin;
//	}
//
//	public void setBtnLogin(By btnLogin) {
//		this.btnLogin = By.xpath("//button[@type='submit']");
//	}

	// Action
	public void setUserNameValue() {
		// WebElement userName = driver.findElement(getTxtUser());
		WebElement userName = driver.findElement(txtUser);
		userName.sendKeys("Admin");

	}

	public void setPasswordValue() {
		// WebElement password = driver.findElement(getTxtPassword());
		WebElement password = driver.findElement(txtPassword);
		password.sendKeys("admin123");

	}

	public void clickLogin() {
		// WebElement loginElement = driver.findElement(getBtnLogin());
		WebElement loginElement = driver.findElement(btnLogin);
		loginElement.click();

	}
	public void clickAdminPage() {
		WebElement adminLink = driver.findElement(lnkAdmin);
		adminLink.click();

	}

}
