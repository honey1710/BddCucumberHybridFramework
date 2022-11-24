package com.pages;

import com.DriverFactory.factory;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DashboardPage {

    By leftMenuItem=By.xpath("//ul/li[@class='oxd-main-menu-item-wrapper']");
    By Admin=By.linkText("Admin");




    private WebDriver driver;
    private factory f;


    public DashboardPage(WebDriver driver){
        this.driver=driver;
    }


    //loginPageOR loginPageOR=new loginPageOR(f.getDriver());

    public ArrayList<String> getLeftMenuItem(){
        List<WebElement> items=driver.findElements(leftMenuItem);
        ArrayList<String> itemsText=new ArrayList<>();
        for(WebElement item:items){
            itemsText.add(item.getText());
        }
        return itemsText;
    }

    public AdminPage ClickOnAdmin() {
        driver.findElement(Admin).click();
        return new AdminPage(driver);
    }


}
