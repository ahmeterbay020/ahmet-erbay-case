package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;


public class CareersQAPage extends BasePage {
    private By seeAllQAJobsBtn = By.xpath("//a[contains(text(),'See all QA jobs')]");

    public CareersQAPage(WebDriver driver) {
        super(driver);
    }

    private By filterLocation = By.xpath("//span[@title='All']");
    private By istanbulOption = By.xpath("//li[normalize-space()='Istanbul, Turkiye']");
    private By all = By.xpath("//li[normalize-space()='All']");
    private By jobCards = By.xpath("//div[@class='position-list-item-wrapper bg-light']");
    private By qA = By.xpath("//span[@title='Quality Assurance']");
    private By istanbulJob = By.xpath("//div[normalize-space()='Istanbul, Turkiye']");
    private By roleView = By.xpath("//a[normalize-space()='View Role']");

    public By getLocationByIndex(int index) {
        return By.xpath("(//div[normalize-space()='Istanbul, Turkiye'])[" + index + "]");
    }

    public By getJobPositionByIndex(int index) {
        return By.xpath("(//span[normalize-space()='Quality Assurance'])[" + index + "]");
    }

    public By getJobDepartmentByIndex(int index) {
        return By.xpath("(//p[contains(normalize-space(), 'Quality Assurance')])[" + index + "]");
    }


    public void applyFilters() {
        waitVisible(qA);
        click(filterLocation);
        click(all);
        click(filterLocation);
        waitVisible(all);
        hover(all);
        click(istanbulOption);

    }

    public List<WebElement> getJobCards() {
        return driver.findElements(jobCards);
    }

    public boolean allJobsMatch() {
        waitVisible(istanbulJob);
        hover(istanbulJob);
        waitVisible(roleView);
        hover(roleView);
        waitVisible(getLocationByIndex(1));
        waitVisible(getJobPositionByIndex(1));
        waitVisible(getJobDepartmentByIndex(1));
        int index = 1;
        List<WebElement> jobs = getJobCards();
        for (int i = 0; i < jobs.size(); i++) {
            String position = driver.findElement(getJobPositionByIndex(index)).getText();
            String department = driver.findElement(getJobDepartmentByIndex(index)).getText();
            String location = driver.findElement(getLocationByIndex(index)).getText();

            if (!(position.contains("Quality Assurance") &&
                    department.contains("Quality Assurance") &&
                    location.contains("Istanbul"))) {
                return false;
            }
            index++;
        }
        return true;
    }

    public void clickFirstViewRole() {
        hover(getJobCards().getFirst());
        click(roleView);

    }

    public void clickSeeAllQAJobs() {
        click(seeAllQAJobsBtn);
    }
}
