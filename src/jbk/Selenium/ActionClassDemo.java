package jbk.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionClassDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\Downloads\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
		
	    driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("file:///D:/jbk%20selenium%20software/Offline%20Website/Offline%20Website/index.html");
		
		Actions action = new Actions(driver);
		
		WebElement email = driver.findElement(By.id("email"));
		WebElement pass = driver.findElement(By.id("password"));
		WebElement button = driver.findElement(By.xpath("//button"));

		action.contextClick(email).click(email).sendKeys(email, "kiran@gmail.com").build().perform();
		
		
	}
	
	
}
