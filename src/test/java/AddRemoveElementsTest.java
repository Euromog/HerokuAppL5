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

import static org.testng.Assert.assertEquals;

public class AddRemoveElementsTest extends baseTest {
    @Test
    public void addRemoveElementsTest() {
        final String URL = "http://the-internet.herokuapp.com/add_remove_elements/";
        driver.get(URL);
        WebElement addButton = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        addButton.click();
        addButton.click();
        List<WebElement> deleteElement = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        deleteElement.get(0).click();
        assertEquals(driver.findElements(By.id("elements")).size(), 1, "1 Element should be displayed");
    }
}
