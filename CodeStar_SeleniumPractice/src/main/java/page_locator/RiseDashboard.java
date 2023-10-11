package page_locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RiseDashboard extends BasePage {

	public RiseDashboard(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public static By userLogged = By.xpath("//span[@class='user-name ml10']");

	public boolean checkExistedUserName() {
		boolean isExisted = false;
		WebElement userSpan = driver.findElement(userLogged);
		if (userSpan.isDisplayed()) {
			isExisted = true;
		}
		return isExisted;
	}

	public String getUserLogged() {
		String userLoggedName = "";
		WebElement userSpan = driver.findElement(userLogged);
		userLoggedName = userSpan.getText();
		return userLoggedName;
	}
}
