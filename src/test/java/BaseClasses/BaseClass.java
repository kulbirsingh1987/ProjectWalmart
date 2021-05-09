package BaseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

	public BaseClass() {
		prop = new Properties();
		File f = new File(".//Configuration.properties");
		try {
			FileInputStream fis = new FileInputStream(f);
			prop.load(fis);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	public void navigateLogin() {
		driver.get(prop.getProperty("SignURL"));
	}
	public void navigateHome() {
		
		driver.get("https://www.walmart.ca/en");	
	}

	public void initialize() {
		String bName = prop.getProperty("browser");
		if (bName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
			driver= new ChromeDriver();
		}	
		
		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}

}
