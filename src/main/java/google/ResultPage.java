package google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ToolboxWebElement;

public class ResultPage
{
	@FindBy(id = "search")
	static WebElement searchDiv;
	
	private static WebDriver driver;
	
	public ResultPage(WebDriver driver)
	{
		ResultPage.driver = driver;
		PageFactory.initElements(ResultPage.driver, this);
	}
	
	static ResultPage init(WebDriver driver)
	{
		return new ResultPage(driver);
	}
	
	static void clickOnTheResult(String result)
	{
		ToolboxWebElement.clickOnButton(searchDiv.findElement(By.xpath("//a[contains(@href, '" + result + "')]")));
	}
}
