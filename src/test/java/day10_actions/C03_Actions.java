package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C03_Actions extends TestBase {
    @Test
    public void test01() {
        // 1- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        // 2- cizili alan uzerine sag click yapalim
        Actions actions= new Actions(driver);
        WebElement ciziliAlan=driver.findElement(By.xpath("//div[@id='hot-spot']"));
        actions.contextClick(ciziliAlan).perform();
        // contextClick() sag click yapar  ****SAG CLICK****
        // 3- Alert'te cikan yazinin "You selected a context menu" oldugunu test edelim
        String alertYazi=driver.switchTo().alert().getText();
        String expectedYazi="You selected a context menu";
        Assert.assertEquals(expectedYazi,alertYazi);
        // 4- Tamam diyerek alert'i kapatalim
        driver.switchTo().alert().accept();
        // 5- Elemental Selenium linkine tiklayalim
        WebElement link=driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        actions.moveToElement(link).click().perform();
        List<String> windowList= new ArrayList<>(driver.getWindowHandles());
        // 6- Acilan sayfada h1 taginda "Elemental Selenium" yazdigini test edelim
        driver.switchTo().window(windowList.get(1));
        String elementYazi= driver.findElement(By.xpath("//h1[text()='Elemental Selenium']")).getText();
        String arananYazi="Elemental Selenium";
        Assert.assertTrue(elementYazi.contains(arananYazi));

    }
}
