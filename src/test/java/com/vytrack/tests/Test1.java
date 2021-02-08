package com.vytrack.tests;

import com.vytrack.pages.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Test1 extends TestBase {

    @Test
    public void test1() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
        Actions action = new Actions(driver);
        WebElement activities = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/a/span"));
        action.moveToElement(activities).perform();
        WebElement events = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]/div/div/ul/li[4]/a/span"));
        Thread.sleep(5000);
        action.moveToElement(events).click().perform();
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(5000);

        String actualResult = driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div[1]/div/div/div/div[2]/div")).getText();

        Assert.assertEquals(actualResult,"Options");
    }



}
