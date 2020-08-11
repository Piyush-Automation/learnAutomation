package Selenium4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class firstClass {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {

	System.setProperty("webdriver.chrome.driver","D:\\LearningAutomation\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}
	
	//@Test(priority =1)
	public void logintest() throws InterruptedException {
		driver.get("https://demoqa.com/text-box");
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.findElement(By.id("userName")).sendKeys("Kiran hada");
		
		driver.findElement(By.id("userEmail")).sendKeys("Kiran.hada@aexp.com");
		
		driver.findElement(By.id("currentAddress")).sendKeys("jaipur");
		
		driver.findElement(By.id("permanentAddress")).sendKeys("jaipur");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		
		String  ele = driver.findElement(By.xpath("//div[@id='output']//div")).getText();
		
		System.out.println(ele);
			
	}
	
	//@Test(priority =2)
	public void tablereading() {

		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebElement table = driver.findElement(By.id("product"));
		
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		for(int i=0;i<rows.size();i++) {
		
			List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
			
			for(int j=0;j<cols.size();j++) {
				
				String tabledata = cols.get(j).getText();
				System.out.print(tabledata);
				System.out.print("--");
			}
			System.out.println();
			
		}

	}
	//@Test
	public void windowhandlestest() {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("openwindow")).click();
		
		Set<String> totalopenwindow = driver.getWindowHandles();
		
		System.out.println("Total open window "+totalopenwindow.size());
		
		for(String str :totalopenwindow) {
			
			driver.switchTo().window(str);
			
		}
		String childwindowtitle = driver.getTitle();
		
		System.out.println("Child Window Title "+childwindowtitle);
		
		
	}
	
	@Test
	public void excelReading() throws IOException, InterruptedException {
		driver.get("https://demoqa.com/text-box");
		FileInputStream fileStream = new FileInputStream("D:\\LearningAutomation\\TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fileStream);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
	
		for (int i = 1; i <= rowCount; i++) {
			WebElement username = driver.findElement(By.id("userName"));
			username.clear();
			username.sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
			
			WebElement email = driver.findElement(By.id("userEmail"));
			email.clear();
			email.sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
			
			WebElement add1 = driver.findElement(By.id("currentAddress"));
			add1.clear();
			add1.sendKeys(sheet.getRow(i).getCell(2).getStringCellValue());
			WebElement add2 = driver.findElement(By.id("permanentAddress"));
			add2.clear();
			add2.sendKeys(sheet.getRow(i).getCell(3).getStringCellValue());
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//button[@id='submit']")).click();
			
			String  ele = driver.findElement(By.xpath("//div[@id='output']//div")).getText();
			
			System.out.println(ele);
			workbook.close();
		}
		
	}
	

		
	
	@AfterMethod
	public void tearDown() {
		
//	driver.quit();
		
	}
	
	
	

}
