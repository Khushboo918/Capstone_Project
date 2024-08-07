package com.store.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePage extends Baseclass {

    @Test
    public void testHomeFunction() throws InterruptedException {
        // Click on the "Home" button
        driver.findElement(By.partialLinkText("Home")).click();
        Thread.sleep(2000);

        // Verify that the homepage is displayed
        WebElement homeCarousel = driver.findElement(By.id("carouselExampleIndicators"));
        Assert.assertTrue(homeCarousel.isDisplayed(), "Homepage carousel is not displayed!");

        // Verify that the product categories are visible
        WebElement categories = driver.findElement(By.id("cat"));
        Assert.assertTrue(categories.isDisplayed(), "Product categories are not displayed!");

        // Verify that the list of products is visible
        WebElement products = driver.findElement(By.id("tbodyid"));
        Assert.assertTrue(products.isDisplayed(), "List of products is not displayed!");
    }
}