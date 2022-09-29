package day13_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {
    /*
    ● Bir class oluşturun : C02_WebTables
    ● login( ) metodun oluşturun ve oturum açın.
    ● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
    ○ Username : manager
    ○ Password : Manager1!
    ● table( ) metodu oluşturun
    ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
    ○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
    ● printRows( ) metodu oluşturun //tr
    ○ table body’sinde bulunan toplam satir(row) sayısını bulun.
    ○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
    ○ 4.satirdaki(row) elementleri konsolda yazdırın.
     */
    @Test
    public void test1() {
         /*
       tr ==> satir
       td ==> sutun
        */
        // ● login( ) metodun oluşturun ve oturum açın.
        // ● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        //○ Username : manager
        //○ Password : Manager1!
        girisYap();
        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody

        List<WebElement> sutunBasliklariSayisi = driver.
                findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("sutun sayisi = " + sutunBasliklariSayisi.size());
        //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement tumBody=driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());
        /*
        TUM BODY'İ BİR STRING OLARAK YAZDIRMAK ISTERSENIZ
        Body webElementini locate edip, getText() method'u ile yazdirabilirsiniz
         */
        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirlarListesi= driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir sayisi : "+satirlarListesi.size());
        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each:satirlarListesi) {

            System.out.println(each.getText());
        }
        //○ 4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> cellList= driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement each:cellList) {
            System.out.println(each.getText());
        }
        // Email basligindaki tum elementleri(sutun) konsolda yazdirin
        // once email basliginin kacinci sutunda oldugunu bulalim

        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        // bu list bize basliklarin listesini veriyor

        int emailSutunNo = 0;
        for (int i = 0; i < basliklarListesi.size(); i++) {
            if (basliklarListesi.get(i).getText().equals("Role")) { // email basligini bulup
                emailSutunNo = i; // sutun numarasini kaydettim
            }
        }
        List<WebElement> EmailSutunListesi =
                driver.findElements(By.xpath("//tbody//td[" + (emailSutunNo + 1) + "]"));
        // yukarda index num 0 dan basliyor ama
        // bizde 1 den baslamasi gerekiyor bu sebeple 1 artiriyoruz


    }

    public void girisYap() {


        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//*[text()='Log in']")).click();
        WebElement userName = driver.findElement(By.xpath("//input[@id='UserName']"));
        Actions actions = new Actions(driver);
        actions.click(userName).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();


    }
}
;
