package javaSelenium;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class createAccount {

//	public static void main(String[] args) {
	
	
		WebDriver driver = null;
	
		@BeforeTest
		
		public void startBrowser() {
			
			System.setProperty("webdriver.chrome.driver","C:\\selenium webdriver\\chromedriver-win64\\chromedriver.exe");
			
			 driver = new ChromeDriver();
			
			driver.get("https://www.rediff.com/");
			
			driver.manage().window().maximize();
		}
		
		
		@Test
		public void createAcc() throws IOException {
			WebElement createAccountLink = driver.findElement(By.xpath("//a[@title='Create Rediffmail Account']"));
			
			createAccountLink.click();
			
			
			
			
			WebElement enterFullName = driver.findElement(By.xpath("//input[starts-with(@name,'name')]"));
			enterFullName.sendKeys("Jageshwar Yadav");
			
			WebElement rediifMail_ID = driver.findElement(By.xpath("//input[starts-with(@name,'login')]"));
			rediifMail_ID.sendKeys("Jagu123");
			
		
			WebElement checkMailAvailability = driver.findElement(By.xpath("//input[@value='Check availability']"));
			
			checkMailAvailability.click();
			
			
			
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			
//			WebElement reccMailOption = driver.findElement(By.xpath("//div[@id='recommend_text']//tr[1]//input"));
			
			WebElement reccMailOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='recommend_text']//tr[1]//input")));
			
			reccMailOption.click();
			
			System.out.println("abcd"+reccMailOption);
			
			WebElement pass = driver.findElement(By.xpath("//input[@type='password' and starts-with(@name,'passwd')]"));
			
			pass.sendKeys("Jagu11324");
			
			
			
			
			WebElement showPassEye = driver.findElement(By.xpath("//em[@id='eyeiconNew' and @class='eye-icon']"));
			
			showPassEye.click();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			WebElement confPass = driver.findElement(By.xpath("//input[@type='password' and starts-with(@name,'confirm')]"));
		
			confPass.sendKeys("Jagu11324");
			
			WebElement altEmail = driver.findElement(By.xpath("//input[starts-with(@name,'altemail')]"));
			
			altEmail.sendKeys("Jagu11324@gmail.com");
			
			driver.findElement(By.xpath("//input[@class='nomargin']")).click();
			driver.findElement(By.xpath("//input[@id='mobno']")).sendKeys("8541074046");
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	            WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[starts-with(@name,'DOB')]")));
			
			WebElement dropdownDay = driver.findElement(By.xpath("//select[starts-with(@name,'DOB_D')]"));
			
			
			Select select = new Select(dropdownDay);
			
			select.selectByValue("05");
			
			WebElement dropdownMonth = driver.findElement(By.xpath("//select[starts-with(@name,'DOB_M')]"));
			
			Select selectM = new Select(dropdownMonth);
			
			selectM.selectByVisibleText("MAR");
			
			WebElement dropdownYear = driver.findElement(By.xpath("//select[starts-with(@name,'DOB_Y')]"));
			
			Select selectY = new Select(dropdownYear);
			
			selectY.selectByIndex(05);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			List <WebElement> radioBtn = driver.findElements(By.xpath("//input[contains(@name,'gender')]"));
			
			for(WebElement radio : radioBtn) {
				if(radio.isSelected()) {
					System.out.println("selected radio button : "+radio.getDomProperty("value"));
				}
			}
			
	     
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
		
//			js.executeScript("arguments[0].removeAttribute('checked');", radioBtn);   // not a correct way -- we should not remove radiobuttons
			
			
			WebElement selectCountry = driver.findElement(By.id("country"));
			
			js.executeScript("arguments[0].scrollIntoView(true);", selectCountry);
			
			Select selectCntry = new Select(selectCountry);
			
			WebElement selectedCountry = selectCntry.getFirstSelectedOption();
			
				System.out.println("selected county : "+selectedCountry.getText());
			
			WebElement selectCityDropdown = driver.findElement(By.xpath("//select[contains(@name,'city')]"));
			
			Select selectCity = new Select(selectCityDropdown);
			
			selectCity.selectByVisibleText("Bokaro");
			
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			
			File destFile = new File("screenshot.png");
			
			
			FileUtils.copyFile(srcFile,destFile);
			
	//		File destFile = new File("C:/Users/YourName/Desktop/screenshot.png"); // save in specific folder
			
	//		You can create a screenshots folder inside your project and save files there:
	//		File destFile = new File("screenshots/screenshot.png");
			
//			Save Screenshot with a Timestamp (To Avoid Overwriting)
//			Each time the test runs, a new screenshot will be saved with a unique timestamp:
//				
//			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//			File destFile = new File("screenshots/screenshot_" + timestamp + ".png");
			
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			
			File destFileWithTime = new File("Screenshots/screenshot_"+ timestamp +".png");
			
			FileUtils.copyFile(srcFile, destFileWithTime);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		
		
		
		
		@AfterTest
		public void close() {
			driver.quit();
		}
		
		
		
		
		
		
		
		
}



