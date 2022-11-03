package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	// Identification

	By txt_Email = By.name("Email");

	By txt_Pass = By.cssSelector("input#Password");

	By btn_Login = By.tagName("button");

	// Actions/Methods

	public void enterEmail(String email) {

		driver.findElement(txt_Email).clear();

		driver.findElement(txt_Email).sendKeys(email);

	}

	public void enterPass(String pwd) {

		driver.findElement(txt_Pass).clear();

		driver.findElement(txt_Pass).sendKeys(pwd);

	}

	public void clickLoginButton() {

		driver.findElement(btn_Login).click();

	}

	public boolean verifyEmailTextboxPresent() {

		return driver.findElement(txt_Email).isDisplayed();

	}

	public boolean verifyElementPresent(By locator) {

		return driver.findElement(locator).isDisplayed();

	}

	public void clickElementUsingJS(WebElement ele) {

		JavascriptExecutor JS = (JavascriptExecutor) driver;

		JS.executeScript("arguments[0].click()", ele);

	}

}