import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void dropdownTest() {
        final String URL = "http://the-internet.herokuapp.com/dropdown";
        driver.get(URL);
        Select select = new Select(driver.findElement(By.id("dropdown")));
        assertEquals(select.getOptions().size(), 3, "Should be 3 options");
        select.selectByValue("1");
        assertTrue(select.getFirstSelectedOption().isSelected(), "Option 1 is selected");
        select.selectByValue("2");
        assertTrue(select.getFirstSelectedOption().isSelected(), "Option 2 is selected");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
