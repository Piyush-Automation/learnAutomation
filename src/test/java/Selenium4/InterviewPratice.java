package Selenium4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InterviewPratice {
	WebDriver driver;

	@BeforeMethod
	public void setup() {

	System.setProperty("webdriver.chrome.driver","D:\\LearningAutomation\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	}
	
	@Test
	public void logintest() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.getTitle());
		
//		driver.findElement(By.xpath("//div[@id='radio-btn-example']//label[3]//input[1]")).click();
//		
//		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("India");
//		
//		
//		Select sel = new Select(driver.findElement(By.id("dropdown-class-example")));
//		sel.selectByIndex(1);
//		
//		driver.findElement(By.id("checkBoxOption2")).click();
//		driver.findElement(By.id("checkBoxOption1")).click();
		
//		driver.findElement(By.id("openwindow")).click();
//		
//		Set<String> windowhandles = driver.getWindowHandles();
//		
//		System.out.println(windowhandles.size());
//		
//		for(String str : windowhandles ) {
//			driver.switchTo().window(str);
//			
//		}
//		System.out.println(driver.getTitle());
	
//		Thread.sleep(8000);
//		driver.findElement(By.xpath("//button[contains(text(),'NO THANKS')]")).click();
//		
//		driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
//		System.out.println("New window title "+driver.getTitle());
		
//		driver.findElement(By.xpath("//a[@id='opentab']")).click();
//		Set<String> windowhandles1 = driver.getWindowHandles();
//		
//		System.out.println(windowhandles1.size());
//		
//		for(String str : windowhandles1 ) {
//			driver.switchTo().window(str);
//			
//		}
//		System.out.println("in new tab "+driver.getTitle());
		
//		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Piyush Gupta");
//		
//		driver.findElement(By.id("confirmbtn")).click();
//		Thread.sleep(3000);
//		
//		System.out.println(driver.switchTo().alert().getText());
//		
//		driver.switchTo().alert().dismiss();
		
//		WebElement tabledata = driver.findElement(By.id("product"));
//		List<WebElement> rowdata=tabledata.findElements(By.tagName("tr"));
//		for(WebElement rows : rowdata) {
//			List<WebElement> coldata = rows.findElements(By.tagName("td"));
//			for(WebElement cols : coldata) {
//				System.out.print(cols.getText());
//				System.out.print("--");
//			}
//			System.out.println();
//		}
		
//		driver.findElement(By.id("hide-textbox")).click();
//		driver.findElement(By.id("show-textbox")).click();
//		driver.findElement(By.id("displayed-text")).sendKeys("Piyush gpta");
//	
//		Actions act = new Actions(driver);
//		act.moveToElement(driver.findElement(By.id("show-textbox"))).build().perform();;
		
		driver.switchTo().frame("courses-iframe");
		
		Thread.sleep(4000);
		
		driver.findElement(By.linkText("Register")).click();
		
		//driver.findElement(By.xpath("/html/body/app-root/div/header/div[2]/div/div/div[2]/nav/div[2]/ul/li[9]/a")).click();
		
								

}
	@AfterMethod
	public void tearDown() {
		
	//driver.close();
		
	}
	
	}
