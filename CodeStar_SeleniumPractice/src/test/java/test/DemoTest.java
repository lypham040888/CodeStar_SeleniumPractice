package test;
import org.openqa.selenium.WebDriver;

import common.CommonActions;
import common.CommonBrowser;
import constants.Test1_WebInfo;

public class DemoTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Init browser
		// ChromeOptions options = new ChromeOptions();
		// System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
		// + "\\driver\\chromedriver.exe");

		WebDriver driver;

		// WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		// driver.get(Test1_WebInfo.testUrl);
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		// WebDriver driver = new FirefoxDriver();
		// driver.manage().window().maximize();
		// driver.get(Test1_WebInfo.testUrl);
		// driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		CommonBrowser cb = new CommonBrowser();
		// driver = cb.initChromeDriver(Test1_WebInfo.testUrl);
		// driver = cb.initFirefoxDriver(Test1_WebInfo.testUrl);
		driver = cb.initEdgeDriver(Test1_WebInfo.testUrl);
		CommonActions action = new CommonActions();
		action.click(null);
		cb.quitDriver(driver);

	}

}
