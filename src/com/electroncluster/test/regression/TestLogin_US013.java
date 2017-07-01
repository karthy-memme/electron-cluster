package com.electroncluster.test.regression;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.electroncluster.test.config.CreateWebDriver;
import com.electroncluster.ui.LoginPage;

public class TestLogin_US013 
{
	WebDriver driver;
	LoginPage login;
	
	@BeforeMethod
	public void setUp()
	{
		driver = CreateWebDriver.instance();
		login = new LoginPage(driver);
	}
	@Test
	public void testLoginInvaildTC_054()
	{
		login.waitForLoginPageToLoad();
		login.getUsernameTextbox().sendKeys("admin");
		login.getPasswordTextbox().sendKeys("gdgdgdg");
		login.getLoginButton().click();
		String actualErrMsg = login.getErrorMsg().getText();
		String expectedErrMsg = 
				"Username or Password is invalid. Please try again.";
		Assert.assertEquals(actualErrMsg, expectedErrMsg);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
