package webdriver;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic11_User_Interaction {
	private WebDriver driver;
	Actions action;
	WebElement element;
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
	}

	@Test
	public void TC_01_Hover() {
		// 
		driver.get("https://www.myntra.com/");
		element.findElement(By.xpath("//div[@class='desktop-navLink']//a[text()='Discover']"));
		action.moveToElement(element).perform();
		sleepInSecond(2);
		driver.findElement(By.xpath("//a[text()='Lacoste']")).click();
		
	    Assert.assertTrue(driver.findElement(By.xpath("//li[@class='breadcrumbs-item']/span[text()='Lacoster Product']")).isDisplayed());
	}

	@Test
	public void TC_02() {
		//
		driver.get("https://www.jqueryui.com/resources/demos/selectable/dispaly-grid.html/");
		
		
	}

	@Test
	public void TC_03() {
		// Login form displayed
		
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