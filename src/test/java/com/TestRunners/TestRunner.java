package com.TestRunners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src\\resources\\Feature",
        glue={"com.StepDef","com.ApplicationHooks"},
        plugin = {"pretty","rerun:target\\failedrerun.txt"},
        publish = true
)

public class TestRunner {

}

