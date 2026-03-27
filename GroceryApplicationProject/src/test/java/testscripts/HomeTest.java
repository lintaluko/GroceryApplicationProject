package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	HomePage homepage;
	@Test(retryAnalyzer = retrymechanism.Retry.class, description=  "validating if user is able to Logout")
public void verifyUserIsAbleToSuccessfullyLogOut() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver); //one time proper declaration should be there
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage= login.clickOnSigninButton();
		homepage.clickAdminButton();
		homepage.clickLogOutButton();
		String actual=homepage.getApplicationTitle();
		String expected ="7rmart supermarket";
		Assert.assertEquals(actual,expected,Constants.LOGOUTERROR);
		
		
}

}
