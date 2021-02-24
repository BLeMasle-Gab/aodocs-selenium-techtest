package utils;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ToolboxWebElement 
{
	
	public static boolean ifExist(WebElement elt)
	{
		if(elt == null)
			return false;
		
		return true;
	}
	
	public static void switchOnIFrame(WebDriver driver, WebElement Iframe)
	{
		driver.switchTo().frame(Iframe);
	}
	
	public static void clickOnButton(WebElement button)
	{
		button.click();
	}
	
	public static void sendValueOnField(WebElement field, String text)
	{
		field.sendKeys(text);
	}
	
	public static void switchToDefaultWindow(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	public static void swithToOpenedTab(WebDriver driver)
	{
		ArrayList<String> allWindows = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(allWindows.get(allWindows.size() - 1));
	}
	
	public static void selectOnDropDownList(WebElement dropDownList, String value, DropDown byDropDown)
	{
		Select selectElt = new Select(dropDownList);
		switch(byDropDown)
		{
			case ByValue:
				selectElt.selectByValue(value);
				break;
			case ByIndex:
				selectElt.selectByIndex(Integer.parseInt(value));
				break;
			case ByVisibleText:
				selectElt.selectByVisibleText(value);
				break;
			default:
				
				break;
		}
	}
	
	public static void scrollToElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static WebElement GetParent(WebElement element)
	{
		return element.findElement(By.xpath(".."));
	}
}
