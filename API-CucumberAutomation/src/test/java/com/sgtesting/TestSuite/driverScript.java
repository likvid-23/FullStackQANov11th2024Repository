package com.sgtesting.TestSuite;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/FeatureFiles",
        glue = "com.sgtesting.employee.StepDefinitions",
        plugin = {"pretty",
                "html:Reports/cucumber-report.html",
                "json:Reports/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)


public class driverScript extends AbstractTestNGCucumberTests {
}
