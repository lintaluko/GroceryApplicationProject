package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

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
		

		public void enterUserNameOnUserNameField(String username) {
			usernamefield.sendKeys(username);
		}

		public void enterPasswordOnPasswordField(String password) {
			passwordbutton.sendKeys(password);
		}

		public void clickOnSigninButton() {
			signinbutton.click();
		}
		public boolean isDashBoardDisplayed() {
			return dashboardtile.isDisplayed();
		}
		public String getApplicationTitle() {
			return applicationtitle.getText();
		}

	}


