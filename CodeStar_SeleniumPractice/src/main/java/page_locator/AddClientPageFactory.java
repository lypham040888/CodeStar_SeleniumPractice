package page_locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddClientPageFactory extends BasePageFactory {
	public AddClientPageFactory(WebDriver driver) {
		super(driver);

	}

	@FindBy(id = "company_name")
	WebElement txtCompanyName;
	@FindBy(xpath = "//div[@id='s2id_created_by']//a")
	WebElement lbkOwnerDropDownList;

	@FindBy(xpath = "//div[contains(@id,'select2-result-label-') and text()='Sara Ann']")
	WebElement ddlOwnerOption;
	@FindBy(name = "address")
	WebElement txtAddress;
	@FindBy(name = "city")
	WebElement txtCity;
	@FindBy(id = "state")
	WebElement txtState;
	@FindBy(id = "zip")
	WebElement txtZip;

	@FindBy(id = "disable_online_payment")
	WebElement chkOnlinePayment;
	@FindBy(id = "save-and-continue-button")
	WebElement btnSave;

	public void saveNewClient(String companyName, String address, String city, String state, String zip) {

		txtCompanyName.clear();
		txtCompanyName.sendKeys(companyName);
		lbkOwnerDropDownList.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
		ddlOwnerOption.click();
		txtAddress.clear();
		txtAddress.sendKeys(address);
		txtState.clear();
		txtState.sendKeys(state);
		txtZip.clear();
		txtZip.sendKeys(zip);
		chkOnlinePayment.click();

		btnSave.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
	}

}
