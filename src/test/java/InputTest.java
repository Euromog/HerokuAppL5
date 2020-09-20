import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class InputTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        options.addArguments("ignore-popup-blocking");
        options.addArguments("ignore-certificate.errors");
        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.manage().window().fullscreen();
//        driver.manage().window().setSize(new Dimension(300,500));
//        driver.manage().window().setPosition(new Point(500, 200));
//        driver.manage().window().getSize();
//        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); //ожидание загрузки страницы
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  //таймаут для поиска элемента
        driver.manage().timeouts().setScriptTimeout(1, TimeUnit.DAYS); //ожидание загрузки скрипта

    }

    @Test
    public void inputTest(){
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("2");
        input.sendKeys(Keys.ARROW_UP);
        assertEquals(input.getAttribute("value"), "3", "3 is displayed");
        input.sendKeys(Keys.ARROW_DOWN);
        assertEquals(input.getAttribute("value"), "2", "2 is displayed");
        input.sendKeys("tst");
        assertEquals(input.getAttribute("value"), "2", "2 is displayed");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
