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

public class NotificationMessageTest {

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
    public void notificationMessageTest(){
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        driver.findElement(By.linkText("Click here")).click();
        assertEquals(driver.findElement(By.xpath("//div[@class='flash notice']")).getText(), "Action unsuccesful, please try again\n×");
        driver.findElement(By.linkText("Click here")).click();
        assertEquals(driver.findElement(By.xpath("//div[@class='flash notice']")).getText(), "Action successful\n×");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit(); 
    }
}
