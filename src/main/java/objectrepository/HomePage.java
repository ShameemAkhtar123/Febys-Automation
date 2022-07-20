package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//img[@alt='profile-icon']")
    WebElement profileIcon;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickOnProfileIcon(){
        profileIcon.click();
        return new LoginPage(driver);
    }
}
