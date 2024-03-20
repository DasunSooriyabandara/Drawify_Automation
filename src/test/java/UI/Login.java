package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) {
		// Set up ChromeDriver using WebDriverManager
		WebDriverManager.chromedriver().setup();

		// Initialize ChromeDriver
		ChromeDriver driver = new ChromeDriver();

		// Open Sauce Demo website
		driver.get("https://drawify.com/");
		
		//Maximize browser
		driver.manage().window().maximize();
		
		//current URL
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
		//Get Title
		String Title = driver.getTitle();
		System.out.println(Title);
		
		//Clicktry for free element		
		driver.findElement(By.xpath("//*[@id=\"wrap\"]/div[2]/div/div/p[2]/a")).click();
		
		//Click cookies toast
		driver.findElement(By.xpath("/html/body/div[1]/div")).click();
		
		// find user name
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[2]/div/div[2]/form/div[1]/div/input"))
				.sendKeys("dmpasindudasun98@gmail.com");
		
		// find password
		driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[2]/div/div[2]/form/div[2]/div/input"))
				.sendKeys("8qHVdhRnQLKEyJ!");
		//Show password
		driver.findElement(By.className("input-icon-toggle")).click();
		
		//Hide password
		driver.findElement(By.className("input-icon-toggle")).click();

		// driver.findElement(By.xpath("//*[@id=\"login-from\"]/div[3]/div[1]/div/label/p")).click();

		//driver.findElement(By.className("col-12 p-t-10")).click();
		driver.findElement(By.cssSelector("#login-from > div:nth-child(4) > div.col-12.p-t-10 > button > div")).click();
		// Close the browser window
		// driver.quit();
		
		
	}

}
