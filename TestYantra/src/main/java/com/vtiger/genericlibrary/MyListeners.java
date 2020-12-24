package com.vtiger.genericlibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


/**
 * This generic class used to mention the Listener 
 * @author Manjunath
 *
 */
public class MyListeners  extends BaseTest  implements ITestListener{


	public void onTestStart(ITestResult result) {
		Reporter.log(result.getName()+" Method Started",true);		
	}

	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName()+" Method Passed",true);		
	}

	public void onTestFailure(ITestResult result) {
		Reporter.log(result.getName()+" Method Failed",true);	
		WebDriverCommonLib wdlib=new WebDriverCommonLib();
			try {
				wdlib.takePageScreenShot(result.getName());
			} catch (Throwable e) {
				e.printStackTrace();
			}
			
	}

	public void onTestSkipped(ITestResult result) {
		Reporter.log(result.getName()+" Method Skipped",true);		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		Reporter.log(context.getName()+" Started",true);		
	}

	public void onFinish(ITestContext context) {
		Reporter.log(context.getName()+" Ended",true);		
	}
	
	
	
	

}
