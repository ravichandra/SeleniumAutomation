package myPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyClass1 {
	
	@Test
	public void test1() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		// WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");

		String searchItem = "iphone 14";

		Thread.sleep(10000);

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchItem);

		driver.findElement(By.id("nav-search-submit-button")).click();

		Thread.sleep(4000);

		// validation step

		String appTitle = driver.getTitle();

		System.out.println("Application Title: " + appTitle);

		Assert.assertEquals("Amazon.in : iphone 14", appTitle);

		Assert.assertEquals("Amazon.in : " + searchItem, appTitle);

		Assert.assertTrue(appTitle.contains(searchItem));

		Thread.sleep(4000);

		driver.close();
	}
	
	@Test
	public void test2() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");

		String searchItem = "iphone 14";

		Thread.sleep(10000);

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchItem);

		driver.findElement(By.id("nav-search-submit-button")).click();

		Thread.sleep(4000);

		// validation step

		String appTitle = driver.getTitle();

		System.out.println("Application Title: " + appTitle);

		Assert.assertEquals("Amazon.in : iphone 14", appTitle);

		Assert.assertEquals("Amazon.in : " + searchItem, appTitle);

		Assert.assertTrue(appTitle.contains(searchItem));

		Thread.sleep(4000);

		driver.close();
	}
	
	@Test
	public void test3() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");

		String searchItem = "iphone 14";

		Thread.sleep(10000);

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchItem);

		driver.findElement(By.id("nav-search-submit-button")).click();

		Thread.sleep(4000);

		// validation step

		String appTitle = driver.getTitle();

		System.out.println("Application Title: " + appTitle);

		Assert.assertEquals("Amazon.in : iphone 14", appTitle);

		Assert.assertEquals("Amazon.in : " + searchItem, appTitle);

		Assert.assertTrue(appTitle.contains(searchItem));

		Thread.sleep(4000);

		driver.close();
	}
}
