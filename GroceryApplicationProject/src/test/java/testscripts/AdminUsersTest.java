package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {
	@Test(description="validating if user is able to add new users")
	public void verifyWhetherUserIsAbleToAddANewUser() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninButton();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnAdminUsersMoreInfoButton();
		FakerUtility faker=new FakerUtility();
		String newusername = faker.createRandomUserName();
		String newpassword = faker.createRandomPassword();
		String usertype =ExcelUtility.readStringData(0, 2, "AdminUsersPage");
		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		adminuserspage.clickOnNewButton();
		adminuserspage.enterUsernameOnUsernameField(newusername);
		adminuserspage.enterPasswordOnPasswordField(newpassword);
		adminuserspage.selectUserTypeFromDropDown(usertype);
		adminuserspage.clickOnSaveButton();
		boolean alertdisplay =adminuserspage.isSuccessAlertDisplayes();
		Assert.assertTrue(alertdisplay, "user was not able to add a new user");
	}

	@Test(description="validating if user is able to search a new user")

	public void verifyIfUserIsAbleToSearchAUser() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninButton();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnAdminUsersMoreInfoButton();
		FakerUtility faker=new FakerUtility();
		String newusername = faker.createRandomUserName();
		String usertype =ExcelUtility.readStringData(0, 2, "AdminUsersPage");
		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		adminuserspage.clickOnSearchButton();
		adminuserspage.enterUsernameOnUsernameBox(newusername);
		adminuserspage.selectUserTypeForSearch(usertype);
		adminuserspage.clickOnSearchButtonAfterInputtingValues();
		boolean searchresult=adminuserspage.isSeachSuccessfull();
		Assert.assertTrue(searchresult, "user was unable to search a user");

	}
@Test(description ="validaring if user is able to reset")
	public void verifyIfUserIsAbleToReset() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninButton();
		HomePage homepage =new HomePage(driver);
		homepage.clickOnAdminUsersMoreInfoButton();
		AdminUsersPage adminuserspage= new AdminUsersPage(driver);
		adminuserspage.clickOnResetButton();
		boolean resetsucess=adminuserspage.isresetSuccess();
		Assert.assertTrue(resetsucess, "user was unable to reset");
	
	}
}
