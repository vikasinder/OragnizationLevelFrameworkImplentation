package com.mystore.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.Base.BaseClass;
import com.mystore.PageObjects.AddToCartPage;
import com.mystore.PageObjects.IndexPage;
import com.mystore.PageObjects.SearchResultPage;
import com.mystore.dataproviders.DataProviders;
import com.mystore.utility.Logs;

public class AddToCartPageTest extends BaseClass{
	
	private IndexPage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchApp(browser); 
		
	}

	
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Regression","Sanity"}, dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void addToCartTest(String Pname,String Pqty,String Psize) throws Throwable {
		Logs.startTestCase("addToCartTest");
		index= new IndexPage();
		searchResultPage=index.searchProduct(Pname);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(Pqty);
		addToCartPage.selectSize(Psize);
		addToCartPage.clickOnAddToCart();
		boolean result=addToCartPage.validateAddtoCart();
		Assert.assertTrue(result);
		Logs.endTestCase("addToCartTest");
		
	}

}
