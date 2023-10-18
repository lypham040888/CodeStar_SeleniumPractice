package page_locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RiseDashboardPageFactory extends BasePageFactory {

	public RiseDashboardPageFactory(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[@class='user-name ml10']")
	WebElement userLogged;
	@FindBy(xpath = "//a[contains(@href,'client')]")
	WebElement lbkClient;

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

	public void navigateClient() {
		lbkClient.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
