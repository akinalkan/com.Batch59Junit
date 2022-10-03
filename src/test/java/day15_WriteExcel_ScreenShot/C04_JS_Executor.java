package day15_WriteExcel_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JS_Executor extends TestBase {
    @Test
    public void JSExecutorTest() throws InterruptedException {
        //amazon'a gidelim
        driver.get("https://amazon.com");
        //asagidaki back to top  butonu gorununcuye kadar js ile scrool yapalim
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement backtoTopElementi= driver.findElement(By.xpath("//a[@id='navBackToTop']"));
        jse.executeScript("arguments[0].scrollIntoView(true);",backtoTopElementi);
        //back to top butonuna js ile clik yapalim
        Thread.sleep(3000);
        jse.executeScript("arguments[0].click()",backtoTopElementi);
        Thread.sleep(3000);




    }
}
