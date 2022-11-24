package com.DriverFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class factory {

    public static ThreadLocal<WebDriver> threadLocalWebDriver=new ThreadLocal<>();
    public static WebDriver driver;

    public WebDriver initDriver(String browser){
        if(browser.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            threadLocalWebDriver.set(new ChromeDriver());
        }
        else {
            System.out.println("Wrong browser");
        }
        driver=threadLocalWebDriver.get();
       // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        return driver;

    }
    public WebDriver getDriver(){
        return threadLocalWebDriver.get();
    }

}
