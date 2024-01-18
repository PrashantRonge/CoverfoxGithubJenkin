package cOVSERFOX_Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class Base 
{
	static protected WebDriver driver;
	//Open Browser
	public void launchCoverfox() throws InterruptedException
	{
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		Reporter.log("Launching CoverFox", true);
		driver.get("https://www.coverfox.com/");
		Thread.sleep(1000);
	}
	
	//CloseBrowser
	public void closeBrowser() throws InterruptedException
	{
		Reporter.log("Closing Browser", true);
		Thread.sleep(5000);
		driver.close();
	}
	
	

}
