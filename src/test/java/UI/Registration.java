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
		Wait<WebDriver> wait = new FluentWait<>(destinationDriver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);

		WebElement emailInput = wait.until(drvr -> drvr.findElement(By.xpath("//*[@id=\"email\"]")));

		// Click cookies accept popup
		driver.findElement(By.xpath("/html/body/div[1]/div")).click();

		// Paste the email address from clipboard into the email input field
		emailInput.sendKeys(Keys.chord(Keys.CONTROL, "v"));

		// Retrieve the value of the email input field after pasting
		String email = emailInput.getAttribute("value");

		System.out.println("Email pasted: " + email);

		// -----------------------------------------------------------------------------------------------------------------

		// Store the password value in a variable
		String password = "abcd1234";

		// Enter weak password
		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys(password);

		// Print the value being sent using sendKeys
		System.out.println("Display message for Weak Password sent: " + password);

		// Show password
		driver.findElement(By.xpath("//*[@id=\"register-from\"]/div[4]/div/button")).click();

		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Dasuntest@gmai.com");
		// Clikc sign up button
		driver.findElement(By.xpath("//*[@id=\"register-from\"]/div[6]/div[1]/button")).click();

		// Enter First NAme
		driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Autumation Testing");

		// Enter Last NAme
		driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Dasun");

		// Email
		System.out.println("Temp MAil Emai address :" + email);

		// Enter strong password
		String spassword = "Test@2023";

		WebElement spasswordInput = driver.findElement(By.id("password"));
		spasswordInput.sendKeys(spassword);

		// Print the value being sent using sendKeys
		System.out.println("SUccessfully registerdd forr Strong Password : " + spassword);

		// Clikc sign up button
		driver.findElement(By.xpath("//*[@id=\"register-from\"]/div[6]/div[1]/button/div")).click();

		// Terms and conditions checkbox
		driver.findElement(By.xpath("//*[@id=\"terms-conditions\"]")).click();

		// Clikc sign up button
		driver.findElement(By.xpath("//*[@id=\"register-from\"]/div[6]/div[1]/button/div")).click();

		System.out.println(
				"sign up button clicked and successfully load auth page and send verification link to the email");

		// Quit browsers
//        driver.quit();
//        destinationDriver.quit();
	}
}