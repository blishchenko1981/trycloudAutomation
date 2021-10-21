package com.trycloud.pages;

import com.trycloud.step_definitions.US10_StepDefs;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

import static org.junit.Assert.assertTrue;


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


    public FilesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public void deleteFile(String nameOfFile) {

        Driver.getDriver().findElement(By.xpath("//tr[@data-file='" + nameOfFile + "']//a[@class='action action-menu permanent']")).click();
        deleteFile.click();

    }

    public void uploadFile(String path){
        addFile.click();
        BrowserUtil.waitFor(3);
        nevidimayaKnopka.sendKeys(path);
        BrowserUtil.waitFor(5);
    }

    public void verifyAllBtnsUnderSettings(){
        try {
            showRichWorkspaces.click();
            BrowserUtil.waitFor(2);
            assertTrue(Driver.getDriver().findElement(By.xpath("//div[@id = 'rich-workspace']")).isDisplayed());
            showRichWorkspaces.click();
        } catch (Exception e) {

            System.out.println("Button was clicked already ");
            e.printStackTrace();

        }


        try {
            showRecomendations.click();
            BrowserUtil.waitFor(2);
            assertTrue(Driver.getDriver().findElement(By.xpath("//div[@data-v-258784da]")).isDisplayed());
            showRecomendations.click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Button was clicked already ");

        }

        showHidden.click();
        assertTrue(showHidden.isDisplayed());

    }

    public void verifyStorageUsageIncreased(){
        String usedAfter = dataUsage.getText();
        usedAfter = usedAfter.substring(0, usedAfter.indexOf(" "));
        US10_StepDefs.usedBefore = US10_StepDefs.usedBefore.substring(0, US10_StepDefs.usedBefore.indexOf(" "));
        System.out.println("usedBefore = " + US10_StepDefs.usedBefore);
        System.out.println("usedAfter = " + usedAfter);
        BrowserUtil.waitFor(1);
        double before = Double.parseDouble(US10_StepDefs.usedBefore);
        double after = Double.parseDouble(usedAfter);
        assertTrue(after>before);
    }

}