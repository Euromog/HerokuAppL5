import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class SortableDataTablesTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        options.addArguments("ignore-popup-blocking");
        options.addArguments("ignore-certificate.errors");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    @Test
    public void inputTest(){
        driver.get("http://the-internet.herokuapp.com/tables");
        WebElement table1 = driver.findElement(By.xpath("//table[1]"));
        WebElement table1Row1 = table1.findElement(By.xpath("//tr[1]"));
        assertEquals(table1Row1.findElement(By.xpath("//td[1]")).getText(), "Smith", "Last name should be Smith");
        assertEquals(table1Row1.findElement(By.xpath("//td[2]")).getText(), "John", "First name should be John");
        assertEquals(table1Row1.findElement(By.xpath("//td[3]")).getText(), "jsmith@gmail.com", "Email should be jsmith@gmail.com");
        assertEquals(table1Row1.findElement(By.xpath("//td[4]")).getText(), "$50.00", "Due should be $50.00");
        assertEquals(table1Row1.findElement(By.xpath("//td[5]")).getText(), "http://www.jsmith.com", "Web site should be http://www.jsmith.com");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
