package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;

public class FormsPage extends BasePage {
    Faker faker = new Faker();

    private By forms = By.xpath("//div[@class='card-body']//*[text()='Forms']");
    private By practiceForm = By.xpath("//span[@class='text' and text()='Practice Form']");
    private By inputFirstName = By.xpath("//input[@id='firstName']");
    private By inputLastName = By.xpath("//input[@id='lastName']");
    private By inputEmail = By.xpath("//input[@id='userEmail']");
    private By radioButtonGenderMale = By.xpath("//label[@class='custom-control-label' and text()='Male']");
    private By inputPhoneNumber = By.xpath("//input[@id='userNumber']");
    private By inputDateOfBirth = By.xpath("//input[@id='dateOfBirthInput']");
    private By submitButton = By.xpath("//button[@id='submit']");
    private By bookStoreApp=By.xpath("//div[@class='header-text' and text()='Interactions']");

    private By inputSubject = By.xpath("//input[@id='subjectsInput']");
    private By checkBoxHobbiesSports = By.xpath("//label[@class='custom-control-label' and text()='Sports']");
    private By choseFilePicture = By.xpath("//input[@id='uploadPicture']");
    private By inputAddress = By.xpath("//textarea[@id='currentAddress']");
    private By dropDownStateAndCity = By.xpath("//input[@id='react-select-3-input']");
    private By dropDownCity = By.xpath("//input[@id='react-select-4-input']");

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String email = faker.internet().emailAddress();
    public String mobileNumber = faker.phoneNumber().subscriberNumber(10);
    public String dateOfBirth = "24 June,1991";

    public String subject = "Maths";
    public String address = faker.address().fullAddress();
    public String stateAndCity = "Haryana";
    public String city = "Lucknow";
    public String fileLocation = "/Users/alexandru.deleanu/Desktop/testFudge.png";
    public String uploadedFile = "testFudge.png";
    public String gender = "Male";
    public String hobbies = "Sports";

    //xpaths for check
    private By tableAll =By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']");
    private By studentNameCheck = By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr[1]/td[2]");
    private By studentEmailCheck = By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr[2]/td[2]");
    private By genderCheck = By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr[3]/td[2]");
    private By mobileCheck = By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr[4]/td[2]");
    private By birthDayCheck = By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr[5]/td[2]");
    private By subjectCheck = By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr[6]/td[2]");
    private By hobbiesCheck = By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr[7]/td[2]");
    private By pictureCheck = By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr[8]/td[2]");
    private By addressCheck = By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr[9]/td[2]");
    private By stateCheck = By.xpath("//table[@class='table table-dark table-striped table-bordered table-hover']/tbody/tr[10]/td[2]");



    public void clickOnForms() {
        clickElement(forms);
    }

    public void clickOnPracticeForm() {
        waitOnElement(practiceForm);
        clickElement(practiceForm);
    }

    public void elementsInput() throws InterruptedException {
        sendKeys(inputFirstName, firstName);
        sendKeys(inputLastName, lastName);
        sendKeys(inputEmail, email);
        clickElement(radioButtonGenderMale);
        sendKeys(inputPhoneNumber, mobileNumber);
        datePick(inputDateOfBirth, dateOfBirth, inputFirstName);
        autocompletionElement(inputSubject, subject);
        clickElement(checkBoxHobbiesSports);
        uploadElement(choseFilePicture, fileLocation);
        sendKeys(inputAddress, address);
        sendKeys(dropDownStateAndCity, stateAndCity);
        pressEnter(dropDownStateAndCity);
        sendKeys(dropDownCity, city);
        clickElement(bookStoreApp);
        scrollToBottom(submitButton);
        waitOnElementToBeClickable(submitButton);
        scrollToBottom(submitButton);
        clickElement(submitButton);
    }

    public Boolean checkElementsAfterInput() {
        boolean isCheckOk = false;
        waitOnElement(tableAll);
        if (getTextOfElement(studentNameCheck).equals(firstName + " " + lastName) && getTextOfElement(hobbiesCheck).contains(hobbies) &&getTextOfElement(studentEmailCheck).equals(email) && getTextOfElement(genderCheck).equals(gender) && getTextOfElement(mobileCheck).equals(mobileNumber)
                && getTextOfElement(birthDayCheck).equals(dateOfBirth) && getTextOfElement(subjectCheck).equals(subject) && getTextOfElement(pictureCheck).equals(uploadedFile) && getTextOfElement(addressCheck).equals(address)) {
            isCheckOk = true;

        }

        System.out.println(getTextOfElement(birthDayCheck).equals(dateOfBirth));
        System.out.println(getTextOfElement(stateCheck).equals(stateAndCity));



        return isCheckOk;
    }
}