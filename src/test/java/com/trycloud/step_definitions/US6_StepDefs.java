package com.trycloud.step_definitions;

import com.github.javafaker.Faker;
import com.trycloud.pages.CommonArea;
import com.trycloud.pages.FilesModulePage;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class US6_StepDefs {


    //AC #1
    Faker faker = new Faker();
    public String folderName = faker.educator().course();


    @Then("user goes to {string} module and clicks the {string} icon on top")
    public void userGoesToModuleAndClicksTheIconOnTop(String module, String plusIcon) {

        FilesModulePage files = new FilesModulePage();
        files.goToFilesModules();
        BrowserUtil.waitFor(1);
        files.clickPlusIcon();


    }

    @And("user clicks {string}, writes a folder name and clicks submit icon")
    public void userClicksWritesAFolderNameAndClicksSubmitIcon(String argument) {


        FilesModulePage files = new FilesModulePage();
        files.createFolder(folderName);

    }

    @Then("user should see the folder displayed on the page")
    public void userShouldSeeTheFolderDisplayedOnThePage() {

        FilesModulePage files = new FilesModulePage();
        Assert.assertTrue(files.ifFolderCreated(folderName));

    }


    //AC #2
    @Then("user goes to {string} module and is choosing a folder from the page")
    public void userGoesToModuleAndIsChoosingAFolderFromThePage(String arg0) {

        FilesModulePage filesModulePage = new FilesModulePage();
            filesModulePage.chooseFolder();

    }

    @And("user clicks the {string} icon on top")
    public void userClicksTheIconOnTop(String arg0) {

        FilesModulePage filesModulePage =new FilesModulePage();
        filesModulePage.clickPlusIcon();
        BrowserUtil.waitFor(1);

    }

    @And("user clicks upload file and upload the file")
    public void userClicksUploadFileAndUploadTheFile() {

        FilesModulePage filesModulePage = new FilesModulePage();
        filesModulePage.uploadPicture();
        BrowserUtil.waitFor(5);
        Driver.getDriver().navigate().refresh();
        BrowserUtil.waitFor(3);
    }

    @Then("user should see the file is displayed on the page")
    public void userShouldSeeTheFileIsDisplayedOnThePage() {

        FilesModulePage files = new FilesModulePage();
        Assert.assertTrue(files.ifFolderCreated("1"));

        //delete the file to avoid duplication
        files.deleteFile();

    }






}
