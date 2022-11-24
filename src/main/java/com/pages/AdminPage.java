package com.pages;

import com.DriverFactory.factory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AdminPage {


    By username=By.xpath("//form//label[text()='Username']//parent::div/following-sibling::div/input");
    By search=By.xpath("//form//button[@type='submit']");
    By recordRows=By.className("oxd-table-card");
    By columns=By.xpath("//div[@class='oxd-table-cell oxd-padding-cell']");

    private WebDriver driver;
    private factory f;

   public AdminPage(WebDriver driver){
       this.driver=driver;
   }


    public void searchUsername(String user){
        driver.findElement(username).sendKeys(user);
        driver.findElement(search).click();
    }

    public boolean isRecordExists(int column, String ExpValue){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean recordExists = false;
        try {

            List<WebElement> recordsList = driver.findElements(recordRows);
            List<WebElement> colList;
            for (WebElement r : recordsList) {
                WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5000));
                w.until(ExpectedConditions.visibilityOf(r));

                recordExists = false;
                colList = r.findElements(columns);
                String ActualValue = colList.get(1).getText();
                if (ExpValue.equalsIgnoreCase(ActualValue))
                    recordExists = true;
            }
        }
        catch(Exception e){
            System.out.println("himani"+e.getMessage()+"    *******"+recordExists);
        }
        finally{
            return recordExists;
        }
    }

}
