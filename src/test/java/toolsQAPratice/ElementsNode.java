package toolsQAPratice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementsNode {
	WebDriver driver;

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "D:\\LearningAutomation\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

	@Test
	public void elementTest() throws InterruptedException {
		driver.get("http://www.demoqa.com");
		Thread.sleep(5000);
//		Actions act = new Actions(driver);
//		act.moveToElement(driver.findElement(By.xpath("//div[@class='category-cards']//div[1]//div[1]//div[2]//*[local-name()='svg']"))).click().build().perform();
//		
		driver.findElement(By.xpath("//div[@class='category-cards']//div[1]//div[1]//div[2]//*[local-name()='svg']")).click();
	//	driver.findElement(By.xpath("(//*[name()='svg']//*[local-name()='path'])[1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Text Box')]")).click();
		driver.findElement(By.id("userName")).sendKeys("Piyush Gupta");
		driver.findElement(By.id("userEmail")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("currentAddress")).sendKeys("Prem Nagar Jaipur");
		driver.findElement(By.id("permanentAddress")).sendKeys("Prem Nagar Jaipur");
		
		Thread.sleep(3000);
//		Actions act = new Actions(driver);
//		act.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'Submit')]"))).click().build().perform();

		
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		String output = driver.findElement(By.xpath("//div[@id='output']")).getText();

		System.out.println("~~~~~~~ "+output);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
