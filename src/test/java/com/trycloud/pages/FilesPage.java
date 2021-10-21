package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FilesPage {

    @FindBy(xpath = "//tr[@data-file='Selenium_methods.pdf']//a[@class='action action-menu permanent']")
    public WebElement action_icon;



    @FindBy(xpath = "//span[.='Delete file']")
    public WebElement deleteFile;

    public void deleteFile(String nameOfFile) {

        Driver.getDriver().findElement(By.xpath("//tr[@data-file='"+ nameOfFile +"']//a[@class='action action-menu permanent']")).click();
        deleteFile.click();

    }


    @FindBy(xpath = "//a[.='Deleted files']")
    public WebElement deletedFiles;

    @FindBy(xpath = "//tr[@data-file='Selenium_methods.pdf']//span[.='Selenium_methods']")
    public WebElement fileForDelete;

    @FindBy(xpath = "//span[@class = 'icon icon-add']")
    public WebElement addFile;

    @FindBy(xpath = "//li[@id = 'quota']//p")
    public WebElement dataUsage;

    @FindBy(xpath = "//span[.='Upload file']")
    public WebElement uploadFile;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement nevidimayaKnopka;

    @FindBy(xpath = "//button[@class='settings-button']")
    public WebElement settings;

    @FindBy(xpath = "//label[@for='recommendationsEnabledToggle']")
    public WebElement showRecomendations;

    @FindBy(xpath = "//label[@for='showRichWorkspacesToggle']")
    public WebElement showRichWorkspaces;

    @FindBy(xpath = "//label[@for='showhiddenfilesToggle']")
    public WebElement showHidden;


    public FilesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
