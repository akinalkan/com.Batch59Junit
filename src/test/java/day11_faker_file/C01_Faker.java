package day11_faker_file;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {
    /*
    FAKER KUTUPHANESİNİ pop.xml E EKLEDIK
    BU KUTUPHANE YAPACAGIMIZ TESTLERDE
    DOLDURMAK ISTEDIGIMIZ ALANLARA RASTGELE ISIM,
    MAIL,PASSWORD VB BILGILER URETIP DOLDURUYOR
     */

    @Test
    public void test01() {
        // facebook anasayfaya gidip
        // yeni kayit olustur butonuna basin
        // isim kutusunu locate edip,
        // geriye kalan alanlari TAB ile dolasarak
        // formu doldurun
        driver.get("https:///facebook.com");
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement isimKutusu= driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        Actions actions= new Actions(driver);
        Faker faker = new Faker();

        actions.click(isimKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.NUMPAD1)
                .sendKeys(Keys.TAB)
                .sendKeys("Sep")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)//ASAGİ OKLA ERKEK SECİMİ YAPABİLDİK
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
    }
}
