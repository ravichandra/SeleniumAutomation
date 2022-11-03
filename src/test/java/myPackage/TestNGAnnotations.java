package myPackage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	@BeforeTest
	public void launchApp() {

		System.out.println("launching app...");
	}

	@AfterTest
	public void closingApp() {

		System.out.println("closing app...");
	}

	@Test(priority = 0)
	public void login() {

		System.out.println("login testcase ...");
	}

	@Test(priority = 3)
	public void logout() {

		System.out.println("logout testcase ...");
	}

	@Test(priority = 1)
	public void addItem() {

		System.out.println("addItem testcase ...");
	}

	@Test(priority = 2)
	public void payment() {

		System.out.println("payment testcase ...");
	}
}
