package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SuccessfulLoginStepDefinitions {
    public static WebDriver getDriver() {
        return driver;
    }

    private static WebDriver driver;

    @Given("browser is open")
    public WebDriver browser_is_open() {
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project path is : "+projectPath);
        System.setProperty("webdriver.chrome.driver","src/test/resources/WebDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().window().maximize();
        try{
            driver.getWindowHandle();
            System.out.println("Step 1 - Browser is launched");
        }catch (Exception e){
            Assert.fail("browser not open");
        }
        return driver;
    }
    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver.get("https://sakshingp.github.io/assignment/login.html");
    }
    @When("user enters username and password")
    public void user_enters_username_and_password() {
        driver.findElement(By.id("username")).sendKeys("username");
        driver.findElement(By.id("password")).sendKeys("password");
    }
    @When("clicks login")
    public void clicks_login() {
        driver.findElement(By.id("log-in")).click();
    }
    @Then("user should be logged in")
    public void user_should_be_logged_in() {
        if(driver.getCurrentUrl().equalsIgnoreCase("https://sakshingp.github.io/assignment/home.html")){
            System.out.println("User is logged in successfully");
        }
        else
            Assert.fail("user not on login page or url doesn't match");
        driver.quit();
    }


}
