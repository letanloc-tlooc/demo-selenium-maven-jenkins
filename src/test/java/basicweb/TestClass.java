package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestClass {

    private static ExtentReports extent;
    private static ExtentTest test;

    public static void main(String[] args) {
        // Khởi tạo ExtentReports
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // Tạo báo cáo cho mỗi bài kiểm tra
        test = extent.createTest("TestCase1");

        WebDriver driver = new FirefoxDriver();

        try {
            driver.get("https://www.youtube.com/");
            test.pass("Opened YouTube successfully.");

            WebElement searchBox = driver.findElement(By.name("search_query"));
            searchBox.sendKeys("Thầy giáo Ba");
            searchBox.submit();
            test.pass("Searched for 'Thầy giáo Ba'.");

            Thread.sleep(3000);

            WebElement firstResult = driver.findElement(By.xpath("(//a[@id='video-title'])[1]"));
            firstResult.click();
            test.pass("Clicked on the first search result.");

            Thread.sleep(5000);
        } catch (InterruptedException e) {
            test.fail("Test failed with exception: " + e.getMessage());
        } finally {
            driver.quit();
            extent.flush();  // Lưu báo cáo
        }
    }
}
