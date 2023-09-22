package io.github.mfaisalkhatri.tests;

import io.github.mfaisalkhatri.driver.Browsers;
import io.github.mfaisalkhatri.driver.DriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected DriverManager driverManager;

    @BeforeClass
    @Parameters("browser")
    public void setupTest(final String browser) {
        this.driverManager = new DriverManager();
        this.driverManager.startBrowser(Browsers.valueOf(browser.toUpperCase()));
        this.driverManager.getDriver().navigate().to("https://www.tendable.com/");

    }

    @AfterClass
    public void tearDown() {
        this.driverManager.quitDriver();
    }
}
