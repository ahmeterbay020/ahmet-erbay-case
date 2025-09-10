package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CareersPage extends BasePage {
    private By locations = By.xpath("//h3[normalize-space()='Our Locations']");
    private By teams = By.xpath("//h3[normalize-space()='Find your calling']");
    private By life = By.xpath("//h2[contains(text(),'Life at Insider')]");
    private By seeAllTeamsBtn = By.xpath("//a[normalize-space()='See all teams']");
    private By QaTeams = By.xpath("//h3[normalize-space()='Quality Assurance']");
    String expectedCarrerPageUrl = "https://useinsider.com/careers/";


    public CareersPage(WebDriver driver) {
        super(driver);
    }

    public void clickseeAllTeamsBtn() {
       waitVisible(seeAllTeamsBtn);
        hover(seeAllTeamsBtn);
        click(seeAllTeamsBtn);
    }

    public void QATeam() {
        waitVisible(QaTeams);
        hover(QaTeams);
        click(QaTeams);
    }

    public boolean blocksVisible(String currentUrl) {
        return waitVisible(locations).isDisplayed()
                && expectedCarrerPageUrl.equals(currentUrl)
                && waitVisible(life).isDisplayed() && waitVisible(teams).isDisplayed();
    }
}

