package webdriver;


import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic06_Webdriver_API {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
	}

	@Test
	public void TC_01_Web_Driver_API() {
     driver.get("https://www.facebook.com/");//(*)
		
     driver.close();
     
     driver.quit();//(*)
     
     String registerURL = driver.getCurrentUrl();//(*)
     
     String registerSource =driver.getPageSource();
     
     String registerTitle = driver.getTitle();//(*)
     
     String registerHandel = driver.getWindowHandle();//(*)
     
     Set<String> registerHandesAll = driver.getWindowHandles();//(*)
     
     driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);//(*)
     driver.manage().timeouts().implicitlyWait(15000,TimeUnit.MILLISECONDS);
     
     driver.manage().window().fullscreen();//(*)
     driver.manage().window().maximize();
     driver.manage().window().getSize();// test GUI
     
     
     driver.navigate().back();
     driver.navigate().forward();
     driver.navigate().refresh();
     
     driver.switchTo().alert();//(*)
     driver.switchTo().window("");//(*)
     driver.switchTo().frame("");//(*)
     
     
     
     
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