package com.TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"rerun:target\\failedrerun.txt"},
        features = "@target\\failedrerun.txt",
        glue={"com.StepDef","com.ApplicationHooks"},
        publish = true
)


public class FailedReRunTestrunner {


}
