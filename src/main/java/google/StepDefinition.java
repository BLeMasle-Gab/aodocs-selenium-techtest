package google;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import selenium.driver.WebDriverUtility;

public class StepDefinition 
{
	@Then("I search {string} on Google")
	public void ISearchOnGoogle(String searchWord) throws Throwable 
	{
		SearchPage.init(WebDriverUtility.driver);
		SearchPage.searchWordsOnPage(searchWord);
	}
	
	@And("I click on the link {string} on result page")
	public void IClickOnResultLink(String resultLink) throws Throwable 
	{
		ResultPage.init(WebDriverUtility.driver);
		ResultPage.clickOnTheResult(resultLink);
	}
}
