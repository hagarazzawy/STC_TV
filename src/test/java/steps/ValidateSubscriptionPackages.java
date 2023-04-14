package steps;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidateSubscriptionPackages extends Base {

	By selectedCountry = By.id("country");
	String selectedCountry_xpath = "//a[contains(@class,'country ')][contains(.,'{}')]";
	By uiPlans = By.xpath("//*[@class='plan-names']//strong");
	By uiPrices = By.xpath("//*[@class='price']//b");
	By uiCurrencies = By.xpath("//*[@class='price']//i");

	public static Logger logger = Logger.getLogger(ValidateSubscriptionPackages.class);
	public static WebDriver driver;
	WebDriverWait wait;

	public ValidateSubscriptionPackages(WebDriver driver) {
		ValidateSubscriptionPackages.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}

	@Given("I open STC TV page")
	public void OpenPage() {
		OpenBrowser();
	}

	@When("I click on the selected country")
	public void ClickSelectedCountry() {
		ClickElement(driver, selectedCountry, "selectedCountry");

	}

	@And("I select {string}")
	public void SelectCountry(String expecetdCountry) {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(selectedCountry_xpath.format(expecetdCountry))));
		ClickElement(driver, By.xpath(selectedCountry_xpath.format(expecetdCountry)), "selectedCountry");
	}

	@Then("the displayed plans are {string}")
	public void CheckPlans(String expectedPlans) {
		ArrayList<String> actualPlans = new ArrayList<String>();
		List<WebElement> plans = driver.findElements(uiPlans);
		for (WebElement plan : plans) {
			actualPlans.add(plan.getText());
		}
		Assert.assertEquals(actualPlans, Arrays.asList(expectedPlans.split(",")));

	}

	@And("the displayed prices are {string}")
	public void CheckPrices(String expectedPrices) {
		ArrayList<String> actualPrices = new ArrayList<String>();
		List<WebElement> prices = driver.findElements(uiPrices);
		for (WebElement price : prices) {
			actualPrices.add(price.getText());
		}
		Assert.assertEquals(actualPrices, Arrays.asList(expectedPrices.split(",")));
	}

	@And("the displayed currencies for each plan are {string}")
	public void CheckCurrencies(String expectedCurrencies) {
		ArrayList<String> actualCurrencies = new ArrayList<String>();
		List<WebElement> currencies = driver.findElements(uiCurrencies);
		for (WebElement currency : currencies) {
			actualCurrencies.add(currency.getText());
		}
		Assert.assertEquals(actualCurrencies, Arrays.asList(expectedCurrencies.split(",")));
	}

}
