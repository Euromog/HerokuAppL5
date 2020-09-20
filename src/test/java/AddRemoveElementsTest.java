import org.openqa.selenium.By;
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

public class AddRemoveElementsTest {

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
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        addButton.click();
        addButton.click();
        List<WebElement> deleteElement = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        deleteElement.get(0).click();
        assertEquals(driver.findElements(By.id("elements")).size(), 1, "1 Element should be displayed");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
