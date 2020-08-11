package Selenium4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumRevision {
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {

	System.setProperty("webdriver.chrome.driver","D:\\LearningAutomation\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//driver.get("https://demoqa.com/buttons");
	//driver.get("https://demoqa.com/frames");
	//driver.get("https://demoqa.com/nestedframes");
	//driver.get("https://demoqa.com/modal-dialogs");
	//driver.get("https://demoqa.com/accordian");
	driver.get("https://demoqa.com/auto-complete");
	}
	
	//@Test
	public void test() throws InterruptedException {
		
		Actions act = new Actions(driver);
		
		WebElement btn = driver.findElement(By.id("doubleClickBtn"));
		WebElement btn1 = driver.findElement(By.id("rightClickBtn"));
		
//		act.doubleClick(btn).perform();
//		act.contextClick(btn1).perform();
		//Thread.sleep(2000);
		WebElement btn2 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/div[3]/button"));
		btn2.click();

		
	}
	//@Test
	public void iframtest() {
		
		driver.switchTo().frame("frame1");
		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		
		driver.switchTo().parentFrame();
		
		driver.switchTo().frame("frame2");
		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
	}
	//@Test
	public void nestedframes() {
		
		driver.switchTo().frame("frame1");
		System.out.println(driver.findElement(By.xpath("//body[contains(text(),'Parent frame')]")).getText());
		WebElement child = driver.findElement(By.xpath("//body[contains(text(),'Parent frame')]//iframe"));
		driver.switchTo().frame(child);
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'Child Iframe')]")).getText());
			
	}
	//@Test
	public void modalframe() throws InterruptedException {
		
		driver.findElement(By.id("showSmallModal")).click();
		Thread.sleep(3000);
		//System.out.println(driver.findElement(By.id("//button[@id='closeSmallModal']")).getText());
		driver.findElement(By.xpath("//button[@id='closeSmallModal']")).click();
		
		
	}
	
	//@Test
	public void Largemodalframe() {
		driver.findElement(By.id("showLargeModal")).click();
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'Lorem Ipsum is simply dummy text of the printing a')]")).getText());
		
		
	}
	
	//@Test
	public void accordiantest() throws InterruptedException {
		
		driver.findElement(By.id("section1Heading")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("section2Heading")).click();
		
		System.out.println(driver.findElement(By.xpath("//p[contains(text(),'Contrary to popular belief, Lorem Ipsum is not sim')]")).getText());	
		
	}
	
	@Test
	public void autocomplete() throws InterruptedException {
		Thread.sleep(3000);
		//WebElement color = driver.findElement(By.xpath("//body/div[@id='app']/div/div/div/div/div[@id='autoCompleteContainer']/div/div/div[@id='autoCompleteMultiple']/div[@id='autoCompleteMultipleContainer']/div[1]"));
		WebElement color1  = driver.findElement(By.cssSelector(".auto-complete__indicator-separator.css-1okebmr-indicatorSeparator"));
		color1.sendKeys("Black");
		color1.sendKeys(Keys.ENTER);
		
	}

	@AfterMethod
	public void tearDown() {
		
	//driver.close();
		
	}
	
	
	

}

