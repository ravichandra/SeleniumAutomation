package myPackage;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyntraTest_JS {

	public WebDriver driver;

	@BeforeTest

	public void launchApp() throws Exception {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.myntra.com/");

	}

	@AfterTest

	public void closeApp() throws Exception {

		Thread.sleep(4000);

		driver.close();

		System.out.println("closing app.....");

	}

	@Test

	public void perfomClickOperation() throws Exception {

		Thread.sleep(4000); // hard coded delay

		WebElement lbl_RetrunPloicy = driver.findElement(By.xpath("//strong[contains(text(),'30days')]"));

		ScrollTillElementIntoView(lbl_RetrunPloicy);

		Thread.sleep(4000);

	}

	public void clickUsingJS(WebElement ele) {

		JavascriptExecutor JS = (JavascriptExecutor) driver;

		JS.executeScript("arguments[0].click()", ele);

	}

	public void highligtElement(WebElement ele, String color) {

		JavascriptExecutor JS = (JavascriptExecutor) driver;

		JS.executeScript("arguments[0].setAttribute('style', arguments[1]);", ele,
				"color: " + color + "; border: 4px solid " + color + ";");

	}

	public void ScrollTillElementIntoView(WebElement ele) {

		JavascriptExecutor JS = (JavascriptExecutor) driver;

		JS.executeScript("arguments[0].scrollIntoView();", ele);

	}

}