package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        tags = "@api",
        plugin = {
                "pretty",
                "html:target/api-report.html",
                "json:target/api-report.json",
                "junit:target/api-report.xml"
        },
        monochrome = true
)
public class ApiRunner extends AbstractTestNGCucumberTests {
}
