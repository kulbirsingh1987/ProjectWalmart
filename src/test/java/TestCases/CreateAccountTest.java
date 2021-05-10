package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseClasses.BaseClass;
import PageObjects.CreateAccountPO;
import Utilities.BrowserBasics;
import Utilities.ExcelUtil;

public class CreateAccountTest extends BaseClass {

	CreateAccountPO cao;
	ExcelUtil e;

	public CreateAccountTest() {
		super();
	}

	@BeforeMethod
	public void init() {

		initialize();
		driver.get(prop.getProperty("url"));
		cao = new CreateAccountPO();
		e = new ExcelUtil();

	}
	
	

	@Test(description = "TC_1 This test case is to Verify If user landed on create account page")
	public void tc_1validateCreateAccountPage()  {

		BrowserBasics.takeScreenshotAtEndOfTest("TC_1");
		Assert.assertEquals(cao.returnTitle(), "Walmart Canada",
				"Test case failed: As user is not able to see the title as Walmart Canada");
	}
	@Test(description = "TC_2 To Check the functionality When user enter First name field with valid data No error occur")
	public void tc_2validateValidDataFirstName() {

		String fname =e.returnExcelData(1, 0);
		cao.enterFirstName(fname);
		cao.enterlastName("");
		BrowserBasics.takeScreenshotAtEndOfTest("TC_2");
		Assert.assertFalse(cao.validateFnameErrorMsg());
	}

	@Test(description = "TC_3 This test case is to verify the Error message if first name is of less then 2 char")
	public void tc_3_validateErrorMessageWithLessThen2Char() {

		String fname =e.returnExcelData(2, 0);
		cao.enterFirstName(fname);
		cao.enterlastName("");
		BrowserBasics.takeScreenshotAtEndOfTest("TC_3");
		Assert.assertTrue(cao.validateFnameErrorMsg());
	}
	@Test(description = "TC_4 This test case is to verify the Error message if First name field left black.")
	public void tc_4_validateErrorMessageWithFieldLEft() {

		String fname =e.returnExcelData(3, 0);
		cao.enterFirstName(fname);
		cao.enterlastName("");
		BrowserBasics.takeScreenshotAtEndOfTest("TC_4");
		Assert.assertTrue(cao.validateBlankFnameErrorMsg());
	}
	@Test(description = "TC_5 This test case is to verify the Error message if First name field with alpha Numeric characters.")
	public void tc_5_validateErrorMessageWithAlphaNum() {

		String fname =e.returnExcelData(4, 0);
		cao.enterFirstName(fname);
		cao.enterlastName("");
		BrowserBasics.takeScreenshotAtEndOfTest("TC_5");
		Assert.assertTrue(cao.validateFnameErrorMsg());
	}
	@Test(description = "TC_6 This test case is to verify the Error message if First name field with alpha Numeric Special characters.")
	public void tc_6_validateErrorMessageWithAlphaNumSpecialChar() {

		String fname =e.returnExcelData(5, 0);
		cao.enterFirstName(fname);
		cao.enterlastName("");
		BrowserBasics.takeScreenshotAtEndOfTest("TC_6");
		Assert.assertTrue(cao.validateFnameErrorMsg());
	}
	@Test(description = "TC_7 This test case is to verify the Error message if  First name field starting with a space.")
	public void tc_7_validateErrorMessageWithFirstCharAsSpace() {

		String fname =e.returnExcelData(6, 0);
		cao.enterFirstName(fname);
		cao.enterlastName("");
		BrowserBasics.takeScreenshotAtEndOfTest("TC_7");
		Assert.assertFalse(cao.validateFnameErrorMsg());
	}
	
	
	
	
	
	@Test(description = "TC_8 To Check the functionality When user enter Last name field with valid data ,No error occur")
	public void tc_8_validateValidDataLastName() {

		String lname =e.returnExcelData(1, 1);
		cao.enterlastName(lname);
		cao.enterFirstName("");
		
		BrowserBasics.takeScreenshotAtEndOfTest("TC_8");
		Assert.assertFalse(cao.validateLnameErrorMsg());
	}

