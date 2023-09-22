package io.github.mfaisalkhatri.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private final WebDriver driver;

    public BasePage(final WebDriver driver) {

        this.driver = driver;
    }

    public WebElement requestADemoBtn() {
        return this.driver.findElement(By.cssSelector(".button-links-panel > a:nth-child(5)"));
    }

    public WebElement contactUsBtn() {
        return this.driver.findElement(By.cssSelector(".button-links-panel > a:nth-child(3)"));
    }

}
