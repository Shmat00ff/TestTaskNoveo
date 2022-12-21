import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class SearchTest {

    @Test
    public static void searchtest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("https://ya.ru/");
            WebElement searchInput = driver.findElement(By.xpath("//input [@class='search3__input mini-suggest__input']"));
            searchInput.sendKeys("Новео", Keys.ENTER);




        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
