package com.store.TestCases;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;

public class CartPage extends Baseclass 
{
	// Test case to verify add to cart functionality
    @Test
    public void testCartFunction() throws InterruptedException, IOException {
            // Add product to the cart
            driver.findElement(By.linkText("Laptops")).click();
            Thread.sleep(2000);
            driver.findElement(By.linkText("MacBook air")).click();
            Thread.sleep(2000);
            //click add to cart button
            driver.findElement(By.linkText("Add to cart")).click();
            Thread.sleep(2000);
            driver.switchTo().alert().accept();
            driver.findElement(By.xpath("//a[@id='cartur']")).click();
            
            //take Screenshot
            takeScreenshot("cartpage");
            test.log(Status.PASS, "Login successful").addScreenCaptureFromPath("Screenshots/cartpage.png");
            Thread.sleep(2000);
        }
}