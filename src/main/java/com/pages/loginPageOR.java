package com.pages;

import com.DriverFactory.factory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPageOR {

    private WebDriver driver;

    private By username=By.name("username");
    private By password=By.name("password");
    private By submit=By.xpath("//button[@type='submit']");
    private By forgotyourpassword=By.linkText("Forgot your password?");

    private By Dashboard=By.xpath("//h6");

    private DashboardPage dashboardPage;

    private factory f;

    public loginPageOR(WebDriver driver){
        this.driver=driver;

    }

    public DashboardPage login(String user, String pwd){

        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(submit).click();
        return new DashboardPage(driver);
    }

    public boolean IsForgetPwdLinkExists(){
     return driver.findElement(forgotyourpassword).isDisplayed();
    }

    public String getPageTitle(){
        return driver.findElement(Dashboard).getText();
    }

}
