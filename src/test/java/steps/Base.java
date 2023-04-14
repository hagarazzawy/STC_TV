package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.log4j.Logger;

public class Base {
	static WebDriver driver;
	public static Logger logger = Logger.getLogger(Base.class);

	public void OpenBrowser() {
		logger = Logger.getLogger("Open browser ");
		String URL = "https://subscribe.stctv.com/sa-en";
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} catch (Exception ex) {
			logger.error("Open browser " + ex.getMessage());
		}

		logger.info("Opening Browser ...");
		logger.info("Open URL = " + URL);
		driver.get(URL);
		driver.manage().window().setSize(new Dimension(1024, 768));
	}

	public Boolean ElementIsDisplayed(WebDriver driver, By element_locator, String element_log) {
		logger = Logger.getLogger("Check Element is displayed");

		try {
			driver.findElement(element_locator).isDisplayed();
			logger.info(element_log + " is Displayed successfully");
			return true;

		} catch (Exception e) {
			logger.error(element_log + " is not Displayed");

			return false;
		}
	}

	public void ClickElement(WebDriver driver, By element_locator, String element_log) {
		logger = Logger.getLogger("Click Element ");
		Boolean flag = ElementIsDisplayed(driver, element_locator, element_log);
		if (flag == true) {
			WebElement element = driver.findElement(element_locator);
			element.click();
			logger.info("Click on " + element_log);
		} else {
			logger.error("Cannot Click on " + element_log);
		}
	}

}
