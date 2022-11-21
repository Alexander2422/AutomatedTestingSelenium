package StepDefinition;


import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.ElementsPage;
import pages.HomePage;


public class ElementsSteps {

    HomePage homePage = new HomePage();
    ElementsPage elementsPage = new ElementsPage();

    @Given("I Set the homepage for demoQA website")
    public void iSetTheHomepageForDemoQAWebsite() {
        homePage.openHomePage();
    }

    @When("I click on the Elements button")
    public void iClickOnTheElementsButton() {
        homePage.clickOnElements();
    }

    @When("I click on Check box button")
    public void iClickOnCheckBoxButton() {
        elementsPage.clickOnCheckBox();
    }

    @When("I click in the Check-box Workspace and Notes")
    public void iClickInTheCheckBoxWorkspaceAndNotes() {
        elementsPage.selectCheckBoxNotes();
        elementsPage.selectCheckBoxWorkspace();

    }

    @Then("I receive the message with what i selected")
    public void iReceiveTheMessageWithWhatISelected() {
        Assert.assertTrue(elementsPage.resultCheckBoxText());
    }

    @When("I click on RadioButton button")
    public void iClickOnRadioButtonButton() {
        elementsPage.clickOnRadioButton();
    }

    @When("I click on YES")
    public void iClickOnYES() {
        elementsPage.clickOnRadioButtonYes();
    }

    @Then("I see the message that says i selected Yes")
    public void iSeeTheMessageThatSaysISelectedYes() {
        Assert.assertTrue(elementsPage.resultResultRadioButton());
    }

    @When("I click on Web Tables button")
    public void iClickOnWebTablesButton() {
        elementsPage.clickOnWebTables();
    }
    @When("I click on ADD")
    public void iClickOnADD() {
        elementsPage.clickOnWebTablesAdd();
    }

    @When("I write all the new entries")
    public void iWriteAllTheNewEntries() throws InterruptedException {
        elementsPage.webTablesAddAllInputs();
    }


    @Then("I check to see if new entry is added")
    public void iCheckToSeeIfNewEntryIsAdded() {
        Assert.assertTrue(elementsPage.checkIfNewEntryIsAdded());
    }

    @When("I press on edit on the new entry and change the name")
    public void iPressOnEditOnTheNewEntryAndChangeTheName() throws InterruptedException {
        elementsPage.webTablesEditButton();
    }

    @Then("I check to see if name was changed successfully")
    public void iCheckToSeeIfNameWasChangedSuccessfully() {
        Assert.assertTrue(elementsPage.checkIfNewEntryIsEdited());
    }

    @When("I press on delete of the new entry")
    public void iPressOnDeleteOfTheNewEntry() {
        elementsPage.clickWebTablesDeleteButton();
    }

    @Then("I check to see if last entry was removed")
    public void iCheckToSeeIfLastEntryWasRemoved() throws InterruptedException {
        Assert.assertFalse(elementsPage.checkIfNewEntryIsEdited());
    }


}
