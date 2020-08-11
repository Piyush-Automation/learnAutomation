package Selenium4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.openqa.selenium.support.locators.RelativeLocator.withTagName;

public class RelativeLocators {
	
	public static void main(String[] args) {
		
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement nameEditBox= driver.findElement(By.cssSelector("[name='name']"));
		System.out.println(driver.findElement(withTagName("label").above(nameEditBox)).getText());
		
		WebElement Datelabel= driver.findElement(By.xpath("//label[text()='Date of Birth']"));
		driver.findElement(withTagName("input").below(Datelabel)).sendKeys("12/05/1991");
		
		WebElement checkbox= driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(withTagName("input").toLeftOf(checkbox)).click();
		
		WebElement radiobtn= driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
		System.out.println(driver.findElement(withTagName("label").toRightOf(radiobtn)).getText());
		
	}

}
