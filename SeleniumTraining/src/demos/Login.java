package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. Define the web browser
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//2. Open web browser and navigate to page
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		
		// Find Elements: Locate the element, Determine the action and pass any parameter
				
		//3. enter email address
		driver.findElement(By.id("MainContent_txtUserName")).sendKeys("tim@testemail.com");
		
		//4. enter password
		driver.findElement(By.id("MainContent_txtPassword")).sendKeys("trpass");
		
		
		//5. Click Login
		driver.findElement(By.id("MainContent_btnLogin")).click();
		
		//6. Get Verification
		String message = driver.findElement(By.id("conf_message")).getText();
		
		System.out.println("Confirmation: " + message);
		
		String pageTitle = driver.getTitle();
				
		//7. Close browser
		driver.close();
		
		

	}

}
