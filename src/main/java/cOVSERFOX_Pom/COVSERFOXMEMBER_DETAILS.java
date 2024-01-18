package cOVSERFOX_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class COVSERFOXMEMBER_DETAILS 
{
	@FindBy(id = "Age-You") private WebElement ageDropDown;
	@FindBy(className = "next-btn") private  WebElement nextButton;
	
	public COVSERFOXMEMBER_DETAILS(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void handleAgeDropDown(String age) throws InterruptedException
	{
		Reporter.log("Handling AgeDropDown ", true);
		Select s = new Select(ageDropDown);
		s.selectByValue(age+"y");
		Thread.sleep(1000);
	}
	public void clickNextBurron() throws InterruptedException 
	{
		Reporter.log("Clicking on next Button", true);
		nextButton.click();
		Thread.sleep(1000);
		
	}

}
