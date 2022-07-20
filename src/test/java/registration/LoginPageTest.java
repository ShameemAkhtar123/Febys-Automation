package registration;

import static org.junit.Assert.assertTrue;

import objectrepository.HomePage;
import objectrepository.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.BaseTest;

import java.io.IOException;


public class LoginPageTest extends BaseTest
{
    WebDriver driver;
    HomePage homePage;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test(priority = 1)
    public void login() throws InterruptedException {
        homePage = new HomePage(driver);

        LoginPage loginPage = homePage.clickOnProfileIcon();
        loginPage.enterEmailAddress("shameem.akhtar@synavos.com");
        loginPage.enterPassword("12345678");
        loginPage.clickOnLoginButton();
        Thread.sleep(2000);
        String homePageURL = driver.getCurrentUrl();
        Assert.assertEquals(homePageURL, "https://qa.febys.com/");
    }
}
