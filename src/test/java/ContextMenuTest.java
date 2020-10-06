import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTest extends baseTest{
    @Test
    public void checkAlertMessage() {
        final String URL = "http://the-internet.herokuapp.com/context_menu";
        driver.get(URL);
        Actions actions = new Actions(driver);
        WebElement squareElementLocator = driver.findElement(By.id("hot-spot"));
        actions.contextClick(squareElementLocator).perform();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.getText();
        assertEquals(alert.getText(), "You selected a context menu", "Alert with message You selected a context menu should be displayed");
        alert.accept();
    }
}
