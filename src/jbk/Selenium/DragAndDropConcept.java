package jbk.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();  //maximize window
		driver.manage().deleteAllCookies();   //Delete all coockies
		
		driver.get("https://demoqa.com/droppable/");
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		Actions act = new Actions(driver);
		
		act.clickAndHold(driver.findElement(By.id("draggable"))).
		moveToElement(driver.findElement(By.id("droppable"))).release().build().perform();;
		
		driver.quit();
		
		
	}

	
	
}
