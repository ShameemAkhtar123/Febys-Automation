package objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import resources.CommonMethods;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Sign up')]")
    WebElement signUpLink;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SignUpPage clickOnSignUpLink() throws InterruptedException {
        CommonMethods.waitForElement(driver, signUpLink);
        signUpLink.click();
        return new SignUpPage(driver);
    }

    public void enterEmailAddress(String email){
        this.email.sendKeys(email);
    }

    public void enterPassword(String password){
        this.password.sendKeys(password);
    }

    public void clickOnLoginButton(){
        loginButton.click();
    }
}
