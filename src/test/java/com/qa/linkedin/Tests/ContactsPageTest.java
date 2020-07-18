package com.qa.linkedin.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.linkedin.Base.BasePage;
import com.qa.linkedin.Pages.ContactsPage;
import com.qa.linkedin.Pages.HomePage;
import com.qa.linkedin.Pages.LoginPage;
import com.qa.linkedin.Utils.Constants;
import com.qa.linkedin.Utils.ExcelUtil;

public class ContactsPageTest {

	Properties prop;
	WebDriver driver;

	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.goToContactsPage();
	}

	@Test(priority = 1)
	public void verifyContactsPageTitle() {
		String title = contactsPage.getContactsPageTitle();
		System.out.println("contacts page title is : " + title);
		Assert.assertEquals(title, Constants.CONTACTS_PAGE_TITLE);
	}

	@DataProvider
	public Object[][] getContactsTestData() {
		Object data[][] = ExcelUtil.getTestData(Constants.CONTACTS_SHEET_NAME);
		return data;
	}

	@Test(priority = 2, dataProvider = "getContactsTestData")
	public void createNewContactTest(String email, String firstname, String lastname, String jobtitle) {
		String name = contactsPage.createNewContact(email, firstname, lastname, jobtitle);
		 Assert.assertEquals(name, firstname+" "+lastname);
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
