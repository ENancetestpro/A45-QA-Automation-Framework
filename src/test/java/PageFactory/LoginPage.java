package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(css = "input[type='email']")
     private WebElement emailField;
     @FindBy(css = "input[type='password']")
     private WebElement passwordField;
   @FindBy(css = "[type='submit']")
     private WebElement submitBtn;


    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    public LoginPage provideEmail(String email) {
      emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public  LoginPage clickSubmit() {
        submitBtn.click();
        return this;
    }

    public void login() {
        provideEmail("elliott.nance@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
    }
}


