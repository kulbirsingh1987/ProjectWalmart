package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClasses.BaseClass;
import PageObjects.HomePage;
import PageObjects.LoginPO;
import PageObjects.SearchAndAddToCartPO;
import Utilities.BrowserBasics;
import Utilities.ExcelUtil;

public class SearchAndAddToCartTestCases extends BaseClass {

	LoginPO lp;
	ExcelUtil e;
	HomePage hp;
	SearchAndAddToCartPO searchAndCart;
	public SearchAndAddToCartTestCases() {
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
		searchAndCart = new SearchAndAddToCartPO();
	
	}
	
	@Test(description ="TC_46 To Verify That User is able to add a single item In cart")
	public void tc_46_verifySingleItemInCart() {
		int itemInCartBefore = searchAndCart.verifyCart();
		hp.searchItem("Camera");
		searchAndCart.addItemInCart(1);
		BrowserBasics.takeScreenshotAtEndOfTest("TC_46");
		Assert.assertEquals(searchAndCart.verifyCart(), itemInCartBefore+1);
		
	}
	@Test(description = "TC_47 To verify if user is able to delete a single item from cart")
	public void tc_47_validateRemoveCartSingleItem() {
		int itemInCartBefore = searchAndCart.verifyCart();
		searchAndCart.clickCart();
		searchAndCart.removeCartItem(1);
		BrowserBasics.takeScreenshotAtEndOfTest("TC_47");
		Assert.assertEquals(searchAndCart.verifyCart(), itemInCartBefore-1);
	}
	@Test(description ="TC_48 To Verify That User is able to add multiple item In cart")
	public void tc_48_verifymultipleItemInCart() {
		int itemInCartBefore = searchAndCart.verifyCart();
		hp.searchItem("Camera");
		searchAndCart.addItemInCart(4);
		BrowserBasics.takeScreenshotAtEndOfTest("TC_48");
		Assert.assertEquals(searchAndCart.verifyCart(), itemInCartBefore+4);
		
	}
	@Test(description = "TC_49 To verify if user is able to delete multiple from cart")
	public void tc_49_validateRemoveCartMultiIpletem() {
		int itemInCartBefore = searchAndCart.verifyCart();
		searchAndCart.clickCart();
		searchAndCart.removeCartItem(4);
		BrowserBasics.takeScreenshotAtEndOfTest("TC_49");
		Assert.assertEquals(searchAndCart.verifyCart(), itemInCartBefore-4);
	}
	
	@Test(description = "TC_50 To verify if cart is empty user is able to see the start shopping button")
	public void tc_50_verifyStartShoppingButtonInEmptyCart() {
		searchAndCart.clickCart();
		BrowserBasics.takeScreenshotAtEndOfTest("TC_50");
		Assert.assertTrue(searchAndCart.validateStartShopping());
	}
	
	@Test(description = "TC_51 To verify if cart is empty user is able to see the start shopping button")
	public void tc_51_verifyShopRollbackButtonInEmptyCart() {
		searchAndCart.clickCart();
		BrowserBasics.takeScreenshotAtEndOfTest("TC_51");
		Assert.assertTrue(searchAndCart.validateShopRollback());
	}
	
	@Test(description = "TC_52 To verify if cart is empty Proceed checkout button should be disabled")
	public void tc_52_verifproceedCheckoutEmptyCart() {
		searchAndCart.clickCart();
		BrowserBasics.takeScreenshotAtEndOfTest("TC_52");
		Assert.assertFalse(searchAndCart.validateProceedCheckout());
	}
	
	@Test(description = "TC_53 To verify if cart is empty Proceed checkout button should be disabled")
	public void tc_53_verifproceedCheckoutEmptyCart() {
		searchAndCart.clickCart();
		BrowserBasics.takeScreenshotAtEndOfTest("TC_53");
		Assert.assertFalse(searchAndCart.validateProceedCheckout());
	}
	
	@Test(description = "TC_54 To veriry if user click on edit button then user is able to see update button on shopping cart button")
	public void tc_54_validateEditbuttonCart() {
		searchAndCart.clickCart();
		searchAndCart.clickEditButton();
		BrowserBasics.takeScreenshotAtEndOfTest("TC_54");
		Assert.assertTrue(searchAndCart.validateUpdateButton());
	}
	
	@Test(description = "TC_55 To veriry if user click on edit button then user is able to see cancel button on shopping cart button")
	public void tc_55_validateCancelbuttonCart() {
		searchAndCart.clickCart();
		searchAndCart.clickEditButton();
		BrowserBasics.takeScreenshotAtEndOfTest("TC_55");
		Assert.assertTrue(searchAndCart.validateCancelButton());
	}
	
	@Test(description = "TC_56 To verify when user click on proceed to checkout button user is able to navigate on secure checkout page")
	public void tc_56_CheckoutProducts() {
		hp.searchItem("Camera");
		searchAndCart.addItemInCart(1);
		searchAndCart.clickCart();
		searchAndCart.proceedCheckoutButton();
		BrowserBasics.takeScreenshotAtEndOfTest("TC_56");
		Assert.assertTrue(searchAndCart.validateSecureCheckoutText());
	}
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
}
