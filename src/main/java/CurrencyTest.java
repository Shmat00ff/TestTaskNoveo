import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class CurrencyTest {

    //Проверка на соответствие цены валют с ценой МОСБиржи.
    @Test (retryAnalyzer = Retry.class)
    public static void currencytest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            driver.get("https://www.moex.com/ru/issue/EUR_RUB__TOM/CETS");
            WebElement AcceptBt = driver.findElement(By.xpath("//div[@class='disclaimer__buttons'] //a [@role='button' and text()='Согласен']"));
            AcceptBt.click(); //Принятие условий МОСБиржы
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement expeur_element = driver.findElement(By.xpath("// ul [@class = 'mx-security-digest'] //li[@class='last'] //span"));
            WebElement difeur = driver.findElement(By.xpath("// ul [@class = 'mx-security-digest'] //li[@class='change'] //span"));
            String de = difeur.getText();
            String exp_eur = String.format("%.2f", Double.parseDouble(expeur_element.getText().replace(",", ".")));
            //Цена EUR на МОСБирже
            driver.get("https://www.moex.com/ru/issue/USD000UTSTOM/CETS");
            WebElement expusd_element = driver.findElement(By.xpath("// ul [@class = 'mx-security-digest'] //li[@class='last'] //span"));
            WebElement difusd = driver.findElement(By.xpath("// ul [@class = 'mx-security-digest'] //li[@class='change'] //span"));
            String du = difusd.getText();
            String exp_usd = String.format("%.2f", Double.parseDouble(expusd_element.getText().replace(",", ".")));
            //Цена USD на МОСБирже

            driver.get("https://ya.ru");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            WebElement eur_element = driver.findElement(By.cssSelector(".home-link2.informers3__stocks-item[title ='EUR MOEX']"));
            String act_eur = eur_element.getText();
            WebElement usd_element = driver.findElement(By.cssSelector(".home-link2.informers3__stocks-item[title ='USD MOEX']"));
            String act_usd = usd_element.getText();

            Assert.assertEquals(act_usd, "USD  " + exp_usd + "  " + du); //Сравнение значений элементов на странице яндекса с МОСБиржей
            Assert.assertEquals(act_eur, "EUR  " + exp_eur + "  " + de);

            System.out.println(act_usd + " <---> USD  " + exp_usd + "  " + du);
            System.out.println(act_eur + " <---> EUR  " + exp_eur + "  " + de);


        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }


    }

}
