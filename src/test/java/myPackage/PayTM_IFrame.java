package myPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PayTM_IFrame {

	@Test
	public void verifyFrameTest() throws Exception {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		// click on SIgn-In button/link
		driver.get("https://paytm.com/");

		driver.findElement(By.xpath("//span[text()='Sign In']")).click();

		Thread.sleep(5000);

		// validation

		// perform action

		// driver.switchTo() ----- alert/frame/window

		// Swtich To Frame

		// ---- Index ------ Indexing start from 0

		// ---- Name / Id

		// ---- WebElement ------ identify frame using locator

		// driver.switchTo().frame(0);

		WebElement myFrame = driver.findElement(By.xpath("//iframe[contains(@src,'login')]"));

		driver.switchTo().frame(myFrame);

		String actualHeading = driver.findElement(By.cssSelector(".heading")).getText();

		System.out.println("Heading text: " + actualHeading);

		Assert.assertTrue(actualHeading.contains("Paytm Web account"));

		driver.findElement(By.xpath("//span[contains(text(),'Watch')]")).click();

	}
	
	@Test
	public void verifyFrameTest1() throws Exception {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		// click on SIgn-In button/link
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?org/openqa/selenium/TakesScreenshot.html");

		Thread.sleep(5000);


		driver.switchTo().frame("packageFrame");
		
		driver.findElement(By.linkText("Actions")).click();
		
		Thread.sleep(4000);
		System.out.println("Title is: "+driver.getTitle());
		
		driver.close();

	}

}