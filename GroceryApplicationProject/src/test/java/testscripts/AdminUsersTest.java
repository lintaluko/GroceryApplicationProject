package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constants;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
	HomePage homepage;
	AdminUsersPage adminuserspage;

	@Test(description = "validating if user is able to add new users")
	public void verifyWhetherUserIsAbleToAddANewUser() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage = login.clickOnSigninButton(); // control shifting to homepage
		adminuserspage = homepage.clickOnAdminUsersMoreInfoButton();
		FakerUtility faker = new FakerUtility();
		String newusername = faker.createRandomUserName();
		String newpassword = faker.createRandomPassword();
		String usertype = ExcelUtility.readStringData(0, 2, "AdminUsersPage");
		adminuserspage.clickOnNewButton().enterUsernameOnUsernameField(newusername)
				.enterPasswordOnPasswordField(newpassword).selectUserTypeFromDropDown(usertype).clickOnSaveButton();
		boolean alertdisplay = adminuserspage.isSuccessAlertDisplayes();
		Assert.assertTrue(alertdisplay, Constants.ADDUSERERROR);
	}

	@Test(description = "validating if user is able to search a new user")

	public void verifyIfUserIsAbleToSearchAUser() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage = login.clickOnSigninButton();
		adminuserspage=homepage.clickOnAdminUsersMoreInfoButton();
		FakerUtility faker = new FakerUtility();
		String newusername = faker.createRandomUserName();
		String usertype = ExcelUtility.readStringData(0, 2, "AdminUsersPage");
		adminuserspage.clickOnSearchButton().enterUsernameOnUsernameBox(newusername).selectUserTypeForSearch(usertype)
				.clickOnSearchButtonAfterInputtingValues();
		boolean searchresult = adminuserspage.isSeachSuccessfull();
		Assert.assertTrue(searchresult, Constants.SEARCHUSERERROR);

	}

	@Test(description = "validating if user is able to reset")
	public void verifyIfUserIsAbleToReset() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password).clickOnSigninButton();
		homepage = login.clickOnSigninButton();
		adminuserspage=homepage.clickOnAdminUsersMoreInfoButton();
		adminuserspage.clickOnResetButton();
		boolean resetsucess = adminuserspage.isresetSuccess();
		Assert.assertTrue(resetsucess, Constants.RESETADMINUSERERROR);

	}
}
