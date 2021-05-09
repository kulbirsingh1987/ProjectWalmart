package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClasses.BaseClass;

public class LoginPO extends BaseClass {

	@FindBy(xpath = "//a[text()='Sign in']")
	WebElement signIn;
	@FindBy(id = "username")
	WebElement UserName;
	@FindBy(id = "password")
	WebElement Password;
	@FindBy(xpath = "//button[text()='Sign in']")
	WebElement login;
	@FindBy(xpath = "//span[text()='My account']")
	WebElement myAccount;
	
	@FindBy(xpath="//span[text()='Please enter a valid email address or phone number.']")
	WebElement emailErrMsg;
	@FindBy(xpath="//span[text()='Password is a required field.']")
	WebElement pwdReqMsg;
	@FindBy(xpath="//span[text()='Your password must be at least 6 characters long.']")
	WebElement pwdLessThen6Char;
	
	
	public LoginPO() {
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String uname) {
		UserName.sendKeys(uname);
	}
	
	public void enterPassword(String pwd) {
		Password.sendKeys(pwd);
	}
	public HomePage login(String uname, String pwd) {
		
		
			UserName.sendKeys(uname);
			Password.sendKeys(pwd);
			login.click();
			return new HomePage();
	
	}
	
	public boolean validateEmailErrMsg() {
		try {
			emailErrMsg.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean validatepwdReqMsg() {
		try {
			pwdReqMsg.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean validatepwdLessThen6Char() {
		try {
			pwdLessThen6Char.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
