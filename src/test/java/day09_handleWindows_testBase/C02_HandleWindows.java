package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleWindows {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        //driver.quit();
    }
    // 1- amazon anasayfaya gidelim
    // 2- url'in amazon icerdigini test edelim
    // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
    // 4- title'in Best Buy icerdigini test edelim
    // 5- ilksayfaya donup sayfada java aratalim
    // 6- arama sonuclarinin Java icerdigini test edelim
    // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
    // 8- logonun gorundugunu test edelim

    @Test
    public void test01() throws InterruptedException {
        // 1- amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        String amazonWindowHandle=driver.getWindowHandle();
        // 2- url'in amazon icerdigini test edelim
        String istenenKelime="amazon";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(istenenKelime));
        // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyWindowHandle=driver.getWindowHandle();
        // 4- title'in Best Buy icerdigini test edelim
        String arananTitleKelime="Best Buy";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(arananTitleKelime));
        // 5- ilksayfaya donup sayfada java aratalim
        driver.switchTo().window(amazonWindowHandle); // todo ilk sayfaya donuyoruz
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);
        // 6- arama sonuclarinin Java icerdigini test edelim
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYaziStr=sonucYaziElementi.getText();
        String aradigimizKelime="Java";;
        Assert.assertTrue(sonucYaziStr.contains(aradigimizKelime));
        // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
        driver.switchTo().window(bestBuyWindowHandle);
        // 8- logonun gorundugunu test edelim
        WebElement logoElementi=driver.findElement(By.xpath("//img[@class='logo'][1]"));
        Assert.assertTrue(logoElementi.isDisplayed());



    }
}
