package UI;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Print_All_Links_home {

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
		driver.get("https://drawify.com/");

		// Manage
		driver.manage().window().maximize();

		// Accept cookies
		// driver.findElement(By.xpath("/html/body/div[1]/div")).click();

		// ............All links in the home page............
		List<WebElement> alltags = driver.findElements(By.tagName("a"));
		System.out.println("Total tags are:" + alltags.size());

		for (int i = 0; i < alltags.size(); i++) {
			System.out.println("Links on the page: " + alltags.get(i).getAttribute("href"));
			System.out.println("Links on the page: " + alltags.get(i).getText());
			System.out.println("------------------------------------");
		}
		//...........subscribe email add.................
		driver.findElement(By.id("subscribe-form-email")).sendKeys("Test@gmail.com");
		driver.findElement(By.className("form-checkbox"));
		Thread.sleep(2000);
		driver.findElement(By.id("btn-subscription")).click();
		System.out.println("All done");

		// Quit browser
		driver.quit();
	}
}
