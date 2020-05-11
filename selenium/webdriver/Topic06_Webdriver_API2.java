package webdriver;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic06_Webdriver_API2 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
	}

	@Test
	public void TC_01_Web_Driver_API() {
     driver.get("http://live.demoguru99.com/");//(*)
     
     driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();
     
     String pageUrl= driver.getCurrentUrl();
     Assert.assertEquals(pageUrl, "http://live.demoguru99.com/index.php/customer/account/login/");
     
     driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
     
     String register=driver.getCurrentUrl();
     
     Assert.assertEquals(register, "http://live.demoguru99.com/index.php/customer/account/create/");
     //assertTrue
     //assertFalse
     //assertEqual
     
     
     
     
	}

	@Test
	public void TC_02_LoginWithInvalidEmail(){

	}

	@Test
	public void TC_03_LoginWitnpasswordAtLeast6Char() {

	}
	@Test
	public void TC_04_LoginWithIncorrectPassword() {

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