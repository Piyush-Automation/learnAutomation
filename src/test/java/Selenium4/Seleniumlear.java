package Selenium4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Seleniumlear {
	WebDriver driver;
	@BeforeMethod
	public void setup() {

	System.setProperty("webdriver.chrome.driver","D:\\LearningAutomation\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}
	
	
	//@Test
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
                  
                  Thread.sleep(6000);
                  
                  driver.findElement(By.xpath("//button[@id='submit']")).click();
                  
                  String  ele = driver.findElement(By.xpath("//div[@id='output']//div")).getText();
                  System.out.println(ele);
                  
                  Row row = sheet.getRow(i);
                  Cell cell  = row.createCell(4);
                  cell.setCellValue(ele);
                  FileOutputStream fileOutputStream = new FileOutputStream("D:\\LearningAutomation\\TestData.xlsx");
                  workbook.write(fileOutputStream);
                
           }
           workbook.close();
           
    }
    
    @DataProvider(name = "getdata")
    public Object[][] dataproviderconcept() {
    	
    	
    	Object[][] data = new Object[2][4];
    	
    	data[0][0] = "Piyush";
    	data[0][1] = "abc@abc.com";
    	data[0][2] = "Jaipur";
    	data[0][3] = "Jaipur";
    	
    	data[1][0] = "Kiran";
    	data[1][1] = "xyz@abc.com";
    	data[1][2] = "Jaipur";
    	data[1][3] = "Jaipur";
    	
    	return data;
    	
    }
    
    @Test(dataProvider = "getdata")
    public void getdataread(String name, String emailid, String address1, String address2) throws InterruptedException {
    	 driver.get("https://demoqa.com/text-box");
    	 WebElement username = driver.findElement(By.id("userName"));
         username.clear();
         username.sendKeys(name);
         
         WebElement email = driver.findElement(By.id("userEmail"));
         email.clear();
         email.sendKeys(emailid);
         
         WebElement add1 = driver.findElement(By.id("currentAddress"));
         add1.clear();
         add1.sendKeys(address1);
         WebElement add2 = driver.findElement(By.id("permanentAddress"));
         add2.clear();
         add2.sendKeys(address2);
         
         Thread.sleep(6000);
         
         driver.findElement(By.xpath("//button[@id='submit']")).click();
         
         String  ele = driver.findElement(By.xpath("//div[@id='output']//div")).getText();
         System.out.println(ele);
    }
    
	
	//@AfterMethod
		public void tearDown() {
			
//		driver.quit();
			
		}

	}
	
	


