package demos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount {

	public static void main(String[] args) {
		String gender = "Female";
		boolean weeklyEmail = true;
		boolean monthlyEmail = true;
		
		// TODO Auto-generated method stub
		//1. Create Webdriver
		System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.23.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//2. Navigate to Account Mangement Page >> Click on create account
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		//Webelement
		WebElement weeklyCheckbox =	driver.findElement(By.id("MainContent_checkWeeklyEmail"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("CREATE ACCOUNT")));
		driver.findElement(By.linkText("CREATE ACCOUNT")).click();
		//3. Fill out form 
		driver.findElement(By.name("ctl00$MainContent$txtFirstName")).sendKeys("Mary Smith");
		driver.findElement(By.id("MainContent_txtEmail")).sendKeys("ms@testemail.com");
		driver.findElement(By.name("ctl00$MainContent$txtHomePhone")).sendKeys("631222222");
		
		driver.findElement(By.cssSelector("input[id='MainContent_txtPassword']")).sendKeys("mspass");
		driver.findElement(By.id("MainContent_txtVerifyPassword")).sendKeys("mspass");
		
		//How to interact with other HTML elements
		if(gender.equals("Male")){
			driver.findElement(By.id("MainContent_Male")).click();
		}
		else
			driver.findElement(By.id("MainContent_Femaile")).click();
		new Select(driver.findElement(By.id("MainContent_menuCountry"))).selectByValue("Canada");
		if (weeklyEmail){
			if(!weeklyCheckbox.isSelected())
				weeklyCheckbox.click();
		}
		else{
			if (weeklyCheckbox.isSelected())
				weeklyCheckbox.click();
		}
		
		driver.findElement(By.id("MainContent_checkMonthlyEmail")).click();
		driver.findElement(By.id("MainContent_btnSubmit")).click();
		
		
		//4. Get Confirmation
		String result = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
		
		if(result.equals("Customer information added successfully")){
			System.out.println("Submitted Successfully");
		}
		else{
			System.out.println("Submission Failed");
		}
		
		//5. Close the browser
		driver.close();

	}

}
