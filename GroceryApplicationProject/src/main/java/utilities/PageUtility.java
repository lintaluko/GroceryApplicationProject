package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class PageUtility {

	public void selectDropdownWithValue(WebElement element, String value) {

		Select object = new Select(element);
		object.selectByValue(value);

	}

	public void selectDropdownWithVisibleText(WebElement element, String value) {

		Select object = new Select(element);
		object.selectByVisibleText(value);

	}

	public void clickUsingJsExecutor(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public void scrollDown(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", (""));
	}
	
	
	public void pasteAFile() throws AWTException {
		Robot r = new Robot();
		r.delay(2500);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		
	}
}
