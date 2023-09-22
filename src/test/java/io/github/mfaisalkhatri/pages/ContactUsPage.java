package io.github.mfaisalkhatri.pages;

import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage extends BasePage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    public ContactUsPage(final WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    private WebElement contactBtn() {
        return this.driver.findElement(By.cssSelector("div:nth-child(1) > div > div:nth-child(2) > div.flex > button"));
    }

    private WebElement fullNameField() {
        return this.driver.findElement(By.id("form-input-fullName"));
    }

    private WebElement organisationNameField() {
        return this.driver.findElement(By.id("form-input-organisationName"));
    }

    private WebElement phoneNumberField() {
        return this.driver.findElement(By.id("form-input-cellPhone"));
    }

    private WebElement emailField() {
        return this.driver.findElement(By.id("form-input-email"));
    }

    private WebElement jobRoleField() {
        return this.driver.findElement(By.id("form-input-jobRole"));
    }

    private void selectJobRole() {
        new Select(jobRoleField()).selectByVisibleText("CNO");
    }

    private WebElement iAgreeRadioBtn() {
        return this.wait.until(ExpectedConditions.elementToBeClickable(By.id("form-input-consentAgreed-0")));
    }
    private WebElement submitBtn() {
        return this.wait.until(ExpectedConditions.elementToBeClickable(By.name("form_page_submit")));
    }

    public void fillContactForm()  {
        contactBtn().click();
        final Faker faker = new Faker();
        fullNameField().sendKeys(faker.name().fullName());
        organisationNameField().sendKeys(faker.company().name());
        phoneNumberField().sendKeys(String.valueOf(faker.number()
                .numberBetween(9000000000L, 9999999999L)));
        emailField().sendKeys(faker.internet().emailAddress());
        selectJobRole();
        final JavascriptExecutor executor = (JavascriptExecutor) this.driver;
        executor.executeScript("arguments[0].click();", iAgreeRadioBtn());
        executor.executeScript("arguments[0].click();", submitBtn());
    }

    public String errorMessage() {
        return this.driver.findElement(By.cssSelector("div.ff-form-errors > p")).getText();
    }
}
