package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist{
    @Test
    public void test01() {
        System.out.println(System.getProperty("user.dir"));//C:\Selenium\com.Bacth59JUnit
        // bunlar dinamik
        // icinde oldugum projenin dosya yolunu(path) verir
        System.out.println(System.getProperty("user.home"));//C:\Users\allam
        // bu da dinamik
        // benim bilgisayarimin bana ozel kismini verir

        // Masa ustunuzdeki text dosyasinin varligini test edin
        String dosyaYolu="C:\\Users\\allam\\Desktop\\text.txt";
        String dosyaYolu2=System.getProperty("user.home")+ "\\Desktop\\text.txt";// bu kod dinamik oldu her pc de calisir
        System.out.println(dosyaYolu);//C:\Users\allam\Desktop\text.txt
        System.out.println(dosyaYolu2);//C:\Users\allam\Desktop\text.txt

        /*
        Bilgisayarimizdaki bir dosyanin varligini test etmemiz icin
        once o dosyaya ulasmamiz gerekir
        Java'da dosyaya erisim icin dosya yoluna (path) ihtiyac vardir
        Her bilgisayarin kullanici adi farkli olacagindan
        masaustu dosya yolu da birbirinden farkli olacaktir
        Testlerimizin tum bilgisayarlarda calismasi icin dosya yolunu DINAMIK yapmak zorundayiz
        Bunun icin her bilgisayarin birbirinden farkli olan yolunu bulmak icin;
        String farkliKisim =System.getProperty("user.home");

        herkesin bilgisayarinda ortak olan kisim ise ;
         String ortakKisim = "\\Desktop\\text.txt";

         String masaustuDosyaYolu = farkliKisim+ortakKisim;
         */
        String ortakKisim = "\\Desktop\\text.txt";
        String farkliKisim =System.getProperty("user.home");
        String masaustuDosyaYolu = farkliKisim+ortakKisim;

        Assert.assertTrue( Files.exists(Paths.get(masaustuDosyaYolu)));
        // bir dosyanin masaustunde var olup olmadigini kontrol eder

    }
}
