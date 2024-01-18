package cOVSERFOX_Test;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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
public class CF_TC55_LiSTNERfaIL_Parametric_Validate_search_results_for_healthcare_plocies extends Base {
  
	//here we are using logger of log4j
	public static Logger logger;
	
	COVSERFOXHOMEPAGE home ;
	COVSERFOXHEALTH_PLAN  healthPlan;
	COVSERFOXMEMBER_DETAILS memberDetail;
	COVSERFOXADRESS_DETAILS adress;
	COVSERFOXRESULT  result;
	
	@BeforeClass
	public void launchBrowser() throws InterruptedException
	{
		
		logger= logger.getLogger("COVERFOXINSURANCE");
		PropertyConfigurator.configure("log4j.properties");
		logger.fatal(adress);
		
		logger.info("Launching coverfox");
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
		logger.info("click on started Button");
		home.clickGetStartedButton();
		
		logger.info("ckick in next button");
		healthPlan.clickNextButton(); //clickNextButton
		
		logger.info("handling age dropdown");
		memberDetail.handleAgeDropDown(Utility.readDataFromExcelsheet(1, 0));
		logger.info("click on next buttton");
		memberDetail.clickNextBurron();
		
		logger.warn("Entering pincode");
		adress.enterPinCode(Utility.readDataFromExcelsheet(1, 1));
		logger.info("Entering mobile number");
		adress.enterMobileNumber(Utility.readDataFromExcelsheet(1, 2));
		logger.info("click on ncontinue button");
		adress.clickContinueButton();
		
	}
	
	@Test
  public void validateTestPlansFromTextAndBanners() throws InterruptedException, IOException 
  {
		Thread.sleep(5000);
		logger.error("Fetching No of Details from Text");
		Reporter.log("Fetching No of Details from Text", true);
		int textReult = result.textpolicienumber();
		logger.warn("Fetching No of Details from Banner");
		Reporter.log("Fetching No of Details from Banner", true);
		int bannerResult = result.bannerpoliciesnumber();
		
		Assert.assertEquals(textReult, bannerResult,"textreult and bannerResult are  matching");
		logger.fatal("Tc is Passed");
		Reporter.log("Tc is Passed", true);
		System.out.println(Utility.prorReadDataFromPropertiesFile("Pincode"));
		Thread.sleep(500);
  }
	
	@AfterClass
	public void closeCoverFox() throws InterruptedException
	{
		closeBrowser();
	}
}
