package parallel;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.WebDriverUtils;

public class Hooks extends WebDriverUtils {

    @Before
    public static void setup() {
        webDriverCreation("chrome");
        //long threadNumber=Thread.currentThread().getId();
    }

    @After
    public static void teardown() {
        webDriverTeardown();
    }
}
