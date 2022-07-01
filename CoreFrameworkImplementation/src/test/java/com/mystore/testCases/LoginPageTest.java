package com.mystore.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.Base.BaseClass;
import com.mystore.PageObjects.HomePage;
import com.mystore.PageObjects.IndexPage;
import com.mystore.PageObjects.LoginPage;
import com.mystore.dataproviders.DataProviders;
import com.mystore.utility.Logs;

public class LoginPageTest extends BaseClass {
	
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
		
	}

	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void loginTest(String uname,String pswd) throws Throwable {
		Logs.startTestCase("loginTest");
		indexPage= new IndexPage();
		Logs.info("user is going to click on SignIn");
		loginPage=indexPage.clickOnSignIn();
		Logs.info("Enter Username and Password");
	   // homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage=loginPage.login(uname,pswd,homePage);
	    String actualURL=homePage.getCurrURL();
	    String expectedURL="http://automationpractice.com/index.php?controller=my-account";
	    Logs.info("Verifying if user is able to login");
	    Assert.assertEquals(actualURL, expectedURL);
	    Logs.info("Login is Sucess");
	    Logs.endTestCase("loginTest");
	}

}
