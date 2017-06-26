package com.electroncluster.test.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.electroncluster.test.config.CreateWebDriver;
import com.electroncluster.ui.HomePage;
import com.electroncluster.ui.LoginPage;

public class TestLoginUS012
{
	WebDriver driver;
	LoginPage login;
	HomePage home;
	@BeforeMethod
	public void setUp()
	{
		driver = CreateWebDriver.instance();
		login = new LoginPage(driver);
		home = new HomePage(driver);
	}
	@Test
	public void testLoginTC053()
	{
		login.waitForLoginPageToLoad();
		login.getUsernameTextbox().sendKeys("admin");
		login.getPasswordTextbox().sendKeys("manager");
		login.getLoginButton().click();
		
		home.waitForHomePageToLoad();
		boolean acutalStatus = home.getLogoutButton().isDisplayed();
		boolean expectedStatus = true;
		Assert.assertEquals(acutalStatus, expectedStatus);
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
