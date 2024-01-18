package cOVSERFOX_Pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class COVSERFOXADRESS_DETAILS 
{
	@FindBy(className = "mp-input-text") private WebElement  pinCode;
	@FindBy(id = "want-expert") private WebElement mobileNumber;
	@FindBy(xpath = "//div[text()='Continue']") private WebElement continueButton;
	 @FindBy(className = "error-ui") private WebElement errorMsg;

	public COVSERFOXADRESS_DETAILS(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void enterPinCode(String pincode) throws InterruptedException
	{
		Reporter.log("Entering PinCode ", true);
		pinCode.sendKeys(pincode);
		Thread.sleep(1000);
	}
	public void enterMobileNumber(String mobilenumber) throws InterruptedException
	{
		Reporter.log("Entering MObile NO ", true);
		mobileNumber.sendKeys(mobilenumber);
		Thread.sleep(1000);
	}
	public void clickContinueButton() throws InterruptedException
	{
		Reporter.log("Clicking on Continue Button", true);
		continueButton.click();
		Thread.sleep(1000);
	}
	public boolean errorMsgElementPresency()
	{
		boolean value = errorMsg.isDisplayed();
		return value;
	}
}
