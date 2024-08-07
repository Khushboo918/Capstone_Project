package com.store.TestCases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

public class Login extends Baseclass 
{
    // Test case to verify valid login functionality
    @Test(priority=0)
    public void testLogin() throws InterruptedException, IOException {
        // Create test for extent reports
        test = extent.createTest("testLogin");
        try {
            // Locate and click on the Sign In button
            WebElement signin = driver.findElement(By.cssSelector("#login2"));
            signin.click();
            test.log(Status.INFO, "Clicked on Sign In");

            // Enter username
            WebElement username = driver.findElement(By.xpath("//input[@id='loginusername']"));
            username.clear();
            username.sendKeys(props.getProperty("username"));
            test.log(Status.INFO, "Entered username");

            // Enter password
            WebElement password = driver.findElement(By.xpath("//input[@id='loginpassword']"));
            password.clear();
            password.sendKeys(props.getProperty("password"));
            test.log(Status.INFO, "Entered password");

            // Click on the Login button
            WebElement login = driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
            login.click();
            test.log(Status.INFO, "Clicked on Login");

            // Wait for 2 seconds
            Thread.sleep(2000);

            // Take a screenshot after login
            takeScreenshot("Login");
            test.log(Status.PASS, "Login successful").addScreenCaptureFromPath("Screenshots/Login.png");

            // Locate and click on the Sign Out button
            WebElement signout = driver.findElement(By.xpath("//a[@id='logout2']"));
            signout.click();
            test.log(Status.INFO, "Clicked on Sign Out");

            // Wait for 5 seconds
            Thread.sleep(5000);

            // Log sign out success
            test.log(Status.PASS, "Sign Out successful");
        } catch (Exception e) {
            // Log failure in case of an exception
            test.log(Status.FAIL, "Login test failed");
            test.fail(e);
        }
    }

    // Test case to verify login with invalid username and password
    @Test(priority = 1)
    public void testInvalidUsernameandpassword() throws InterruptedException, IOException {
        // Create test for extent reports
        test = extent.createTest("testInvalidUsernameandpassword");
        try {
            // Locate and click on the Sign In button
            WebElement signin = driver.findElement(By.cssSelector("#login2"));
            signin.click();
            test.log(Status.INFO, "Clicked on Sign In");

            // Enter invalid username
            WebElement username = driver.findElement(By.xpath("//input[@id='loginusername']"));
            username.clear();
            username.sendKeys(props.getProperty("invalidusername"));
            test.log(Status.INFO, "Entered username");

            // Enter invalid password
            WebElement password = driver.findElement(By.xpath("//input[@id='loginpassword']"));
            password.clear();
            password.sendKeys(props.getProperty("invalidpassword"));
            test.log(Status.INFO, "Entered password");

            // Click on the Login button
            WebElement login = driver.findElement(By.xpath("//button[normalize-space()='Log in']"));
            login.click();
            test.log(Status.INFO, "Clicked on Login");

            // Wait for 2 seconds
            Thread.sleep(2000);

            // Take a screenshot after invalid login attempt
            takeScreenshot("invalidlogin");
            test.log(Status.PASS, "Login successful").addScreenCaptureFromPath("Screenshots/invalidlogin.png");

            // Locate and click on the Sign Out button
            WebElement signout = driver.findElement(By.xpath("//a[@id='logout2']"));
            signout.click();
            test.log(Status.INFO, "Clicked on Sign Out");

            // Wait for 5 seconds
            Thread.sleep(5000);

            // Log sign out success
            test.log(Status.PASS, "Sign Out successful");
        } catch (Exception e) {
            // Log failure in case of an exception
            test.log(Status.FAIL, "Login test failed");
            test.fail(e);

            // Wait for 4 seconds before continuing
            Thread.sleep(4000);
        }
    }
}  