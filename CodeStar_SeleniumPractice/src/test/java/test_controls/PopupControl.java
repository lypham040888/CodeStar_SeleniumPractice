package test_controls;

import org.testng.annotations.Test;

import common.CommonActions;

import org.testng.annotations.BeforeTest;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class PopupControl {
	WebDriver driver;
	CommonActions actions;

	@Test
	public void TestPopupWindows() {
		driver = actions.initChromeDriver("https://demo.guru99.com/popup.php");
		// Sẽ xuất hiện 1 tab mới sau khi click here ( có 2 cửa sổ )
		actions.click(By.xpath("//a[@href='../articles_popup.php']"));
		// Lấy Id của window hiện tại
		String currentWindowsName = driver.getWindowHandle();
		System.out.println("Current name: " + currentWindowsName);
		System.out.println("Current url: " + driver.getCurrentUrl());
		System.out.println("Current title: " + driver.getTitle());

		// Lấy tất cả các windows tab
		Set<String> allWindowsTab = driver.getWindowHandles();
		for (String windowTitle : allWindowsTab) {
			System.out.println(windowTitle);
			// Duyệt tất cả các tab, nếu tab được duyệt khác với tab ban đầu thì sẽ chuyển
			// và tương tác tiếp với các element
			if (!windowTitle.equals(currentWindowsName)) {
				System.out.println("Thực hiên chuyển tab");
				driver.switchTo().window(windowTitle);
				System.out.println("Switched url: " + driver.switchTo().window(windowTitle).getCurrentUrl());
				System.out.println("Switched title: " + driver.switchTo().window(windowTitle).getTitle());
				actions.sendKeys(By.name("emailid"), "testuserpopup@gmail.com");
				actions.click(By.name("btnLogin"));
				//driver.close();

			}
		}
		// Chuyển về trang bắt đầu ( main windows)
		//driver.switchTo().window(currentWindowsName);
	
		driver.switchTo().defaultContent();

	}

	@BeforeTest
	public void beforeTest() {

		actions = new CommonActions();
	}

	@AfterTest
	public void afterTest() {
		actions.quitDriver();
	}

}
