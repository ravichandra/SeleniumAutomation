package myPackage;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TestNGAnnotations2 {
	WebDriver driver;

	@BeforeTest
	public void beforeTest() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		Thread.sleep(4000);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}
	
	@Test(priority = 1)
	public void login() throws InterruptedException {
		WebElement txt_UserName = driver.findElement(By.name("username")); //

		txt_UserName.sendKeys("Admin");

		// Password - name

		driver.findElement(By.name("password")).sendKeys("admin123");

		// click on Login Button

		// Tagname - login

		driver.findElement(By.tagName("button")).click();

		Thread.sleep(5000);

		
	}
	
	@Test(priority = 2)
	public void logout() throws InterruptedException {
		// Classname - oxd-userdropdown-name

		driver.findElement(By.className("oxd-userdropdown-name")).click();

		Thread.sleep(5000);

		// LinkText - Logout

		driver.findElement(By.linkText("Logout")).click();

		Thread.sleep(5000);
	}
	
	

}
