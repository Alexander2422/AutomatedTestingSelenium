package StepDefinition;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features",
        glue={"StepDefinition"},
        tags = "@Tests",//to change when running tests
        plugin={"pretty","html:target/HtmlReports.html"})

public class TestRunner {
}
