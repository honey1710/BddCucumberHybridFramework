package com.StepDef;

import com.DriverFactory.factory;
import com.pages.AdminPage;
import com.pages.DashboardPage;
import com.pages.loginPageOR;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class AdminStepDef {

    AdminPage adminPage;
    DashboardPage dashboardPage;
    loginPageOR loginPage;
    WebDriver driver;
    factory f;

    @When("Search with username {string}")
    public void search_with_username(String user) {
        adminPage.searchUsername(user);
    }

    @Then("Record Should be displayed with username {string}")
    public void record_should_be_displayed_with_username(String user) {
        Assert.assertTrue(adminPage.isRecordExists(1, user));
    }


    @When("User click on Admin")
    public void userClickOnAdmin() {
        adminPage = dashboardPage.ClickOnAdmin();
    }

    @Given("User {string} is logged in with password {string} and at AdminPage")
    public void user_is_logged_in_with_password_and_at_admin_page(String user, String pwd) {
        f=new factory();
        driver=f.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        loginPage=new loginPageOR(f.getDriver());
        dashboardPage =loginPage.login(user,pwd);
        adminPage=dashboardPage.ClickOnAdmin();

    }
}

