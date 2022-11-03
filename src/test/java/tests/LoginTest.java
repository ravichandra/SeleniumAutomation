package tests;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseTest {

	@Test

	public void verifyLoginFeature() {

		LoginPage lp = new LoginPage(driver);

		lp.enterEmail(conf.getAdminUser());

		lp.enterPass(conf.getAdminPass());

		lp.clickLoginButton();

//      driver.findElement(By.name("Email")).clear();

//      driver.findElement(By.name("Email")).sendKeys(conf.getAdminUser());

//      driver.findElement(By.cssSelector("input#Password")).clear();

//      driver.findElement(By.cssSelector("input#Password")).sendKeys(conf.getAdminPass());

//      

//      driver.findElement(By.tagName("button")).click();

	}

}
