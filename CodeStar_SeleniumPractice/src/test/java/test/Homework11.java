package test;

import org.testng.annotations.Test;

import common.CommonActions;
import common.CommonBrowser;
import constants.Test1_WebInfo;

import org.testng.annotations.BeforeMethod;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.AfterTest;

public class Homework11 {
	CommonBrowser cb;
	CommonActions actions;
	WebDriver driver;

	@Test (priority = 1)
	public void Part1() {
		// Button ==> btnLogin, btnSignOut
		// intput textbox ==> txtEmail, textarea = txt
		// Convention for control in programming
		// Label ==> lblName
		// table ==> tblPeople
		// Row in table tr
		// ListBox ==> lstUser

		// Checkbox ==> chk
		// RadioButoon ==> rbtn
		//
		WebElement btnLogin = driver.findElement(By.xpath("//button[@type='submit']"));
		btnLogin.click();
		cb.pause(2000);
		WebElement lbkProjects = driver.findElement(By.xpath("//a[contains(@href,'all_projects')]"));
		lbkProjects.click();
		cb.pause(1000);

		List<WebElement> following = driver
				.findElements(By.xpath("//a[contains(text(),'Virtual Reality Experience Design')]/following::li"));
		for (int i = 0; i < following.size(); i++) {

			System.out.println("Following item: " + i);
			System.out.println(following.get(i).getAttribute("class"));
		}
		List<WebElement> preceding = driver
				.findElements(By.xpath("//a[contains(text(),'Virtual Reality Experience Design')]/preceding::li"));
		for (int i = 0; i < preceding.size(); i++) {
			System.out.println("Preceding item: " + i);
			System.out.println(preceding.get(i).getAttribute("class"));

		}

	}
	@Test(priority = 2)
	public void Part2() {
		WebElement lbkItem = driver.findElement(By.xpath("//a[contains(@href,'view/17')]"));
		lbkItem.click();
		cb.pause(1000);
		
		WebElement lbkTabList = driver.findElement(By.xpath("//a[contains(@href,'project_tasks/17')]"));
		lbkTabList.click();
		cb.pause(1000);

		List<WebElement> parentItem = driver
				.findElements(By.xpath("//a[contains(text(),'Submit plugin to WordPress repository')]/parent::td"));
		for (int i = 0; i < parentItem.size(); i++) {

			System.out.println("parentItem item: " + i);
			System.out.println(parentItem.get(i).getText());
		}
		List<WebElement> childItem = driver
				.findElements(By.xpath("//div[@id='project-tasks_list-section']/child::script"));
		for (int i = 0; i < childItem.size(); i++) {
			System.out.println("childItem item: " + i);
			System.out.println(childItem.get(i).getText());

		}

	}

	@BeforeMethod
	public void beforeMethod() {
		// System.out.println("This is before Method");
	}

	@AfterMethod
	public void afterMethod() {
		// System.out.println("This is after Method");
	}

	@BeforeTest
	public void initBrowser() {
		cb = new CommonBrowser();
		// driver = cb.initChromeDriver(Test1_WebInfo.bepAntoanUrl);
		driver = cb.initChromeDriver("https://rise.fairsketch.com/projects/all_projects");
		// System.out.println("This is beforeTest ");
	}

	@AfterTest
	public void closeBrowser() {
		// System.out.println("This is afterTest ");
		cb.quitDriver(driver);
	}

}
