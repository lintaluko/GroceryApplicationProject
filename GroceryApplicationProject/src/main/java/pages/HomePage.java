package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

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
	

	public void clickAdminButton() {
		adminbutton.click();
	}

	public void clickLogOutButton() {
		logoutbutton.click();
	}

	public void clickOnAdminUsersMoreInfoButton() {
		adminusersmoreinfo.click();
	}

	public void clickOnMangeNewsMoreInfoButton() {
		managenewsmoreinfo.click();
	}
	public String getApplicationTitle() {
		return applicationtitle.getText();
}
	public boolean isDashBoardDisplayed() {
		return dashboardtile.isDisplayed();
	}
}
