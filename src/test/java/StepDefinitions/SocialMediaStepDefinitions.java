package StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SocialMediaStepDefinitions {

    private static WebDriver driver;
    SuccessfulLoginStepDefinitions sf;

    @When("user clicks on twitter")
    public void user_clicks_on_twitter() {
        sf = new SuccessfulLoginStepDefinitions();
        driver = sf.getDriver();
        driver.findElement(By.xpath("/html/body/div/div/form/div[3]/div[2]/a[1]/img")).click();
        System.out.println("user clicks on twitter");
    }

    @Then("user should be taken to twitter page")
    public void user_should_be_taken_to_twitter_page() {
        if(driver.getCurrentUrl().contains("twitter"))
            System.out.println("User is taken to twitter page");
        else
            Assert.fail("User is not taken to twitter sign in page");
    }

    @When("user clicks on facebook")
    public void user_clicks_on_facebook() {
        driver.findElement(By.xpath("/html/body/div/div/form/div[3]/div[2]/a[2]/img")).click();
        System.out.println("user clicks on facebook");
    }
    @Then("user should be taken to facebook page")
    public void user_should_be_taken_to_facebook_page() {
        if(driver.getCurrentUrl().contains("facebook"))
            System.out.println("User is taken to facebook page");
        else
            Assert.fail("User is not taken to facebook sign in page");
    }

    @When("user clicks on linkedin")
    public void user_clicks_on_linkedin() {
        driver.findElement(By.xpath("/html/body/div/div/form/div[3]/div[2]/a[3]/img")).click();
        System.out.println("user clicks on linkedin");
    }
    @Then("user should be taken to linkedin page")
    public void user_should_be_taken_to_linkedin_page() {
        if(driver.getCurrentUrl().contains("linkedin"))
            System.out.println("User is taken to linkedin page");
        else {
            Assert.fail("User is not taken to linkedin sign in page");
        }
    }
}
