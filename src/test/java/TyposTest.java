import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class TyposTest extends baseTest {
    @Test
    public void typosTest() {
        final String URL = "http://the-internet.herokuapp.com/typos";
        driver.get(URL);
        WebElement content = driver.findElement(By.id("content"));
        String text = "Typos\n" + "This example demonstrates a typo being introduced. It does it randomly on each page load.\n" + "Sometimes you'll see a typo, other times you won't.";
        String actualResult = content.getText();
        assertEquals(actualResult, text);
    }
}
