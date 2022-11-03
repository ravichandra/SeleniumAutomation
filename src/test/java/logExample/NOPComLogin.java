package logExample;

import org.openqa.selenium.By;

import org.testng.Assert;

import org.testng.annotations.Test;

public class NOPComLogin extends BaseTest {

	@Test(priority = 1)

	public void verifyLogin() {

		log.info("clear text from username field.");

		driver.findElement(By.id("Email")).clear();

		log.info("enter value into username: " + conf.getAdminUser());

		driver.findElement(By.id("Email")).sendKeys(conf.getAdminUser());

		log.info("clear text from password field.");

		driver.findElement(By.id("Password")).clear();

		log.info("enter value into password: " + conf.getAdminPass());

		driver.findElement(By.id("Password")).sendKeys(conf.getAdminPass());

		log.info("click on checkbox");

		driver.findElement(By.id("RememberMe")).click();

		log.info("click on Login button.");

		driver.findElement(By.tagName("button")).click();

	}

	@Test(priority = 2)

	public void verifyAppTitle() {

		log.info("Validation of app title after login.");

		log.info("App Title: " + driver.getTitle());

		Assert.assertTrue(driver.getTitle().contains("Dashboard"));

	}

	@Test(priority = 3)

	public void verufyLogout() {

		log.info("click on Logout button.");

		driver.findElement(By.linkText("Logout")).click();

	}

}