	@Test(description = "TC_9 This test case is to verify the Error message if user enter Last name is of less then 2 char")
	public void tc_9_validateErrorMessageWithLessThen2CharInLastName() {

		String lname =e.returnExcelData(2, 1);
		cao.enterlastName(lname);
		cao.enterFirstName("");
		BrowserBasics.takeScreenshotAtEndOfTest("TC_9");
		Assert.assertTrue(cao.validateLnameErrorMsg());
	}
	@Test(description = "TC_10 This test case is to verify the Error message if Last name field left black.")
	public void tc_10_validateErrorMessageWithFieldLeftInLastName() {

		String lname =e.returnExcelData(3, 1);
		cao.enterlastName(lname);
		cao.enterFirstName("");
		BrowserBasics.takeScreenshotAtEndOfTest("TC_10");
		Assert.assertTrue(cao.validateBlankLnameErrorMsg());
	}
	@Test(description = "TC_11 This test case is to verify the Error message if user enter Last name field  alpha Numeric characters.")
	public void tc_11_validateErrorMessageWithAlphaNumInLastName() {

		String lname =e.returnExcelData(4, 1);
		cao.enterlastName(lname);
		cao.enterFirstName("");
		BrowserBasics.takeScreenshotAtEndOfTest("TC_11");
		Assert.assertTrue(cao.validateLnameErrorMsg());
	}
	@Test(description = "TC_12 This test case is to verify the Error message if user enter Last name field alpha Numeric Special characters.")
	public void tc_12_validateErrorMessageWithAlphaNumSpecialCharInLastName() {

		String lname =e.returnExcelData(5, 1);
		cao.enterlastName(lname);
		cao.enterFirstName("");
		BrowserBasics.takeScreenshotAtEndOfTest("TC_12");
		Assert.assertTrue(cao.validateLnameErrorMsg());
	}
	@Test(description = "TC_13 This test case is to verify the Error message if user enter Last name field starting with a space.")
	public void tc_13_validateErrorMessageWithFirstCharAsSpaceInLastName() {

		String lname =e.returnExcelData(6, 1);
		cao.enterlastName(lname);
		cao.enterFirstName("");
		BrowserBasics.takeScreenshotAtEndOfTest("TC_13");
		Assert.assertFalse(cao.validateLnameErrorMsg());
	}
	
	
	@Test(description = "TC_14 Checking functionality of phone number field with valid data .")
	public void tc_14_checkValidPhnNumber() {

		String phnNum =e.returnExcelData(1, 2);
		cao.enterPhoneNumber(phnNum);
		cao.enterFirstName("");
		BrowserBasics.takeScreenshotAtEndOfTest("TC_14");
		Assert.assertFalse(cao.validatePhnNumErrorMsg());
	}
	@Test(description = "TC_15 Checking functionality of phone number field with invalid data less than 10 digits .")
	public void tc_15_checkInvalidPhnNumber() {

		String phnNum =e.returnExcelData(2, 2);
		cao.enterPhoneNumber(phnNum);
		cao.enterFirstName("");
		BrowserBasics.takeScreenshotAtEndOfTest("TC_15");
		Assert.assertTrue(cao.validatePhnNumErrorMsg());
	}
	@Test(description = "TC_16 Checking functionality of phone number field with invalid data More than 10 digits .")
	public void tc_16_checkInvalidPhnNumber11Digit() {

		String phnNum =e.returnExcelData(3, 2);
		cao.enterPhoneNumber(phnNum);
		cao.enterFirstName("");
		BrowserBasics.takeScreenshotAtEndOfTest("TC_16");
		Assert.assertTrue(cao.validatePhnNumErrorMsg());
	}
	
	@Test(description = "TC_17 Checking functionality of phone number field with invalid data starting with space .")
	public void tc_17_checkInvalidPhnNumberStartWithBlank() {

		String phnNum =e.returnExcelData(4, 2);
		cao.enterPhoneNumber(phnNum);
		cao.enterFirstName("");
		BrowserBasics.takeScreenshotAtEndOfTest("TC_17");
		Assert.assertTrue(cao.validatePhnNumErrorMsg());
	}
	
	
	
	
	
	
	
	
	@Test(description = "TC_18 Checking functionality of email field with valid data.")
	public void tc_18_checkValidEmail() {

		String email =e.returnExcelData(1, 3);
		cao.enterEmail(email);
		cao.enterFirstName("");
		BrowserBasics.takeScreenshotAtEndOfTest("TC_18");
		Assert.assertFalse(cao.validatEmailErrorMsg());
	}
	@Test(description = "TC_19 Checking functionality of email field with invalid data.")
	public void tc_19_checkInvalidEmail() {

		String email =e.returnExcelData(2, 3);
		cao.enterEmail(email);
		cao.enterFirstName("");
		BrowserBasics.takeScreenshotAtEndOfTest("TC_19");
		Assert.assertTrue(cao.validatEmailErrorMsg());
	}
	@Test(description = "TC_20 Checking functionality of email field with data starting with a space.")
	public void tc_20_checkInvalidEmailWithStartingSpace() {

		String email =e.returnExcelData(3, 3);
		cao.enterEmail(email);
		cao.enterFirstName("");
		BrowserBasics.takeScreenshotAtEndOfTest("TC_20");
		Assert.assertFalse(cao.validatEmailErrorMsg());
	}
	
	@Test(description = "TC_21 Checking functionality of blank email field.")
	public void tc_21_checkInvalidEmailWithBlank() {

		String email =e.returnExcelData(4, 3);
		cao.enterEmail(email);
		cao.enterFirstName("");
		BrowserBasics.takeScreenshotAtEndOfTest("TC_21");
		Assert.assertTrue(cao.validatEmailErrorMsg());
	}
	
	
	@Test(description = "TC_23 Checking functionality of password field with no data.")
	public void tc_23_checkValidPassword() {

		String pwd =e.returnExcelData(1, 4);
		cao.enterPassword(pwd);
		cao.enterFirstName("");
		BrowserBasics.takeScreenshotAtEndOfTest("TC_23");
		Assert.assertTrue(cao.validateBlankPwdErrorMsg());
	}
	
