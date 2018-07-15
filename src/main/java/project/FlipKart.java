package project;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class FlipKart extends WebDriverServiceImpl{

	@Test
	public void FlipkartActions() throws InterruptedException{
			pressEscape();
			Thread.sleep(5000);
			WebElement ele = locateElement("xpath","//span[text()='TVs & Appliances']");
			mouseHoverOver(ele);
			WebElement Product = locateElement("xpath","(//span[text()='Samsung'])[2]");
			click(Product);
			WebElement minPrice = locateElement("xpath","(//select[@class='fPjUPw'])/option[4]");
			click(minPrice);
			WebElement maxPrice = locateElement("xpath","(//select[@class='fPjUPw'])[2]/option[4]");
			click(maxPrice);
			WebElement screenSize = locateElement("xpath","//div[text()='Screen Size']");
			click(screenSize);
			WebElement sizeSel = locateElement("xpath","//div[text()='48 - 55']");
			click(sizeSel);
			WebElement SelectItem = locateElement("xpath","//img[@class='_1Nyybr  _30XEf0']");
			click(SelectItem);
			switchToWindow(1);
			WebElement SelectPrice = locateElement("xpath","//div[@class='_1vC4OE _3qQ9m1']");
			String priceval = getText(SelectPrice);
			System.out.println(priceval);
			switchToWindow(0);
			WebElement SelectPrice1 = locateElement("xpath","//div[@class='_1vC4OE _2rQ-NK']");
			String priceval1 = getText(SelectPrice1);
			System.out.println(priceval1);
			if(priceval.contains(priceval1))
					{
				System.out.println("correct");
					}
			else
			{
				System.out.println("Not correct");
			}
			switchToWindow(1);
			closeActiveBrowser();
			switchToWindow(0);
			WebElement Prod1 = locateElement("xpath","(//span[text()='Add to Compare'])[1]");
			click(Prod1);
			WebElement Prod2 = locateElement("xpath","(//span[text()='Add to Compare'])[2]");
			click(Prod2);
			WebElement Compare = locateElement("xpath","//span[text()='COMPARE']");
			click(Compare);
			WebElement Titles = locateElement("xpath","//span[text()='COMPARE']");
			String VerifyText = getText(Titles);
			if(VerifyText.contentEquals("Compare"))
			{
				System.out.println("Title is correct");
			}
			else
			{
				System.out.println("Title is not correct");
			}
			
			
			
			
			
		}
	 


}
