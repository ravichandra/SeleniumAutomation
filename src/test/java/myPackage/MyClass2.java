package myPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyClass2 {
	@Test
	public void test1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		Thread.sleep(10000);
		
		driver.findElement(By.cssSelector("input#Email")).clear();
		driver.findElement(By.cssSelector("input#Email")).sendKeys("admin@yourstore.com");
		
		driver.findElement(By.xpath("//input[@class='password']")).clear();
		driver.findElement(By.xpath("//input[@class='password']")).sendKeys("admin");

		driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@class='nav-link' and contains(@href,'#')])[6]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text() = ' Customers']")).click();
		Thread.sleep(5000);
		
		// validation step

		String appTitle = driver.getTitle();

		System.out.println("Application Title: " + appTitle);

		Assert.assertEquals("Customers / nopCommerce administration", appTitle);
		
		String appURL = driver.getCurrentUrl();
		System.out.println(appURL);
		Assert.assertEquals("https://admin-demo.nopcommerce.com/Admin/Customer/List", appURL);
		
		driver.close();
		
	}
}
