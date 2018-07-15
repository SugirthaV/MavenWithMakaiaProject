package lib.selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import lib.listeners.WebDriverListener;

public class WebDriverServiceImpl extends WebDriverListener implements WebDriverService{

	public WebElement locateElement(String locator, String locValue) {
		
		try {
			switch (locator) {
			case "id": return driver.findElement(By.id(locValue));
			
			case "class": return driver.findElement(By.className(locValue));
			
			case "link" : return driver.findElement(By.linkText(locValue));
			
			case "xpath" : return driver.findElement(By.xpath(locValue));
			
			case "name" : return driver.findElement(By.name(locValue));

			default:
				break;
			}
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void type(WebElement ele, String data) {
		try {
			ele.sendKeys(data);
			reportSteps("The Data "+data+" entered sccessfully", "PASS");
		} catch (InvalidElementStateException e) {
			// TODO Auto-generated catch block
			//System.err.println("ELement" +ele + "not Ready for Typing");
			reportSteps("Not Entered", "FAIL");
		}		
	}

	public void click(WebElement ele) {
		try {
			ele.click();
			reportSteps("The Data "+ele+" entered sccessfully", "PASS");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("Element" +ele+ "not fond to click");
			reportSteps("Not Clicked", "FAIL");
		}		
	}

	public String getText(WebElement ele) {
		try {
			reportSteps("The entered text "+ele+" is captured sccessfully", "PASS");
			return ele.getText();
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("Element" +ele+ "not fond to click");
			reportSteps("Not Captured", "FAIL");
		}
		return null;
	}

	public void selectDropDownUsingVisibleText(WebElement ele, String value) {
		try {
			Select dd = new Select(ele);
			dd.selectByVisibleText(value);
			reportSteps("The value "+ele+" is selected in dropdown sccessfully", "PASS");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//System.err.println("Element" +ele+ "not fond to click");
			reportSteps("Not Selected", "FAIL");
		}
		
		
	}

	public void selectDropDownUsingValue(WebElement ele, String value) {
		try {
			Select dd = new Select(ele);
			dd.selectByValue(value);
			reportSteps("The value "+ele+" is selected in dropdown sccessfully", "PASS");
		} catch (NoSuchElementException e) {
			//System.err.println("Element" +ele+ "not fond to click");
			reportSteps("Not Selected", "FAIL");
		}
		
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) {
		try {
			Select dd = new Select(ele);
			dd.selectByIndex(index);
			reportSteps("The value "+ele+" is selected in dropdown sccessfully", "PASS");
		} catch (NoSuchElementException e) {
			//System.err.println("Element" +ele+ "not fond to click");
			reportSteps("Not Selected", "FAIL");
		}
		
		
	}

	public boolean verifyExactTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean verifyPartialTitle(String expectedTitle) {
		// TODO Auto-generated method stub
		return false;
	}

	public void verifyExactText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		
	}

	public void verifyPartialText(WebElement ele, String expectedText) {
		// TODO Auto-generated method stub
		
	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		
	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub
		
	}

	public void verifySelected(WebElement ele) {
		// TODO Auto-generated method stub
		
	}

	public void verifyDisplayed(WebElement ele) {
		// TODO Auto-generated method stub
		
	}

	public void switchToWindow(int index) {
		
		Set <String> allWindows = driver.getWindowHandles();
		List <String> listOfWin = new ArrayList<String>();
		listOfWin.addAll(allWindows);
		driver.switchTo().window(listOfWin.get(index));
		
		
	}

	public void switchToFrame(WebElement ele) {
		// TODO Auto-generated method stub
		
	}

	public void acceptAlert() {
		Alert alert=driver.switchTo().alert();
		alert.accept();
		
	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		
	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		return null;
	}

	public void closeActiveBrowser() {
		driver.close();		
	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear(WebElement ele) {
		driver.unregister(this);
		ele.clear();
		driver.register(this);
	}
	
	public void pressEscape() {
		driver.getKeyboard().sendKeys(Keys.ESCAPE);
	}
	
	public void mouseHoverOver(WebElement ele) {
		
		Actions builder = new Actions(driver);
		builder.moveToElement(ele).perform();
		
	}
	


}
