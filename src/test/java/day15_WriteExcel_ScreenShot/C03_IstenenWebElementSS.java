package day15_WriteExcel_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_IstenenWebElementSS extends TestBase {
    @Test
    public void webElementSS() throws IOException {
        //amazona gidip Nutella aratalim
        //ve sonuc sayisinin oldugu web elementin fotografini cekelim
        driver.get("https://amazon.com");
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        WebElement sonucYaziElementi= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));//1.adim

        File sonucYaziElementSS=new File("target/ekranGoruntuleri/sonucYazisiSS.jpeg");//2.adim

        File temp=sonucYaziElementi.getScreenshotAs(OutputType.FILE);//3.adim

        FileUtils.copyFile(temp,sonucYaziElementSS);//4.adim






    }
}
