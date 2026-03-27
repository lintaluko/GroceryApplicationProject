package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage {
	public WebDriver driver;
	WaitUtility wait = new WaitUtility();
	PageUtility page=new PageUtility();
	
	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newuser;
	@FindBy(xpath = "//input[@class='form-control' and @id='username']")
	WebElement newusernamefield;
	@FindBy(xpath = "//input[@class='form-control' and @id='password']")
	WebElement newpasswordfield;
	@FindBy(xpath = "//select[@id='user_type' and @name='user_type']")
	WebElement newuserdropdown;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement savebutton;
	@FindBy(xpath = "//a[@onclick='click_button(2)']")
	WebElement searchbutton;
	@FindBy(xpath = "//input[@class='form-control' and @name='un']")
	WebElement searchusername;
	@FindBy(xpath = "//select[@class='form-control' and @name='ut']")
	WebElement searchusertype;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger' and @name='Search']")
	WebElement searchsubmit;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetbutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successalert;
	@FindBy(xpath = "//div[@class='card-body table-responsive p-0']")
	WebElement searchsuccess;
	@FindBy(xpath = "//h4[@class='card-title'and text()='Admin Users']")
	WebElement resetdisplay;

	public AdminUsersPage clickOnNewButton() {
		newuser.click();
		return this;
	}

	public  AdminUsersPage enterUsernameOnUsernameField(String newusername) {
		newusernamefield.sendKeys(newusername);
		return this;

	}

	public  AdminUsersPage enterPasswordOnPasswordField(String newpassword) {
		newpasswordfield.sendKeys(newpassword);
		return this;
	}

	public  AdminUsersPage selectUserTypeFromDropDown(String usertype) {
		//Select select = new Select(newuserdropdown);
		//select.selectByVisibleText(usertype);
		page.selectDropdownWithVisibleText(newuserdropdown, usertype);
		return this;
	}

	public  AdminUsersPage clickOnSaveButton() {
		wait.waitUntilElementToBeClickable(driver, savebutton);
		savebutton.click();
		return this;
	}

	public  AdminUsersPage clickOnSearchButton() {
		searchbutton.click();
		return this;
	}

	public AdminUsersPage enterUsernameOnUsernameBox(String username) {
		searchusername.sendKeys(username);
		return this;

	}

	public AdminUsersPage selectUserTypeForSearch(String usertype) {
		//Select select = new Select(searchusertype);
		//select.selectByVisibleText(usertype);
		page.selectDropdownWithVisibleText(searchusertype, usertype);
		return this;
	}

	public AdminUsersPage clickOnSearchButtonAfterInputtingValues() {
		searchsubmit.click();
		return this;
	}

	public AdminUsersPage clickOnResetButton() {
		resetbutton.click();
		return this;
	}

	public boolean isSuccessAlertDisplayes() {
		return successalert.isDisplayed();
	}

	public boolean isSeachSuccessfull() {
		return searchsuccess.isDisplayed();
	}

	public boolean isresetSuccess() {
		return resetdisplay.isDisplayed();
	}
}
