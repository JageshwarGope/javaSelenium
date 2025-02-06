package javaSelenium;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		
		WebElement signIn = driver.findElement(By.xpath("//a[@class='signin']"));
		
		signIn.click();
		
		WebElement userName = driver.findElement(By.xpath("//input[@id='login1']"));
		
		userName.sendKeys("jgope654@gmail.com");
		
		WebElement userPass= driver.findElement(By.xpath("//input[@id='password']"));
		
		userPass.sendKeys("jagu1123@");
		
		WebElement proceed= driver.findElement(By.xpath("//input[@name='proceed']"));
		
		proceed.click();
		
		
		WebElement actualText = driver.findElement(By.xpath("//*[@id='div_login_error']"));
		
		String actualTextString = actualText.getText();
		
		//String expectedTextString = "Wrong username and password combination.";
		
		System.out.println(actualTextString);
		
		
	
//		if(actualTextString.equalsIgnoreCase(expectedTextString)) {
//			createAccountLink.click();
//		}
		
		Assert.assertEquals("Error login message validation", actualTextString, "Wrong username and password combination.");

		
		Thread.sleep(10000);
		
		driver.quit();
		
		
	}

}
