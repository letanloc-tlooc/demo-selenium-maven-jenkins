package basicweb;

import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentReport {

	public static void main(String[] args) {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("Spark.html");
		extent.attachReporter(spark);
		
		ExtentTest test1 = extent.createTest("Youtobe seartch","test youtobe");
		test1.log(Status.INFO, "Starting test case");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.youtube.com/");
		test1.pass("Navigated to youtobe.com");
		
		// Tìm kiếm hộp tìm kiếm và nhập từ khóa
        WebElement searchBox = driver.findElement(By.name("search_query"));
        test1.pass("Entered text in SearchBox");
        searchBox.sendKeys("Thầy giáo Ba");
        searchBox.submit();
        test1.pass("Pressed keyboard enter key");
        
        driver.quit();
        test1.pass("Closed the browser");
        test1.info("Test Completed");
        extent.flush();
	}

}
