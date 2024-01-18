package cOVSERFOX_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class COVSERFOXHOMEPAGE 
{
	@FindBy(xpath = "//button[text()='Get Started']") private WebElement getStartedBUtton;

	public COVSERFOXHOMEPAGE(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickGetStartedButton() throws InterruptedException
	{
		Reporter.log("Clicking on Gender Button", true);
		getStartedBUtton.click();
		Thread.sleep(1000);
	}
}
