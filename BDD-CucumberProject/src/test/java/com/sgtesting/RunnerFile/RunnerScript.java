package com.sgtesting.RunnerFile;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Resources/FeatureFiles", glue = "com/sgtesting/Stepdefinitions"
)
public class RunnerScript extends AbstractTestNGCucumberTests {

}
