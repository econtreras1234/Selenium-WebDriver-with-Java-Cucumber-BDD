package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
	
	//This method return a WebDriver object
	public static WebDriver open(String browserType) {
		if(browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			return new ChromeDriver();
		}
		else if(browserType.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
			return new InternetExplorerDriver();			
		}
		else {
			//Code for Firefox
			System.setProperty("webdriver.gecko.driver", "D:\\geckodriver-v0.23.0-win64\\geckodriver.exe");
			return new FirefoxDriver();
		}
	}

}

