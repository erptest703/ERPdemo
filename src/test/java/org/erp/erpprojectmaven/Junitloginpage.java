package packageLMS;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Junitloginpage {

	public static WebDriver driver;

	public static WebDriverWait wait;

	@BeforeClass
	public static void setup() {
		String Chromepath = "C:\\Users\\isham\\OneDrive\\ERP training\\chromedriver_win32\\\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", Chromepath);
		driver = new ChromeDriver();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://sethuonline.com/lms");
		driver.manage().window().maximize();

	}

	@Test
	public void InvalidDataCheck() throws InterruptedException {
		WebElement Loginclk = driver.findElement(By.linkText("Login"));
		Loginclk.click();

		// check for invalid data
		WebElement Usertx = driver.findElement(By.name("user_login"));
		Usertx.sendKeys("test");// enter in login text box.
		WebElement pwdtx = driver.findElement(By.name("user_password"));
		pwdtx.sendKeys("erp");// enter in password text box.
		WebElement submitBt = driver.findElement(By.id("wp-submit"));
		submitBt.click();

		WebElement error1 = driver.findElement(By.xpath("//*[@id=\"thim-popup-login\"]/div/div/p"));// xpath of error
		System.out.println(error1.getText());
		String errormsg = error1.getText();
		String actualerror = "ERROR: Invalid username or email.";
		if (errormsg.equalsIgnoreCase(actualerror)) {
			Usertx.clear();
			pwdtx.clear();
		
		}
	}
	
	
	@Test
	public void getTitle1() {
		String expectedTitle = driver.getTitle();
		String actualTitle = "e-learning LMS – Knowledge Fruit";
		assertEquals(expectedTitle, actualTitle);

	}

	@AfterClass
	public static void teardown() {
		driver.close();
	}
}
