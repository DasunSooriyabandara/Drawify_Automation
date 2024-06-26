package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class verify_email {

    public static void main(String[] args) {
        // Setup WebDriver for Temp-Mail website
        WebDriverManager.chromedriver().setup();
        WebDriver tempMailDriver = new ChromeDriver();
        tempMailDriver.get("https://temp-mail.org/en/");
        tempMailDriver.manage().window().maximize();
        
        // SCROLL & Find the element using its xpath
        WebElement scrollElement1 = tempMailDriver.findElement(By.xpath("//*[@id=\"tm-body\"]/main/div[1]/div/div[2]/div[2]/div/div[1]/div/div[4]"));

        // SCROLL the element into view
        ((JavascriptExecutor) tempMailDriver).executeScript("arguments[0].scrollIntoView();", scrollElement1);

        // Click on arrow to expand the mail
        WebElement clickButton = tempMailDriver.findElement(By.xpath("//*[@id=\"tm-body\"]/main/div[1]/div/div[2]/div[2]/div/div[1]/div/div[4]/ul/li[2]/div[3]/div[2]/a"));
        clickButton.click();
        
        // SCROLL & Find the element using its xpath
        WebElement scrollElement2 = tempMailDriver.findElement(By.xpath("//*[@id=\"tm-body\"]/main/div[1]/div/div[2]/div[2]/div/div[1]/div/div[2]/div[3]/center/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table[2]/tbody/tr/td/table/tbody"));

        // SCROLL the element into view
        ((JavascriptExecutor) tempMailDriver).executeScript("arguments[0].scrollIntoView();", scrollElement2);
    


        //----------------------
//        // Retrieve the email address
//        String email = copyButton.getAttribute("value");
//        System.out.println("Email pasted: " + email);
//
//        // Setup WebDriver for destination page
//        WebDriverManager.chromedriver().setup();
//        WebDriver destinationDriver = new ChromeDriver();
//        destinationDriver.get("https://drawify.com/auth/register");
//        destinationDriver.manage().window().maximize();
//
//        // Wait for the email input field to be visible
//        Wait<WebDriver> wait = new FluentWait<>(destinationDriver)
//                .withTimeout(Duration.ofSeconds(30))
//                .pollingEvery(Duration.ofSeconds(2))
//                .ignoring(Exception.class);
//
//        WebElement emailInput = wait.until(drvr -> drvr.findElement(By.xpath("//*[@id=\"email\"]")));
//
//        // Click cookies accept popup on the destination page
//        destinationDriver.findElement(By.xpath("/html/body/div[1]/div")).click();
//
//        // Paste the email address from clipboard into the email input field
//        emailInput.sendKeys(Keys.chord(Keys.CONTROL, "v"));
//
//        // Retrieve the value of the email input field after pasting
//        email = emailInput.getAttribute("value");
//        System.out.println("Email pasted: " + email);
//
//        // Store the password value in a variable
//        String password = "abcd1234";
//
//        // Enter weak password
//        WebElement passwordInput = destinationDriver.findElement(By.id("password"));
//        passwordInput.sendKeys(password);
//
//        // Print the value being sent using sendKeys
//        System.out.println("Display message for Weak Password sent: " + password);
//
//        // Show password
//        destinationDriver.findElement(By.xpath("//*[@id=\"register-from\"]/div[4]/div/button")).click();
//
//        // Enter First Name
//        destinationDriver.findElement(By.xpath("//*[@id=\"first-name\"]"))
//                        .sendKeys("Automation Testing");
//
//        // Enter Last Name
//        destinationDriver.findElement(By.xpath("//*[@id=\"last-name\"]"))
//                        .sendKeys("Dasun");
//
//        // Enter strong password
//        String strongPassword = "Test@2023";
//        WebElement strongPasswordInput = destinationDriver.findElement(By.id("password"));
//        strongPasswordInput.sendKeys(strongPassword);
//
//        // Print the value being sent using sendKeys
//        System.out.println("Successfully registered for Strong Password : " + strongPassword);
//
//        // Click sign up button
//        destinationDriver.findElement(By.xpath("//*[@id=\"register-from\"]/div[6]/div[1]/button/div")).click();
//        // Terms and conditions checkbox
//        destinationDriver.findElement(By.xpath("//*[@id=\"terms-conditions\"]")).click();
//
//        // Click sign up button
//        destinationDriver.findElement(By.xpath("//*[@id=\"register-from\"]/div[6]/div[1]/button/div")).click();
//
//        System.out.println("Sign up button clicked and successfully loaded auth page and "
//                            + "sent verification link to the email");

        // Quit drivers
//        tempMailDriver.quit();
//        destinationDriver.quit();
    }
}
