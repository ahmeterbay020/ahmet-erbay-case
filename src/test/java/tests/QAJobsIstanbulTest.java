package tests;

import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;

public class QAJobsIstanbulTest {
    WebDriver driver;
    HomePage home;
    HeaderComponent header;
    CareersPage careers;
    CareersQAPage careersQA;
    LeverJobPage lever;

    @BeforeClass
    public void setup() {
        driver = DriverFactory.initDriver();
        home = new HomePage(driver);
        header = new HeaderComponent(driver);
        careers = new CareersPage(driver);
        careersQA = new CareersQAPage(driver);
        lever = new LeverJobPage(driver);
    }

    @Test
    public void testQAJobsInIstanbul() {
        home.open();
        home.acceptCookies();
        Assert.assertTrue(home.isLoaded(), "Home page not loaded!");
        header.goToCareers();
        careers.clickseeAllTeamsBtn();
        Assert.assertTrue(careers.blocksVisible(driver.getCurrentUrl()), "Career blocks not visible!");
        careers.QATeam();
        careersQA.clickSeeAllQAJobs();
        careersQA.applyFilters();
        Assert.assertFalse(careersQA.getJobCards().isEmpty(), "No jobs found!");
        Assert.assertTrue(careersQA.allJobsMatch(), "Some jobs do not match filters!");
        String originalTab = driver.getWindowHandle();
        careersQA.clickFirstViewRole();
        Assert.assertTrue(lever.verifyLeverPage(originalTab,careersQA.getJobCards().getFirst().findElement(By.tagName("a")).getAttribute("href")), "Not redirected to Lever!");
    }

    @AfterClass
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}

