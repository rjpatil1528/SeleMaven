package jbk.Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automation {
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

		WebElement errormsg = driver.findElement(By.xpath("//div[@id='email_error']"));
		System.out.println(errormsg.getText());

		List<WebElement> courses = driver.findElements(By.tagName("h3"));
		System.out.println("total courses---" + courses.size());

		for (int i = 0; i < courses.size(); i++) {
			String text = courses.get(i).getText();
			System.out.println(text);
		}

		List<WebElement> leftpanel = driver.findElements(By.tagName("span"));
		System.out.println(leftpanel.size());
		for (WebElement left : leftpanel) {
			String text = left.getText();
			System.out.println(left);
		}
	}
}
