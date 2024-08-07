package com.store.TestCases;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
public class PlaceOrderPage extends Baseclass {

	// Test case to verify placeorder functionality
    @Test
    public void placeOrder() throws InterruptedException, IOException 
    {
        // Add product to the cart
        driver.findElement(By.linkText("Laptops")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Sony vaio i5")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        
        //take screenshot
        takeScreenshot("placeorderpage");
        test.log(Status.PASS, "place orderpage").addScreenCaptureFromPath("Screenshots/placeorderpage.png");
        
        // Go to cart
        driver.findElement(By.linkText("Cart")).click();
        Thread.sleep(2000);
        // Place order
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
        Thread.sleep(2000);
        
        // Fill in order details
        driver.findElement(By.id("name")).sendKeys("admin");
        driver.findElement(By.id("country")).sendKeys("India");
        driver.findElement(By.id("city")).sendKeys("Hyderabad");
        driver.findElement(By.id("card")).sendKeys("1234567812345678");
        driver.findElement(By.id("month")).sendKeys("8");
        driver.findElement(By.id("year")).sendKeys("2024");
        
        // Confirm purchase
        driver.findElement(By.xpath("//button[text()='Purchase']")).click();
        Thread.sleep(2000);
        
        // Verify order confirmation
        WebElement confirmationMessage = driver.findElement(By.xpath("//h2[contains(text(), 'Thank you for your purchase!')]"));
        Assert.assertTrue(confirmationMessage.isDisplayed(), "Order confirmation message not displayed!");
        takeScreenshot("placeorderpage2");
        test.log(Status.PASS, "placeorder").addScreenCaptureFromPath("Screenshots/placeorderpage2.png");

        // Close the confirmation
        driver.findElement(By.xpath("//button[text()='OK']")).click();
    }
}