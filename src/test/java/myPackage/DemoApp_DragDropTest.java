package myPackage;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoApp_DragDropTest {

	public WebDriver driver;

	@BeforeTest

	public void launchApp() throws Exception {

		WebDriverManager.chromedriver().setup();
	

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@AfterTest

	public void closeApp() throws Exception {

		Thread.sleep(4000);

		driver.close();

		System.out.println("closing app.....");

	}

	@Test(enabled = true)

	public void perfomClickOperation() throws Exception {

		// inside frame

		// handle frame

		WebElement photoFrame = driver.findElement(By.xpath("//iframe[contains(@data-src,'photo')]"));

		driver.switchTo().frame(photoFrame);

		WebElement img3 = driver.findElement(By.xpath("//img[contains(@src,'tatras3')]"));

		WebElement img4 = driver.findElement(By.xpath("//img[contains(@src,'tatras4')]"));

		WebElement trash = driver.findElement(By.cssSelector("div#trash"));

		// Method 1
		
		Actions act = new Actions(driver);
		
		act.dragAndDrop(img3, trash).perform();

		// act.dragAndDrop(img4, trash).perform();

		System.out.println("--------------------------------------------");

		// Method 2

		// A convenience method that performs click-and-hold at the location of the
		// source element,

		// moves to the location of the target element, then releases the mouse.
		
		act.clickAndHold(img4).moveToElement(trash).release().perform();

	}

}