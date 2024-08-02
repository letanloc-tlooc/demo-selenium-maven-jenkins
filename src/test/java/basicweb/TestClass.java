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
