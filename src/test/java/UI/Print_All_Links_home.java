package UI;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

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

		// Store the home page URL
		String homePageUrl = driver.getCurrentUrl();

		// Manage
		driver.manage().window().maximize();

		// Accept cookies
		// driver.findElement(By.xpath("/html/body/div[1]/div")).click();

		// ............All links in the home page............
//        List<WebElement> alltags = driver.findElements(By.tagName("a"));
//        System.out.println("Total tags are:" + alltags.size());
//
//        for (int i = 0; i < alltags.size(); i++) {
//            System.out.println("Links on the page: " + alltags.get(i).getAttribute("href"));
//            System.out.println("Links on the page: " + alltags.get(i).getText());
//            System.out.println("------------------------------------");
//        }

		// ...........Navigation bar links......................
		// ...........Templates.................................
		driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[1]/a")).click();
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL after navigating: " + currentUrl);
		driver.get(homePageUrl); // Navigate back to the home page

		// ...........Community.................................
		// .....................Drawifiers.................................

		// Locate the dropdown menu and click on it to expand it
		WebElement dropdown1 = driver.findElement(By.xpath("//*[@id=\"dropdown-community\"]"));
		dropdown1.click();

		// Locate the Drawifiers within the dropdown and click on it
		WebElement specificOption = driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[2]/div/a[1]"));
		specificOption.click();

		// Get the current URL of the page after navigating
		String currentUrl1 = driver.getCurrentUrl();
		System.out.println("Current URL after navigating: " + currentUrl1);
		driver.get(homePageUrl); // Navigate back to the home page

		// .....................Become a Drawifier.................................
		// Locate the dropdown menu and click on it to expand it
		WebElement dropdownopt2 = driver.findElement(By.xpath("//*[@id=\"dropdown-community\"]"));
		dropdownopt2.click();

		// Locate the Drawifiers within the dropdown and click on it
		WebElement specificOption2 = driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[2]/div/a[2]"));
		specificOption2.click();

		// Get the current URL of the page after navigating
		String currentUrl11 = driver.getCurrentUrl();
		System.out.println("Current URL after navigating: " + currentUrl11);
		driver.get(homePageUrl); // Navigate back to the home page

		// ...........Pricing.................................
		driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[3]/a")).click();
		String currentUrl3 = driver.getCurrentUrl();
		System.out.println("Current URL after navigating: " + currentUrl3);
		driver.get(homePageUrl); // Navigate back to the home page

		// ...........Blog.................................
		driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[4]/a")).click();
		String currentUrl4 = driver.getCurrentUrl();
		System.out.println("Current URL after navigating: " + currentUrl4);
		driver.get(homePageUrl); // Navigate back to the home page

		// ...........Academy.................................
		// .....................Webinars.................................

		// Locate the dropdown menu and click on it to expand it
		WebElement dropdown2 = driver.findElement(By.cssSelector("#dropdown-community"));
		dropdown2.click();

		// Locate the Drawifiers within the dropdown and click on it
		WebElement specificOptionD2o1 = driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[5]/div/a[1]"));
		specificOptionD2o1.click();

		// Get the current URL of the page after navigating
		String currentUrl15 = driver.getCurrentUrl();
		System.out.println("Current URL after navigating: " + currentUrl15);
		driver.get(homePageUrl); // Navigate back to the home page

		// .....................Tutorials.................................

		// Locate the dropdown menu and click on it to expand it
		WebElement dropdown = driver.findElement(By.cssSelector("#dropdown-community"));
		dropdown.click();

		// Locate the Drawifiers within the dropdown and click on it
		WebElement specificOptionD2O2 = driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[5]/div/a[1]"));
		specificOptionD2O2.click();

		// Get the current URL of the page after navigating
		String currentUrl16 = driver.getCurrentUrl();
		System.out.println("Current URL after navigating: " + currentUrl16);
		driver.get(homePageUrl); // Navigate back to the home page

//		
//
//		// ...........Academy.................................
//		// .....................Drawifiers.................................
//		
//		
//
//		// ...........subscribe email add.................
//		driver.findElement(By.id("subscribe-form-email")).sendKeys("Test@gmail.com");
//		driver.findElement(By.className("form-checkbox"));
////		Thread.sleep(2000);
//		driver.findElement(By.id("btn-subscription")).click();
//		System.out.println("All done");

		// Quit browser
		driver.quit();
	}
}
