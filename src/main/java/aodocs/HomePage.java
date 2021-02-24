package aodocs;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ToolboxWebElement;

public class HomePage 
{
	@FindBy(xpath = "//a[contains(@href, 'request_demo')]")
	static WebElement requestDemoLink;
	
	@FindBy(id = "hs_cos_wrapper_dnd_area-module-3")
	static WebElement titleArea;
	
	private static WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		HomePage.driver = driver;
		PageFactory.initElements(HomePage.driver, this);
		Assert.assertTrue(ToolboxWebElement.ifExist(titleArea));
	}
	
	static HomePage init(WebDriver driver)
	{
		return new HomePage(driver);
	}
	
	public static void clickOnRequestDemo()
	{
		ToolboxWebElement.clickOnButton(requestDemoLink);
		ToolboxWebElement.swithToOpenedTab(driver);
	}
	
}
