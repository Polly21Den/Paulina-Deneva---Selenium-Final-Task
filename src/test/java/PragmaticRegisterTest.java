import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PragmaticRegisterTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://shop.pragmatic.bg/");
    }

    @Test
    public void registerTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accountDropdownMenu = driver.findElement(By.cssSelector(".dropdown .hidden-xs.hidden-sm.hidden-md"));
        accountDropdownMenu.click();
        WebElement registerOption = driver.findElement(By.cssSelector(".dropdown-menu.dropdown-menu-right a"));
        registerOption.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-firstname")));
        WebElement firstNameInputField = driver.findElement(By.id("input-firstname"));
        firstNameInputField.sendKeys("Paulina");
        WebElement lastNameInputField = driver.findElement(By.id("input-lastname"));
        lastNameInputField.sendKeys("Deneva");
        WebElement emailInputField = driver.findElement(By.id("input-email"));
        String prefix = RandomStringUtils.randomAlphabetic(10);
        String sufix = RandomStringUtils.randomAlphabetic(5);
        String emailAddress = sufix + "@" + prefix + ".com";
        emailInputField.sendKeys(emailAddress);
        WebElement telephoneInputField = driver.findElement(By.id("input-telephone"));
        String lastDigits = RandomStringUtils.randomNumeric(8);
        String telephoneNumber = "08" + lastDigits;
        telephoneInputField.sendKeys(telephoneNumber);
        WebElement passwordInputField = driver.findElement(By.id("input-password"));
        passwordInputField.sendKeys("parola123!");
        WebElement passwordConfirmationInputField = driver.findElement(By.id("input-confirm"));
        passwordConfirmationInputField.sendKeys("parola123!");
        WebElement checkboxAgree = driver.findElement(By.cssSelector("[name='agree']"));
        checkboxAgree.click();
        WebElement continueButton = driver.findElement(By.cssSelector(".btn.btn-primary"));
        continueButton.click();
        WebElement finalPageText = driver.findElement(By.xpath("//h1[contains(text(), 'Your Account Has Been Created!')]"));
        String finalPageTitle = driver.getTitle();
        Assert.assertEquals(finalPageTitle, "Your Account Has Been Created!");

//        String text = finalPageText.getText();
//        Assert.assertEquals(text, "Your Account Has Been Created!");
    }

//    @AfterMethod
//    public void tearDown() {
//        driver.quit();
//    }
}
