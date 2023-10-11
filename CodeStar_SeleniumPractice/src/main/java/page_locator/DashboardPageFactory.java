package page_locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageFactory extends BasePageFactory {
	WebDriver driver;

	public DashboardPageFactory(WebDriver driver) {
		//this.driver = driver;
		//PageFactory.initElements(driver, this);
		super(driver);
	}

	@FindBy(xpath = "//span[@class='user-name ml10']")
	WebElement userLogged;

	public boolean checkExistedUserName() {
		boolean isExisted = false;
		if (userLogged.isDisplayed()) {
			isExisted = true;
		}
		return isExisted;
	}

	public String getUserLogged() {
		String userLoggedName = "";
		userLoggedName = userLogged.getText();
		return userLoggedName;
	}
}
