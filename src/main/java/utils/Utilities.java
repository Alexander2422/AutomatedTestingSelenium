package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class Utilities extends WebDriverUtils{

    Actions act = new Actions(driver);
    public static int duration = 5;

    public static void clickElement(By elem) {
        driver.findElement(elem).click();
    }

    public static void openLink(String link) {
        driver.get(link);
    }

    public void sendKeys(By elem, String textToSend) {
        driver.findElement(elem).sendKeys(textToSend);
    }

    public void waitOnElementToBeClickable(By elem, int duration) {
        new WebDriverWait(driver, Duration.ofSeconds(duration)).until(ExpectedConditions.elementToBeClickable(elem));
    }
    public static void waitOnElement(By elem){
        new WebDriverWait(driver, Duration.ofSeconds(duration)).until(ExpectedConditions.presenceOfElementLocated(elem));
    }
    public int randomNumberGenerator(int range) {
        Random random = new Random();
        return 100 + random.nextInt(range);
    }

    public static String getTextOfElement(By elem) {
        return driver.findElement(elem).getText();
    }

    public void selectFromDropdown(By dropdownList, String whatToSelect) {
        WebElement dropdown = driver.findElement(dropdownList);
        Select selectObject = new Select(dropdown);
        selectObject.selectByVisibleText(whatToSelect);
    }
}
