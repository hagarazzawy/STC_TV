package Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase {
	By selectedCountry = By.id("country");
	String country_xpath = "//a[contains(@class,'country ')][contains(.,'%s')]";
	By uiPlans = By.xpath("//*[@class='plan-names']//strong");
	By uiPrices = By.xpath("//*[@class='price']//b");
	By uiCurrencies = By.xpath("//*[@class='price']//i");
	By selectCountryPopupHeader = By.xpath("//strong[contains(.,'Select Your Country')]");

	static WebDriver driver;
	WebDriverWait wait;

	public HomePage(WebDriver driver) {
		HomePage.driver = driver;
		wait = new WebDriverWait(driver, 30);
	}

	public void ClickSelectedCountry() {
		ClickElement(driver, selectedCountry, "selectedCountry");

	}

	public void SelectCountry(String expecetdCountry) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(country_xpath, expecetdCountry))));
		ClickElement(driver, By.xpath(String.format(country_xpath, expecetdCountry)), expecetdCountry);
	}

	public boolean isSelectCountryPopupDisplayed() {
		return ElementIsDisplayed(driver, selectCountryPopupHeader, "select Country Popup");
	}

	public String GetSelectedCountry() {
		return GetElementText(driver, selectedCountry, "The selected Country");
	}

	public ArrayList<String> GetPlans() {
		ArrayList<String> actualPlans = new ArrayList<String>();
		List<WebElement> plans = driver.findElements(uiPlans);
		for (WebElement plan : plans) {
			actualPlans.add(plan.getText());
		}
		return actualPlans;
	}

	public ArrayList<String> GetPrices() {
		ArrayList<String> actualPrices = new ArrayList<String>();
		List<WebElement> prices = driver.findElements(uiPrices);
		for (WebElement price : prices) {
			actualPrices.add(price.getText());
		}
		return actualPrices;
	}

	public ArrayList<String> GetCurrencies() {
		ArrayList<String> actualCurrencies = new ArrayList<String>();
		List<WebElement> currencies = driver.findElements(uiCurrencies);
		for (WebElement currency : currencies) {
			actualCurrencies.add(currency.getText().substring(0 ,currency.getText().indexOf('/')));
		}
		return actualCurrencies;
	}
}
