package com.qa.hubspot.tests;

import java.util.Properties;

import javax.management.DescriptorKey;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
//pre condition --> Test --> ac vs exp --> post step
//@BeforeTest -->   @Test --> Assert   --> @AfterTest
//browser, url --> test google title --> Google vs Google --> close browser
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic - 101 : design login feature")
@Feature("US - 105 : design test cases for login page feature")
public class LoginPageTest {

	Properties prop;
	WebDriver driver;

	BasePage basePage;
	LoginPage loginPage;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
	}

	
	@Test(priority=1, enabled=true)
	@Description("verify Login Page Title Test....")
	@Severity(SeverityLevel.NORMAL)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("login page title is : " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "title is not found...");
	}
	
	@Test(priority=2,enabled = false)
	@Description("verify Sign up link Test case....")
	@Severity(SeverityLevel.CRITICAL)
	public void verifySignUpLinkTest(){
		System.out.println("verify Sign up link Test case....");
		Assert.assertTrue(loginPage.checkSignUpLink(), "sign up link is not present....");
	}
	
	@Test(priority=3,enabled = false)
	@Description("verify user is able to Login - feature Test....")
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest(){
		System.out.println("verify Login Test case....");
		HomePage homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(homePage.getAccountName(), prop.getProperty("accountname"), "login is failed.....");
		System.out.println("end of Login Test case....");

	}
	

	@AfterTest
	public void tearDown() {
		System.out.println("close the browser");
		driver.quit();
	}

}
