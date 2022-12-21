import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
            WebElement sitenoveo = driver.findElement(By.xpath("//li [@data-fast='1'] //div //div //div //a //b"));
            String site_act = sitenoveo.getText();

            Assert.assertEquals(site_act, "новео.рф");





        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
