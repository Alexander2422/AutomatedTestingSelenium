package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.WebDriverUtils;

public class Hooks extends WebDriverUtils {

    @Before
    public static void setup() {
        webDriverCreation("firefox");
    }

    @After
    public static void teardown() {
        webDriverTeardown();
    }
}
