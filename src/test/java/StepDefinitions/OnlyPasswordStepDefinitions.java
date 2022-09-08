package StepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OnlyPasswordStepDefinitions {
    private static WebDriver driver;

    SuccessfulLoginStepDefinitions sf;
    @When("user enters only password")
    public void user_enters_only_password() {
        sf = new SuccessfulLoginStepDefinitions();
        driver = sf.getDriver();
        driver.findElement(By.id("password")).sendKeys("password");
    }
    @Then("error message2 {string} should be displayed")
    public void error_message2_should_be_displayed(String string) {
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
