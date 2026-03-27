package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	HomePage homepage;
	@Test(priority = 1, description = "validating the user credentials with valid credentials", groups = { "smoke" }) 
	public void verifyLoginCredentialsWithValidCredentials() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password); //connecting using dot operator.
		homepage=login.clickOnSigninButton();
		boolean dashboarddisplay = login.isDashBoardDisplayed();
		Assert.assertTrue(dashboarddisplay, Constants.VALIDCREDENTIALSERROR);

	}

	@Test(priority = 2, description = "validating the user credentials with valid username and invalid password")
	public void verifyLoginCredentialsWithvalidUserNameAndInvalidPassword() throws IOException {
		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSigninButton(); //same page
		String actual = login.getApplicationTitle();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constants.INVALIDPASSWORDERROR);
		// assertion error message will be displayed in console when assertion fails

	}

	@Test(priority = 3, description = "validating the user credentials with invalid username and valid password")
	public void verifyUserLoginWithInValidUserNameandvalidPassword() throws IOException {
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSigninButton();
		String actual = login.getApplicationTitle();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constants.INVALIDUSERNAMEERROR);

	}

	@Test(priority = 4, description = "validating the user credentials with invalid credentials", groups = { "smoke" },dataProvider = "loginProvider")
	public void verifyUserLoginWithInValidCredentials(String username, String password) throws IOException {
		//String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		//String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSigninButton();
		String actual = login.getApplicationTitle();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constants.INVALIDCREDENTIALSERROR);

	}
	 @DataProvider(name = "loginProvider") //can give any name
	 	public Object[][] getDataFromDataProvider() throws IOException { //declaration form of data provider, any method name.
	  
	 		return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" }, 
	 				// new Object[] {ExcelUtility.getStringData(3, 
	 				// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")} //can read from excel too
	 		}; 
	 	}
}
