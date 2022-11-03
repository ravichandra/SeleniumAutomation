package logExample;

import org.openqa.selenium.By;

import org.testng.Assert;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

public class NOPComLogin1 extends BaseTest {

	@Test(priority = 1, dataProvider = "regressionData")

	public void verifyLoginWithInValidUserDetails(String uname, String pwd) throws Exception {

		Thread.sleep(2000);

		log.info("clear text from username field.");

		driver.findElement(By.id("Email")).clear();

		log.info("enter value into username: " + uname);

		driver.findElement(By.id("Email")).sendKeys(uname);

		Thread.sleep(2000);

		log.info("clear text from password field.");

		driver.findElement(By.id("Password")).clear();

		log.info("enter value into password: " + pwd);

		driver.findElement(By.id("Password")).sendKeys(pwd);

		Thread.sleep(2000);

		log.info("click on checkbox");

		driver.findElement(By.id("RememberMe")).click();

		Thread.sleep(2000);

		log.info("click on Login button.");

		driver.findElement(By.tagName("button")).click();

		Thread.sleep(2000);

		// validation step

		log.info("Validation of error message for invalid user.");

		Assert.assertTrue(driver.getPageSource().contains("Login was unsuccessful"));

	}

	@DataProvider

	public Object[][] sampleData() {

		Object[][] data = { { "Ashwini@gmail.com", "demo@123" }, { "Deepika@yahoomail.com", "23129900" },
				{ "neha@ibm.com", "welcome@123" } };

		return data;

	}

	@DataProvider

	public Object[][] regressionData() {

		Object[][] data = { { "AshwiniRegression@gmail.com", "demo@123" },
				{ "DeepikaRegression@yahoomail.com", "23129900" }, { "nehaRegression@ibm.com", "welcome@123" },
				{ "BhavanaRegression@ibm.com", "welcome@123" } };

		return data;

	}

}