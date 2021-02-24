package aodocs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import selenium.driver.WebDriverUtility;

public class StepDefinition 
{
	@Given("I am on home page")
	public void IamHomePage() throws Throwable 
	{
		HomePage.init(WebDriverUtility.driver);
	}
	
	@Then("I click on the button Request a demo on the home page")
	public void IClickOnLinkRequestDemo() throws Throwable 
	{		
		HomePage.clickOnRequestDemo();
	}
	
	@Given("I am on request a demo page")
	public void IAmOnRequestADemoPage() throws Throwable 
	{
		RequestDemoPage.init(WebDriverUtility.driver);
	}
	
	@When("I set the first name {string}, the last name {string} and the email {string} for the company {string} size {string} in the country {string} on the request demo page")
	public void IFillFormOnRequestADemoPage(String firstName, String lastName, String email, String company, String companySize, String country) throws Throwable 
	{
		RequestDemoPage.setContactUsFor(firstName, lastName, email, company, companySize, country);
	}
	
	@Then("I verify that the error message {string} is displayed on the field {string}")
	public void IVerifyErrorMessageOnField(String errorMessage, String field)  throws Throwable 
	{
		RequestDemoPage.verifyTheErrorMessage(RequestDemoFields.valueOf(field), errorMessage);
	}
}
