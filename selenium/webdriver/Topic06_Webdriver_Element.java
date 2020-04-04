package webdriver;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Topic06_Webdriver_Element {
	WebDriver driver;

	WebElement element;
	WebElement firstNameTextbox = driver.findElement(By.xpath(""));
	WebElement lastNameTextbox = driver.findElement(By.xpath(""));
	
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		
	}

	@Test
	public void TC_01_Element() {
		element =driver.findElement(By.xpath("//*[@id='small-searchterms']"));
		
		element.sendKeys("Dell 2010");
		sleepTnSecond(2);
		element.clear();
		sleepTnSecond(2);
		element.sendKeys("macbook");
		sleepTnSecond(2);
		
		
		String SearchStoreValue =element.getAttribute("placeholder");
		System.out.print("attribute "+ SearchStoreValue);
		
		element=driver.findElement(By.cssSelector(".search-box-button"));
		
		String SearchBrColor = element.getCssValue("background-color");
		System.out.print("background "+ SearchBrColor);
		
		String Searchbuttontag= element.getTagName();
		System.out.print("tagname "+ Searchbuttontag);
		
		
		element= driver.findElement(By.xpath("//div[@class='topic-block-title']/h2"));
		System.out.print("Welcom text "+ element.getText());
		
		Assert.assertTrue(element.isDisplayed());
		
		Assert.assertTrue(element.isEnabled());

     
     
     
	}

	@Test
	public void TC_02_(){

	}

	@Test
	public void TC_03_() {

	}
	@Test
	public void TC_04_() {

	}
	@Test
	public void TC_05() {

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