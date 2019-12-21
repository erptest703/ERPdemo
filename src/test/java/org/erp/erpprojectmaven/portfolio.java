package packageLMS;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class portfolio {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String Chromepath = "C:\\Users\\isham\\OneDrive\\ERP training\\chromedriver_win32\\\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", Chromepath);
		WebDriver driver = new ChromeDriver();
		driver.get("http://sethuonline.com/lms");
		//click on portfolio tab
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//a[contains(@href,'portfolio-masonry')])[1]")).click();// used href and contains
		Thread.sleep(2000);
		//click on presentation tab
		driver.findElement(By.xpath("//*[@id=\"post-4424\"]/div/div/div/div/div/div/div/div[1]/ul/li[2]/a")).click();
		Thread.sleep(3000);
       //  use actions interface to handle mouse hovering on the image
		Actions act = new Actions(driver);
		WebElement hoveronpage = driver.findElement(By.xpath(
				"//img[contains(@src,'http://sethuonline.com/lms/wp-content/uploads/2016/03/presentation-2.jpg')]"));
		act.moveToElement(hoveronpage).perform();
		//use the actions interface to click on a link on the image.
		WebElement clickimage = driver.findElement(By.linkText("Up your skill"));
		act.moveToElement(clickimage).click().build().perform();
		Thread.sleep(2000);
		driver.close();
	}

}
