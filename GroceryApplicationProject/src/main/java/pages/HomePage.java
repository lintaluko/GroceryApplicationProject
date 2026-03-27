package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class HomePage {
	public WebDriver driver;
	WaitUtility wait =new WaitUtility();
	PageUtility page = new PageUtility();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement adminbutton;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/logout' and @class='dropdown-item']")
	WebElement logoutbutton;
	@FindBy(xpath = "//a[@class='small-box-footer'and @href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	WebElement adminusersmoreinfo;
	@FindBy(xpath = "//a[@class='small-box-footer' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	WebElement managenewsmoreinfo;
	@FindBy(xpath="//b[text()='7rmart supermarket']")
	WebElement applicationtitle;
	@FindBy(xpath="//p[text()='Dashboard']")
	WebElement dashboardtile;
	

	public HomePage clickAdminButton() {
		wait.waitUntilElementToBeClickable(driver, adminbutton);
		//adminbutton.click();
		page.clickUsingJsExecutor(driver, adminbutton);
		return this;
	}

	public LoginPage clickLogOutButton() {
		logoutbutton.click();
		return new LoginPage(driver);
	}

	public AdminUsersPage clickOnAdminUsersMoreInfoButton() {
		adminusersmoreinfo.click();
		return new AdminUsersPage(driver);
	}

	public ManageNewsPage clickOnMangeNewsMoreInfoButton() {
		managenewsmoreinfo.click();
		return new ManageNewsPage(driver);
	}
	public String getApplicationTitle() {
		return applicationtitle.getText();
}
	public boolean isDashBoardDisplayed() {
		return dashboardtile.isDisplayed();
	}
}
