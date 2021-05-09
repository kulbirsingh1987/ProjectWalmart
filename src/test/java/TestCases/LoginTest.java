package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClasses.BaseClass;
import PageObjects.CreateAccountPO;
import PageObjects.LoginPO;
import Utilities.BrowserBasics;
import Utilities.ExcelUtil;

public class LoginTest extends BaseClass {

	LoginPO lp;
	ExcelUtil e;

	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void init() {
		initialize();
		driver.get(prop.getProperty("SignURL"));
		lp = new LoginPO();
		e = new ExcelUtil();
	}

	@Test(description = "TC_34 To validate if user is able to login successfully")
	public void tc_34_validateLogin() throws InterruptedException {

		lp.login(prop.getProperty("userName"), prop.getProperty("password"));
		Thread.sleep(5000);
		BrowserBasics.takeScreenshotAtEndOfTest("TC_34");
		Assert.assertTrue(driver.getCurrentUrl().contains("my-account"));
	}

	@Test(description = "TC_35 To verify that user see a warning message if left the username field blank")
	public void tc_35_blankUserNameField() {
		lp.enterUserName("");
		lp.enterPassword("");
		BrowserBasics.takeScreenshotAtEndOfTest("TC_35");
		Assert.assertTrue(lp.validateEmailErrMsg());
	}

	@Test(description = "TC_36 To verify that user see a warning message if left the Password field blank")
	public void tc_36_blanPasswordNameField() {
		lp.enterPassword("");
		lp.enterUserName(prop.getProperty("userName"));

		BrowserBasics.takeScreenshotAtEndOfTest("TC_36");
		Assert.assertTrue(lp.validatepwdReqMsg());
	}

	@Test(description = "TC_37 To verify that user see a warning message if enter Invalid email Address")
	public void tc_37_invalidEmailAddressField() {
		lp.enterUserName(e.returnExcelData(1, 0));
		lp.enterPassword("");
		BrowserBasics.takeScreenshotAtEndOfTest("TC_37");
		Assert.assertTrue(lp.validateEmailErrMsg());
	}

	@Test(description = "TC_38 To verify that user see a warning message if enter Password less then 6 char")
	public void tc_38_invalidPasswordField() {
		lp.enterPassword(e.returnExcelData(1, 0));
		lp.enterUserName(prop.getProperty("userName"));

		BrowserBasics.takeScreenshotAtEndOfTest("TC_38");
		Assert.assertTrue(lp.validatepwdLessThen6Char());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
