package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import utils.Utilities;


public class ElementsPage extends BasePage {
    Faker faker = new Faker();

    private By checkBox = By.xpath("//span[@class='text' and text()='Check Box']");
    private By radioButton = By.xpath("//span[@class='text' and text()='Radio Button']");
    private By radioButtonYes = By.xpath("//label[@for='yesRadio']");
    private By checkBoxNotes = By.xpath("//span[@class='rct-title' and text()='Notes']");
    private By expandAll = By.xpath("//button[@aria-label='Expand all']");
    private By workSpace = By.xpath("//span[@class='rct-title' and text()='WorkSpace']");
    private By resultCheckBox = By.xpath("//div[@id='result']");
    private By resultRadioButton = By.xpath("//p[@class='mt-3']");
    private By webTables = By.xpath("//span[@class='text' and text()='Web Tables']");
    private By webTablesAddButton = By.xpath("//button[@id='addNewRecordButton']");
    private By webTablesName = By.xpath("//input[@id='firstName']");
    private By webTablesLastName = By.xpath("//input[@id='lastName']");
    private By webTablesUserEmail = By.xpath("//input[@id='userEmail']");
    private By webTablesUserAge = By.xpath("//input[@id='age']");
    private By webTablesSalary = By.xpath("//input[@id='salary']");
    private By webTablesDepartment = By.xpath("//input[@id='department']");
    private By webTablesSubmit = By.xpath("//button[@id='submit']");
    private By webTablesSearch = By.xpath("//input[@id='searchBox']");
    private By webTablesTable = By.xpath("//div[@class='rt-tbody']");
    private By webTablesEditButton = By.xpath("//span[@title='Edit']");
    private By webTablesDeleteButton = By.xpath("//span[@title='Delete']");

    private static String firstName = "";


    public void clickOnCheckBox() {
        Utilities.clickElement(checkBox);
        Utilities.waitOnElement(expandAll);
        Utilities.clickElement(expandAll);
    }

    public void clickOnRadioButton() {
        Utilities.clickElement(radioButton);
    }

    public void clickOnRadioButtonYes() {
        Utilities.waitOnElement(radioButtonYes);
        Utilities.clickElement(radioButtonYes);
    }

    public void selectCheckBoxNotes() {
        Utilities.clickElement(checkBoxNotes);
    }

    public void selectCheckBoxWorkspace() {
        Utilities.clickElement(workSpace);
    }

    public Boolean resultCheckBoxText() {
        boolean isCheckResultBoxText = false;
        if (Utilities.getTextOfElement(resultCheckBox).contains("notes\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu")) {
            isCheckResultBoxText = true;
        }
        return isCheckResultBoxText;


    }

    public Boolean resultResultRadioButton() {
        boolean isResultRadioButton = false;

        if (Utilities.getTextOfElement(resultRadioButton).contains("Yes")) {
            isResultRadioButton = true;
        }
        return isResultRadioButton;
    }

    public void clickOnWebTables() {
        clickElement(webTables);
    }

    public void clickOnWebTablesAdd() {
        clickElement(webTablesAddButton);
    }

    public void webTablesAddAllInputs() throws InterruptedException {
        waitOnElement(webTablesName);
        firstName = faker.name().firstName() + randomNumberGenerator(50);
        sendKeys(webTablesName, firstName);
        sendKeys(webTablesLastName, faker.name().lastName());
        sendKeys(webTablesUserEmail, faker.internet().emailAddress());
        sendKeys(webTablesUserAge, "34");
        sendKeys(webTablesSalary, "7000");
        sendKeys(webTablesDepartment, "Software");
        clickElement(webTablesSubmit);
    }

    public boolean checkIfNewEntryIsAdded() {
        return checkIfTextIsPresentInElement(webTablesSearch, firstName, webTablesTable);
    }

    public void webTablesEditButton() throws InterruptedException {
        waitOnElement(webTablesEditButton);
        clickElement(webTablesEditButton);
        firstName += randomNumberGenerator(3);
        sendKeys(webTablesName, firstName);
        clickElement(webTablesSubmit);
    }

    public boolean checkIfNewEntryIsEdited() {
        System.out.println(getTextOfElement(webTablesTable));
        return checkIfTextIsPresentInElement(webTablesSearch, firstName, webTablesTable);
    }

    public void clickWebTablesDeleteButton() {
        clickElement(webTablesDeleteButton);
    }

}
