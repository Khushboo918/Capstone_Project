package com.store.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
public class ContactPage extends Baseclass {

    // Test case to verify contact functionality
	@Test
    public void testContactForm() throws InterruptedException, IOException {
        // Click on the "Contact" button
    	test = extent.createTest("test Contact");
        driver.findElement(By.linkText("Contact")).click();
        Thread.sleep(2000);

        // Fill in the contact form
        driver.findElement(By.id("recipient-email")).sendKeys("admin@example.com");
        driver.findElement(By.id("recipient-name")).sendKeys("admin");
        driver.findElement(By.id("message-text")).sendKeys("This is a test message.");
        Thread.sleep(4000);
        
        //take screenshot
        takeScreenshot("contactpage");
        test.log(Status.PASS, "contactpage").addScreenCaptureFromPath("Screenshots/contactpage.png");
        // Click on the "Send message" button
        driver.findElement(By.xpath("//button[text()='Send message']")).click();
           Thread.sleep(3000); 
           
        // Handle the alert
        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains("Thanks for the message!!"), "Alert text did not match expected value!");
        driver.switchTo().alert().accept();
  
    }
}