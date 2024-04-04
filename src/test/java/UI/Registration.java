package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Registration {

    public static void main(String[] args) {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Open Temp-Mail website
        driver.get("https://temp-mail.org/en/");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Find and click the button to copy the email address to clipboard
        WebElement copyButton = driver.findElement(By.xpath("//*[@id=\"click-to-copy\"]"));
        copyButton.click();

        // Open a new browser window for the destination page
        WebDriver destinationDriver = new ChromeDriver();

        // Open the destination page and maximize the window
        destinationDriver.get("https://drawify.com/auth/register");
        destinationDriver.manage().window().maximize();

        // Wait for the email input field to be visible
        Wait<WebDriver> wait = new FluentWait<>(destinationDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);
        
        WebElement emailInput = wait.until(drvr -> drvr.findElement(By.xpath("//*[@id=\"email\"]")));

        // Paste the email address from clipboard into the email input field
        emailInput.sendKeys(Keys.chord(Keys.CONTROL, "v"));

        // Quit browsers
//        driver.quit();
//        destinationDriver.quit();
    }
}
