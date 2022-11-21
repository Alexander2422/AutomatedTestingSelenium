package pages;

import org.openqa.selenium.By;
import utils.Utilities;

import java.awt.*;

public class HomePage extends BasePage{
    private By elements = By.xpath("//div[@class='card-body']//*[text()='Elements']");



    public void openHomePage(){
        Utilities.openLink(StaticLinks.homepageDemoQA);
    }
    public void clickOnElements(){
        Utilities.clickElement(elements);
    }

    public static class StaticLinks{
        public static String homepageDemoQA="https://demoqa.com/";
    }

}
