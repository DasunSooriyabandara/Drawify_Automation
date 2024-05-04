package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Registration2 {

    public static void main(String[] args) throws InterruptedException {
        // Setup WebDriver for Temp-Mail website
        WebDriverManager.chromedriver().setup();
        WebDriver tempMailDriver = new ChromeDriver();
        tempMailDriver.get("https://tempmail.plus/en/#!");
        tempMailDriver.manage().window().maximize();
        
        //refresh page to get random name
        tempMailDriver.findElement(By.xpath("//*[@id=\"pre_rand\"]")).click();
        
        
        
        
        // Find and click the button to copy the email address to clipboard
        WebElement copyButton = tempMailDriver.findElement(By.xpath("//*[@id=\"pre_copy\"]"));
        copyButton.click();

        // Retrieve the email address
        String email = copyButton.getAttribute("value");
        System.out.println("Email pasted: " + email);

        // Setup WebDriver for destination page
        WebDriverManager.chromedriver().setup();
        WebDriver destinationDriver = new ChromeDriver();
        destinationDriver.get("https://beta.drawify.com/auth/register");
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
        destinationDriver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("a");

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

        
     // Setup WebDriver for Mailtrap page
        WebDriverManager.chromedriver().setup();
        WebDriver mailtrapDriver = new ChromeDriver();
        mailtrapDriver.get("https://mailtrap.io/");
        mailtrapDriver.manage().window().maximize();

        // Scroll vertically by 300 pixels
        String script = "window.scrollBy(0,300);";
        ((JavascriptExecutor) mailtrapDriver).executeScript(script);

        
        // Accept cookies
        WebDriverWait wait12 = new WebDriverWait(mailtrapDriver,Duration.ofSeconds(40));
        WebElement acceptCookiesButton = wait12.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CybotCookiebotDialogBodyButtonAccept\"]")));
        acceptCookiesButton.click();

        
        // Click login from dashboard
       mailtrapDriver.findElement(By.xpath("//*[@id=\"screen-reader-shortcut-header\"]/nav/div/div/div[2]/div[4]/a[1]")).click();
       
       
   
      
        
        // Wait for the email input field to be visible
//        WebDriverWait wait1 = new WebDriverWait(tempMailDriver, Duration.ofSeconds(30));
//        WebElement emailInput1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tm-body > main > div:nth-child(1) > div > div.col-sm-12.col-md-12.col-lg-12.col-xl-8 > div.tm-content > div > div.inboxWarpMain > div > div.inbox-dataList > ul > li:nth-child(2) > div:nth-child(3) > div.m-link-view")));
//        	
        
        //String username = "ifonix.innovations@gmail.com";
        //String passwordMT = "1234!@#$Qw";
        
        
        String script1 = "window.scrollBy(0,300);";
        ((JavascriptExecutor) mailtrapDriver).executeScript(script1);
        
        // Enter email address
        WebElement email1 = mailtrapDriver.findElement(By.xpath("//input[@type='email']"));
        email1.sendKeys("ifonix.innovations@gmail.com");	
        //Click next button
        mailtrapDriver.findElement(By.xpath("//*[@id=\"new_user\"]/div[3]/a")).click();
        
        
        
        //Enter Password
        //WebElement password1 = mailtrapDriver.findElement(By.cssSelector("#user_password"));
       // password1.sendKeys("1234!@#$Qw");
        
        WebDriverWait wait1 = new WebDriverWait(mailtrapDriver, Duration.ofSeconds(30));
        WebElement password1 = wait1.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#user_password")));
        password1.sendKeys("1234!@#$Qw");
        
        
        //Click Login button      
        mailtrapDriver.findElement(By.xpath("//input[@type='submit']")).click();
        
        System.out.println("Successfully login to Mail trap :" +  mailtrapDriver.getCurrentUrl());
        
        WebDriverWait wait121 = new WebDriverWait(mailtrapDriver, Duration.ofSeconds(10));
        WebElement inbox = wait121.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"falconApp\"]/div/div[2]/div/div/div[1]/div/div[2]/div/div[2]/div/div[1]/a")));
        inbox.click();
        
        
        //Click on MY INBOX testing
        //mailtrapDriver.findElement(By.xpath("//*[@id=\"falconApp\"]/div/div[2]/div/div[3]/div/div[3]/div/div[1]/span/a/span")).click();
        //Click on MY INBOX
        //mailtrapDriver.findElement(By.xpath("//*[@id=\"falconApp\"]/div/div[2]/div/div[3]/div/div[3]/div/div[1]")).click();
      
        //Refresh the page
//        WebDriverWait wait111 = new  WebDriverWait( mailtrapDriver, Duration.ofSeconds(5));
//        WebElement inboxx = wait121.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"falconApp\"]/div/div[2]/div/div[1]/div[2]/button[2]/svg")));
//        inboxx.click();
//        
        System.out.println("Test one");
     // Assuming you have already navigated to the inbox page
        
        WebDriverWait wait11 = new WebDriverWait(mailtrapDriver, Duration.ofSeconds(10));
        WebElement inboxItem = wait11.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"falconApp\"]/div/div[2]/div/div[1]/div[2]/ul/li[1]")));
        inboxItem.click();
      
        
     // Locate and click on the first email in the list
     //WebElement firstEmail = mailtrapDriver.findElement(By.xpath("//*[@id=\"falconApp\"]/div/div[2]/div/div[1]/div[2]/ul/li[1]"));
     //firstEmail.click();
     
   //*[@id="falconApp"]/div/div[2]/div/div[1]/div[2]/ul/li[1]
     
     System.out.println("Successfully open the verification email :" +  mailtrapDriver.getCurrentUrl());
        
     // Scroll vertically by 300 pixels
     String script11 = "window.scrollBy(0,400);";
     ((JavascriptExecutor) mailtrapDriver).executeScript(script11);
       
     
     try {
    	    // Switch to the iframe
    	    mailtrapDriver.switchTo().frame(0);
    	    System.out.println("Switched to iframe successfully");
    	    
    	    // Wait for the email verification link/button to be clickable
    	    WebDriverWait wait111 = new WebDriverWait(mailtrapDriver, Duration.ofSeconds(60));
    	    WebElement inboxItem1 = wait111.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"templateBody\"]/table/tbody/tr/td/table[2]/tbody/tr/td/table/tbody/tr/td/a")));
    	    
    	    // Click the email verification link/button
    	    inboxItem1.click();
    	    System.out.println("Email verification link/button clicked successfully");
    	} catch (Exception e) {
    	    System.out.println("An error occurred: " + e.getMessage());
    	}

    	// Quit drivers
    	tempMailDriver.quit();
    	destinationDriver.quit();



    }
}