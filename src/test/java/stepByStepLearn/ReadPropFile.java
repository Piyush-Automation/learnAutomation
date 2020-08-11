package stepByStepLearn;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadPropFile {
	
	public WebDriver driver;
	public String browserName;
	
	@BeforeMethod
	public void readpropfile() {
		Properties prop = new Properties();
		try {
			InputStream input= new FileInputStream("D:\\LearningAutomation\\SeleniumDailyPratice\\src\\test\\java\\Utility\\config.properties");
			prop.load(input);
			browserName = prop.getProperty("browser");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void login() {
		
		if(browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		
		driver.get("https://automationstepbystep.com/");
			
	}
	
	@AfterMethod
	public void writeinpropfile() {
		Properties prop = new Properties();
		try {
			OutputStream output = new FileOutputStream("D:\\LearningAutomation\\SeleniumDailyPratice\\src\\test\\java\\Utility\\config.properties");
			prop.setProperty("result", "pass");
			prop.store(output, null);
			driver.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	

}
