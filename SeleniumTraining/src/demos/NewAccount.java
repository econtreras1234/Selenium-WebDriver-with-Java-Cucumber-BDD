package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccount {

	public static void main(String[] args) {
		String name = "Mary Smith";
		String email = "ms@testemail.com";
		String phoneNumber="631222222";
		String password="mspass";
		String browserType = "chrome";
		WebDriver driver;
		
		String gender;
		String country="Canada";
		
		String weeklyEmail;
		String monthlyEmail;
		String occassionalEmail;
		//Code for Chrome
		//1. Create Webdriver
		driver = utilities.DriverFactory.open(browserType);
		driver.manage().window().maximize();
		//Define WebElements
		WebElement nameElement = driver.findElement(By.name("ctl00$MainContent$txtFirstName"));
		WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail"));
		WebElement phoneElement = driver.findElement(By.id("MainContent_txtEmail"));
		//2. Navigate to Account Mangement Page >> Click on create account
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
				
		WebDriverWait wait = new WebDriverWait(driver, 5);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("CREATE ACCOUNT")));
		driver.findElement(By.linkText("CREATE ACCOUNT")).click();
		//3. Fill out form 
		
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		phoneElement.sendKeys(phoneNumber);
		
		driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']")).sendKeys(password);
		driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys(password);
		
		//How to interact with other HTML elements
		driver.findElement(By.id("MainContent_Male")).click();
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByValue(country);
		driver.findElement(By.id("MainContent_checkMonthlyEmail")).click();
		driver.findElement(By.id("MainContent_btnSubmit")).click();
		
		
		//4. Get Confirmation
		String result = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		
		if(result.equals("Customer information added successfully"))
				System.out.println("Submitted Successfully");
		
		//5. Close the browser
		driver.close();


	}

}
