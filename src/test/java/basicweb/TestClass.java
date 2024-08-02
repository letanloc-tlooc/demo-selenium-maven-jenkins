package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new FirefoxDriver();
		try {
            // Mở trang YouTube
            driver.get("https://www.youtube.com/");

            // Tìm kiếm hộp tìm kiếm và nhập từ khóa
            WebElement searchBox = driver.findElement(By.name("search_query"));
            searchBox.sendKeys("Thầy giáo Ba");
            searchBox.submit();

            // Chờ một chút để kết quả tìm kiếm xuất hiện
            Thread.sleep(3000);

            // Tìm kiếm kênh trong kết quả tìm kiếm (tùy thuộc vào cấu trúc trang web)
            // Ví dụ: nhấp vào kết quả tìm kiếm đầu tiên
            WebElement firstResult = driver.findElement(By.xpath("(//a[@id='video-title'])[1]"));
            firstResult.click();

            // Chờ thêm một chút để xem kết quả (có thể loại bỏ nếu không cần thiết)
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Đóng trình duyệt
            driver.quit();
        }
	}

}
// package basicweb;

// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.FileReader;
// import java.io.FileWriter;
// import java.io.IOException;

// public class TestClass {

//     private static final String REPORT_FILE = "report.html";

//     public static void main(String[] args) {
//         WebDriver driver = new FirefoxDriver();
//         String reportContent = readFile(REPORT_FILE);
//         StringBuilder updatedContent = new StringBuilder(reportContent);

//         try {
//             // Thực hiện các bước kiểm tra
//             driver.get("https://www.youtube.com/");
//             updatedContent.append("<li>Opened YouTube</li>\n");

//             WebElement searchBox = driver.findElement(By.name("search_query"));
//             searchBox.sendKeys("Thầy giáo Ba");
//             searchBox.submit();
//             updatedContent.append("<li>Searched for 'Thầy giáo Ba'</li>\n");

//             Thread.sleep(3000);

//             WebElement firstResult = driver.findElement(By.xpath("(//a[@id='video-title'])[1]"));
//             firstResult.click();
//             updatedContent.append("<li>Clicked on the first search result</li>\n");

//             Thread.sleep(5000);

//             updatedContent.append("<p id=\"test-status\">Test completed successfully!</p>\n");

//         } catch (InterruptedException e) {
//             e.printStackTrace();
//             updatedContent.append("<li>Test interrupted</li>\n");
//             updatedContent.append("<p id=\"test-status\">Test failed due to interruption!</p>\n");
//         } catch (Exception e) {
//             e.printStackTrace();
//             updatedContent.append("<li>Test failed with error: " + e.getMessage() + "</li>\n");
//             updatedContent.append("<p id=\"test-status\">Test failed!</p>\n");
//         } finally {
//             // Đóng trình duyệt
//             driver.quit();

//             // Cập nhật tệp báo cáo HTML
//             writeFile(REPORT_FILE, updatedContent.toString());
//         }
//     }

//     private static String readFile(String fileName) {
//         StringBuilder content = new StringBuilder();
//         try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
//             String line;
//             while ((line = br.readLine()) != null) {
//                 content.append(line).append("\n");
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//         return content.toString();
//     }

//     private static void writeFile(String fileName, String content) {
//         try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
//             bw.write(content);
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
// }

