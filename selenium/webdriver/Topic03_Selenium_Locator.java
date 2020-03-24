package webdriver;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic03_Selenium_Locator {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		System.out.println("Drive ID "+driver.toString());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://live.demoguru99.com/index.php/customer/account/create/");
	}

	@Test
	public void TC_01_ID() {
		// Login Page Url matching
		driver.findElement(By.id("firstname")).sendKeys("Automation");
		sleepTnSecond(3);
	}

	@Test
	public void TC_02_class() {
		// Login Page title
		driver.get("http://live.demoguru99.com/index.php/customer/account/login/");
		driver.findElement(By.className("validate-password")).sendKeys("Password!");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		sleepTnSecond(3);
		
		
	}

	@Test
	public void TC_03_Name() {
		// Login form displayed
		driver.findElement(By.name("login[username]")).sendKeys("automation@gmail.com");
		sleepTnSecond(3);
	}
	@Test
	public void TC_04_Css() {
		driver.get("http://live.demoguru99.com/index.php/customer/account/create/");
		//1
		driver.findElement(By.cssSelector("#firstname")).sendKeys("Automation");
		//2
		driver.findElement(By.cssSelector(".name-middlename")).isDisplayed();
		//3
		driver.findElement(By.cssSelector("input[name='q']")).sendKeys("lenovo");
		//4
		System.out.println("Number of input =" +driver.findElement(By.cssSelector("input:not([type='hidden'])")).getSize());
		//5
		driver.findElement(By.cssSelector("a[href='http://live.demoguru99.com/index.php/mobile.html']")).click();
		//6
		driver.findElement(By.cssSelector("a[href*='index.php/mobile.html']")).click();
		sleepTnSecond(3);
	}
	@Test
	public void TC_05_Xpath() {
		driver.get("http://live.demoguru99.com/index.php/customer/account/create/");
		//1
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Automation");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//2
		driver.findElement(By.xpath("//div[@class='field name-lastname']")).isDisplayed();
		//3
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("dell");
		//4
		
		//5
		driver.findElement(By.xpath("//a[text()='Site Map']")).click();
		//6
		driver.findElement(By.xpath("//a[contains(text(),'Advanced')]")).click();
		
		sleepTnSecond(3);
	}

	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	public void sleepTnSecond(long timeout) {
		try {
			Thread.sleep(timeout*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}