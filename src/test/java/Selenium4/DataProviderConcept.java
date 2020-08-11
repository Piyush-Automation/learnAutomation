package Selenium4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderConcept {
	
WebDriver driver;
	
	@BeforeMethod
	public void setup() {

	System.setProperty("webdriver.chrome.driver","D:\\LearningAutomation\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}
	
	
	@Test(dataProvider="test")
	public void test(String fname, String email,String add1, String add2) throws InterruptedException {
		driver.get("https://demoqa.com/text-box");
		
		WebElement username = driver.findElement(By.id("userName"));
		username.clear();
		username.sendKeys(fname);
		
		WebElement emailid = driver.findElement(By.id("userEmail"));
		emailid.clear();
		emailid.sendKeys(email);
		
		WebElement address1 = driver.findElement(By.id("currentAddress"));
		address1.clear();
		address1.sendKeys(add1);
		WebElement address2 = driver.findElement(By.id("permanentAddress"));
		address2.clear();
		address2.sendKeys(add2);
		System.out.println("This is for git upload testing");
	
		
		Thread.sleep(3000);
		
		
		
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		System.out.println(driver.findElement(By.xpath("//div[@id='output']//div")).getText());	
		
	}

	@DataProvider(name="test")
	public Object[][] getdata() throws IOException {
				
		FileInputStream fileStream = new FileInputStream("D:\\LearningAutomation\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		
		
		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i =0; i<sheet.getLastRowNum(); i++) {
		
		for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
			
			data[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
			
		}

		}
		workbook.close();
		return data;
		
	}
	

	//@AfterMethod
	public void tearDown() {
		
//	driver.quit();
		
	}

}
