package com.trycloud.step_definitions;

import com.trycloud.pages.ActivityPage;
import com.trycloud.pages.CommonArea;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;


public class US10_StepDefs {
    ActivityPage activityPage = new ActivityPage();
    CommonArea commonArea = new CommonArea();


    @When("Click Settings on the left bottom corner")
    public void click_settings_on_the_left_bottom_corner() {
        commonArea.clickModule("Activity");
        activityPage.settingsBtn.click();

    }

    @Then("Verify user can click any buttons.")
    public void verify_user_can_click_any_buttons() {

        activityPage.RSSBtn.click();
        BrowserUtil.waitFor(3);
        assertTrue(activityPage.urlBox.isDisplayed());

    }

}
