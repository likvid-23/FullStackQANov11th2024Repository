package com.sgtesting.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = "src/resources/features",
        glue = "com/sgtesting/StepDefinitions",
        plugin = {"pretty",
                "html:Reports/BDD-CucumberProject.html"}
)
public class RunnerScript extends AbstractTestNGCucumberTests {

}
