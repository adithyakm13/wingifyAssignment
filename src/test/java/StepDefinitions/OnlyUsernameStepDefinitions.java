package StepDefinitions;

import io.cucumber.java.an.E;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OnlyUsernameStepDefinitions {
    private static WebDriver driver;
    SuccessfulLoginStepDefinitions sf;
    private String error_message_not_displayed;

    @When("user enters only username")
    public void user_enters_only_username() {
        sf = new SuccessfulLoginStepDefinitions();
        driver = sf.getDriver();
        driver.findElement(By.id("username")).sendKeys("username");
        System.out.println("user enters only username");
    }

    @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String string) {
        WebElement alert = driver.findElement(By.xpath("//*[@role = 'alert'][2]"));
        if (string.equalsIgnoreCase(alert.getText()))
            System.out.println(alert.getText() + " is displayed");
        else
        {
            System.out.println(alert.getText());
            System.out.println(string);
            Assert.fail(string + "is not displayed");}
        driver.quit();


    }

}
