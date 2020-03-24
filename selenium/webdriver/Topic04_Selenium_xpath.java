package webdriver;


import static org.junit.Assert.assertArrayEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic04_Selenium_xpath {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		System.out.println("Drive ID "+driver.toString());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://live.demoguru99.com/");
	}

	@Test
	public void TC_01_LoginWithEmptyEmailAndPassword() {
	driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
	driver.findElement(By.id("email")).sendKeys("");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.name("login[password]")).sendKeys("");
	driver.findElement(By.cssSelector("button[title='Login']")).click();
	String errorEmail = driver.findElement(By.id("advice-required-entry-email")).getText();
	Assert.assertEquals(errorEmail, "This is a required field.");
	
	}

	@Test
	public void TC_02_LoginWithInvalidEmail(){
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		driver.findElement(By.id("email")).sendKeys("123123@123");
		driver.findElement(By.name("login[password]")).sendKeys("");
		driver.findElement(By.cssSelector("button[title='Login']")).click();
		String errorEmail = driver.findElement(By.id("advice-required-entry-email")).getText();
		Assert.assertEquals(errorEmail, "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void TC_03_LoginWitnpasswordAtLeast6Char() {
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
		driver.findElement(By.name("login[password]")).sendKeys("123");
		driver.findElement(By.cssSelector("button[title='Login']")).click();
		String errorEmail = driver.findElement(By.id("advice-required-entry-email")).getText();
		Assert.assertEquals(errorEmail, "Please enter 6 or more characters without leading or trailing spaces.");
	}
	@Test
	public void TC_04_LoginWithIncorrectPassword() {
		driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
		driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
		driver.findElement(By.name("login[password]")).sendKeys("123123123");
		driver.findElement(By.cssSelector("button[title='Login']")).click();
		String errorEmail = driver.findElement(By.id("advice-required-entry-email")).getText();
		Assert.assertEquals(errorEmail, "Please enter 6 or more characters without leading or trailing spaces.");
	}
	@Test
	public void TC_05_Xpath() {

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