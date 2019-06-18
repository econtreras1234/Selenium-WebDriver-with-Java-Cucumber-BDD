package smoketest;

import org.openqa.selenium.WebDriver;

public class PageTitleJUnit {
	
	public void pageTitleTest(){
		String webURL = "ttp://sdettraining.com/trguitransactions/AccountManagement.aspx";
		
		WebDriver driver = utilities.DriverFactory.open("chrome");
		driver.get(webURL);
		String actualTitle = driver.getTitle();
		String expectedTitle = "SDET TRAINING";
	}

}
