package steps;

import java.io.ByteArrayInputStream;
import java.util.*;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import ConfigFileReader.ConfigFileReader;
import Pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;

public class ValidateSubscriptionPackages extends TestBase {
	HomePage homePage = new HomePage(driver);
	ConfigFileReader configFileReader = new ConfigFileReader();

	@Given("I open STC TV page")
	public void OpenSTCTVPage() {
		OpenURL(configFileReader.getApplicationUrl());
	}

	@When("I click on the selected country")
	public void ClickSelectedCountry() {
		homePage.ClickSelectedCountry();
		Assert.assertTrue(homePage.isSelectCountryPopupDisplayed(), "select Country Popup is not open");

	}

	@When("I select country {string}")
	public void SelectCountry(String expecetdCountry) {
		homePage.SelectCountry(expecetdCountry);
		Assert.assertEquals(homePage.GetSelectedCountry(), expecetdCountry,
				"The selected country is not " + expecetdCountry);
	}

	@Then("the displayed plans are {string}")
	public void CheckPlans(String expectedPlans) {
		logger = Logger.getLogger("Assertion ");
		try {
			logger.info("Verifing plans");
			Assert.assertEquals(homePage.GetPlans(), Arrays.asList(expectedPlans.split(",")));
		} catch (Exception e) {
			logger.error("issue in Verifing plans");
			Assert.fail("issue in Verifing plans");
		}

	}

	@Then("the displayed prices are {string}")
	public void CheckPrices(String expectedPrices) {
		logger = Logger.getLogger("Assertion ");
		try {
			logger.info("Verifing prices");
			Assert.assertEquals(homePage.GetPrices(), Arrays.asList(expectedPrices.split(",")));
		} catch (Exception e) {
			logger.error("issue in Verifing prices");
			Assert.fail("issue in Verifing prices");
		}
	}

	@Then("the displayed currencies for each plan are {string}")
	public void CheckCurrencies(String expectedCurrencies) {
		logger = Logger.getLogger("Assertion ");
		try {
			logger.info("Verifing currencies");
			Assert.assertEquals(homePage.GetCurrencies(), Arrays.asList(expectedCurrencies.split(",")));
		} catch (Exception e) {
			logger.error("issue in Verifing Currencies");
			Assert.fail("issue in Verifing Currencies");
		}
	}

	@After
	public void TearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			Allure.addAttachment("Screenshot with the failure", new ByteArrayInputStream(screenshot));
		}
	}

}
