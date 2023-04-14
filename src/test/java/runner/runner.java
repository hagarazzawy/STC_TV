package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(features ="src/test/java/feature" , glue="steps" , plugin={"pretty","html:target/cucumber-html-report"})
	public class runner  extends AbstractTestNGCucumberTests  {

	}