	@Test(description = "TC_25 Checking functionality of password field for password strenght with combination of charanters, numbers and special characters.")
	public void tc_25_checkValidPasswordWithSpecialCharNumber() {

		String pwd =e.returnExcelData(2, 4);
		cao.enterPassword(pwd);
		cao.enterFirstName("");
		
		BrowserBasics.takeScreenshotAtEndOfTest("TC_25");
		Assert.assertTrue(cao.getPwdStrength().contains("strong"));
	}
	
	@Test(description = "TC_26 Checking functionality of password field for password strenght with combination of charanters and special characters.")
	public void tc_26_checkValidPasswordWithSpecialChar() {

		String pwd =e.returnExcelData(3, 4);
		cao.enterPassword(pwd);
		cao.enterFirstName("");
		
		BrowserBasics.takeScreenshotAtEndOfTest("TC_26");
		Assert.assertTrue(cao.getPwdStrength().contains("strong"));
	}
	@Test(description = "TC_27 Checking functionality of password field for password strenght with just character input.")
	public void tc_27_checkValidPasswordWithChar() {

		String pwd =e.returnExcelData(4, 4);
		cao.enterPassword(pwd);
		cao.enterFirstName("");
		
		BrowserBasics.takeScreenshotAtEndOfTest("TC_27");
		Assert.assertTrue(cao.getPwdStrength().contains("moderate"));
	}
	@Test(description = "TC_30 Checking functionality of password with less than 6 characters.")
	public void tc_30_checkValidPasswordWithChar() {

		String pwd =e.returnExcelData(5, 4);
		cao.enterPassword(pwd);
		cao.enterFirstName("");		
		BrowserBasics.takeScreenshotAtEndOfTest("TC_30");
		Assert.assertTrue(cao.getPwdStrength().contains("weak"));
	}
	
	@Test(description = "TC_31 To verify user is able to create account without select the check box about \"Email me about Flyers, rollback & clearance selection\"  .")
	public void tc_31_createAccountWithoutselectOptionalCheckbox() throws InterruptedException {
		String fname =e.returnExcelData(1, 0);
		String lname =e.returnExcelData(1, 1);
		String phnNum =BrowserBasics.generateRandomStrings(10,"Number");
		String email =BrowserBasics.generateRandomStrings(8, "string") + "@yopmail.com";
		String pwd =e.returnExcelData(2, 4);
		cao.enterFirstName(fname);
		cao.enterlastName(lname);
		cao.enterPhoneNumber(phnNum);
		cao.enterEmail(email);
		cao.enterPassword(pwd);
		
		
		cao.clickAgreementCheckbox();
		
		cao.clickCreateAccount();
		Thread.sleep(10000);
		
		BrowserBasics.takeScreenshotAtEndOfTest("TC_31");
		Assert.assertTrue(driver.getCurrentUrl().contains("my-account"));
	}
	@Test(description = "TC_32 Checking functionality of Terms and conditions check box by clicking on it.")
	public void tc_32_createAccountWithoutselectOptionalCheckbox() throws InterruptedException {
		String fname =e.returnExcelData(1, 0);
		String lname =e.returnExcelData(1, 1);
		String phnNum =BrowserBasics.generateRandomStrings(10,"Number");
		String email =BrowserBasics.generateRandomStrings(8, "string") + "@yopmail.com";
		String pwd =e.returnExcelData(2, 4);
		cao.enterFirstName(fname);
		cao.enterlastName(lname);
		cao.enterPhoneNumber(phnNum);
		cao.enterEmail(email);
		cao.enterPassword(pwd);
		
		
		cao.clickAgreementCheckbox();
		
		cao.clickCreateAccount();
		Thread.sleep(10000);
		
		BrowserBasics.takeScreenshotAtEndOfTest("TC_32");
		Assert.assertTrue(driver.getCurrentUrl().contains("my-account"));
	}
	@Test(description = "TC_33 Checking functionality of Terms and conditions check box by not clicking on it.")
	public void tc_33_createAccountWithoutselectOptionalCheckbox() throws InterruptedException {
		String fname =e.returnExcelData(1, 0);
		String lname =e.returnExcelData(1, 1);
		String phnNum =BrowserBasics.generateRandomStrings(10,"Number");
		String email =BrowserBasics.generateRandomStrings(8, "string") + "@yopmail.com";
		String pwd =e.returnExcelData(2, 4);
		cao.enterFirstName(fname);
		cao.enterlastName(lname);
		cao.enterPhoneNumber(phnNum);
		cao.enterEmail(email);
		cao.enterPassword(pwd);
		
		cao.clickCreateAccount();
	
		BrowserBasics.takeScreenshotAtEndOfTest("TC_33");
		Assert.assertTrue(cao.validateAgreementErrMsg());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
