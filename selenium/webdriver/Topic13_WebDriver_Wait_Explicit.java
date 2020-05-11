package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic13_WebDriver_Wait_Explicit {
	private WebDriver driver;
	Actions action;
	WebElement element;
	private WebDriverWait explicitWait;
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		explicitWait = new WebDriverWait(driver,15);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
	}

	@Test
	public void TC_01_Visible_Pass() {
		// 
	driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
	
	driver.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
	
	
	explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']/h4")));
	
	Assert.assertEquals(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText(),"Hello World!");
	
	
	}

//	@Test
	public void TC_02_Visible_Fail() {
		//
		driver.get("https://www.facebook.com/");
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='reg_email_confirmation__']")));
		
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//input[@id='reg_email_confirmation__']")).isDisplayed());
		
		
		
		
	}

//	@Test
	public void TC_03_Invisible_Pass() {
		//
		driver.get("https://www.facebook.com/");
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@name='reg_email_confirmation__']")));
		
//		AssertJUnit.assertTrue(driver.findElement(By.xpath("//input[@id='reg_email_confirmation__']")).isDisplayed());
		
		
	}
	@Test
	public void TC_04_Invisible_Pass() {
		//
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//li[text()='Invalid email address.']")));
		
//		AssertJUnit.assertTrue(driver.findElement(By.xpath("//input[@id='reg_email_confirmation__']")).isDisplayed());
		
		
	}
//	@Test
	public void TC_05_Invisible_Fail() {
		//
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@id='email']")));
		
//		AssertJUnit.assertTrue(driver.findElement(By.xpath("//input[@id='reg_email_confirmation__']")).isDisplayed());
		
		
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	public void sleepInSecond(long timeoout) {
		try {
			Thread.sleep(timeoout*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}