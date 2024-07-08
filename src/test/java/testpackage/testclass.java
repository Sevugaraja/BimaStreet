package testpackage;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; 
import org.testng.Assert;
import org.testng.annotations.*;                                                                                                                                                                                                          
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testclass {

		public static WebDriver driver;
		@BeforeMethod
		public static void preRequesticMethod() {                     
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();		
		}
		
		@Test(priority=1)
		public static void testMethod() throws Exception{
			driver.get(readValue("DomainOne"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			Assert.assertEquals(driver.getTitle(),readValue("DomainOneTitle"));	
			driver.findElement(By.xpath("//p[text()='Health Insurance']/parent::a")).click();
			Thread.sleep(3000);
			Assert.assertEquals(driver.getTitle(), readValue("BimastreetInsuranceTitle"));
			Assert.assertTrue(driver.findElement(By.xpath("//input[@id='One Adult']")).isSelected());
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='Son ']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='1st Adult DOB']")).click();
			Thread.sleep(3000);
			String actualAdultDate = driver.findElement(By.xpath("//div[contains(@class,'MuiPickersCalendarHeader') and @id]")).getText();
			if(!(actualAdultDate.equals(splitMethod(readValue("AdultOneDoB"),2)))) {
				driver.findElement(By.xpath("//button[contains(@class,'switchViewButton')]")).click();
				driver.findElement(By.xpath("//button[text()='"+splitMethod(readValue("AdultOneDoB"),2)+"']")).click();	
				Thread.sleep(4000);
				driver.findElement(By.xpath("//button[text()='"+splitMethod(readValue("AdultOneDoB"),0)+"']")).click();
			}
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='Child 1 Date of birth (DOB)']")).click();
			Thread.sleep(3000);
			String actualSonDate = driver.findElement(By.xpath("//div[contains(@class,'MuiPickersCalendarHeader') and @id]")).getText();
			if(!(actualSonDate.equals(splitMethod(readValue("SonOneDoB"),2)))) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[contains(@class,'switchViewButton')]")).click();
				driver.findElement(By.xpath("//button[text()='"+splitMethod(readValue("SonOneDoB"),2)+"']")).click();					
				Thread.sleep(5000);
				driver.findElement(By.xpath("//button[text()='"+splitMethod(readValue("SonOneDoB"),0)+"']")).click();
			}
			Thread.sleep(2000);
			WebElement gender =driver.findElement(By.xpath("//div[@id='Gender']"));
			gender.click();
			Thread.sleep(2000);
			dropdownMethod(driver.findElements(By.xpath("//ul/li")),readValue("Gender")).click();
			Thread.sleep(2000);
			WebElement continueElement = driver.findElement(By.xpath("//button[text()='Continue']"));
			scrollToElement(continueElement);
			jsClickElement(continueElement);
			Thread.sleep(2000);
			driver.findElement(By.id("Mobile")).sendKeys(readValue("MobileNumber"));
			Thread.sleep(2000);
			driver.findElement(By.id("Pincode")).sendKeys(readValue("Pincode"));
			Thread.sleep(4000);
			
		}
		
		@Test(priority=2)
		public static void testMethod2() throws Exception{
			driver.get(readValue("DomainOne"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			Assert.assertEquals(driver.getTitle(),readValue("DomainOneTitle"));	
			driver.findElement(By.xpath("//p[text()='Health Insurance']/parent::a")).click();
			Thread.sleep(3000);
			Assert.assertEquals(driver.getTitle(), readValue("BimastreetInsuranceTitle"));
			Assert.assertTrue(driver.findElement(By.xpath("//input[@id='One Adult']")).isSelected());
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@id='Two Adult']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='Daughter ']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='1st Adult DOB']")).click();
			Thread.sleep(3000);
			String actualAdultDate = driver.findElement(By.xpath("//div[contains(@class,'MuiPickersCalendarHeader') and @id]")).getText();
			if(!(actualAdultDate.equals(splitMethod(readValue("AdultSecondDoB"),2)))) {
				driver.findElement(By.xpath("//button[contains(@class,'switchViewButton')]")).click();
				driver.findElement(By.xpath("//button[text()='"+splitMethod(readValue("AdultSecondDoB"),2)+"']")).click();	
				Thread.sleep(4000);
				driver.findElement(By.xpath("//button[text()='"+splitMethod(readValue("AdultSecondDoB"),0)+"']")).click();
			}
			Thread.sleep(3000);
			WebElement gender =driver.findElement(By.xpath("//div[@id='Gender']"));
			gender.click();
			Thread.sleep(2000);
			dropdownMethod(driver.findElements(By.xpath("//ul/li")),readValue("GenderSecond")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='2nd Adult DOB']")).click();
			Thread.sleep(3000);
			String actualAdultSecondDate = driver.findElement(By.xpath("//div[contains(@class,'MuiPickersCalendarHeader') and @id]")).getText();
			if(!(actualAdultSecondDate.equals(splitMethod(readValue("AdultSecondMaleDoB"),2)))) {
				driver.findElement(By.xpath("//button[contains(@class,'switchViewButton')]")).click();
				driver.findElement(By.xpath("//button[text()='"+splitMethod(readValue("AdultSecondMaleDoB"),2)+"']")).click();	
				Thread.sleep(4000);
				driver.findElement(By.xpath("//button[text()='"+splitMethod(readValue("AdultSecondMaleDoB"),0)+"']")).click();
			}
			Thread.sleep(3000);
			WebElement relationShip =driver.findElement(By.xpath("//div[contains(@id,'Relationship')]"));
			relationShip.click();
			Thread.sleep(2000);
			dropdownMethod(driver.findElements(By.xpath("//ul/li")),readValue("RelationShip")).click();
			Thread.sleep(2000);
			jsClickElement(driver.findElement(By.xpath("//input[@id='Child 1 Date of birth (DOB)']")));
			Thread.sleep(3000);
			String actualSonDate = driver.findElement(By.xpath("//div[contains(@class,'MuiPickersCalendarHeader') and @id]")).getText();
			if(!(actualSonDate.equals(splitMethod(readValue("DaughterSecondDoB"),2)))) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[contains(@class,'switchViewButton')]")).click();
				driver.findElement(By.xpath("//button[text()='"+splitMethod(readValue("DaughterSecondDoB"),2)+"']")).click();					
				Thread.sleep(5000);
				driver.findElement(By.xpath("//button[text()='"+splitMethod(readValue("DaughterSecondDoB"),0)+"']")).click();
			}
			
			Thread.sleep(3000);
			WebElement continueElement = driver.findElement(By.xpath("//button[text()='Continue']"));
			scrollToElement(continueElement);
			jsClickElement(continueElement);
			Thread.sleep(2000);
			driver.findElement(By.id("Mobile")).sendKeys(readValue("MobileNumberSecond"));
			Thread.sleep(2000);
			driver.findElement(By.id("Pincode")).sendKeys(readValue("Pincode"));
			Thread.sleep(4000);
		}
		
		@AfterMethod
		public static void postRequesticMethod() {
			 driver.close();		
		}
		
		public static String readValue(String key) throws Exception {
			FileInputStream fis = new FileInputStream(".//Properties.properties");
			Properties prop = new Properties();
			prop.load(fis);
			return prop.getProperty(key);
		}
		
		public static String splitMethod(String input, int userNumber) {
			String[] inputArray = input.split("/");
			String output=null;
			for(int i = 0;i<=inputArray.length -1;i++) {
				if(i == userNumber) {
					output= inputArray[i];
					break;
				}
			}
			return output;
		}
		
		public static WebElement dropdownMethod(List<WebElement> multiElement, String UserSelect) {
			WebElement output =null;
			for(WebElement unique:multiElement) {
				if(unique.getText().equalsIgnoreCase(UserSelect)) {
					output= unique;
					break;
				}
			}
			
			return output;
		}
		public static void scrollToElement(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element);
		}
		public static void jsClickElement(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}

	}
	
	
	

                          
