package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonArea {

    @FindBy(xpath = "(//li[@data-id='dashboard'])[1]")
    WebElement dashboardModule;

    @FindBy(xpath = "(//a[@aria-label = 'Files'])[1]")
    WebElement filesModule;

    @FindBy(xpath = "(//a[@aria-label='Photos'])[1]")
    WebElement photosModule;

    @FindBy(xpath = "(//a[@aria-label='Activity'])[1]")
    WebElement activityModule;

    @FindBy(xpath = "(//a[@aria-label='Talk'])[1]")
    WebElement talkModule;

    @FindBy(xpath = "(//a[@aria-label='Contacts'])[1]")
    WebElement contactsModule;

    @FindBy(xpath = "(//a[@aria-label='Calendar'])[1]")
    WebElement calendarModule;

    @FindBy(xpath = "(//a[@aria-label='Deck'])[1]")
    WebElement deckModule;

    public CommonArea(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

}
