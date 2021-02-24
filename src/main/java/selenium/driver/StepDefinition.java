package selenium.driver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class StepDefinition 
{
  @Given("I Go to the url {string} on the browser {string}")
  public void IGoToTheUrl(String url, String browser) throws Throwable 
  {
	  WebDriverUtility.driver = WebDriverUtility.getWebDriver(Browser.valueOf(browser));
	  WebDriverUtility.launchBrowser(WebDriverUtility.driver, url);
  }
  
  @And("I close the browser")
  public void IStopTheWebdrier()
  {
	  WebDriverUtility.closeWebDriver(WebDriverUtility.driver);
  }
}
