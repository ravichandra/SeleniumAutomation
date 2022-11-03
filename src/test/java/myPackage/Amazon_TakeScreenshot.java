package myPackage;

import java.io.File;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon_TakeScreenshot {

	public WebDriver driver;

	@BeforeTest

	public void launchApp() throws Exception {

		System.out.println("launch app.....");

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");

	}

	@AfterTest

	public void closeApp() throws Exception {

		Thread.sleep(4000);

		driver.close();

		System.out.println("closing app.....");

	}

	@Test

	public void searchTest() throws Exception {

		// driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 14"+
		// Keys.ENTER);

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 14");

		driver.findElement(By.id("nav-search-submit-button")).click();

		Thread.sleep(5000);

		// capture screenshot

		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE); // captured a screenshot

		File target = new File(".\\screenshot\\AmazonSearchTest.png");

		FileUtils.copyFile(screenshotFile, target);

	}

}
