package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions extends TestBase {
    @Test
    public void test01() {
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement tasinacakElement = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement hedefElement = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(tasinacakElement, hedefElement).perform();
        //***dragAndDrop() DOSYAYI HEDEFE TASIR***
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String actualYazi=driver.findElement(By.xpath("//*[text()='Dropped!']")).getText();
        String istenenYazi="Dropped!";
        Assert.assertEquals(actualYazi,istenenYazi);


    }
}
