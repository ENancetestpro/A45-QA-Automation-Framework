import PageFactory.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests<WebDriverWait> extends BaseTest {

    @Test
    public void loginInvalidEmailValidPasswordTest(){
        // Pre-condition
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        LoginPage loginPage = new LoginPage(getDriver());
        String url = "https://qa.koel.app/";
        getDriver().get(url);


        // Steps
        WebElement emailField = getDriver().findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("invalid@class.com");

        WebElement passwordField = getDriver().findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");

        WebElement submit = getDriver().findElement(By.cssSelector("button[type='submit']"));
        submit.click();


        // Expected Result
        Assert.assertEquals(getDriver().getCurrentUrl(), url); //https://qa.koel.app/

        // Post-condition
        driver.quit();
    }


    @Test
    public void loginValidEmailPasswordTest(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

//        LoginPage loginPage = new LoginPage(getDriver());
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement emailField = getDriver().findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("elliott.nance@testpro.io");

        WebElement passwordField = getDriver().findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

//        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar")));
//        Assert.assertTrue(avatarIcon.isDisplayed());
        Assert.assertEquals(getDriver().getCurrentUrl(), url); //https://qa.koel.app/
        driver.quit();
    }

    @Test
    public void loginValidEmailEmptyPasswordTest() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        LoginPage loginPage = new LoginPage(getDriver());
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);

        WebElement emailField = getDriver().findElement(By.cssSelector("input[type='email']"));

        emailField.clear();
        emailField.sendKeys("elliott.nance@testpro.io");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));

        passwordField.clear();
        passwordField.sendKeys("");

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

        Assert.assertEquals(getDriver().getCurrentUrl(), url); //https://qa.koel.app/

        driver.quit();
    }
}
