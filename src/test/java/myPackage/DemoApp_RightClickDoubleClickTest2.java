package myPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoApp_RightClickDoubleClickTest2 {

	public WebDriver driver;

	@BeforeTest

	public void launchApp() throws Exception {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://demo.guru99.com/test/simple_context_menu.html");

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@AfterTest

	public void closeApp() throws Exception {

		Thread.sleep(4000);

		driver.close();

		System.out.println("closing app.....");

	}

	@Test(enabled = false)

	public void perfomClickOperation() throws Exception {

		WebElement btn_RightClick = driver.findElement(By.xpath("//span[contains(text(),'right')]"));

		// btn_RightClick.click();

		// Create an object Actions

		Actions act = new Actions(driver);

		act.contextClick(btn_RightClick).perform();

		WebElement btn_Delete = driver.findElement(By.xpath("//span[contains(text(),'Del')]"));

		btn_Delete.click();

		// act.click(btn_Delete).perform();

		Thread.sleep(2000);

		Alert alert_del = driver.switchTo().alert();

		System.out.println(alert_del.getText());

		alert_del.accept();

	}

	@Test

	public void perfomDoubleClick() throws Exception {

		WebElement btn_DoubleClick = driver.findElement(By.xpath("//button[contains(text(),'Dou')]"));

		// btn_RightClick.click();

		// Create an object Actions

		Actions act = new Actions(driver);

		act.doubleClick(btn_DoubleClick).perform();

		Thread.sleep(2000);

		Alert alert_del = driver.switchTo().alert();

		System.out.println(alert_del.getText());

		alert_del.accept();

	}

}