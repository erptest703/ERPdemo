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

public class JunitloginValid {

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
  public void ValidDataChk() throws InterruptedException
  {
	  driver.findElement(By.linkText("Login")).click();
		
		
	    // Thread.sleep(2000);
		// check for valid data
		driver.findElement(By.name("user_login")).sendKeys("testing");// enter in login text box.
		driver.findElement(By.name("user_password")).sendKeys("pxkP3RtPe(X8cWIrlzV)5plu");// enter in password text box.
		driver.findElement(By.id("rememberme")).click();

		driver.findElement(By.id("wp-submit")).click();
  }
	
	


	@AfterClass
	public static void teardown() {
		driver.close();
	}
}
