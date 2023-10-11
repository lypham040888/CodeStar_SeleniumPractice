package common;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import constants.Test1_WebInfo;

public class CommonBrowser {
	public WebDriver driver;
	protected int DEFAULT_TIMEOUT = 20000;
	protected int WAIT_INTERVAL = 1000;
	public int loopCount = 0;
	public final int ACTION_REPEAT = 5;
	public Actions action;

	/**
	 * init Driver
	 * 
	 * @param URL
	 */
	public WebDriver initDriverTest(String... URL) {
		String url1 = URL.length > 0 ? URL[0] : Test1_WebInfo.baseUrl;
		String proName = URL.length > 2 ? URL[2] : "";
		String broName = URL.length > 1 ? URL[1] : "chrome";
		String url2 = System.getProperty("Url");
		String browser = System.getProperty("browser");
		String plaftForm = System.getProperty("platForm");
		WebDriver dr = null;

		if (browser == null) {
			browser = broName;
		}
		ChromeOptions options = new ChromeOptions();
		if ("chrome".equals(browser)) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
			dr = new ChromeDriver();
		} else if ("iexplorer".equals(browser)) {
			dr = new InternetExplorerDriver();
		} else if ("safari".equals(browser)) {
			dr = new SafariDriver();
		} else {
			if (proName != null && proName != "") {
				FirefoxProfile ffprofile = new FirefoxProfile(new File(proName));
				dr = new FirefoxDriver();
			} else {
				FirefoxProfile fxProfile = new FirefoxProfile();
				File browserAppPath = new File("/usr/bin/geckodriver");
				FirefoxBinary ffBin = new FirefoxBinary(browserAppPath);
				dr = new FirefoxDriver();
			}
		}
		if (url2 != "" && url2 != null) {
			dr.get(url2);
		} else {
			dr.get(url1);
		}
		dr.manage().window().maximize();
		//dr.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		return dr;
	}

	public WebDriver initChromeDriver(String URL) {
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
				// Instantiate the chrome driver
		driver = new ChromeDriver(options);

		//driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		return driver;
	}

	public WebDriver initFirefoxDriver(String URL) {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		return driver;
	}

	public WebDriver initEdgeDriver(String URL) {
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		return driver;
	}

	public WebDriver navigate(String URL) {
		driver.navigate().to(URL);
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		return driver;
	}

	/**
	 * pause driver in timeInMillis
	 * 
	 * @param timeInMillis
	 */
	public void pause(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param locator
	 * @param opParams
	 */

	/**
	 * quit driver if driver existed
	 * 
	 * @param dr
	 */
	public void closeDriver(WebDriver dr) {
		if (dr.toString().contains("null")) {
			System.out.print("All Browser windows are closed ");
		} else {
			driver.manage().deleteAllCookies();
			dr.close();
		}
	}

	public void quitDriver(WebDriver dr) {
		dr.quit();

	}

}
