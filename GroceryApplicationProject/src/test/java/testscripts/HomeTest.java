package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	@Test(description = "validating if user is able to Logout")
public void verifyUserIsAbleToSuccessfullyLogOut() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninButton();
		HomePage homepage= new HomePage(driver);
		homepage.clickAdminButton();
		homepage.clickLogOutButton();
		//String actual=homepage.getApplicationTitle();
		//String expected ="7rmart supermarket";
		//Assert.assertEquals(actual,expected,"user was able to login with invalid credentials");
		boolean dashboarddisplay= homepage.isDashBoardDisplayed();
		Assert.assertFalse(dashboarddisplay, "user is unable to logout");
		
		
		
}

}
