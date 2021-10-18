package com.trycloud.step_definitions;

import com.trycloud.pages.CommonArea;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;

import java.util.Map;

public class US14_StepDef {

    CommonArea commonArea = new CommonArea();

    String expectedResult;

    @When("Click magnifier icon on the right top")
    public void click_magnifier_icon_on_the_right_top() {
     commonArea.magnifierIcon.click();
    }

    @When("Search any existing file or folder or user name")
    public void searchAnyExistingFileOrFolderOrUserName(Map<String,String> nameOfFile) {

        commonArea.searchBox.sendKeys(nameOfFile.get("name of file"));
        expectedResult = nameOfFile.get("name of file");
        System.out.println("expectedResult = " + expectedResult);

    }


    @Then("Verify the app displays the expected result option")
    public void verify_the_app_displays_the_expected_result_option() {

       String actualResult =  commonArea.searchResult.getAttribute("title");
        System.out.println("actualResult = " + actualResult);
        assertTrue(expectedResult.equals(actualResult));
    }



}

