package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmountSortingStepDefinitions {
    private static WebDriver driver;
    SuccessfulLoginStepDefinitions sf;
    @Given("user is logged in")
    public void user_is_logged_in() {
        sf = new SuccessfulLoginStepDefinitions();
        driver = sf.getDriver();
        driver.get("https://sakshingp.github.io/assignment/home.html");
        if(driver.getCurrentUrl().equalsIgnoreCase("https://sakshingp.github.io/assignment/home.html"))
            System.out.println("User is logged in");
        else
            Assert.fail("User is not logged in");
    }
    @When("amount is clicked it is sorted")
    public void amount_is_clicked_it_is_sorted() throws InterruptedException {
        driver.findElement(By.id("amount")).click();
        System.out.println("user clicks amount");
        Thread.sleep(2000);
        driver.quit();
    }
}
