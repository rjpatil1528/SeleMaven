package jbk.Selenium;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableDemo {
public static void main(String[] args) {
	
	System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("file:///D:/jbk%20selenium%20software/Offline%20Website/Offline%20Website/index.html");

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
}
