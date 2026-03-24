package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger' and @href='https://groceryapp.uniqassosiates.com/admin/news/add']")
	WebElement newsnewbutton;
	@FindBy(xpath = "//textarea[@placeholder='Enter the news']")
	WebElement newsfield;
	@FindBy(xpath = "//button[text()='Save']")
	WebElement newssavebutton;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary' and @href='javascript:void(0)']")
	WebElement newssearchbutton;
	@FindBy(xpath = "//input[@placeholder='Title']")
	WebElement titlebox;
	@FindBy(xpath = "//button[@type='submit' and @name='Search']")
	WebElement search;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning' and @href='https://groceryapp.uniqassosiates.com/admin/list-news']")
	WebElement newsresetbutton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement successnews;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']")
	WebElement sucessnewssearch;
	@FindBy(xpath="//h4[@class='card-title' and text()='Manage News']")
	WebElement sucessnewsreset;
	
	public void clickOnNewsNewButton() {
		newsnewbutton.click();
	}

	public void enterNewNewsInTheBox(String news) {
		newsfield.sendKeys(news);
	}

	public void clickOnSaveButton() {
		newssavebutton.click();
	}

	public void clickOnNewsSearchButton() {
		newssearchbutton.click();
	}

	public void enterNewsTitleInBox(String news) {
		titlebox.sendKeys(news);
	}

	public void clickOnSearchAfterInputingValues() {
		search.click();
	}

	public void clickOnNewsResetButton() {
		newsresetbutton.click();
	}
	public boolean isNewsSuccess() {
		return successnews.isDisplayed();
	}
	public boolean isNewsSearchSucess() {
		return sucessnewssearch.isDisplayed();
	}
	public boolean isNewsResetSucess() {
		return sucessnewsreset.isDisplayed();
	}
}
