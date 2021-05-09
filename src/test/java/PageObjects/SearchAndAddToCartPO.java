package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClasses.BaseClass;
import Utilities.BrowserBasics;

public class SearchAndAddToCartPO extends BaseClass {

	@FindBy(xpath = "(//span[@data-automation='cart-count'])[2]")
	WebElement cartCount;

	@FindBy(xpath = "(//*[@id='cartoutline_a'])[2]/../../..")
	WebElement emptyCart;

	@FindBy(xpath = "//button[text()='Continue Shopping']")
	WebElement continueShopping;

	@FindBy(xpath = "//span[text()='Remove']")
	WebElement removeItems;

	@FindBy(xpath = "//button[text()='Start shopping']")
	WebElement startShopping;

	@FindBy(xpath = "//button[text()='Shop Rollback']")
	WebElement shopRollback;

	@FindBy(xpath = "(//button[text()='Proceed to checkout'])[1]")
	WebElement proceedToCheckout;

	@FindBy(xpath = "//span[text()='Your shopping cart is currently empty']")
	WebElement shoppingCartMsg;

	@FindBy(xpath = "//button[contains(@aria-label,'Edit postal')]")
	WebElement EditButton;

	@FindBy(xpath = "//button[text()='Update']")
	WebElement updateButton;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement cancelButton;

	@FindBy(xpath = "//h1[text()='Secure Checkout']")
	WebElement secureCheckout;
	public SearchAndAddToCartPO() {
		PageFactory.initElements(driver, this);
	}

	public void addItemInCart(int noOfItem) {
		List<WebElement> lst = driver.findElements(By.xpath("//button[text()='Add to cart']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		for (int i = 0; i < noOfItem; i++) {
			js.executeScript("arguments[0].scrollIntoView();", lst.get(i));
			lst.get(i).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			continueShopping.click();
		}

	}

	public int verifyCart() {
		try {
			String str = cartCount.getText();
			int i = Integer.parseInt(str);
			return i;
		} catch (Exception e) {
			return 0;
		}
	}

	public void clickCart() {
		try {
			cartCount.click();
		} catch (Exception e) {
			emptyCart.click();
		}
	}

	public void removeCartItem(int noOfItem) {
		List<WebElement> lst = driver.findElements(By.xpath("//span[text()='Remove']"));

		for (int i = 0; i < noOfItem; i++) {
			lst.get(i).click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public boolean validateStartShopping() {
		try {
			return startShopping.isDisplayed();

		} catch (Exception e) {
			return false;
		}
	}

	public boolean validateShopRollback() {
		try {
			shopRollback.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean validateProceedCheckout() {
		try {
			boolean flag = proceedToCheckout.isEnabled();
			System.out.println(flag);
			return flag;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean validateEmptyCartMsg() {
		try {
			boolean flag = shoppingCartMsg.isDisplayed();
			System.out.println(flag);
			return flag;
		} catch (Exception e) {
			return false;
		}
	}

	public void clickEditButton() {

		EditButton.click();
	}
	
	public void clickUpdateButton() {
		updateButton.click();
	}
	public void proceedCheckoutButton() {
		proceedToCheckout.click();
	}
	public boolean validateUpdateButton() {
		try {
			boolean flag = updateButton.isDisplayed();
			System.out.println(flag);
			return flag;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean validateCancelButton() {
		try {
			boolean flag = cancelButton.isDisplayed();
			System.out.println(flag);
			return flag;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean validateSecureCheckoutText() {
		try {
			boolean flag = secureCheckout.isDisplayed();
			System.out.println(flag);
			return flag;
		} catch (Exception e) {
			return false;
		}
	}

}
