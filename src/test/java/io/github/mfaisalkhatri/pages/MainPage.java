package io.github.mfaisalkhatri.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage  extends BasePage{

    private final WebDriver driver;

    public MainPage(final WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void acceptCookies() {
        this.driver.findElement(By.id("elc-accept-link")).click();
    }

    public WebElement homeMenu() {
        return this.driver.findElement(By.cssSelector("a.logo"));
    }

    public WebElement ourStoryMenu () {
        return this.driver.findElement(By.cssSelector("#main-navigation-new > ul > li:nth-child(1) > a"));
    }

    public WebElement ourSolutionMenu () {
        return this.driver.findElement(By.cssSelector("#main-navigation-new > ul > li:nth-child(2) > a"));
    }

    public WebElement whyTendableMenu () {
        return this.driver.findElement(By.cssSelector("#main-navigation-new > ul > li:nth-child(3) > a"));
    }

    public OurStoryPage navigateToOurStoryPage() {
        ourStoryMenu().click();
        return new OurStoryPage(this.driver);
    }

    public OurSolutionPage navigateToOurSolutionPage() {
        ourSolutionMenu().click();
        return new OurSolutionPage(this.driver);
    }

    public WhyTendablePage navigateToWheyTendablePage() {
        whyTendableMenu().click();
        return new WhyTendablePage(this.driver);
    }

    public ContactUsPage navigateToContactUsPage() {
        contactUsBtn().click();
        return new ContactUsPage(this.driver);
    }


}
