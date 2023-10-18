package page_locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClientPageFactory extends BasePageFactory {
	public ClientPageFactory(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//a[contains(@title,'Add client')]")
	WebElement btnAddClient;

	public void addClient() {
		btnAddClient.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
