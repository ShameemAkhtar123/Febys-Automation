package registration;

import lombok.extern.java.Log;
import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.BaseTest;
import resources.CommonMethods;


import java.io.IOException;

public class SignUpPageTest extends BaseTest {

    public WebDriver driver;
    HomePage homePage;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test(priority = 1)
    public void sign_up() throws InterruptedException {
        homePage = new HomePage(driver);

        LoginPage loginPage = homePage.clickOnProfileIcon();
        SignUpPage signUpPage = loginPage.clickOnSignUpLink();

        signUpPage.enterFirstName("Shameem");
        signUpPage.enterLastName("Akhtar");
        signUpPage.enterEmail(CommonMethods.generateRandomEmail());
        signUpPage.enterPassword("12345678");
        signUpPage.enterConfirmPassword("12345678");
        signUpPage.selectPhoneNumberCountry();
        signUpPage.enterPhoneNumber("03461254678");
        signUpPage.clickOnRegisterButton();
        Thread.sleep(2000);
        String homePageURL = driver.getCurrentUrl();
        Assert.assertEquals(homePageURL, "https://qa.febys.com/");
    }
}
