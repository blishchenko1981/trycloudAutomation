package com.trycloud.step_definitions;

import com.trycloud.pages.CommonArea;
import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static org.junit.Assert.assertTrue;

public class us3_StepDef {

    FilesPage filesPage = new FilesPage();

    @When("user clicks on Files module")
    public void userClicksOnFilesModule() {
        CommonArea clickModule = new CommonArea();
        clickModule.clickModule("Files");
        BrowserUtil.waitFor(2);


    }
    @Then("verify the page title is {string}")
    public void verifyThePageTitleIs(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        BrowserUtil.waitFor(2);
        System.out.println("actualTitle = " + actualTitle);

        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @And("click the top left checkbox of the table")
    public void clickTheTopLeftCheckboxOfTheTable() {
        filesPage.checkAllBoxes.click();
        BrowserUtil.waitFor(4);
    }

    @Then("verify all the files are selected")
    public void verifyAllTheFilesAreSelected() {

   assertTrue(BrowserUtil.AllBoxesSelected(filesPage.selectedBoxes));


    }
}
