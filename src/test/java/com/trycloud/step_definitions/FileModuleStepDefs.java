package com.trycloud.step_definitions;

import com.github.javafaker.Faker;
import com.trycloud.pages.CommonArea;
import com.trycloud.pages.LoginPage;
import com.trycloud.pages.ModulesPage;
import com.trycloud.utilities.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;


public class FileModuleStepDefs {

    CommonArea commonArea = new CommonArea();
    ModulesPage modulesPage = new ModulesPage();
    Faker faker = new Faker();
    String message = faker.gameOfThrones().quote();

    @When("user click the {string} module on the page")
    public void userClickTheModuleOnThePage(String modulesName) {
        BrowserUtil.waitFor(1);
        commonArea.clickModule(modulesName);
    }

    @When("Click action-icon from any file on the page")
    public void click_action_icon_from_any_file_on_the_page() {
        modulesPage.clickActionIcon();
        BrowserUtil.waitFor(1);

    }

    @When("Click details")
    public void click_details() {
        modulesPage.clickDetailsBtn();

    }

    @When("Write a comment inside to the input box")
    public void write_a_comment_inside_to_the_input_box() {

        modulesPage.clickCommentBtn(message);
    }

    @When("Click the submit button to post it")
    public void click_the_submit_button_to_post_it() {
        modulesPage.clickSubmitBtn();
    }

    @Then("Verify the comment is displayed in the comment section.")
    public void verify_the_comment_is_displayed_in_the_comment_section() {

        assertTrue(modulesPage.messageIsDisplayed(message));
    }


}
