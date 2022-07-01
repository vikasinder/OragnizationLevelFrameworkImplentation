package com.mystore.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;

import com.mystore.Base.BaseClass;
import com.mystore.actiondriver.Action;

public class IndexPage extends BaseClass {
	
	Action action= new Action();

//	@FindBy(xpath = "//a[@class='login']") 
//	private WebElement signInBtn;
//	
//	@FindBy(xpath = "//img[@class='logo img-responsive']")
//	private WebElement myStoreLogo;
//	
//	@FindBy(id="search_query_top")
//	private WebElement searchProductBox;
//	
//	@FindBy(name="submit_search")
//	private WebElement searchButton;
//	
//	
//	public IndexPage() {
//		PageFactory.initElements(driver, this);
//	}
//	
	private	WebElement signInBtn=getDriver().findElement(By.xpath("//a[@class='login']"));
	private	WebElement myStoreLogo=getDriver().findElement(By.xpath("//img[@class='logo img-responsive']"));
	private	WebElement searchProductBox=getDriver().findElement(By.id("search_query_top"));
	private	WebElement searchButton=getDriver().findElement(By.name("submit_search"));
	
	public LoginPage clickOnSignIn() throws Throwable {
	//	Action.fluentWait(driver, signInBtn, 10);
	
		signInBtn.click();
		//Action.click(driver, signInBtn);
		return new LoginPage();
	}
	
//	public boolean validateLogo() throws Throwable {
//		return Action.isDisplayed(driver, myStoreLogo);
//	}
//	
	public boolean validateLogo() throws Throwable {
		return myStoreLogo.isDisplayed();
	}
//	
	public String getMyStoreTitle() {
		String myStoreTitel=getDriver().getTitle();
		return myStoreTitel;
	}
	
	public SearchResultPage searchProduct(String productName) throws Throwable {
		action.type(searchProductBox, productName);
		action.scrollByVisibilityOfElement(getDriver(), searchButton);
		action.click(getDriver(), searchButton);
		Thread.sleep(2000);
		return new SearchResultPage();
	}

}
