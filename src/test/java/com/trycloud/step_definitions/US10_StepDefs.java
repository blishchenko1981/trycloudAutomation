package com.trycloud.step_definitions;

import com.trycloud.pages.CommonArea;
import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.junit.Assert.*;


public class US10_StepDefs {

    CommonArea commonArea = new CommonArea();
    FilesPage filesPage = new FilesPage();
    public static  String usedBefore;


    @When("Click Settings on the left bottom corner")
    public void click_settings_on_the_left_bottom_corner() {
        commonArea.clickModule("Files");
        filesPage.settings.click();

    }

    @Then("Verify user can click any buttons.")
    public void verify_user_can_click_any_buttons() {
        BrowserUtil.waitFor(2);
        filesPage.verifyAllBtnsUnderSettings();

    }

    @When("Check the current storage usage")
    public void checkTheCurrentStorageUsage() {

        commonArea.filesModule.click();
        usedBefore = filesPage.dataUsage.getText();
    }

    @When("Upload a file {string}")
    public void uploadAFile(String pathOfFile) {
        filesPage.uploadFile(pathOfFile);
    }


    @And("Refresh the page")
    public void refreshThePage() {

        String urlFile = Driver.getDriver().getCurrentUrl();
        Driver.getDriver().get(urlFile);

    }

    @Then("Verify the storage usage is increased.")
    public void verifyTheStorageUsageIsIncreased() {

        filesPage.verifyStorageUsageIncreased();

        BrowserUtil.waitFor(3);


    }


    @And("Delete file {string}")
    public void deleteFile(String nameOFFile) {
        filesPage.deleteFile(nameOFFile);
        BrowserUtil.waitFor(2);
    }
}
