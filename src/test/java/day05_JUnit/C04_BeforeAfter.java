package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeAfter {
    WebDriver driver;

    @Before
    public void setUp() {
        System.out.println("before");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        System.out.println("After");
        driver.close();
    }

    @Test
    public void test01() {
        System.out.println("test1");
        driver.get("https://www.amazon.com");
    }
    @Test
    public void test02() {
        System.out.println("test2");
        driver.get("https://www.techproeducation.com");
    }
    @Test
    public void test03() {
        System.out.println("test3");
        driver.get("https://www.facebook.com");
    }

}
