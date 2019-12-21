package packageLMS;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class signInAcountPage {

	public static void main(String[] args) throws InterruptedException {

		String Chromepath = "C:\\Users\\isham\\OneDrive\\ERP training\\chromedriver_win32\\\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", Chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://sethuonline.com/lms");
		driver.manage().window().maximize();
		WebDriverWait wt1 = new WebDriverWait(driver, 10);
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(1000);
		// check for valid data
		driver.findElement(By.name("user_login")).sendKeys("testing");// enter in login text box.
		driver.findElement(By.name("user_password")).sendKeys("pxkP3RtPe(X8cWIrlzV)5plu");// enter in password text box.
		driver.findElement(By.id("wp-submit")).click();

		// click on logout button
		wt1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		// explicit wait till i see the logout button on the next page
		driver.findElement(By.linkText("Logout")).click();
		// come to sign in my account page.
		driver.findElement(By.name("log")).sendKeys("testing");
		driver.findElement(By.name("pwd")).sendKeys("pxkP3RtPe(X8cWIrlzV)5plu");
		// WebElement catchatext=
		// driver.findElement(By.xpath("//*[@id=\"loginform\"]/p[3]/input"));
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//input[@id='wp-submit'])[2]")).click();//click the login button

	}
}
