package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_handleWindows {
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
        driver.quit();
    }

    @Test
    public void test01() {
       // driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri=driver.getWindowHandle();
        //CDwindow-61E546C51B4637046018B46743DFAE9C

        /*
        bu kod acilan sayfanin uniqe hash kodudur
        Selenium sayfalar arasi geciste bu window hadle degerini kullaniriz
        eger sayfalar arasinda driver'imizi gezdiriyorsak ve herhangi bir sayfadan
        suanda bulundugumuz sayfaya gecmek istiyorsak
        driver.switchTo().window("CDwindow-61E546C51B4637046018B46743DFAE9C");
        bu sayfanin window handle degerini girerek bu sayfaya gecisi saglariz
         */
        // 1- Amazon ana sayfasina gidin
        driver.get("https://www.amazon.com");
        // 2- nutella icin arama yaptirin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        // 3- ilk urunun resmini tiklayarak farkli bir tab olarak acin
        WebElement ilkUrunResmi= driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB); // YENİ TABI ACİYORUZ AMA HENUZ NUTELLA BURDA CİKMAZ
       /*
       bu komutu kullandigimizda driver otomatik olrak olusturulan
        new Tab'a gecer
        yeni tab'da gorevi gerceklestirmek icin
        adimlari bastan almamiz gerekir
        */
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();
        // 4- yeni tab'da acilan urunun basligini yazdirin yazdirin
        String urunTitleElementi=driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        System.out.println(urunTitleElementi);
        // ilk sayfaya gecip URL'i yazdiralim
        driver.switchTo().window(ilkSayfaHandleDegeri); // ilk sayfaya geciyoruz
        System.out.println(driver.getCurrentUrl()); // URL'i yazdiriyoruz
    }
}
