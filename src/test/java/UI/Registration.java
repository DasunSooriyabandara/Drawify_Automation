package UI;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Registration {

	public static String browser = "chrome"; // External configuration
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		// Open Drawify website
		driver.get("https://temp-mail.org/en/");

		// Store the home page URL
		String homePageUrl = driver.getCurrentUrl();

		// Manage
		driver.manage().window().maximize();

		WebElement contentToCopy = driver.findElement(By.id("click-to-copy"));

		// Initialize second WebDriver for destination browser
		WebDriver destinationDriver = new ChromeDriver();

		// Open the destination browser window and navigate to the target page
		destinationDriver.get("https://drawify.com/auth/register");

		// Manage
		driver.manage().window().maximize();

		// Locate the element where you want to paste the content
		WebElement pasteElement = destinationDriver.findElement(By.xpath("//*[@id=\"email\"]"));

		// Use Actions class to paste the copied content
		Actions actions = new Actions(destinationDriver);
		actions.moveToElement(pasteElement).click().sendKeys(Keys.CONTROL + "v") // Press CTRL + V to paste
				.build().perform();

		// Quit browser
		driver.quit();
	}
}
