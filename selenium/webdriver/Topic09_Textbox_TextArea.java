package webdriver;


import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic09_Textbox_TextArea {
	private WebDriver driver;
	private String email,userID,password,loginPageURL;
	private String name, dob ,address,city,state,pin,phone,gender;
	private By nameTextBox=By.name("name");
	private By dobTextBox=By.name("dob");
	private By addresstextBox=By.name("addr");
	private By cityTextBox=By.name("city");
	private By stateTexBox=By.name("state");
	private By pinTextBox=By.name("pinno");
	private By phoneTextBox=By.name("telephoneno");
	private By emailTextBox=By.name("emailid");
	private By passwordTextBox=By.name("password");
	private By submitButton=By.name("sub");
	
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4/");
		
		email = "tom_jerry"+randomNumber()+"@gmail.com";
		name="Tom Jerry";
		dob="2020-02-02";
		address="11 Tran Phu";
		city="HCM";
		state="VietNam";
		pin="650000";
		phone="1234321";
		gender="male";
	}

	@Test
	public void TC_01_Get_Email() {
		// Login Page Url matching
		loginPageURL=driver.getCurrentUrl();
		driver.findElement(By.xpath("//a[text()='here']")).click();
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		userID=driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
		System.out.print("User ID la   "+ userID);
		password=driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
		System.out.print("Password la   "+ userID);
		
		
		
	}

	@Test
	public void TC_02_LoginToSystem() {
		driver.get(loginPageURL);
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//tr[@class='heading3']/td[text()='Manger Id : " +userID+"']")).isDisplayed());
	
		String msWelcome= driver.findElement(By.xpath("//marquee[@class='heading3']")).getText();
		Assert.assertEquals(msWelcome, "Welcome To Manager's Page of Guru99 Bank");
		
	}

	@Test
	public void TC_03_New_Custommer() {
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
		
		driver.findElement(nameTextBox).sendKeys(name);
		driver.findElement(dobTextBox).sendKeys(dob);
		driver.findElement(addresstextBox).sendKeys(address);
		driver.findElement(cityTextBox).sendKeys(city);
		driver.findElement(stateTexBox).sendKeys(state);
		driver.findElement(pinTextBox).sendKeys(pin);
		driver.findElement(phoneTextBox).sendKeys(phone);
		driver.findElement(emailTextBox).sendKeys(email);
		driver.findElement(passwordTextBox).sendKeys(password);
		
		driver.findElement(submitButton).click();
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='heading3' and text()='Customer Register Successfully!!!']")).isDisplayed());
		
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), name);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText(), gender);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), dob);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), address);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), city);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), state);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), pin);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), phone);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), email);
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
	public int randomNumber() {
		Random num=new Random();
		return num.nextInt(99999);
	}
}