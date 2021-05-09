package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClasses.BaseClass;
import Utilities.BrowserBasics;

public class CreateAccountPO extends BaseClass {

	@FindBy(id = "firstName")
	WebElement firstName;

	@FindBy(id = "lastName")
	WebElement lastName;

	@FindBy(id = "phoneNumber")
	WebElement phoneNumber;
	
	@FindBy(id = "email")
	WebElement email;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(xpath = "//button[text()='Create account']")
	WebElement createAccount;
	
	@FindBy(xpath= "//a[text()='Sign in']")
	WebElement signIn;
	
	
	@FindBy(xpath="//*[contains(text(),'you are confirming that')]")
	WebElement agreementCheckBox;
	
	@FindBy(xpath = "//span[text()='Please enter a valid first name.']")
	WebElement firstNameErrorMsg;

	@FindBy(xpath = "//span[text()='Please enter a valid last name.']")
	WebElement lastNameErrorMsg;
	@FindBy(xpath = "//span[text()='Please enter your first name.']")
	WebElement fnameMsg;

	@FindBy(xpath = "//span[text()='Please enter your last name.']")
	WebElement lnameMsg;

	@FindBy(xpath = "//span[text()='Please enter a valid email address.']")
	WebElement emailErrMsg;
	@FindBy(xpath = "//span[text()='Please enter a valid phone number.']")
	WebElement phoneErrMsg;
	
	@FindBy(xpath = "//span[text()='Password is a required field.']")
	WebElement pwdBlankErrMsg;
	@FindBy(xpath = "//span[text()='Your password must be at least 6 characters long.']")
	WebElement pwdErrMsgLessChar;
	
	@FindBy(xpath="//div[@class='password-strength-label']/span")
	WebElement pwdStrength;
	
	@FindBy(xpath = "//div[text()='You must read and accept Walmart’s Terms of Use to subscribe.']")
	WebElement AgreementErrMsg	;
	
	public CreateAccountPO() {
		PageFactory.initElements(driver, this);
	}

	public void randomClick() {
		firstName.click();
	}
	public String returnTitle() {
		return driver.getTitle();
	}

	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void enterlastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void enterEmail(String eml) {
		email.sendKeys(eml);
	}

	public void enterPhoneNumber(String phnNum) {
		phoneNumber.sendKeys(phnNum);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void clickCreateAccount() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",signIn);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		createAccount.click();
	}
	public void clickAgreementCheckbox() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",agreementCheckBox);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		agreementCheckBox.click();
	}
	
	public boolean validateFnameErrorMsg() {
		try {
			firstNameErrorMsg.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean validateBlankFnameErrorMsg() {
		try {
			fnameMsg.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean validateLnameErrorMsg() {
		try {
			lastNameErrorMsg.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean validateBlankLnameErrorMsg() {
		try {
			lnameMsg.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean validatEmailErrorMsg() {
		try {
			emailErrMsg.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean validatePhnNumErrorMsg() {
		try {
			phoneErrMsg.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean validateBlankEmailErrorMsg() {
		try {
			lnameMsg.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean validateBlankPwdErrorMsg() {
		try {
			pwdBlankErrMsg.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean validateLessCharPwdErrorMsg() {
		try {
			pwdErrMsgLessChar.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean validateAgreementErrMsg() {
		try {
			AgreementErrMsg.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public String returnPwd() {
		return password.getAttribute("value");
	}
	
	public String getPwdStrength() {
		return pwdStrength.getText();
	}
}
