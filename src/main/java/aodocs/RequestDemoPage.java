package aodocs;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utils.DropDown;
import utils.ToolboxWebElement;

public class RequestDemoPage 
{
	@FindBy(id = "hs_form_target_widget_1586150982423")
	static WebElement formId;
	
	@FindBy(xpath = "//input[contains(@id, 'firstname')]")
	static WebElement firstNameId;
	
	@FindBy(xpath = "//input[contains(@id, 'lastname')]")
	static WebElement lastNameId;
	
	@FindBy(xpath = "//input[contains(@id, 'email')]")
	static WebElement emailId;
	
	@FindBy(xpath = "//input[contains(@id, 'company-')]")
	static WebElement companyNameId;
	
	@FindBy(xpath = "//select[contains(@id, 'company_size')]")
	static WebElement companySizeId;
	
	@FindBy(xpath = "//select[contains(@id, 'country')]")
	static WebElement countryId;
	
	@FindBy(xpath = "//input[contains(@id, 'phone')]")
	static WebElement phoneId;
	
	@FindBy(xpath = "//select[contains(@id, 'request_type')]")
	static WebElement requestId;
	
	@FindBy(xpath = "//textarea[contains(@id, 'your_request_')]")
	static WebElement messageId;
	
	@FindBy(xpath = "//select[contains(@id, 'how_did_you_hear_about_us')]")
	static WebElement aboutUsId;
	
	@FindBy(xpath = "//input[@type = 'submit']")
	static WebElement submit;
	
	@FindBy(id = "ccc-notify-dismiss")
	static WebElement dismissNotif;
	
	@FindBy(id = "ccc")
	static WebElement dismissBanner;
	
	private static WebDriver driver;
	
	public RequestDemoPage(WebDriver driver)
	{
		RequestDemoPage.driver = driver;
		PageFactory.initElements(RequestDemoPage.driver, this);
		Assert.assertTrue(ToolboxWebElement.ifExist(formId));
	}
	
	static RequestDemoPage init(WebDriver driver)
	{
		return new RequestDemoPage(driver);
	}
	
	public static void setContactUsFor(String firstName, String lastName, String email, String company, String companySize, String country)
	{
		dismissNotification();
		
		ToolboxWebElement.sendValueOnField(firstNameId, firstName);
		ToolboxWebElement.sendValueOnField(lastNameId, lastName);
		ToolboxWebElement.sendValueOnField(emailId, email);
		ToolboxWebElement.sendValueOnField(companyNameId, company);
		ToolboxWebElement.selectOnDropDownList(companySizeId, companySize, DropDown.ByValue);
		ToolboxWebElement.selectOnDropDownList(countryId, country, DropDown.ByValue);
		
		ToolboxWebElement.clickOnButton(submit);
	}
	
	private static void dismissNotification()
	{
		if(ToolboxWebElement.ifExist(dismissBanner))
		{
			new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(dismissNotif));
			ToolboxWebElement.clickOnButton(dismissNotif);
		}
	}
	
	public static void verifyTheErrorMessage(RequestDemoFields field, String errorMessage)
	{
		WebElement fieldParent = null;
		switch(field)
		{
			case FirstName:
				fieldParent = ToolboxWebElement.GetParent(ToolboxWebElement.GetParent(firstNameId));
				break;
			case LastName:
				fieldParent = ToolboxWebElement.GetParent(ToolboxWebElement.GetParent(lastNameId));
				break;
			case Phone:
				fieldParent = ToolboxWebElement.GetParent(ToolboxWebElement.GetParent(phoneId));
				break;
			case Email:
				fieldParent = ToolboxWebElement.GetParent(ToolboxWebElement.GetParent(emailId));
				break;
			case Company:
				fieldParent = ToolboxWebElement.GetParent(ToolboxWebElement.GetParent(companyNameId));
				break;
			case CompanySize:
				fieldParent = ToolboxWebElement.GetParent(ToolboxWebElement.GetParent(companySizeId));
				break;
			case Country:
				fieldParent = ToolboxWebElement.GetParent(ToolboxWebElement.GetParent(countryId));
				break;
			case Request:
				fieldParent = ToolboxWebElement.GetParent(ToolboxWebElement.GetParent(requestId));
				break;
			case Message:
				fieldParent = ToolboxWebElement.GetParent(ToolboxWebElement.GetParent(messageId));
				break;
			case AboutUs:
				fieldParent = ToolboxWebElement.GetParent(ToolboxWebElement.GetParent(aboutUsId));
				break;
		}
		
		Assert.assertTrue(fieldParent.getText().equals(errorMessage));
	}
}
