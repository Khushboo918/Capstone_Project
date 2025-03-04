package com.store.TestCases;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.store.PageObject.SelectBrowserBase;

public class Baseclass {
    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;
    Properties props;
    SelectBrowserBase selectBrowserBase;

    @BeforeClass
    public void setup() throws FileNotFoundException, IOException {
    	//extent reports creating object
        ExtentSparkReporter spark=new ExtentSparkReporter("./extent-reports/extent-report.html");
        extent=new ExtentReports();
        extent.attachReporter(spark);
        selectBrowserBase=new SelectBrowserBase(driver);
        //select browser here
    	driver=SelectBrowserBase.selectBrowser("chrome");
        props=new Properties();
        props.load(new FileInputStream("./src/test/java/data.properties"));
        //navigate to website
        driver.navigate().to("https://www.demoblaze.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod() {
        test=extent.createTest("Test Case: " + this.getClass().getName());
    }
    @AfterMethod
    public void afterMethod() {
        extent.flush();
    }
    @AfterClass
    public void close() {
        driver.quit();
        extent.flush();
    }
    //screeenshot method creation
    public void takeScreenshot(String fileName) throws IOException {
        File screenshot=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(screenshot, new File("./screenshots/"+fileName+".png"));
    }
}