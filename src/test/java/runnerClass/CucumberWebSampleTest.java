package runnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/db_test.feature", glue = "com.qapropsoft.carina.demo", monochrome = true, 
		dryRun = false,
		tags = "@SmokeTest or @SanityTest",
		//publish = true, 
		plugin = { "pretty",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports1/report.html"}

)
public class CucumberWebSampleTest extends AbstractTestNGCucumberTests {

	

}