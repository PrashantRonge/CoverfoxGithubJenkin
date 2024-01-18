package listners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import cOVSERFOX_Base.Base;
import cOVSERFOX_Utility.Utility;

public class ListnerCoverFox extends Base implements ITestListener
{
	@Override
	public void onTestFailure(ITestResult result) {
		
		try {
			Utility.takeScreenShot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		
	}
	
	@Override
	public void onTestStart(ITestResult result)
	{
		
	}

}
