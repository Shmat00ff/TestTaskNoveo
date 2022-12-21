import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class WheatherTest {

    @Test
    public static void wheathertest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("https://ya.ru");
            String window1 = driver.getWindowHandle();
            WebElement tempact = driver.findElement(By.xpath("//a [@class='home-link2 informers3__item informers3__weather home-link2_color_inherit home-link2_hover_red']"));
            String acttemp = tempact.getText();
            tempact.click();
            Set<String> currentWindows = driver.getWindowHandles();
            String window2 = null;
            for (String window : currentWindows){
                if (!window.equals(window1)){
                    window2 = window;
                    break;
                }
            }
            driver.switchTo().window(window2);
            WebElement tempexp = driver.findElement(By.xpath("//div [@class='temp fact__temp fact__temp_size_s'] //span [@class='temp__value temp__value_with-unit']"));
            String exptemp = tempexp.getText();
            driver.close();
            driver.switchTo().window(window1);

            Assert.assertEquals(acttemp, exptemp + "°");


        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
