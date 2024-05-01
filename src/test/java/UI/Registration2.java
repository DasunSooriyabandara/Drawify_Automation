package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Registration2 {

    public static void main(String[] args) throws InterruptedException {
        // Setup WebDriver for Temp-Mail website
        WebDriverManager.chromedriver().setup();
        WebDriver tempMailDriver = new ChromeDriver();
        tempMailDriver.get("https://tempmail.plus/en/#!");
        tempMailDriver.manage().window().maximize();

        // Find and click the button to copy the email address to clipboard
        WebElement copyButton = tempMailDriver.findElement(By.id("pre_copy"));
        copyButton.click();

        // Retrieve the email address
        String email = copyButton.getAttribute("value");
        System.out.println("Email pasted: " + email);

        // Setup WebDriver for destination page
        WebDriver destinationDriver = new ChromeDriver();
        destinationDriver.get("https://beta.drawify.com/auth/register");
        destinationDriver.manage().window().maximize();

        // Wait for the email input field to be visible
        WebDriverWait wait = new WebDriverWait(destinationDriver, Duration.ofSeconds(30));
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

        // Paste the email address from clipboard into the email input field
        emailInput.sendKeys(Keys.CONTROL + "v");

        // Retrieve the value of the email input field after pasting
        email = emailInput.getAttribute("value");
        System.out.println("Email pasted: " + email);

        // Store the password value in a variable
        String password = "abcd1234";

        // Enter weak password
        WebElement passwordInput = destinationDriver.findElement(By.id("password"));
        passwordInput.sendKeys(password);

        // Print the value being sent using sendKeys
        System.out.println("Display message for Weak Password sent: " + password);

        // Show password
        destinationDriver.findElement(By.xpath("//*[@id=\"register-from\"]/div[4]/div/button")).click();

        // Enter First Name
        destinationDriver.findElement(By.id("first-name")).sendKeys("Automation Testing");

        // Enter Last Name
        destinationDriver.findElement(By.id("last-name")).sendKeys("a");

        // Enter strong password
        String strongPassword = "Test@2023";
        WebElement strongPasswordInput = destinationDriver.findElement(By.id("password"));
        strongPasswordInput.sendKeys(strongPassword);

        // Print the value being sent using sendKeys
        System.out.println("Successfully registered for Strong Password : " + strongPassword);

        // Click sign up button
        destinationDriver.findElement(By.xpath("//*[@id=\"register-from\"]/div[6]/div[1]/button/div")).click();

        // Terms and conditions checkbox
        destinationDriver.findElement(By.id("terms-conditions")).click();

        // Click sign up button
        destinationDriver.findElement(By.xpath("//*[@id=\"register-from\"]/div[6]/div[1]/button/div")).click();

        System.out.println("Sign up button clicked and successfully loaded auth page and "
                + "sent verification link to the email");

        destinationDriver.manage().window().minimize();

        // Setup WebDriver for Mailtrap page
        WebDriver mailtrapDriver = new ChromeDriver();
        mailtrapDriver.get("https://mailtrap.io/");
        mailtrapDriver.manage().window().maximize();

        // Accept cookies
        WebDriverWait wait12 = new WebDriverWait(mailtrapDriver, Duration.ofSeconds(30));
        WebElement acceptCookiesButton = wait12.until(ExpectedConditions.visibilityOfElementLocated(By.id("CybotCookiebotDialogBodyButtonAccept")));
        acceptCookiesButton.click();

        // Click login from dashboard
        mailtrapDriver.findElement(By.xpath("//*[@id=\"screen-reader-shortcut-header\"]/nav/div/div/div[2]/div[4]/a[1]")).click();

        // Enter email address
        WebElement email1 = mailtrapDriver.findElement(By.xpath("//input[@type='email']"));
        email1.sendKeys("ifonix.innovations@gmail.com");

        // Click next button
        mailtrapDriver.findElement(By.xpath("//*[@id=\"new_user\"]/div[3]/a")).click();

        // Enter Password
        WebElement password1 = mailtrapDriver.findElement(By.id("user_password"));
        password1.sendKeys("1234!@#$Qw");

        // Click Login button
        mailtrapDriver.findElement(By.xpath("//input[@type='submit']")).click();

        // Click on email testing
        mailtrapDriver.findElement(By.xpath("//*[@id=\"falconApp\"]/div/aside/nav/ul/li[2]/a")).click();

        // Click on MY INBOX
        mailtrapDriver.findElement(By.xpath("//*[@id=\"falconApp\"]/div/div[2]/div/div[3]/div/div[3]/div/div[1]")).click();

        // Refresh the page
        mailtrapDriver.findElement(By.xpath("//*[@id=\"falconApp\"]/div/div[2]/div/div[1]/div[1]/div[2]/button[2]")).click();

        // Open the email
        mailtrapDriver.findElement(By.xpath("//*[@id=\"falconApp\"]/div/div[2]/div/div[1]/div[2]/ul")).click();

        // Scroll
        String script111111111 = "window.scrollBy(0,600);";
        ((JavascriptExecutor) mailtrapDriver).executeScript(script111111111);

        // Click verify email button
        mailtrapDriver.findElement(By.xpath("//*[@id=\"templateBody\"]/table/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr/td")).click();

        System.out.println("email verification link/button clicked");

        // Quit drivers
        tempMailDriver.quit();
        destinationDriver.quit();
        mailtrapDriver.quit();
    }
}
