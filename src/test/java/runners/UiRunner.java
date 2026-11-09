package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefinitions"},
        tags = "not @api",
        plugin = {
                "pretty",
                "html:target/ui-report.html",
                "json:target/ui-report.json",
                "junit:target/ui-report.xml"
        },
        monochrome = true
)
public class UiRunner extends AbstractTestNGCucumberTests {
}
