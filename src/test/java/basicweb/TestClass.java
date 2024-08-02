// package basicweb;

// import org.openqa.selenium.By;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.firefox.FirefoxDriver;


// public class TestClass {

// 	public static void main(String[] args) {
// 		// TODO Auto-generated method stub
// 		WebDriver driver = new FirefoxDriver();
// 		try {
//             // Mở trang YouTube
//             driver.get("https://www.youtube.com/");

//             // Tìm kiếm hộp tìm kiếm và nhập từ khóa
//             WebElement searchBox = driver.findElement(By.name("search_query"));
//             searchBox.sendKeys("Thầy giáo Ba");
//             searchBox.submit();

//             // Chờ một chút để kết quả tìm kiếm xuất hiện
//             Thread.sleep(3000);

//             // Tìm kiếm kênh trong kết quả tìm kiếm (tùy thuộc vào cấu trúc trang web)
//             // Ví dụ: nhấp vào kết quả tìm kiếm đầu tiên
//             WebElement firstResult = driver.findElement(By.xpath("(//a[@id='video-title'])[1]"));
//             firstResult.click();

//             // Chờ thêm một chút để xem kết quả (có thể loại bỏ nếu không cần thiết)
//             Thread.sleep(5000);
//         } catch (InterruptedException e) {
//             e.printStackTrace();
//         } finally {
//             // Đóng trình duyệt
//             driver.quit();
//         }
// 	}

// }
package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileWriter;
import java.io.IOException;

public class TestClass {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        FileWriter htmlWriter = null;

        try {
            // Tạo file HTML báo cáo
            htmlWriter = new FileWriter("report.html");
            htmlWriter.write("<!DOCTYPE html>\n");
            htmlWriter.write("<html lang=\"en\">\n");
            htmlWriter.write("<head>\n");
            htmlWriter.write("    <meta charset=\"UTF-8\">\n");
            htmlWriter.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
            htmlWriter.write("    <title>Test Report</title>\n");
            htmlWriter.write("    <style>\n");
            htmlWriter.write("        body { font-family: Arial, sans-serif; margin: 20px; padding: 0; }\n");
            htmlWriter.write("        h1 { color: #333; }\n");
            htmlWriter.write("        ul { margin: 0; padding: 0; list-style-type: none; }\n");
            htmlWriter.write("        li { margin: 5px 0; }\n");
            htmlWriter.write("    </style>\n");
            htmlWriter.write("</head>\n");
            htmlWriter.write("<body>\n");
            htmlWriter.write("    <h1>Test Report</h1>\n");
            htmlWriter.write("    <ul>\n");

            // Mở trang YouTube
            driver.get("https://www.youtube.com/");
            htmlWriter.write("        <li>Opened YouTube</li>\n");

            // Tìm kiếm hộp tìm kiếm và nhập từ khóa
            WebElement searchBox = driver.findElement(By.name("search_query"));
            searchBox.sendKeys("Thầy giáo Ba");
            searchBox.submit();
            htmlWriter.write("        <li>Searched for 'Thầy giáo Ba'</li>\n");

            // Chờ một chút để kết quả tìm kiếm xuất hiện
            Thread.sleep(3000);

            // Tìm kiếm kênh trong kết quả tìm kiếm
            WebElement firstResult = driver.findElement(By.xpath("(//a[@id='video-title'])[1]"));
            firstResult.click();
            htmlWriter.write("        <li>Clicked on the first search result</li>\n");

            // Chờ thêm một chút để xem kết quả
            Thread.sleep(5000);

            // Đóng báo cáo HTML
            htmlWriter.write("    </ul>\n");
            htmlWriter.write("</body>\n");
            htmlWriter.write("</html>\n");

        } catch (InterruptedException e) {
            e.printStackTrace();
            try {
                if (htmlWriter != null) {
                    htmlWriter.write("        <li>Test interrupted</li>\n");
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Đóng trình duyệt
            driver.quit();
            if (htmlWriter != null) {
                try {
                    htmlWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
