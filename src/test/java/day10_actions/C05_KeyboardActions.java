package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://amazon.com");
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        // once arama kutusuna click yapip
        // sonra harh harf Nutella yazisini yazdiralim
        // sonra da ENTER tuwsuna basalim
        Actions actions = new Actions(driver);
        // once arama kutusuna click yapip
        actions.click(aramaKutusu)
                .keyDown(Keys.SHIFT)
                .sendKeys("n")
                .keyUp(Keys.SHIFT)
                .sendKeys("u")
                .sendKeys()
                .sendKeys("t")
                .sendKeys("e")
                .sendKeys("l")
                .sendKeys("l")
                .sendKeys("a")
                .sendKeys(Keys.ENTER)
                .perform();
        // keyDown() hangi tusunu girmek istiyorsam icine yaziyorum
        // keyUp() tıkladigim tustan elimi kaldiriyorum
        // SHIFT klavyede bu tusa basili yazinCa buyuk harf yaziyor bu sebeple bunu girdik
        Thread.sleep(3000);

    }
}
