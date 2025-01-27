package javaSelenium;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = null;
		
		System.setProperty("webdriver.chrome.driver","C:\\selenium webdriver\\chromedriver-win64\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("https://www.rediff.com/");
		
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//WebDriverWait waitt = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		Thread.sleep(10000);
		
		driver.close();
		
		
	}

}
