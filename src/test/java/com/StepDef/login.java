package com.StepDef;

import com.DriverFactory.factory;
import com.pages.DashboardPage;
import com.pages.loginPageOR;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class login {

    private loginPageOR loginPageOR;
    private DashboardPage dashboardPage;
    private WebDriver driver;
    private factory f;
    @Given("Launch Url")
    public void launch_url() {
        System.out.println("hh");
        f=new factory();
        driver=f.getDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");



    }
    @When("User Enter UserName {string} and Password {string} to login")
    public void user_enter_user_name_and_password_to_login(String user, String pwd) {
        loginPageOR=new loginPageOR(f.getDriver());
        dashboardPage =loginPageOR.login(user,pwd);
    }
    @Then("Verify Page Title {string}")
    public void verify_page_title(String string) {
        Assert.assertEquals(string,loginPageOR.getPageTitle());
    }


    @And("extra")
    public void extra() {

        System.out.println("hjkhfr");
    }
}
