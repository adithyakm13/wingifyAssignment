package StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NoUsernameAndPasswordStepDefinitions {
    private static WebDriver driver;
    SuccessfulLoginStepDefinitions sf;

    @When("user enters only nothing")
    public void user_enters_only_nothing() {
        sf = new SuccessfulLoginStepDefinitions();
        driver = sf.getDriver();

    }
    @Then("error message3 {string} should be displayed")
    public void error_message3_should_be_displayed(String string) {
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
