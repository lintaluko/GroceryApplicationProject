package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	public WebDriver driver;
	WaitUtility wait= new WaitUtility();

		public LoginPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);

		}

		@FindBy(xpath = "//input[@placeholder='Username']")
		WebElement usernamefield; // annotation provided by PageFactory
		@FindBy(xpath = "//input[@placeholder='Password']")
		WebElement passwordbutton;
		@FindBy(xpath = "//button[@type='submit']")
		WebElement signinbutton;
		@FindBy(xpath="//p[text()='Dashboard']")
		WebElement dashboardtile;
		@FindBy(xpath="//b[text()='7rmart supermarket']")
		WebElement applicationtitle;
		

		public LoginPage enterUserNameOnUserNameField(String username) {
			usernamefield.sendKeys(username);
			return this;
		}

		public LoginPage enterPasswordOnPasswordField(String password) {
			passwordbutton.sendKeys(password);
			return this;
		}

		public HomePage clickOnSigninButton() {
			signinbutton.click();
			return new HomePage(driver);
		}
		public boolean isDashBoardDisplayed() {
			return dashboardtile.isDisplayed();
		}
		public String getApplicationTitle() {
			return applicationtitle.getText();
		}

	}


