package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constants;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	HomePage homepage;
	ManageNewsPage managenews;
	
	@Test(description = "validating if user is able to add a new news")
	public void verifyIfUserIsAbleToAddNews() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage = login.clickOnSigninButton(); // control shifting to homepage
		managenews=homepage.clickOnMangeNewsMoreInfoButton();
		String news = ExcelUtility.readStringData(0, 0, "ManageNewsPage");
		managenews.clickOnNewsNewButton().enterNewNewsInTheBox(news).clickOnSaveButton();
		boolean newssucess=managenews.isNewsSuccess();
		Assert.assertTrue(newssucess,Constants.ADDNEWNEWSERROR);
	}

	@Test(description = "Validating if user is able to search a news")
	public void verifyUserISAbleToSearchNews() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage = login.clickOnSigninButton(); // control shifting to homepage
		homepage.clickOnMangeNewsMoreInfoButton();
		String news = ExcelUtility.readStringData(0, 0, "ManageNewsPage");
		managenews.clickOnNewsSearchButton().enterNewsTitleInBox(news).clickOnSearchAfterInputingValues();
		boolean successsearch=managenews.isNewsSearchSucess();
		Assert.assertTrue(successsearch,Constants.SEARCHNEWSERROR);

	}

	@Test(description = "Validating if user is able to reset the page")
	public void verifyUserIsAbleToResetManageNewsPage() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username).enterPasswordOnPasswordField(password);
		homepage = login.clickOnSigninButton(); // control shifting to homepage
		homepage.clickOnMangeNewsMoreInfoButton();
		managenews.clickOnNewsResetButton();
		boolean successreset= managenews.isNewsResetSucess();
		Assert.assertTrue(successreset, Constants.RESETMANAGENEWSERROR);
		
		
	}
}
