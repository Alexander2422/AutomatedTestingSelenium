package parallel;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import pages.FormsPage;

public class FormsSteps {

    FormsPage formsPage = new FormsPage();
    @When("I click on Forms button")
    public void iClickOnFormsButton() {

        formsPage.clickOnForms();
    }

    @When("I click on Practice form")
    public void iClickOnPracticeForm() {
        formsPage.clickOnPracticeForm();
    }

    @When("I input all the information in the student form")
    public void iInputAllTheInformationInTheStudentForm() throws InterruptedException {
        formsPage.elementsInput();
    }

    @Then("I check to see if all information is correct")
    public void iCheckToSeeIfAllInformationIsCorrect() {
        Assert.assertTrue(formsPage.checkElementsAfterInput());
    }
}
