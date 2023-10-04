package page_locator;

import org.openqa.selenium.WebDriver;

public class AdminPage extends BasePage {

	WebDriver driver;

	public AdminPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
