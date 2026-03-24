package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	@Test(description = "validating if user is able to add a new news")
	public void verifyIfUserIsAbleToAddNews() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninButton();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMangeNewsMoreInfoButton();
		String news = ExcelUtility.readStringData(0, 0, "ManageNewsPage");
		ManageNewsPage managenews = new ManageNewsPage(driver);
		managenews.clickOnNewsNewButton();
		managenews.enterNewNewsInTheBox(news);
		managenews.clickOnSaveButton();
		boolean newssucess=managenews.isNewsSuccess();
		Assert.assertTrue(newssucess,"user was unable to create new news");
	}

	@Test(description = "Validating if user is able to search a news")
	public void verifyUserISAbleToSearchNews() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninButton();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMangeNewsMoreInfoButton();
		String news = ExcelUtility.readStringData(0, 0, "ManageNewsPage");
		ManageNewsPage managenews = new ManageNewsPage(driver);
		managenews.clickOnNewsSearchButton();
		managenews.enterNewsTitleInBox(news);
		managenews.clickOnSearchAfterInputingValues();
		boolean successsearch=managenews.isNewsSearchSucess();
		Assert.assertTrue(successsearch, "user was unable to search news");

	}

	@Test(description = "Validating if user is able to reset the page")
	public void verifyUserIsAbleToResetManageNewsPage() throws IOException {
		String username = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(username);
		login.enterPasswordOnPasswordField(password);
		login.clickOnSigninButton();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMangeNewsMoreInfoButton();
		ManageNewsPage managenews = new ManageNewsPage(driver);
		managenews.clickOnNewsResetButton();
		boolean successreset= managenews.isNewsResetSucess();
		Assert.assertTrue(successreset, "user was unsuccessfull in resetting");
		
		
	}
}
