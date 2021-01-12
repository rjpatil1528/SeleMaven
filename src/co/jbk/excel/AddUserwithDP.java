package co.jbk.excel;

import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class AddUserwithDP {
	WebDriver driver;
	
	 @BeforeMethod
	  public void initialization() {
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("file:///D:/jbk%20selenium%20software/Offline%20Website/Offline%20Website/index.html");
			driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
			driver.findElement(By.id("password")).sendKeys("123456");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
		}
	
  @Test(dataProvider = "dp")
  public void addUser(String username, String mobile, String email, String course) {
	  driver.findElement(By.xpath("//span[text()='Users']")).click();
		driver.findElement(By.xpath("//button[text()='Add User']")).click();
		
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("mobile")).sendKeys(mobile);
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("course")).sendKeys(course);
  }
 
 @AfterMethod
  public void tearDown() {
	  driver.quit();
  }


  @DataProvider
  public Object[][] dp() throws Exception {
	  FileInputStream fis = new FileInputStream("UserData.xls");
		Workbook wb = Workbook.getWorkbook(fis);
		Sheet sh = wb.getSheet("login");
		String data[][] = new String[sh.getRows()][sh.getColumns()];
		
		for (int i=0; i<sh.getRows(); i++) {
			for (int j=0; j<sh.getColumns(); j++) {
				
				Cell cell = sh.getCell(j, i);
				 data[i][j] = cell.getContents();
			}
		}
		return data;
  }
}
