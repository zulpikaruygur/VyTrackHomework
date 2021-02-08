package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindAll({
            @FindBy(id = "prependedInput"),
            @FindBy(name = "_username")
    })
    public WebElement username;

    @FindAll({
            @FindBy(id = "prependedInput2"),
            @FindBy(name = "_password")
    })
    public WebElement password;

    @FindBy(id = "_submit")
    public WebElement loginButton;
}
