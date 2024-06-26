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

public class testRegone {

    public static void main(String[] args) throws InterruptedException {
        // Setup WebDriver for Temp-Mail website
        WebDriverManager.chromedriver().setup();
        WebDriver tempMailDriver = new ChromeDriver();
        tempMailDriver.get("https://internxt.com/temporary-email");
        tempMailDriver.manage().window().maximize();

        // Find and click the button to copy the email address to clipboard
        WebElement copyButton = tempMailDriver.findElement(By.xpath("//*[@id=\"__next\"]/section[1]/div/div[2]/div/div/button"));
        copyButton.click();

        // Retrieve the email address
        String email = copyButton.getAttribute("value");
        System.out.println("Email pasted: " + email);

        // Setup WebDriver for destination page
        WebDriverManager.chromedriver().setup();
        WebDriver destinationDriver = new ChromeDriver();
        destinationDriver.get("https://beta.drawify.com/auth/login");
        destinationDriver.manage().window().maximize();

        // Wait for the email input field to be visible
        WebDriverWait wait = new WebDriverWait(destinationDriver, Duration.ofSeconds(30));
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"email\"]")));

        // Click cookies accept popup on the destination page
        destinationDriver.findElement(By.xpath("/html/body/div[1]/div")).click();

        // Paste the email address from clipboard into the email input field
        emailInput.sendKeys(Keys.chord(Keys.CONTROL, "v"));

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
        destinationDriver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Automation Testing");

        // Enter Last Name
        destinationDriver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Dasun");

        // Enter strong password
        String strongPassword = "Test@2023";
        WebElement strongPasswordInput = destinationDriver.findElement(By.id("password"));
        strongPasswordInput.sendKeys(strongPassword);

        // Print the value being sent using sendKeys
        System.out.println("Successfully registered for Strong Password : " + strongPassword);

        // Click sign up button
        destinationDriver.findElement(By.xpath("//*[@id=\"register-from\"]/div[6]/div[1]/button/div")).click();

        // Terms and conditions checkbox
        destinationDriver.findElement(By.xpath("//*[@id=\"terms-conditions\"]")).click();

        // Click sign up button
        destinationDriver.findElement(By.xpath("//*[@id=\"register-from\"]/div[6]/div[1]/button/div")).click();

        System.out.println("Sign up button clicked and successfully loaded auth page and "
                + "sent verification link to the email");

        destinationDriver.manage().window().minimize();

        // Setup WebDriver for mailtrap after verification mail send page
//        WebDriver verificationDriver = new ChromeDriver();
//        verificationDriver.get("https://temp-mail.org/en/");
//        verificationDriver.manage().window().maximize();

        // Scroll vertically by 500 pixels
        String script = "window.scrollBy(0,300);";
        ((JavascriptExecutor) tempMailDriver).executeScript(script);

        
        System.out.println("heloooo 1 ");
        
        // Wait for the email input field to be visible
//        WebDriverWait wait1 = new WebDriverWait(tempMailDriver, Duration.ofSeconds(30));
//        WebElement emailInput1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tm-body > main > div:nth-child(1) > div > div.col-sm-12.col-md-12.col-lg-12.col-xl-8 > div.tm-content > div > div.inboxWarpMain > div > div.inbox-dataList > ul > li:nth-child(2) > div:nth-child(3) > div.m-link-view")));
//        		
        // Click on the expanded email
//        emailInput1.click();
        System.out.println("heloooo 2 ");
        Thread.sleep(5000);
  //-------------------------------------------------------------      
        WebElement emailSubjectElement = tempMailDriver.findElement(By.xpath("//*[@id=\"tm-body\"]/main/div[1]/div/div[2]/div[2]/div/div[1]/div/div[4]/ul/li[2]/div[3]/div[2]/a"));
        Thread.sleep(5000);
        emailSubjectElement.click();
        
        System.out.println("heloooo 3 ");
        
     // Example: Extracting the email content
        WebElement emailContentElement = tempMailDriver.findElement(By.xpath("//div[@class='col box']"));
        String emailContent = emailContentElement.getText();
        System.out.println("Email Content: " + emailContent);
        
  //---------------------------------------------------------------      
        // Click on the verification link
        tempMailDriver.findElement(By.xpath("//*[@id=\"tm-body\"]/main/div[1]/div/div[2]/div[2]/div/div[1]/div/div[2]/div[3]/center/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr/td/a")).click();

        System.out.println("Successfully loaded the verification page.");

        // Quit drivers
        tempMailDriver.quit();
        destinationDriver.quit();
    }
}