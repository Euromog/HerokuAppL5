import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class InputTest extends baseTest {
    @Test
    public void inputTest() {
        final String URL = "http://the-internet.herokuapp.com/inputs";
        driver.get(URL);
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("2");
        input.sendKeys(Keys.ARROW_UP);
        assertEquals(input.getAttribute("value"), "3", "3 should be displayed after tapping Arrow_Up");
        input.sendKeys(Keys.ARROW_DOWN);
        assertEquals(input.getAttribute("value"), "2", "2 should be displayed after tapping Arrow_Down");
        input.sendKeys("tst");
        assertEquals(input.getAttribute("value"), "2", "2 should be displayed");
    }
}
