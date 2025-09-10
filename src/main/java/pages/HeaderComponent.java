package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HeaderComponent extends BasePage {
    private By companyMenu = By.xpath("//nav//a[normalize-space()='Company']");
    private By careersLink = By.xpath("//a[contains(@href,'careers')]");

    public HeaderComponent(WebDriver driver) { super(driver); }

    public void goToCareers() {
        Actions actions = new Actions(driver);
        WebElement company = waitVisible(companyMenu);
        actions.moveToElement(company).perform();
        click(careersLink);
    }
}

