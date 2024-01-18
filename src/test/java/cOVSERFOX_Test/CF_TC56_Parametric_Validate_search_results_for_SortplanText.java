package cOVSERFOX_Test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import cOVSERFOX_Base.Base;
import cOVSERFOX_Pom.COVSERFOXADRESS_DETAILS;
import cOVSERFOX_Pom.COVSERFOXHEALTH_PLAN;
import cOVSERFOX_Pom.COVSERFOXHOMEPAGE;
import cOVSERFOX_Pom.COVSERFOXMEMBER_DETAILS;
import cOVSERFOX_Pom.COVSERFOXRESULT;
import cOVSERFOX_Utility.Utility;

@Listeners(listners.ListnerCoverFox.class)
public class CF_TC56_Parametric_Validate_search_results_for_SortplanText extends Base {
  
	COVSERFOXHOMEPAGE home;
	COVSERFOXHEALTH_PLAN  healthPlan;
	COVSERFOXMEMBER_DETAILS memberDetail;
	COVSERFOXADRESS_DETAILS adress;
	COVSERFOXRESULT  result;
	
	@BeforeClass
	public void launchBrowser() throws InterruptedException
	{
		launchCoverfox();
		home = new COVSERFOXHOMEPAGE(driver);
		healthPlan = new COVSERFOXHEALTH_PLAN(driver);
		memberDetail = new COVSERFOXMEMBER_DETAILS(driver);
		adress  = new COVSERFOXADRESS_DETAILS(driver);
		result  = new  COVSERFOXRESULT(driver);
		
	}
	@BeforeMethod
	public void enterMemberDetails() throws InterruptedException, EncryptedDocumentException, IOException
	{
		home.clickGetStartedButton();
		
		healthPlan.clickNextButton(); //clickNextButton
		
		memberDetail.handleAgeDropDown(Utility.readDataFromExcelsheet(1, 0));
		memberDetail.clickNextBurron();
		
		adress.enterPinCode(Utility.readDataFromExcelsheet(1, 1));
		adress.enterMobileNumber(Utility.readDataFromExcelsheet(1, 2));
		adress.clickContinueButton();
		
	}
	
	@Test(enabled = false)
	  public void validateTestPlansFromTextAndBanners() throws InterruptedException, IOException 
	  {
			Thread.sleep(5000);
			Reporter.log("Fetching No of Details from Text", true);
			int textReult = result.textpolicienumber();
			Reporter.log("Fetching No of Details from Banner", true);
			int bannerResult = result.bannerpoliciesnumber();
			
			Assert.assertEquals(textReult, bannerResult,"textreult and bannerResult are not matching, Tc is Failed");
			Reporter.log("Tc is Passed", true);
			Thread.sleep(500);
			Utility.takeScreenShot(driver, "CF_TC55");
	  }
	
	
	
	@Test
	public void validateSortPlansButton() throws InterruptedException
	{
		Thread.sleep(5000);
		Assert.assertTrue(result.sortPlanElementPresency(), "Sortplan Button is Not implimented,Tc is Failed");
	
	}
	
	@AfterClass
	public void closeCoverFox() throws InterruptedException
	{
		Thread.sleep(10000);
		closeBrowser();
	}
}
