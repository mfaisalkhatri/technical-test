package io.github.mfaisalkhatri.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager {

    private WebDriver driver;

    public void startBrowser(final Browsers browser) {
        switch (browser) {
            case FIREFOX -> setupFirefox();
            case EDGE -> setupEdge();
            default -> setupChrome();
        }
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        this.driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void quitDriver() {
        this.driver.quit();
    }

    private void setupChrome() {
        this.driver = new ChromeDriver();

    }

    private void setupFirefox() {
        this.driver = new FirefoxDriver();
    }

    private void setupEdge() {
        this.driver = new EdgeDriver();
    }

}
