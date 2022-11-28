package StepDefinition;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features="src/test/java/Features",
        glue={"StepDefinition"},
        tags = "@Tests",//to change when running tests
        plugin={"pretty","html:target/HtmlReports.html"})

public class TestRunner extends AbstractTestNGCucumberTests {

}
