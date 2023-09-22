package io.github.mfaisalkhatri.tests;

import io.github.mfaisalkhatri.pages.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TendableWebSiteTests extends BaseTest {

    private MainPage mainPage;

    @BeforeClass
    public void testConfig() {
        this.mainPage = new MainPage(this.driverManager.getDriver());
    }

    @Test
    public void testTopLevelMenus() {
        this.mainPage.acceptCookies();
        assertTrue(this.mainPage.homeMenu().isDisplayed());
        assertTrue(this.mainPage.ourStoryMenu().isDisplayed());
        assertTrue(this.mainPage.ourSolutionMenu().isDisplayed());
        assertTrue(this.mainPage.whyTendableMenu().isDisplayed());
    }


    @Test
    public void testPresenceOfRequestADemoButton() {
        assertTrue(this.mainPage.requestADemoBtn().isEnabled());

        final var ourStoryPage = this.mainPage.navigateToOurStoryPage();
        assertTrue(ourStoryPage.requestADemoBtn().isEnabled());

        final var ourSolutionPage = this.mainPage.navigateToOurSolutionPage();
        ourSolutionPage.requestADemoBtn().isEnabled();

        final var whyTendablePage = this.mainPage.navigateToWheyTendablePage();
        whyTendablePage.requestADemoBtn().isEnabled();
    }

    @Test
    public void testContactMarketing() {
        final var contactUsPage = this.mainPage.navigateToContactUsPage();
        contactUsPage.fillContactForm();
        assertEquals(contactUsPage.errorMessage(), "Sorry, there was an error submitting the form. Please try again.");
    }
}
