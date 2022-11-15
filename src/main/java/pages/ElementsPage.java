package pages;

import com.github.javafaker.Bool;
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
    private By webTablesName = By.xpath("//input[@placeholder='firstName']");
    private By webTablesLastName = By.xpath("//input[@id='lastName']");
    private By webTablesUserEmail = By.xpath("//input[@id='userEmail']");
    private By webTablesUserAge = By.xpath("//input[@id='Age']");
    private By webTablesSalary = By.xpath("//input[@id='Salary']");
    private By webTablesDepartment=By.xpath("//input[@id='department']");
    private By webTablesSubmit = By.xpath("//button[@id='Submit']");
    private By webTablesSearch = By.xpath("//input[@id='searchBox']");
    private By webTablesTable = By.xpath("//div[@class='rt-tbody']");

    private static String firstName="";

    public void setFirstName(String fName) {
        this.firstName = fName;
    }
    public static String getFirstName() {
        return firstName;
    }

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
        if (Utilities.getTextOfElement(resultCheckBox).contains("notes\n" +
                "workspace\n" +
                "react\n" +
                "angular\n" +
                "veu")) {
            return true;
        }
        return false;


    }

    public Boolean resultResultRadioButton() {
        if (Utilities.getTextOfElement(resultRadioButton).contains("Yes")) {
            return true;
        }
        return false;
    }

    public void clickOnWebTables(){
        clickElement(webTables);
    }
    public void clickOnWebTablesAdd(){
        clickElement(webTablesAddButton);
    }
    public void webTablesAddAllInputs() throws InterruptedException {
        waitOnElement(webTablesName);
        firstName=faker.name().firstName()+randomNumberGenerator(50);
        sendKeys(webTablesName,firstName);
        sendKeys(webTablesLastName,faker.name().lastName());
        sendKeys(webTablesUserEmail,faker.internet().emailAddress());
        sendKeys(webTablesUserAge,"34");
        sendKeys(webTablesSalary,"7000");
        sendKeys(webTablesDepartment,"Software");
        Thread.sleep(4500);


    }

}
