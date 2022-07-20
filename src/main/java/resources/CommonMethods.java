package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class CommonMethods {
    WebDriver driver;

    public static String generateRandomEmail() {
        String name = RandomStringUtils.randomAlphabetic(9);
        String domain = RandomStringUtils.randomAlphabetic(6);
        String randomWords = RandomStringUtils.randomAlphanumeric(5);
        return name + randomWords + "@" + domain + ".com";
    }

    public static String getScreenshotPath(String methodName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "\\reports\\" + methodName + ".png";
        FileUtils.copyFile(source, new File(destinationFile));
        return destinationFile;
    }

    static ExtentReports extent;
    public static ExtentReports getReportObject()
    {
        String pathOfReport = System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(pathOfReport);
        reporter.config().setReportName("Febys Automation");
        reporter.config().setDocumentTitle("Test Result");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Shameem Akhtar");
        return extent;
    }

    public static void waitForElement(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
