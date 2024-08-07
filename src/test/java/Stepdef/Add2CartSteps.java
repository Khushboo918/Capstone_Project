package Stepdef;


import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Add2CartSteps {
    private WebDriver driver;

    @Given("I am on the Demoblaze homepage")
    public void iAmOnTheDemoblazeHomepage() {
        // Set up WebDriver and navigate to the homepage
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Given("I Select the the laptop category")
    public void i_select_the_the_laptop_category() throws InterruptedException {
    	driver.findElement(By.linkText("Laptops")).click();
        Thread.sleep(2000);
    }
    
    @Then("select click on any laptop related item")
    public void select_click_on_any_laptop_related_item() throws InterruptedException {
    	driver.findElement(By.linkText("MacBook air")).click();
        Thread.sleep(2000);
    }

    @When("I click on the {string} button")
    public void iClickOnTheButton(String buttonText) throws InterruptedException {
        // Locate and click on the "Add to cart" button
    	driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(2000);
    }

    @When("I click on the {string} button in the alert dialog")
    public void iClickOnTheButtonInTheAlertDialog(String buttonText) throws InterruptedException {
        // Wait for the alert to appear and click "OK"
    	driver.switchTo().alert().accept();
        Thread.sleep(2000);
    }

    @Then("I click on the cart icon")
    public void iClickOnTheCartIcon() throws InterruptedException {
        // Click on the cart icon to view the cart
    	driver.findElement(By.linkText("Cart")).click();
        Thread.sleep(3000);
    }

    @Then("I should see my selected item in the cart")
    public void iShouldSeeMySelectedItemInTheCart() {
        // Check if the selected item appears in the cart
        WebElement cartItem = driver.findElement(By.id("page-wrapper"));
        assertTrue(cartItem.isDisplayed());
    }

    // Close the browser after each scenario
    @After
    public void tearDown() {
        driver.quit();
    }
}