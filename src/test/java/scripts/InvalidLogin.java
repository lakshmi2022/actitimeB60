package scripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import generic.BaseTest;
import generic.Util;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class InvalidLogin extends BaseTest{
	@Test(priority = 2)
	public void testInvalidLogin(){
		String un=Util.getXlData(XL_PATH,"InvalidLogin",1,0);
		String pw=Util.getXlData(XL_PATH,"InvalidLogin",1,1);
		
//		1. Enter invalid user name
		LoginPage loginPage=new LoginPage(driver,test);
		loginPage.setUserName(un);
		
//		2. Enter invalid password
		loginPage.setPassword(pw);
	
//		3. click on login button
		loginPage.clickLoginButton();
		
//		4. verify error message is displayed
		boolean result = loginPage.errorMessage(wait);;
		Assert.assertTrue(result,"Error Message is not displayed");
		
	}
}


