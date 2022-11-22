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

    static Actions act = new Actions(driver);
    public static int duration = 5;
    String selectAll = Keys.chord(Keys.COMMAND, "a");
    String commandZoomOut = Keys.chord(Keys.COMMAND, Keys.SUBTRACT);
    Keys delete = Keys.DELETE;


    public static void clickElement(By elem) {
        driver.findElement(elem).click();
    }

    public static void openLink(String link) {
        driver.get(link);
    }

    public void sendKeys(By elem, String textToSend) {
        driver.findElement(elem).sendKeys(textToSend);
    }

    public void waitOnElementToBeClickable(By elem) {
        new WebDriverWait(driver, Duration.ofSeconds(duration)).until(ExpectedConditions.elementToBeClickable(elem));
    }

    public static void waitOnElement(By elem) {
        new WebDriverWait(driver, Duration.ofSeconds(duration)).until(ExpectedConditions.presenceOfElementLocated(elem));
    }

    public int randomNumberGenerator(int range) {
        Random random = new Random();
        return 100 + random.nextInt(range);
    }

    public static String getTextOfElement(By elem) {
        return driver.findElement(elem).getText();
    }

    public static void uploadElement(By location, String locationOfFile) {
        driver.findElement(location).sendKeys(locationOfFile);
    }

    public static void autocompletionElement(By location, String textElement) {
        driver.findElement(location).sendKeys(textElement);
        driver.findElement(location).sendKeys(Keys.TAB);
    }

    public void selectFromDropdown(By dropdownList, String whatToSelect) {
        WebElement dropdown = driver.findElement(dropdownList);
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

    public void datePicker(By location, By dateTable, By dateMonth, String month, By dateYear, String year, By dateDay, String day) {
        driver.findElement(location).click();
        waitOnElement(dateTable);
        //daySelect
        List<WebElement> l = driver.findElements(dateTable);

        for (int j = 0; j < l.size(); j++) {
            String newString = l.get(j).toString();
            //List<WebElement> l2 = driver.findElements(l.get(j));
//            for(int k=0;k<l.size();k++){
//                System.out.println(l.get(k));
//            }

        }

//        Select seDay = new Select (driver.findElement(dateDay));
//        seDay.selectByValue(day);
        //monthSelect
        Select seMonth = new Select(driver.findElement(dateMonth));
        seMonth.selectByVisibleText(month);
        //yearSelect
        Select seYear = new Select(driver.findElement(dateYear));
        seYear.selectByValue(year);

    }

    public void datePick(By input, String inputDate, By someElement) throws InterruptedException {
        driver.findElement(input).click();
        driver.findElement(input).sendKeys(selectAll);
        driver.findElement(input).sendKeys(inputDate);
        clickElement(someElement);
    }

    public void dropDownSelect(By elementLocation, String whatToSelectText) {
        Select sel = new Select(driver.findElement(elementLocation));
        sel.selectByVisibleText(whatToSelectText);
    }

    public void pressEnter(By location) {
        driver.findElement(location).sendKeys(Keys.ENTER);
    }

    public void scrollToBottom(By element) throws InterruptedException {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
        Thread.sleep(500);
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));

    }

    public void zoomOut(int howManyTimes) {
        int times = 0;
        while (times < howManyTimes) {
            driver.findElement(By.tagName("html")).sendKeys(Keys.chord(commandZoomOut));
            times++;
        }
    }

}

