package com.trycloud.pages;

import com.trycloud.utilities.ConfigReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "user")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "submit-form")
    private WebElement login;

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void goTo(){
Driver.getDriver().get(ConfigReader.read("trycloud_url"));
    }

    public void login(String username){
        this.username.sendKeys(ConfigReader.read(username));
        this.password.sendKeys(ConfigReader.read("password"));
        this.login.click();
    }
}
