package cOVSERFOX_Pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class COVSERFOXRESULT 
{
	@FindBy(xpath = "//div[contains(text(),'Health Insurance Plans')]") private WebElement textPlan;
	@FindBy(id = "plans-list") private List<WebElement> bannerPlans;
	@FindBy(xpath = "//div[text()='Sort Plans']")private WebElement sortPlansField;
	
	public COVSERFOXRESULT(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public int textpolicienumber()
	{
		String test = textPlan.getText();
		String[] array = test.split(" ");
		String stringvalue = array[0];
		int integericValue = Integer.parseInt(stringvalue);
		return integericValue;
	}
	public int bannerpoliciesnumber()
	{
		int bannerpolicies = bannerPlans.size();
		return bannerpolicies;
	} 
	
	public boolean sortPlanElementPresency()
	{
		Reporter.log("Validating sortPlanElementPresency", true);
		boolean presency = sortPlansField.isDisplayed();
		return presency;
	}
	

}
