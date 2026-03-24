package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage { 
		public WebDriver driver;

		public AdminUsersPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);

}
		@FindBy(xpath="//a[@onclick='click_button(1)']")
	    WebElement newuser;
		@FindBy(xpath="//input[@class='form-control' and @id='username']")
		WebElement newusernamefield;
		@FindBy(xpath="//input[@class='form-control' and @id='password']")
		WebElement newpasswordfield;
		@FindBy(xpath="//select[@id='user_type' and @name='user_type']")
		WebElement newuserdropdown;
		@FindBy(xpath="//button[@name='Create']")
		WebElement savebutton;
		@FindBy(xpath="//a[@onclick='click_button(2)']")
		WebElement searchbutton;
		@FindBy(xpath="//input[@class='form-control' and @name='un']")
		WebElement searchusername;
		@FindBy(xpath="//select[@class='form-control' and @name='ut']")
		WebElement searchusertype;
		@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger' and @name='Search']")
		WebElement searchsubmit;
		@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")
		WebElement resetbutton;
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
		WebElement successalert;
		@FindBy(xpath="//div[@class='card-body table-responsive p-0']")
		WebElement searchsuccess;
		@FindBy(xpath="//h4[@class='card-title'and text()='Admin Users']")
		WebElement resetdisplay;
		
		
		public void clickOnNewButton() {
			newuser.click();
		}
		public void enterUsernameOnUsernameField(String newusername) {
			newusernamefield.sendKeys(newusername);
			
		}
		public void enterPasswordOnPasswordField(String newpassword) {
			newpasswordfield.sendKeys(newpassword);
		}
		public void selectUserTypeFromDropDown(String usertype) {
			Select select =new Select(newuserdropdown);
			select.selectByVisibleText(usertype);
		}
		
		public void clickOnSaveButton() {
			savebutton.click();
		}
		
		public void clickOnSearchButton() {
			searchbutton.click();
		}
		public void enterUsernameOnUsernameBox(String username) {
			searchusername.sendKeys(username);
			
		}
		public void selectUserTypeForSearch(String usertype) {
			Select select =new Select(searchusertype);
			select.selectByVisibleText(usertype);
		}
		public void clickOnSearchButtonAfterInputtingValues() {
			searchsubmit.click();
		}
		public void clickOnResetButton() {
			resetbutton.click();
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


