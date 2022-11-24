package com.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    @Given("enter username and password")
    public void enterUsernameAndPassword() {

        System.out.println("user");
    }

    @When("User clicks on login buttonn")
    public void userClicksOnLoginButton() {
        System.out.println("click");
    }

    @When("User clicks on login button")
    public void userClicksOnLoginButtons() {
        System.out.println("clickssss");
    }

    @Then("Validate logged in User")
    public void validateLoggedInUser() {
    System.out.println("logegd");
    }
}
