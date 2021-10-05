package com.DataDriven.Test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.TestUtility.TestUtil;

public class DataDrivenTest {

	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver",  "D://selenium//Chrome Driver//chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.get("https://demoqa.com/register");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	
	@DataProvider
	public Iterator<Object[]> gettestdata()
	{
	ArrayList<Object[]> testdata=	TestUtil.getdatafromExcelfile();
	return testdata.iterator();
	}
	
	@Test(dataProvider = "gettestdata")
	public void loginpage(String firstname,String lastname,String username,String password)
	{
		
		driver.findElement(By.id("firstname")).sendKeys(firstname);
		driver.findElement(By.id("lastname")).sendKeys(lastname);
		driver.findElement(By.id("userName")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		
		 
	}
	
	@AfterMethod
	public void teardown()
	{
		
 	driver.quit();
	}
}
