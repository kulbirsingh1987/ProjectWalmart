package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClasses.BaseClass;
import PageObjects.HomePage;
import PageObjects.LoginPO;
import Utilities.BrowserBasics;
import Utilities.ExcelUtil;

public class HomeTest  extends BaseClass {

	
	LoginPO lp;
	ExcelUtil e;
	HomePage hp;

	public HomeTest() {
		super();
	}

	@BeforeMethod
	public void init() throws InterruptedException {
		initialize();
		navigateLogin();
		
		lp= new LoginPO();
		
		hp=lp.login(prop.getProperty("userName"), prop.getProperty("password"));
		Thread.sleep(5000);
		e = new ExcelUtil();
		navigateHome();
	
	}
	
	
	@Test(description = "TC_40 To verify user navigate to My recommendations page when click on my recommendations")
	public void tc_40_NavigateMyRecommendations() {
		hp.myRecommendationsClick();		
		BrowserBasics.takeScreenshotAtEndOfTest("TC_40");
		Assert.assertTrue(driver.getCurrentUrl().contains("recommendations"));
	}
	
	
	@Test(description = "TC_41 To Validate if user is able to see the searched item in search result")
	public void tc_41_validateSearchedItemByText() {
		String str = hp.validateSearch("camera");
		BrowserBasics.takeScreenshotAtEndOfTest("TC_41");
		Assert.assertEquals("camera", str);
	}
	@Test(description = "TC_42 To Validate if user is able to search an item by Item Number")
	public void tc_42_validateSearchedItemByItemNumber() {
		String str = hp.validateSearch("1015164");
		BrowserBasics.takeScreenshotAtEndOfTest("TC_42");
		Assert.assertEquals("1015164", str);
	}
	
	@Test(description = "TC_43 To verify if user is able to navigate on My Account page")
	public void tc_43_verifyNavigationOnMyAccountPage() {
		hp.myAccountClick();
		BrowserBasics.takeScreenshotAtEndOfTest("TC_43");
		Assert.assertEquals(hp.returnOrderPlacedText(),"You haven't placed an order in a while.");
	}
	@Test(description = "TC_44 To Verify that user is able to navigate on My Order Page")
	public void tc_44_verifyMyOrderNavigate() {
		hp.myOrderClick();
		BrowserBasics.takeScreenshotAtEndOfTest("TC_44");
		Assert.assertTrue(driver.getCurrentUrl().contains("order-history"));
	}
	
	@Test(description = "TC_45 To verify if user is able to logout after click on Sign Out link")
	public void tc_45_validateSignOut() {
		hp.clickSignOut();
		BrowserBasics.takeScreenshotAtEndOfTest("TC_45");
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.walmart.ca/en");
	}
	
	@Test(description = "TC_57 To verify if user is able to navigate on Address Page")
	public void tc_57_VerifyNavigateAddressPage() {
		hp.clickAddress();
		BrowserBasics.takeScreenshotAtEndOfTest("TC_57");
		Assert.assertEquals(driver.getCurrentUrl(),"/addresses");
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}
