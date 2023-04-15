package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import steps.TestBase;

import org.testng.annotations.*;

@CucumberOptions(features = "src/test/java/feature", glue = "steps", plugin = { "pretty",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" })
public class runner extends AbstractTestNGCucumberTests {

	@BeforeClass
	public void Setup() {
		TestBase.OpenBrowser();
	}

	@AfterClass
	public void TearDown() {
		TestBase.CloseBrowser();

	}

}
