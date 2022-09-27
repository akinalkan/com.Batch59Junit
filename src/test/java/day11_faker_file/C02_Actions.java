package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {
    @Test
    public void test01() {
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        //3- video’yu gorecek kadar asagi inin ( bunun icin actions a ihtiyacimiz var bunu 3 asamada olusturuyorduk)
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        //4- videoyu izlemek icin Play tusuna basin
        WebElement frame= driver.findElement(By.xpath("//*[@src=\"https://www.youtube.com/embed/owsfdh4gxyc\"]"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//*[@class=\"ytp-large-play-button ytp-button ytp-large-play-button-red-bg\"]")).click();
        //5- videoyu calistirdiginizi test edin
        WebElement pauseButton= driver.findElement(By.xpath("//*[@title='Pause (k)']"));
        Assert.assertTrue(pauseButton.isDisplayed());
    }
}
