package Selenium4;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.tools.javac.util.Name;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementScreenShot {
	
	public static void main(String[] args) throws IOException {
		
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
	 WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
	 name.sendKeys(courseName);
	 File srcfile = name.getScreenshotAs(OutputType.FILE);
	 
	 FileUtils.copyFile(srcfile, new File("logo.png"));
	 
	 System.out.println("Height "+name.getRect().getHeight());
	 System.out.println("Width "+name.getRect().getWidth());
	 
	 System.out.println(name.getLocation());
	 driver.quit();

}

}
