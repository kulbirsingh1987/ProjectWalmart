package Utilities;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BaseClasses.BaseClass;

public class BrowserBasics extends BaseClass{
	
	

	public static void takeScreenshotAtEndOfTest(String str)  {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + str + "_" + System.currentTimeMillis() + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String generateRandomStrings(int length, String type) {
		StringBuilder sb = new StringBuilder(length);
		if (type.equalsIgnoreCase("Number")) {
			final String strg = "0123456789";
			SecureRandom rndm = new SecureRandom();
			for (int i = 0; i < length; i++)
				sb.append(strg.charAt(rndm.nextInt(strg.length())));
		} else if (type.equalsIgnoreCase("String")) {
			final String strg = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			SecureRandom rndm = new SecureRandom();
			for (int i = 0; i < length; i++)
				sb.append(strg.charAt(rndm.nextInt(strg.length())));
		} else if (type.equalsIgnoreCase("Alphanumeric")) {
			final String strg = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			SecureRandom rndm = new SecureRandom();
			for (int i = 0; i < length; i++)
				sb.append(strg.charAt(rndm.nextInt(strg.length())));
		} else {
			System.err.println("Wrong type declared.");
		}
		return sb.toString();
	}
	
	
	public static void mouseHover(WebElement target) {
		Actions act= new Actions(driver);
		act.moveToElement(target).build().perform();
	}
}
