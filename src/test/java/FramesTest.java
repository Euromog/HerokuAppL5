import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FramesTest extends baseTest {
    @Test
    public void iframeTest() {
        final String URL = "http://the-internet.herokuapp.com/frames";
        driver.get(URL);
        WebElement iframeLink = driver.findElement(By.xpath("//*[contains(text(), 'iFrame')]"));
        iframeLink.click();
        WebElement iFrame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrame);
        WebElement iframeText = driver.findElement(By.id("tinymce"));
        assertEquals( iframeText.getText(), "Your content goes here.", "Your content goes here. text should be displayed inside frame");
    }
}
