package jbk.Selenium;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTableDemo2 {

WebDriver driver = null;
	
	@BeforeMethod
	public void initialization() {
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///D:/jbk%20selenium%20software/Offline%20Website/Offline%20Website/index.html");	
	}
	
	@Test
	public void emailsTest() {
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		
		ArrayList<String> emails = new ArrayList<String>();
		for (int i=2; i<=5; i++) {
			String email = driver.findElement(By.xpath("//tr["+i+"]/td[3]")).getText();
			emails.add(email);
		}
		for(String id : emails) {
			if(id.contains("@gmail.com"))
				System.out.println("email is valid");
			else
				System.out.println("email is invalid");
		}
	}
	
	@Test
	public void genderTest() {
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		
		ArrayList<String> genders = new ArrayList<String>();
		for (int i=2; i<=5; i++) {
			String gender = driver.findElement(By.xpath("//tr["+i+"]/td[6]")).getText();
			genders.add(gender);
		}
		for(String id : genders) {
			if(id.contains("Male"))
				System.out.println("gender is valid");
			else
				System.out.println("gender is invalid");
		}
	}
	
	@Test
	public void addUser() {
		String gender="Female";
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//span[text()='Users']")).click();
		driver.findElement(By.xpath("//button[text()='Add User']")).click();
		driver.findElement(By.id("username")).sendKeys("rahul");
		driver.findElement(By.id("mobile")).sendKeys("92345273");
		driver.findElement(By.id("email")).sendKeys("rjpatil@gmail.com");
		driver.findElement(By.id("course")).sendKeys("Selenium");
		
		if(gender.equals("Male")) {
			WebElement radio = driver.findElement(By.id("Male"));
			radio.click();
			String value = radio.getAttribute("id");
			System.out.println("Selected gender is:"+value);
		}else {
			WebElement radio = driver.findElement(By.id("Female"));
			radio.click();
			String value = radio.getAttribute("id");
			System.out.println("Selected gender is:"+value);
		}
		//Thread.sleep(2000);
		
		WebElement state = driver.findElement(By.xpath("//select"));
		Select select = new Select(state);
		select.selectByVisibleText("Maharashtra");
		
		
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@id='submit']")).click();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
}
