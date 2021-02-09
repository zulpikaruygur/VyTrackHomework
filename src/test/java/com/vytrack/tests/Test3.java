package com.vytrack.tests;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test3 extends TestBase{

    @Test
    public void test3() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
        Actions action = new Actions(driver);
        WebElement activities = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/a/span"));
        action.moveToElement(activities).perform();
        WebElement events = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/div/div/ul/li[4]/a/span"));
        Thread.sleep(5000);
        action.moveToElement(events).click().perform();
        Thread.sleep(10000);
        String actualResult = driver.findElement(By.cssSelector("#grid-calendar-event-grid-749682296 > div.oro-datagrid > div:nth-child(1) > div > div.pull-right.grid-toolbar-tools > div.page-size.pull-right.form-horizontal > div > div > button")).getText();
        Assert.assertEquals(actualResult,"25");
    }
}
