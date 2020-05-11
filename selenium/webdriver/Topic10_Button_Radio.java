package webdriver;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic10_Button_Radio {
	private WebDriver driver;
	public Actions action;
	private JavascriptExecutor jsExercute=null;
	Alert alert;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

//	@Test
	public void TC_01_button() throws Exception {
		driver.get("http://bhphotovideo.com/");
		
		driver.findElement(By.xpath("//button[@class='login']")).click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='If-section If-login-section']")).isDisplayed());
		
	}

//	@Test
	public void TC_02_CheckBox() throws Exception {
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index/");
		
		By zoneCheckBox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::input");
		
		driver.findElement(zoneCheckBox).click();
		Thread.sleep(5000);
		
		Assert.assertTrue(driver.findElement(zoneCheckBox).isSelected());
		
		driver.findElement(zoneCheckBox).click();
		Thread.sleep(3000);
		
		
		
	}

	@Test
	public void TC_03_Alert() throws Exception {
		driver.get("https://www.google.com.vn/");
		
		
		jsExercute.executeScript("alert('Create a new Accept Alert');");
		Thread.sleep(3000);
		
		alert= driver.switchTo().alert();
		
		Assert.assertEquals(alert.getText(), "Create a new Accept Alert");
		alert.accept();
		
		//////////////////////////////
		jsExercute.executeScript("confirm('Create a new Confirm Alert');");
		Thread.sleep(3000);
		
		alert= driver.switchTo().alert();
	
		Assert.assertEquals(alert.getText(), "Create a new Confirm Alert");
		alert.dismiss();
		////////////////////////////
		jsExercute.executeScript("promt('Create a new Promt Alert');");
		Thread.sleep(3000);
		alert= driver.switchTo().alert();
		alert.sendKeys("Automation Testing");
		Thread.sleep(3000);
		Assert.assertEquals(alert.getText(), "Create a new Promt Alert");
		alert.accept();
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