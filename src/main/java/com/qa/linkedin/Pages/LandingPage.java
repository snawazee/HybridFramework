package com.qa.linkedin.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.linkedin.Base.BasePage;
import com.qa.linkedin.Utils.Constants;
import com.qa.linkedin.Utils.ElementUtil;

import io.qameta.allure.Step;

public class LandingPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	// 1. By locators:
	By username = By.id("username");
	By password = By.id("password");
	By loginButton = By.id("loginBtn");
	By signUpLink = By.linkText("Sign up");
	

	// 2. constructor of the page class:

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	// 3. page actions/methods:
	@Step("get login page title...")
	public String getLoginPageTitle() {
		return elementUtil.waitForTitleToBePresent(Constants.LOGIN_PAGE_TITLE, 10);
	}

	@Step("check sign up link on login page...")
	public boolean checkLogo() {
		return elementUtil.doIsDisplayed(signUpLink);
	}

}
