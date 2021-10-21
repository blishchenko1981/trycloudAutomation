package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesPage {

    @FindBy(xpath = "//tr[@data-file='Selenium_methods.pdf']//a[@class='action action-menu permanent']")
    public WebElement action_icon;

    @FindBy(xpath = "//span[.='Delete file']")
    public WebElement deleteFile;

    @FindBy(xpath = "//a[.='Deleted files']")
    public WebElement deletedFiles;

    @FindBy(xpath = "//tr[@data-file='Selenium_methods.pdf']//span[.='Selenium_methods']")
    public WebElement fileForDelete;

    @FindBy(xpath = "//label[@for='select_all_files']")
    public WebElement checkAllBoxes;

    @FindBy(xpath = "//input[@class='selectCheckBox checkbox']")
    public List<WebElement> selectedBoxes;


    public FilesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
