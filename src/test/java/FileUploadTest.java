import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class FileUploadTest extends baseTest {
    @Test
    public void fileUploadTest() {
        final String URL = "http://the-internet.herokuapp.com/upload";
        driver.get(URL);
        WebElement fileUploadButton = driver.findElement(By.id("file-upload"));
        File file = new File("src/test/resources/test.jpg");
        fileUploadButton.sendKeys(file.getAbsolutePath());
        assertEquals(fileUploadButton.getAttribute("value"), "C:\\fakepath\\test.jpg", "test.jpg should be uploaded");
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploaded-files")));
        String actualText = driver.findElement(By.id("uploaded-files")).getText();
        assertEquals(actualText, "test.jpg", "File name should be test.jpg");

    }
}
