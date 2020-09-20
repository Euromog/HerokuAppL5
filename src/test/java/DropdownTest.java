import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class DropdownTest {

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
    public void dropdownTest(){
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select select= new Select(driver.findElement(By.id("dropdown")));
        assertEquals(select.getOptions().size(), 3, "Should be 3 options");
        select.selectByValue("1");
        assertTrue(select.getFirstSelectedOption().isSelected(), "Option 1 is selected" );
        select.selectByValue("2");
        assertTrue(select.getFirstSelectedOption().isSelected(), "Option 2 is selected" );


//        select.selectByVisibleText("Option 1");
//        assertEquals(select.getFirstSelectedOption().getText(), "Option 1");



    }

    @AfterMethod
    public void tearDown(){
        driver.quit(); 
    }
}
