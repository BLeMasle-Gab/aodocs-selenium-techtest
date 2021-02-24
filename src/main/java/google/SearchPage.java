package google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ToolboxWebElement;

public class SearchPage 
{
	@FindBy(xpath = "//iframe[contains(@src,'google.fr&continue')]")
	static WebElement googleIframe;
	
	@FindBy(id = "introAgreeButton")
	static WebElement iAgree;
	
	@FindBy(name = "q")
	static WebElement searchField;
	
	private static WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		SearchPage.driver = driver;
		PageFactory.initElements(SearchPage.driver, this);
	}
	
	static SearchPage init(WebDriver driver)
	{
		return new SearchPage(driver);
	}
	
	public static void searchWordsOnPage(String searchWord)
	{
		if(ToolboxWebElement.ifExist(googleIframe))
		{
			ToolboxWebElement.switchOnIFrame(driver, googleIframe);
			ToolboxWebElement.clickOnButton(iAgree);
			ToolboxWebElement.switchToDefaultWindow(driver);
		}
		
		ToolboxWebElement.sendValueOnField(searchField, searchWord + "\n");					
	}
}
