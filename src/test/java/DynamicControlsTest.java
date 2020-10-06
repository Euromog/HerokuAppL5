import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DynamicControlsTest extends baseTest {
    @Test
    public void checkDynamicControls() {
        final String URL = "http://the-internet.herokuapp.com/dynamic_controls";
        driver.get(URL);
        By checkbox = By.cssSelector("input[type='checkbox']");
        WebElement checkboxElement = driver.findElement(checkbox);
        checkboxElement.click();
        WebElement removeButton = driver.findElement(By.cssSelector("[onclick='swapCheckbox()']"));
        removeButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBe(By.id("message"), "It's gone!"));

        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        assertTrue(driver.findElements(checkbox).isEmpty(), "Checkbox should not be displayed");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement input = driver.findElement(By.cssSelector("input[type='text']"));
        assertFalse(input.isEnabled(), "Input should be disabled");
        WebElement enableButton = driver.findElement(By.cssSelector("[onclick='swapInput()']"));
        enableButton.click();
        wait.until(ExpectedConditions.textToBe(By.id("message"), "It's enabled!"));
        assertTrue(input.isEnabled(), "Input should be disabled");
    }
}
