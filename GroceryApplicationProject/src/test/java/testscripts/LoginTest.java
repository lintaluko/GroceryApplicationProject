package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test(priority = 1, description = "validating the user credentials with valid credentials", groups = { "smoke" }) // group
																														// name
																														// either
																														// lower
																														// case
																														// or
																														// upper
	public void verifyLoginCredentialsWithValidCredentials() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninButton();
		boolean dashboarddisplay = login.isDashBoardDisplayed();
		Assert.assertTrue(dashboarddisplay, "user was unable to login with valid credentials");

	}

	@Test(priority = 2, description = "validating the user credentials with valid username and invalid password")
	public void verifyLoginCredentialsWithvalidUserNameAndInvalidPassword() throws IOException {
		String username = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninButton();
		String actual = login.getApplicationTitle();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, "user was able to login with invalid password");
		// assertion error message will be displayed in console when assertion fails

	}

	@Test(priority = 3, description = "validating the user credentials with invalid username and valid password")
	public void verifyUserLoginWithInValidUserNameandvalidPassword() throws IOException {
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninButton();
		String actual = login.getApplicationTitle();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, "user was able to login with invalid username");

	}

	@Test(priority = 4, description = "validating the user credentials with valid incredentials", groups = { "smoke" })
	public void verifyUserLoginWithInValidCredentials() throws IOException {
		String username = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninButton();
		String actual = login.getApplicationTitle();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, "user was able to login with invalid credentials");

	}

}
