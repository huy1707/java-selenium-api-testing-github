package webdriver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;





public class Topic06_Webdriver_Element_Ex {
	WebDriver driver;
	By UserEmail=By.id("mail");
	By EduTextBox=By.id("edu");
	By AgeUnder18=By.id("under_18");
	By DevelopText=By.id("development");

	
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
	}

	@Test
	public void TC_01_Check_Display() {
	
		if	(driver.findElement(UserEmail).isDisplayed()){driver.findElement(UserEmail).sendKeys("Automation");}
		if	(isElementDisplay(EduTextBox)) {ElementSenkey(EduTextBox,"Selenium");}
		if	(driver.findElement(AgeUnder18).isDisplayed()) {driver.findElement(AgeUnder18).click();}
		
		
				
     
	}

	@Test
	public void TC_02_Check_Enable(){
		if(driver.findElement(UserEmail).isEnabled())
		{
					System.out.print("Email Textbox is enable");
		}else
			
		{
			System.out.print("Email Textbox is disable");
		}

	}

	@Test
	public void TC_03_CheckSelected() {

		ClickElement(DevelopText);
		Assert.assertTrue(isElementSelected(DevelopText));
		
		ClickElement(DevelopText);
		Assert.assertFalse(isElementSelected(DevelopText));
		
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
	
	public boolean isElementDisplay(By by){
		
		WebElement element=driver.findElement(by);
		if(element.isDisplayed())
		{
			System.out.print("Elenemt---   " + by +" ---   is displayed \n");
			return true;
		}else
		{
			System.out.print("Elenemt---   " + by +"----  is displayed  \n");
			return false;
		}
	}
	public boolean isElementSelected(By by){
		
		WebElement element=driver.findElement(by);
		if(element.isSelected())
		{
			System.out.print("Elenemt---   " + by +" ---   is selected \n ");
			return true;
		}else
		{
			System.out.print("Elenemt---   " + by +"----  is deselected  \n");
			return false;
		}
	}
	public void ElementSenkey(By by,String value){
		WebElement element=driver.findElement(by);
		element.clear();
		element.sendKeys(value);
	}
	
	public void ClickElement(By by)
	{WebElement element=driver.findElement(by);
	element.click();
		
	}

}