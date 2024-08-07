package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectBrowserBase {
    // Protected WebDriver variable to be used by subclasses
    protected static WebDriver driver;
    
    // Constructor to initialize WebDriver
    public SelectBrowserBase(WebDriver driver) {
        SelectBrowserBase.driver = driver;
    }
    
    // Method to select and initialize browser 
    public static WebDriver selectBrowser(String browserName) {
        
        // Check if the browserName is "chrome"
        if (browserName.equalsIgnoreCase("chrome")) {
            // Initialize ChromeDriver
            driver = new ChromeDriver();
            driver.manage().window().maximize(); // Maximize the browser window
            //navigate to website
            driver.get("https://www.demoblaze.com/"); 
            
        } else if (browserName.equalsIgnoreCase("firefox")) {
            // Check if the browserName is "firefox"
            driver = new FirefoxDriver();
            driver.manage().window().maximize(); 
            driver.get("https://www.demoblaze.com/"); 
            
        } else if (browserName.equalsIgnoreCase("edge")) {
            // Check if the browserName is "edge"
            driver = new EdgeDriver();
            driver.manage().window().maximize(); // Maximize the browser window
            //navigatr website url
            driver.get("https://www.demoblaze.com/");
            
        } else {
            // Print an error message if the browser is not found
            System.out.println("Sorry! Browser not found.");
        }
        return driver; 
    }
}