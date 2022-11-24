package com.StepDef;

import com.DriverFactory.factory;
import com.pages.AdminPage;
import com.pages.DashboardPage;
import com.pages.loginPageOR;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.ListResourceBundle;

public class DashboardStepDef {

    private DashboardPage dashboardPage;
    private loginPageOR loginPageOR;
    private factory f;
    private WebDriver driver;



    @Given("User {string} is logged in with password {string}")
    public void user_is_logged_in_with_password(String user, String pwd) {

        f=new factory();
        driver=f.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        loginPageOR=new loginPageOR(f.getDriver());
        dashboardPage =loginPageOR.login(user,pwd);
    }

    @Then("Left Side Menu Items Should be Available")
    public void left_side_menu_items_should_be_available(DataTable expectedItemsList) {

        List<String> expected=expectedItemsList.asList();
        List<String> actual= dashboardPage.getLeftMenuItem();
        Assert.assertTrue(actual.containsAll(expected));
    }






}
