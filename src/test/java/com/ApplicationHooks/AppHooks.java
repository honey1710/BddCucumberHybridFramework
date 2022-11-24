package com.ApplicationHooks;

import com.DriverFactory.factory;
import com.Util.configReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AppHooks {
    private configReader config;
    private WebDriver driver;
    private factory factoryDriver;

    @Before
    public void launchUrl(){

        config=new configReader();
        factoryDriver=new factory();
        String browser =config.readConfig("browser");
        System.out.println(browser);
        driver=factoryDriver.initDriver(browser);
    }

    @After(order=0)
    public void closeBrowser(){
        driver.close();
    }

    @After(order=1)
    public void screenshotIfFailed(Scenario scenario){
        if(scenario.isFailed()) {
            String screenshotName=scenario.getName().replace(" ","");
            byte[] srcPath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(srcPath,"image/path",screenshotName);
        }
    }

}
