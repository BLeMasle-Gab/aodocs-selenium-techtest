package RunnerTest;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/requestForDemo.feature"},
plugin = {"pretty", "html:out"})
@io.cucumber.junit.platform.engine.Cucumber
public class RunTest extends AbstractTestNGCucumberTests
{
	public static  WebDriver driver = null;
	
	
	
}