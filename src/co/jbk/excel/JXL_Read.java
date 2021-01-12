package co.jbk.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class JXL_Read {
	
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
	}

	@Test(dataProvider = "dp")
	public void test(String uname, String pass) {

		driver.findElement(By.id("email")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String validTitle = "JavaByKiran | Dashboard";
		String invalidTitle = "JavaByKiran | Log in";

		if (driver.getTitle().contains("Log in"))
			Assert.assertEquals(driver.getTitle(), invalidTitle);
		else
			Assert.assertEquals(driver.getTitle(), validTitle);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	@DataProvider
	public Object[][] dp() throws Exception {
		FileInputStream fis = new FileInputStream("LoginTestData.xls");
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
