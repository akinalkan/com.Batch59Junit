package day05_JUnit;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://zero.webappsecurity.com");
        driver.findElement(By.id("signin_button")).click();
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.xpath("//*[@name='submit']")).click();
        driver.navigate().back();
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();
        driver.findElement(By.xpath("//*[@id='sp_amount']")).sendKeys("1000");
        driver.findElement(By.xpath("//*[@id='sp_date']")).sendKeys("2020-09-10");
        driver.findElement(By.id("pay_saved_payees")).click();
        WebElement yazi=driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
        yazi.isDisplayed();
        driver.close();




    }
}
