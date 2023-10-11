package page_locator;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import common.CommonActions;

public class RegisterPage extends BasePageFactory {
	public RegisterPage(WebDriver driver) {
		super(driver);

	}

	CommonActions actions = new CommonActions();

	@FindBy(id = "txtFirstname")
	WebElement txtFirstName;

	@FindBy(id = "txtEmail")
	WebElement txtEmail;

	@FindBy(id = "txtCEmail")
	WebElement txtCEmail;;

	@FindBy(id = "txtPassword")

	WebElement txtPassword;
	@FindBy(id = "txtCPassword")
	WebElement txtCPassword;
	@FindBy(id = "txtPhone")

	WebElement txtPhone;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnSubmit;

	@FindBy(id = "thongbao")
	WebElement divThongbao;

	public void registerNewAccount() {
		actions.sendKeys(txtFirstName, "Jack Pham");

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		// 2023.10.11.21.01.24

		Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
		Random random = new Random();
		int number = random.nextInt(40);
		// Random 0-40

		String email = "Jack" + String.valueOf(number) + sdf1.format(timestamp2) + ".pham@gmail.com";
		actions.sendKeys(txtEmail, email);

		actions.sendKeys(txtCEmail, email);
		actions.sendKeys(txtPassword, "123456789");
		actions.sendKeys(txtCPassword, "123456789");
		actions.sendKeys(txtPhone, "0978344222");
		btnSubmit.click();

		String msgThongbao = divThongbao.getText();
		System.out.println(msgThongbao);
	}

	public void registerNewAccount(String username, String domain, String password, String phone) {
		actions.sendKeys(txtFirstName, username);

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		// 2023.10.11.21.01.24

		Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
		Random random = new Random();
		int number = random.nextInt(40);
		// Random 0-40

		String email = username + String.valueOf(number) + sdf1.format(timestamp2) + "." + domain + "@gmail.com";
		actions.sendKeys(txtEmail, email);

		actions.sendKeys(txtCEmail, email);
		actions.sendKeys(txtPassword, password);
		actions.sendKeys(txtCPassword, password);
		actions.sendKeys(txtPhone, phone);
		btnSubmit.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String msgThongbao = divThongbao.getText();
		System.out.println(msgThongbao);
	}

}
