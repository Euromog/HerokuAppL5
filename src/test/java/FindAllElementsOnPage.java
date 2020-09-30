import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class FindAllElementsOnPage extends baseTest {
    @Test
    public void formShouldBeSubmitted() {
       final String URL = "file:///Users/euromog/IdeaProjects/HerokuAppL5%202/src/test/resources/htmlPage.html";
        driver.get(URL);
        WebElement fNameInput = driver.findElement(By.id("fname"));
        fNameInput.sendKeys("Evgeniy");
        assertEquals(fNameInput.getAttribute("value"), "Evgeniy", "First name should be Evgeniy");

        WebElement lNameInput = driver.findElement(By.id("lname"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('value', 'Makuta');", lNameInput);
        assertEquals(lNameInput.getAttribute("value"), "Makuta", "Family name should be Makuta");

        WebElement phoneInput = driver.findElement(By.name("phone"));
        phoneInput.sendKeys("2912345");
        assertEquals(phoneInput.getAttribute("value"), "2912345", "Phone number should be 2912345");

        WebElement maleGenderSelect = driver.findElement(By.cssSelector("#male"));
        maleGenderSelect.click();
        assertTrue(maleGenderSelect.isSelected(), "Male Gender should be selected");

        WebElement femaleGenderSelect = driver.findElement(By.xpath("//input[@id='female']"));
        femaleGenderSelect.click();
        assertTrue(femaleGenderSelect.isSelected(), "Female Gender should be selected");
        assertFalse(maleGenderSelect.isSelected(), "Male Gender should not be selected");

        List<WebElement> marriedCheckbox = driver.findElements(By.id("isMarried"));
        assertFalse(marriedCheckbox.get(0).isSelected(), "Married checkbox should not be selected");
        marriedCheckbox.get(0).click();
        assertTrue(marriedCheckbox.get(0).isSelected(), "Married checkbox should be selected");

        WebElement newsDropDown = driver.findElement(By.id("news"));
        Select select = new Select(newsDropDown);
        assertEquals(select.getOptions().size(), 5, "How do you know about us dropdown should select 5 options");
        select.selectByValue("friends");
        assertEquals(select.getFirstSelectedOption().getAttribute("value"), "friends", "Friends option should be selected");

        WebElement submitButton = driver.findElement(By.cssSelector("#submit"));
        submitButton.submit();
        WebElement fNameCheckAfterSumbit = driver.findElement(By.id("fname"));
        assertEquals(fNameCheckAfterSumbit.getAttribute("value"), "", "First name field should be empty after submitting");

        WebElement bugLink = driver.findElement(By.id("bugLink"));
        bugLink.click();
        WebElement pic = driver.findElement(By.cssSelector("[data-delta='4']"));
        assertTrue(pic.isDisplayed(), "Bug picture should be displayed");
    }
}
