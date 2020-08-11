package Selenium4;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindow {

	public static void main(String[] args) {
		
	WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String>itr = handles.iterator();
		 String parentwindow = itr.next();
		 String childtwindow = itr.next();
		 driver.switchTo().window(childtwindow);
		 
		 driver.get("https://rahulshettyacademy.com/");
		 
		 String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		 driver.switchTo().window(parentwindow);
		 driver.findElement(By.xpath("//input[@name='name']")).sendKeys(courseName);
		 driver.quit();

	}

}
