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
    String usedBefore;


    @When("Click Settings on the left bottom corner")
    public void click_settings_on_the_left_bottom_corner() {
        commonArea.clickModule("Files");
        filesPage.settings.click();

    }

    @Then("Verify user can click any buttons.")
    public void verify_user_can_click_any_buttons() {
        BrowserUtil.waitFor(2);
        try {
            filesPage.showRichWorkspaces.click();
            BrowserUtil.waitFor(2);
            assertTrue(Driver.getDriver().findElement(By.xpath("//div[@id = 'rich-workspace']")).isDisplayed());
            filesPage.showRichWorkspaces.click();
        } catch (Exception e) {

            System.out.println("Button was clicked already ");
            e.printStackTrace();

        }


        try {
            filesPage.showRecomendations.click();
            BrowserUtil.waitFor(2);
            assertTrue(Driver.getDriver().findElement(By.xpath("//div[@data-v-258784da]")).isDisplayed());
            filesPage.showRecomendations.click();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Button was clicked already ");

        }


            filesPage.showHidden.click();
            assertTrue(filesPage.showHidden.isDisplayed());


    }

    @When("Check the current storage usage")
    public void checkTheCurrentStorageUsage() {

        commonArea.filesModule.click();
        usedBefore = filesPage.dataUsage.getText();
        System.out.println("UsedBefore = " + usedBefore);
    }

    @When("Upload a file")
    public void uploadAFile() {
        filesPage.addFile.click();

        BrowserUtil.waitFor(3);
        filesPage.nevidimayaKnopka.sendKeys("C:\\Users\\Vitalii\\Desktop\\Zoom Meeting 9_20_2021 2_58_22 PM.png");

        BrowserUtil.waitFor(5);

        //   filesPage.addFile.click();
        // filesPage.uploadFile.click();
        //     Runtime.getRuntime().exec("C:/Users/Vitalii/Desktop/FileUploadScript.exe");


    }

    @And("Refresh the page")
    public void refreshThePage() {

        String urlFile = Driver.getDriver().getCurrentUrl();
        Driver.getDriver().get(urlFile);

    }

    @Then("Verify the storage usage is increased.")
    public void verifyTheStorageUsageIsIncreased() {

        String usedAfter = filesPage.dataUsage.getText();
        System.out.println("usedAfter = " + usedAfter);
        BrowserUtil.waitFor(3);

        assertTrue(!(usedBefore.equals(usedAfter)));


        filesPage.deleteFile("Zoom Meeting 9_20_2021 2_58_22 PM.png");

        BrowserUtil.waitFor(3);


    }
}
