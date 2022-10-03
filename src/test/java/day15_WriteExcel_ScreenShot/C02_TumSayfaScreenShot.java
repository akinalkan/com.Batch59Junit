package day15_WriteExcel_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class C02_TumSayfaScreenShot extends TestBase {
    @Test
    public void tumSayfa() throws IOException {
        //amazon sayfasin agidip tum sayfanin fotografini cekin
        driver.get("https://amazon.com");

        TakesScreenshot ts = (TakesScreenshot) driver;

        LocalDateTime date = LocalDateTime.now();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMDDHHmmss");

        String tarih = date.format(dtf);

        File tumSayfaResim = new File("target/ekranGoruntuleri/tumSayfa" + tarih + ".jpeg");

        File geciciDosya = ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciDosya, tumSayfaResim);
    }
}
