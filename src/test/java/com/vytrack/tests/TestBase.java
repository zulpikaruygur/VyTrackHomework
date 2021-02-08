package com.vytrack.tests;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    public void driverSetUp(){
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("url"));
    }

    @AfterMethod
    public void driverClose() throws InterruptedException {
        Thread.sleep(2000);
        Driver.closeDriver();
    }
}
