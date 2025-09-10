package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LeverJobPage extends BasePage {
    public LeverJobPage(WebDriver driver) {
        super(driver);
    }



    public boolean verifyLeverPage(String originalTab,String jobUrl) {
        switchToNewTab(driver, originalTab);
        wait.until(ExpectedConditions.urlContains("lever.co"));


        return driver.getCurrentUrl().equals(jobUrl);
    }
}


