package com.store.TestCases;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpPage {
    WebDriver driver;
    String baseUrl = "https://www.demoblaze.com/";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @Test
    public void testSignUpFunction() throws InterruptedException {
        // Click on the "Sign up" button
        driver.findElement(By.linkText("Sign up")).click();
        Thread.sleep(2000);

        // Fill in the sign-up form
        driver.findElement(By.id("sign-username")).sendKeys("admin" +System.currentTimeMillis());
        driver.findElement(By.id("sign-password")).sendKeys("admin123");

        // Click on the "Sign up" button
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();
        Thread.sleep(2000);

        // Handle the alert
        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains("Sign up successful"), "Alert text did not match expected value!");
        driver.switchTo().alert().accept();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}