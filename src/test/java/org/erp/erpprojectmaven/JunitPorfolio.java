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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JunitPorfolio {

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
	public void portFolio() throws InterruptedException {
		wait = new WebDriverWait(driver, 20);

		// used href and contains
		//click on portfolio
		WebElement Portfcl = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//a[contains(@href,'portfolio-masonry')])[1]")));
		Portfcl.click();
		// click on presentation tab
		WebElement Presentck = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"post-4424\"]/div/div/div/div/div/div/div/div[1]/ul/li[2]/a")));
				Presentck.click();
		
		// use actions interface to handle mouse hovering on the image
		Actions act = new Actions(driver);
		WebElement hoveronpage = driver.findElement(By.xpath(
				"//img[contains(@src,'http://sethuonline.com/lms/wp-content/uploads/2016/03/presentation-2.jpg')]"));
		act.moveToElement(hoveronpage).perform();
		// use the actions interface to click on a link on the image.
		WebElement clickimage = driver.findElement(By.linkText("Up your skill"));
		act.moveToElement(clickimage).click().build().perform();
	
	}

	@AfterClass
	public static void teardown() {
		driver.close();
	}
}
