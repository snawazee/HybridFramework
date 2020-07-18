package com.qa.linkedin.Tests;

import java.util.Properties;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.linkedin.Base.BasePage;
import com.qa.linkedin.Pages.HomePage;
import com.qa.linkedin.Pages.LandingPage;
import com.qa.linkedin.Pages.LoginPage;
import com.qa.linkedin.Utils.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic - Landing Page Test")
@Feature("US - Landing page feature design test")
public class LandingPageTest {

	Properties prop;
	WebDriver driver;

	BasePage basePage;
	LandingPage landingPage;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		landingPage = new LandingPage(driver);
	}

	
	@Test(priority=1, enabled=true)
	@Description("verify Landing Page Title Test....")
	@Severity(SeverityLevel.NORMAL)
	public void verifyLoginPageTitleTest() {
		String title = landingPage.getLoginPageTitle();
		System.out.println("login page title is : " + title);
		Assert.assertEquals(title, Constants.LANDING_PAGE_TITLE, "title is not found...");
	}
	
	@Test(priority=2,enabled = false)
	@Description("verify Logo Test case....")
	@Severity(SeverityLevel.CRITICAL)
	public void verifySignUpLinkTest(){
		System.out.println("verify Logo....");
		Assert.assertTrue(landingPage.checkLogo(), "sign up link is not present....");
	}


}
