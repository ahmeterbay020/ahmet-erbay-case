package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By logo = By.cssSelector("img[alt*='insider_logo']");
    private By cookieBtn = By.cssSelector("a#wt-cli-accept-all-btn");

    public HomePage(WebDriver driver) { super(driver); }

    public void open() {
        driver.get("https://useinsider.com/");
    }

    public boolean isLoaded() {
        return waitVisible(logo).isDisplayed();
    }

    public void acceptCookies() {
        try {
            driver.findElement(cookieBtn).click();
        } catch (Exception ignored) {}
    }
}

