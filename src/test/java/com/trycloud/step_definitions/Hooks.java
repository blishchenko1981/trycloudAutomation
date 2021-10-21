package com.trycloud.step_definitions;


import com.trycloud.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    // We can set up a hook class that contains
    // methods that run before each scenario and after each scenario
    // or even when we learn tags
    // we can run certain code before and after each scenario that tagged with certain tag
    @Before()
    public void setupDriver(){
        System.out.println("THIS IS FROM @Before inside hooks class");
        // set up implicit wait
        Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS) ;
        Driver.getDriver().manage().window().maximize();
    }

    @After()
    public void tearDown(Scenario scenario){

        // check if scenario failed or not
        if(scenario.isFailed() ){
            // this is how we take screenshot in selenium
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png","WHAT EVER YOU WANT ");


        }
        System.out.println("THIS IS FROM @After inside hooks class");
        Driver.closeBrowser();

    }
}
