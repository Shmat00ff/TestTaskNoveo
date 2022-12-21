import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest {

    @Test(retryAnalyzer = Retry.class)
    public void logintest(WebDriver driver, String login, String pass) {
        try {

            WebElement loginInput = driver.findElement(By.id("passp-field-login"));
            loginInput.sendKeys(login, Keys.ENTER);
            WebElement passInput = driver.findElement(By.xpath("//input [@name='passwd']"));
            passInput.sendKeys(pass);
            WebElement loginButton = driver.findElement(By.xpath("//button [@id = 'passp:sign-in']"));
            loginButton.click();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public void unlog(WebDriver driver) {
        try {
            WebElement passicon = driver.findElement(By.xpath("//span [@class='avatar__image-wrapper']"));
            passicon.click();
            WebElement exitbutt = driver.findElement(By.xpath("//a [@class='home-link2 usermenu-redesign__item usermenu-redesign__exit ']"));
            exitbutt.click();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}