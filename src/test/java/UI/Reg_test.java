package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Reg_test {

	public static void main(String[] args) {
		// Set up ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();

		// Initialize ChromeDriver
		ChromeDriver driver = new ChromeDriver();

		// Open Sauce Demo website
		driver.get("https://drawify.com/auth/register");
		
		//Maximize browser
		driver.manage().window().maximize();
		
				
		// Store the password value in a variable
		String password = "abcd1234";

		// Enter weak password
		WebElement passwordInput = driver.findElement(By.id("password"));
		passwordInput.sendKeys(password);

		// Print the value being sent using sendKeys
		System.out.println("Display message for Weak Password sent: " + password);
		
		//Click cookies accept popup
		driver.findElement(By.xpath("/html/body/div[1]/div")).click();
					
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
		//System.out.println("Emai :" + email);

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

		System.out.println("sign up button clicked and successfully load auth page and send verification link to the email");

//		
		
		
		
	}
}