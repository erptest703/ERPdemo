package packageLMS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;*/

public class loginPage {

	public static void main(String[] args) throws InterruptedException {

		String Chromepath = "C:\\Users\\isham\\OneDrive\\ERP training\\chromedriver_win32\\\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", Chromepath);
		WebDriver driver = new ChromeDriver();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://sethuonline.com/lms");
		driver.manage().window().maximize();

		//WebDriverWait wait = new WebDriverWait(driver, 20);// explicit wait
		driver.findElement(By.linkText("Login")).click();
		
		// check for invalid data
		driver.findElement(By.name("user_login")).sendKeys("test");// enter in login text box.
		driver.findElement(By.name("user_password")).sendKeys("erp");// enter in password text box.
		driver.findElement(By.id("wp-submit")).click();
		
		Thread.sleep(2000);
		WebElement error1 = driver.findElement(By.xpath("//*[@id=\"thim-popup-login\"]/div/div/p"));//xpath of error
		System.out.println(error1.getText());
		String errormsg = error1.getText();
		String actualerror = "ERROR: Invalid username or email.";
		if (errormsg.equalsIgnoreCase(actualerror))
		{
			driver.findElement(By.name("user_login")).clear();
			driver.findElement(By.name("user_password")).clear();

		}
		Thread.sleep(2000);
		// check for valid data
		driver.findElement(By.name("user_login")).sendKeys("testing");// enter in login text box.
		driver.findElement(By.name("user_password")).sendKeys("pxkP3RtPe(X8cWIrlzV)5plu");// enter in password text box.
		driver.findElement(By.id("rememberme")).click();

		driver.findElement(By.id("wp-submit")).click();

		// used explicit wait here
		// WebElement logclickwait=
		// wait.until(ExpectedConditions.elementToBeClickable(By.id("wp-submit")));

		// logclickwait.submit();
		 Thread.sleep(3000);
		driver.close();
	}

}
