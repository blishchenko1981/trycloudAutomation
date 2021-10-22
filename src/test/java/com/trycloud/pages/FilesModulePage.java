package com.trycloud.pages;

import com.github.javafaker.Faker;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import io.cucumber.java.bs.A;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilesModulePage {

    //existing folders on the front page
    @FindBy(xpath = "//div[@id='recommendations']/ul/li")
    public List<WebElement> existingFolders;

    //files
    @FindBy(xpath = "(//a[@aria-label = 'Files'])[1]")
    public WebElement filesModule;

    @FindBy(xpath = "//a[@class='button new']")
    public WebElement plusIcon;

    @FindBy(xpath = "(//a[@class='menuitem'])[1]")
    public WebElement newFolder;

    @FindBy(id = "view13-input-folder")
    public WebElement folderNameInputBox;

    @FindBy(xpath = "//form/input[@class = 'icon-confirm']")
    public WebElement confirmAfterNaming;


    @FindBy(xpath = "//label/span[@class='displayname']")
    public WebElement uploadFile;


    @FindBy(xpath = "//span[@class='innernametext']")
    public List<WebElement> listOfFiles;

    @FindBy(xpath = "//input[@type='file']")
    public WebElement nevidimayaKnopka;

    @FindBy(xpath = "//label[@for='select_all_files']")
    public WebElement selectAll;

    @FindBy(xpath = "//span[@id='selectedActionsList']/a")
    public WebElement actions;

    @FindBy(xpath = "//li[@class='item-delete']/a")
    public WebElement delete;


    public FilesModulePage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public void goToFilesModules(){

        this.filesModule.click();

    }

    public void createFolder(String folderName){

        this.newFolder.click();
        this.folderNameInputBox.sendKeys(folderName);
        BrowserUtil.waitFor(2);
        this.confirmAfterNaming.click();
        BrowserUtil.waitFor(2);

    }

    public void chooseFolder(){

        this.filesModule.click();
        listOfFiles.get(0).click();

    }

    public void clickPlusIcon(){

        this.plusIcon.click();

    }

    public void uploadPicture() {
        this.nevidimayaKnopka.sendKeys("/Users/kseniiamazanko/Desktop/trycloudAutomation/.idea/1.jpg");
    }

    public void deleteFile(){
        this.selectAll.click();
        BrowserUtil.waitFor(1);
        this.actions.click();
        BrowserUtil.waitFor(1);
        this.delete.click();
        BrowserUtil.waitFor(1);
    }

    //get text from Web elements of folders list
    public List<String> getNamesOfWebElementList(List <WebElement> allFolders){

        List<String> namesOfFolders = new ArrayList<>();
        allFolders.forEach(p->namesOfFolders.add(p.getText()));

        return namesOfFolders;

    }


    //method to check if the folder was created or the file was uploaded
    public boolean ifFolderCreated(String fileName){

        boolean result = false;

        List<String> createdFoldersNames = getNamesOfWebElementList(listOfFiles);

        System.out.println("createdFoldersNames = " + createdFoldersNames);

        if(createdFoldersNames.contains(fileName)){

            result=true;

        }

        return result;

    }










}
