package day12_SeleniumWaits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {
    // 1. Bir class olusturun : WaitTest
    // 2. Iki tane metod olusturun : implicitWait() , explicitWait()
    // Iki metod icin de asagidaki adimlari test edin.
    @Test
    public void implicitlyWaitTesti() {
        // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneYaziElementi = driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());
        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        // 7. It’s back mesajinin gorundugunu test edin
        WebElement itsBackYazisi = driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBackYazisi.isDisplayed());
    }

    @Test
    public void explicitlyWaitTesti() {

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        // explicitWait İCİN ONCE WAIT OBJESİ OLUSTURULUR
         /*
        WebElement itsGoneYaziElementi=driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
                                                // GORUNUR OLMASINI ISTEDIGIMIZ ELEMENTI LOCATE ETTIK
        wait.until(ExpectedConditions.visibilityOf(itsGoneYaziElementi));
                                                // GORUNUR OLMASINI BEKLEDIGIMIZ ELEMENTI BEKLE
        Assert.assertTrue(itsGoneYaziElementi.isDisplayed());
                                                // GORUNUR OLDUGUNU TEST ET

           YAZİNİN gorunur olmasini beklerken yazinin locate'ini kullanmak sorun olusturur
           cunku henuz gorunmeyen bir yazinin locate edilmesi de mumkun olmayabilir
           (HTML kodlari yazan developer farkli uygulamalar yapabilir)
           Bu durumda bekle islemi ve locate'i birlikte yapmaliyiz
          */
        WebElement itsGoneYaziElementi = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //7. It’s back mesajinin gorundugunu test edin
        WebElement istBackYaziElementi = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));
        // .until BEKLE DEMEK
        Assert.assertTrue(istBackYaziElementi.isDisplayed());

    }
}
