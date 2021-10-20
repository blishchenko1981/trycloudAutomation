package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActivityPage {

    public ActivityPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='Settings']")
    public WebElement settingsBtn;

    @FindBy(xpath = "//label[@for='enable_rss']")
    public WebElement RSSBtn;

    @FindBy(xpath = "//input[@id='feed-link']")
    public WebElement urlBox;



}
