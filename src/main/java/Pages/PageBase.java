package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.apache.log4j.Logger;

public class PageBase {
	static WebDriver driver;
	public static Logger logger = Logger.getLogger(PageBase.class);

	public Boolean ElementIsDisplayed(WebDriver driver, By element_locator, String element_log) {
		logger = Logger.getLogger("Check element is displayed");

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
		Boolean flag = ElementIsDisplayed(driver, element_locator, element_log);
		logger = Logger.getLogger("Click Element");
		if (flag == true) {
			WebElement element = driver.findElement(element_locator);
			element.click();
			logger.info("Click on " + element_log);
		} else {
			logger.error("Cannot Click on " + element_log);
		}
	}

	public String GetElementText(WebDriver driver, By element_locator, String elementLog) {
		logger = Logger.getLogger("Get Element Text");
		String elementText;
		if (driver.findElement(element_locator).isDisplayed()) {
			elementText = driver.findElement(element_locator).getText();
			logger.info(elementLog + " text is " + elementText);
			return elementText;
		} else {
			logger.error(elementLog + " text is not Displayed");
			return "";
		}

	}

}
