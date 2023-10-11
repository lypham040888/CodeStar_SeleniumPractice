package page_locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFactory extends BasePageFactory {
	WebDriver driver;

	public LoginPageFactory(WebDriver driver) {
		// this.driver = driver;
		// PageFactory.initElements(driver, this);
		super(driver);
	}

	@FindBy(name = "email")
	WebElement txtEmail;
	@FindBy(name = "password")
	WebElement txtPassword;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnLogin;
	@FindBy(xpath = "//div[contains(@class,'alert alert-danger')]")
	WebElement lbLErrorAuthenticate;

	public void clickLogin(String uservalue, String passwordvalue) {

		txtEmail.clear();
		txtEmail.sendKeys(uservalue);
		txtPassword.clear();
		txtPassword.sendKeys(passwordvalue);
		btnLogin.click();

	}

}
