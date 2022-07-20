package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {
    WebDriver driver;

    @FindBy(name = "firstName")
    WebElement firstName;

    @FindBy(name = "lastName")
    WebElement lastName;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(name = "confirmPassword")
    WebElement confirmPassword;

    @FindBy(name = "PhoneNumberCountry")
    WebElement PhoneNumberCountry;

    @FindBy(name = "PhoneNumber")
    WebElement phoneNumber;


    @FindBy(xpath = "//span[contains(text(),'Register now')]")
    WebElement submit;

    public SignUpPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String fName){
        firstName.sendKeys(fName);
    }

    public void enterLastName(String lName){
        lastName.sendKeys(lName);
    }

    public void enterEmail(String email){
        this.email.sendKeys(email);
    }

    public void enterPassword(String password){
        this.password.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword){
        this.confirmPassword.sendKeys(confirmPassword);
    }

    public void selectPhoneNumberCountry() throws InterruptedException {
        PhoneNumberCountry.click();
        Thread.sleep(1000);
        Select select = new Select(PhoneNumberCountry);
        select.selectByValue("PK");
    }

    public void enterPhoneNumber(String phoneNumber){
        this.phoneNumber.sendKeys(phoneNumber);
    }

    public void clickOnRegisterButton() throws InterruptedException {
        Thread.sleep(20000);
        submit.click();
    }

}
