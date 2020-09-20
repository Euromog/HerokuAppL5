import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class CheckboxTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void checkboxTest(){
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        assertFalse(checkboxes.get(0).isSelected(), "Checkbox 1 should not be selected");
        checkboxes.get(0).click();
        assertTrue(checkboxes.get(0).isSelected(), "Checkbox 1 should be selected");
        assertTrue(checkboxes.get(1).isSelected(),"Checkbox 2 should be selected");
        checkboxes.get(1).click();
        assertFalse(checkboxes.get(1).isSelected(), "Checkbox 2 should not be selected");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit(); 
    }
}
