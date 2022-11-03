package myPackage;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IRCTCAPP_Window {
	@Test
	public void switchWindow() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		// click on SIgn-In button/link
		driver.get("https://www.irctc.co.in/nget/train-search");

		Thread.sleep(5000);

		// click on OK button

		WebElement btn_OK = driver.findElement(By.xpath("//button[text()='OK']"));

		btn_OK.click();
		Thread.sleep(3000);

		String parentWindow = driver.getWindowHandle(); // return single window

		System.out.println("mainWindow : " + parentWindow);

		System.out.println("click on Hotel link");

//		WebElement link_Hotel = driver.findElement(By.linkText("HOTELS"));

//		link_Hotel.click();

		driver.findElement(By.xpath("(//label[text()='HOTELS'])[2]")).click();
		
		System.out.println("-------------------------------------");

		Set<String> allwindow = driver.getWindowHandles(); // multiple window

		System.out.println("window count: " + allwindow.size());

		String mainWindow = (String) allwindow.toArray()[0];

		String hotelWindow = (String) allwindow.toArray()[1];

		System.out.println("main Window: " + mainWindow);

		System.out.println("hotelWindow: " + hotelWindow);

		Thread.sleep(4000);

		System.out.println("Switching to hotel window.........");

		driver.switchTo().window(hotelWindow);

		Thread.sleep(4000);

		System.out.println("Switching to main window.........");

		driver.switchTo().window(mainWindow);

		Thread.sleep(4000);

		System.out.println("Switching to hotel window.........");

		driver.switchTo().window(hotelWindow);

		driver.findElement(By.linkText("Login")).click();

		Thread.sleep(4000);

		System.out.println("Switching to main window.........");

		driver.switchTo().window(mainWindow);

		//driver.findElement(By.linkText("CONTACT US")).click();

		Thread.sleep(2000);

		System.out.println("Switching to hotel window.........");

		driver.switchTo().window(hotelWindow);

		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		driver.close();
		Thread.sleep(4000);
		driver.quit();
	}
}
