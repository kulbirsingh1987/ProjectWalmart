package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClasses.BaseClass;
import Utilities.BrowserBasics;

public class HomePage extends BaseClass {

	@FindBy(xpath = "//a[@data-automation='sign-in-container']")
	WebElement myAccountBtn;

	@FindBy(xpath = " //a[contains(text(),'My recommendations')]")
	WebElement MyRecommendations;

	@FindBy(xpath = "//a[text()='My account']")
	WebElement myAccount;

	@FindBy(xpath = "//a[text()='My orders']")
	WebElement myOrders;
	
	@FindBy(xpath = "//button[text()='Start shopping']")
	WebElement startShopping;
	
	@FindBy(xpath="//a[text()='Sign out']")
	WebElement signOut;
	
	@FindBy(xpath = "//div[contains (text(),'placed an order in a while.')]")
	WebElement placeOrderText;
	
	@FindBy(xpath = "//input[@placeholder='What are you looking for?']")
	WebElement searchBox;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchBtn;

	@FindBy(xpath = "//h1[@data-automation='search-term']")
	WebElement serachTerm;
	
	@FindBy(xpath = "//a[text()='Addresses']")
	WebElement address;
	
	public void clickAddress() {
		address.click();
	}
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void myRecommendationsClick() {
		BrowserBasics.mouseHover(myAccountBtn);
		MyRecommendations.click();
		
	}

	public void myAccountClick() {
		BrowserBasics.mouseHover(myAccountBtn);
		myAccount.click();
	}
	public void myOrderClick() {
		BrowserBasics.mouseHover(myAccountBtn);
		myOrders.click();
	}
	
	public void searchItem(String search) {
		searchBox.sendKeys(search);
		searchBtn.click();
	}
	
	public String validateSearch(String search) {
		searchBox.sendKeys(search);
		searchBtn.click();
		return serachTerm.getText();

	}
	
	public void clickSignOut() {
		BrowserBasics.mouseHover(myAccountBtn);
		signOut.click();
	}
	

	public String returnOrderPlacedText() {
		return placeOrderText.getText();
	}
	
}
