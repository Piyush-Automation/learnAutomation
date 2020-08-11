package toolsQAPratice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverMangerConcept {
	private WebDriver driver;
	
	@Test
	public void seleniumTest() {
		WebDriverManager.chromiumdriver().setup();
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
//		WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
//		WebDriverManager.iedriver().setup();

	//	driver = new EdgeDriver();
		driver.get("https://www.google.com/");
		driver.quit();
		
	}
	

}
