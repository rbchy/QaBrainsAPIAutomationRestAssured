package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.BaseTest;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Browser lifecycle for UI scenarios only. API scenarios (@api) never open a browser.
 * On a failed UI scenario the report gets a screenshot and the page HTML, and the HTML is
 * also saved under target/failures/ so a CI run can be debugged from its artifacts.
 */
public class Hooks {

    @Before(value = "not @api", order = 0)
    public void openBrowser() {
        WebDriver driver = BaseTest.initDriver();
        String url = BaseTest.config.getProperty("url");
        if (url == null) {
            throw new IllegalStateException("url is missing from config.properties");
        }
        driver.get(url);
    }

    @After(value = "not @api")
    public void closeBrowser(Scenario scenario) {
        WebDriver driver = BaseTest.currentDriver();
        try {
            if (scenario.isFailed() && driver != null) {
                byte[] png = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(png, "image/png", scenario.getName());

                String html = driver.getPageSource();
                scenario.attach(html, "text/html", "Page source at failure (" + driver.getCurrentUrl() + ")");
                Path dir = Paths.get("target", "failures");
                Files.createDirectories(dir);
                Files.writeString(dir.resolve(safeName(scenario.getName()) + ".html"),
                        "<!-- " + driver.getCurrentUrl() + " -->\n" + html, StandardCharsets.UTF_8);
            }
        } catch (Exception e) {
            System.err.println("Could not capture failure evidence: " + e.getMessage());
        } finally {
            BaseTest.quitDriver();
        }
    }

    private static String safeName(String name) {
        return name.replaceAll("[^A-Za-z0-9-]+", "_");
    }
}
