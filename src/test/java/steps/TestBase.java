package steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class TestBase {
	static WebDriver driver;
	public static Logger logger = Logger.getLogger(TestBase.class);

	public static void OpenBrowser() {
		logger = Logger.getLogger("Open browser ");
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} catch (Exception ex) {
			logger.error("Open browser " + ex.getMessage());
		}

		logger.info("Opening Browser ...");
		driver.manage().window().maximize();
	}

	public static void OpenURL(String URL) {
		logger = Logger.getLogger("Open URL ");
		logger.info("Open URL " + URL);
		driver.get(URL);

	}

	public static void CloseBrowser() {

		logger = Logger.getLogger("Close browser ");
		try {
			driver.quit();
			logger.info("Close Browser ...");
		} catch (Exception ex) {
			logger.error("Close browser " + ex.getMessage());

		}

	}

	public void AssertEqualTowlists(ArrayList<String> actual, List<String> expected) {
		logger = Logger.getLogger("Verify tow lists are equal ");
		if (expected.size() != actual.size()) {
			logger.error("Tow lists sizes are not equal");
		} else {
			for (int i = 0; i < expected.size(); i++) {
				if (actual.get(i).equals(expected.get(i)))
					logger.info(expected.get(i) + " exist ");
				else {

					logger.error(expected.get(i) + " does not exist ");
					Assert.fail();

				}
			}
		}
	}

}
