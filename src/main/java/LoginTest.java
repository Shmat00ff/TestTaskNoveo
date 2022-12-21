import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver = new ChromeDriver();

    WebElement loginInput = driver.findElement(By.xpath(""));
    WebElement passInput = driver.findElement(By.xpath(""));
    WebElement loginButton = driver.findElement(By.xpath(""));

    @Test
    public void logintest(String login, String pass) {
        loginInput.sendKeys(login);
        passInput.sendKeys(pass);
        loginButton.click();




    }




}
