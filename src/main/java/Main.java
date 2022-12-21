import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\tool\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



            driver.get("https://ya.ru/");
            WebElement entryBut = driver.findElement(By.xpath("//div [@class='headline__personal'] //a [text()='Войти']"));
            entryBut.click();


            LoginTest lp = new LoginTest();
            lp.logintest(driver, "cb.asessor.new@yandex.ru", "asessor!"); //Positive LoginTest

        try {
            lp.unlog(driver);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }


}
