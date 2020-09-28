import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class HoversTest {

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
    public void hovers1Test() {
        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);
        List<WebElement> elements = driver.findElements(By.className("figure"));
        actions.moveToElement(elements.get(0)).perform();
        assertEquals(driver.findElement(By.xpath("//*[@id='content']/div/div[1]/div/h5")).getText(), "name: user1", "name: user1 should be displayed");
        driver.findElement(By.linkText("View profile")).click();
        assertEquals(driver.findElement(By.xpath("//h1[text()='Not Found']")).getText(), "Not Found", "404 Not Found");
    }

    @Test
    public void hovers2Test() {
        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);
        List<WebElement> elements = driver.findElements(By.className("figure"));
        actions.moveToElement(elements.get(1)).perform();
        assertEquals(driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/h5")).getText(), "name: user2", "name: user1 should be displayed");
        driver.findElement(By.linkText("View profile")).click();
        assertEquals(driver.findElement(By.xpath("//h1[text()='Not Found']")).getText(), "Not Found", "404 Not Found");
    }

    @Test
    public void hovers3Test() {
        final String URL = "http://the-internet.herokuapp.com/hovers";
        driver.get(URL);
        Actions actions = new Actions(driver);
        List<WebElement> elements = driver.findElements(By.className("figure"));
        actions.moveToElement(elements.get(2)).perform();
        assertEquals(driver.findElement(By.xpath("//*[@id='content']/div/div[3]/div/h5")).getText(), "name: user3", "name: user1 should be displayed");
        driver.findElement(By.linkText("View profile")).click();
        assertEquals(driver.findElement(By.xpath("//h1[text()='Not Found']")).getText(), "Not Found", "404 Not Found");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
