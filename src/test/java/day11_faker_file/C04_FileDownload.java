package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    // 1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
    // 2. https://the-internet.herokuapp.com/download adresine gidelim.
    // 3. dummy.txt dosyasını indirelim
    // 4. Dosyanın başarıyla indirilip indirilmediğini test edelim

    @Test
    public void test01() {
        // 2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        // 3. dummy.txt dosyasını indirelim
       WebElement textLinki=driver.findElement(By.xpath("//*[text()='test.txt']"));
       textLinki.click();
        // 4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        // DOSYA DOWLOANDS'A indirilecektir, bize downloads'un dosya yolu lazim
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Desktop\\text.txt";
        String arananKisim=farkliKisim+ortakKisim;
        System.out.println(arananKisim);
        System.out.println(farkliKisim);
        System.out.println(ortakKisim);

        //geriye o dosya yolundaki dosyanin var oldugunu assert edelim
        Assert.assertTrue(Files.exists(Paths.get(arananKisim)));


    }
}
