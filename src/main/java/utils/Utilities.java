package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Utilities extends WebDriverUtils {

    static Actions act = new Actions(getDriver());
    public static int duration = 5;
    String selectAll = Keys.chord(Keys.COMMAND, "a");
    String commandZoomOut = Keys.chord(Keys.COMMAND, Keys.SUBTRACT);
    Keys delete = Keys.DELETE;


    public static void clickElement(By elem) {
        getDriver().findElement(elem).click();
    }
    public static void maximizePage(){
        getDriver().manage().window().maximize();
    }

    public static void openLink(String link) {
        getDriver().get(link);
    }

    public void sendKeys(By elem, String textToSend) {
        getDriver().findElement(elem).sendKeys(textToSend);
    }

    public void waitOnElementToBeClickable(By elem) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(duration)).until(ExpectedConditions.elementToBeClickable(elem));
    }

    public static void waitOnElement(By elem) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(duration)).until(ExpectedConditions.presenceOfElementLocated(elem));
    }

    public int randomNumberGenerator(int range) {
        Random random = new Random();
        return 100 + random.nextInt(range);
    }

    public static String getTextOfElement(By elem) {
        return getDriver().findElement(elem).getText();
    }

    public static void uploadElement(By location, String locationOfFile) {
        getDriver().findElement(location).sendKeys(locationOfFile);
    }

    public static void autocompletionElement(By location, String textElement) {
        getDriver().findElement(location).sendKeys(textElement);
        getDriver().findElement(location).sendKeys(Keys.TAB);
    }

    public void selectFromDropdown(By dropdownList, String whatToSelect) {
        WebElement dropdown = getDriver().findElement(dropdownList);
        Select selectObject = new Select(dropdown);
        selectObject.selectByVisibleText(whatToSelect);
    }

    public boolean checkIfTextIsPresentInElement(By webTablesSearch, String wordToCheck, By webTablesTable) {
        boolean isTrue = false;
        waitOnElement(webTablesSearch);
        sendKeys(webTablesSearch, wordToCheck);
        if (getTextOfElement(webTablesTable).contains(wordToCheck)) {
            isTrue = true;
        }
        return isTrue;
    }

    public void datePick(By input, String inputDate, By someElement) throws InterruptedException {
        getDriver().findElement(input).click();
        getDriver().findElement(input).sendKeys(selectAll);
        getDriver().findElement(input).sendKeys(inputDate);
        clickElement(someElement);
    }

    public void dropDownSelect(By elementLocation, String whatToSelectText) {
        Select sel = new Select(getDriver().findElement(elementLocation));
        sel.selectByVisibleText(whatToSelectText);
    }

    public void pressEnter(By location) {
        getDriver().findElement(location).sendKeys(Keys.ENTER);
    }

    public void scrollToBottom(By element) throws InterruptedException {

        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(element));
        Thread.sleep(500);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));

    }

    public void zoomOut(int howManyTimes) {
        int times = 0;
        while (times < howManyTimes) {
            getDriver().findElement(By.tagName("html")).sendKeys(Keys.chord(commandZoomOut));
            times++;
        }
    }

}

