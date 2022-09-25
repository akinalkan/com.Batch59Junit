package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C03_WindowHandles {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test01() {
        // 1- "https://the-internet.herokuapp.com/windows" adresine gidin
        driver.get("https://the-internet.herokuapp.com/windows");
        // 2- Sayfadaki textin "Opening a new window" oldugunu dogrulayin
        String sayfadakiText = driver.findElement(By.xpath("//*[text()='Opening a new window']")).getText();
        String arananKelime = "Opening a new window";
        Assert.assertEquals(arananKelime, sayfadakiText);

        // 3- Sayfa basliginin(title) "The Internet" oldugunu dogrulayin
        String expectedTitle = "The Internet";
        String actulaTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actulaTitle);

        // 4- Click Here butonuna basin
        driver.findElement(By.linkText("Click Here")).click();
        List<String> windowList = new ArrayList<>(driver.getWindowHandles());//!!!Onemli bir adim isi kisaltir
        driver.switchTo().window(windowList.get(1));


        /*
         TODO ***
           switchTo().newWindow() demeden link tiklayarak yeni tab veya window olustugunda
          biz driver'a yeni sayfaya gec demedikce, driver eski sayfada kalir
          ve yeni sayfa ile ilgili hicbir islem yapamaz yeni sayfada driver'i calistirmak isterseniz
          once driver'i yeni sayfaya yollamalisiniz



        TODO ***
        Bir web sitesine gittigimizde bir webelementi tikladigimizda
        yeni bir sekme ya da pencere acilirsa
        bu yeni acilan sekmenin handle degerini bulabilmek
        icin driver.getWindowHandles() methodunu bir ArrayList'e
        atip butun sayfalarin listesine ulasabiliriz.
        Ilk actigim pencerenin index'i 0'dır,ikinci acilan sekmenin index'i 1'dir
        ve ikinci acilan pencere veya sekmede islem yapabilmek icin
        driver.switchTo().window(ListAdi.get(1)) methodu kullaniriz
        */


        // 5- Acilan yeni pencerenin sayfa basliginin (title) "New Window" oldugunu dogrulayin
        String expectedIkinciTitle = "New Window";
        String actualIkinciTitle = driver.getTitle();
        Assert.assertEquals(expectedIkinciTitle, actualIkinciTitle);
        // 6- Sayfadaki textin "New Window" oldugunu dogrulayin.
        WebElement text = driver.findElement(By.className("example"));
        String actualText = "New Window";
        Assert.assertTrue(text.getText().contains(actualText));
        // 7- Bir onceki pencereye geri dondukten donra sayfa basliginin "The Internet" oldugunu dogrulayin.
        driver.switchTo().window(windowList.get(0));
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
        /*
        NOT: String'lerden oluşan bir list oluşturup getWindowHandles() method'u ile
        açık bulunan tüm sayfaların / pencerelerin WindowHandle değerlerini o list'e atıyoruz.

        Daha sonra driver.switchTo().window() method'unun içine oluşturduğumuz list'ten
        hangi web sayfasını istiyorsak onun indeksini yazarak sayfalar arasında geçiş yapabiliyoruz.

        Yapı şu şekilde: driver.switchTo().window(listAdı.get(window'un indeks numarası))

        Örneğimizde windowList adındaki list'imizden 1. elementi getirdik.
        0 ilk sayfanın WindowHandle değerini, 1 ise ikinci sayfanın WindowHandle değerini verir.
         */

    }
}

