package UI;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Print_All_Links_home {

	private static final String JavascriptExecutor = null;
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
		driver.get("https://beta.drawify.com/home");

		// Store the home page URL
		String homePageUrl = driver.getCurrentUrl();

		// Manage
		driver.manage().window().maximize();

		// Accept cookies
		driver.findElement(By.xpath("/html/body/div[1]/div")).click();

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

		// driver.findElement(By.xpath("//*[@id=\"wrap\"]/div[2]/div[2]/div/p/a[10]")).click();
		Thread.sleep(5000);

		WebElement Featuredemp = driver.findElement(By.xpath("//*[@id=\"wrap\"]/div[2]/div[3]/div/h2"));
		System.out.println(Featuredemp.getText());

		// -----------FEATURED TEMPLATES----------------

		String script = "window.scrollBy(0,300);";
		((JavascriptExecutor) driver).executeScript(script);

		// Locate the templates container
		WebElement templatesContainer = driver.findElement(By.className("card-deck"));

		// Find all template elements within the container
		List<WebElement> templateElements = templatesContainer.findElements(By.className("card-body"));

		// Print the number of templates
		System.out.println("Number of templates: " + templateElements.size());
		System.out.println("-----------------------------------------------");

		// Print the names of the templates
		for (WebElement template : templateElements) {
			// Find the element containing the template name
			WebElement nameElement = template.findElement(By.className("card-title"));
			String templateName = nameElement.getText();

			// Find the element containing the template URL
			WebElement urlElement = template.findElement(By.tagName("a"));
			String templateURL = urlElement.getAttribute("href");

			System.out.println("Template Name: " + templateName);
			System.out.println("Template URL: " + templateURL);
			System.out.println("-----------------------------------------------");
		}

		// -----------PITCHING AND SALES----------------

		WebDriverManager.chromedriver().setup();
		WebDriver pitchingsales = new ChromeDriver();
		pitchingsales.get("https://beta.drawify.com/templates/pitching-and-sales");
		pitchingsales.manage().window().maximize();

		// Wait for the page to load
		Thread.sleep(2000);

		// Scroll
		String script1 = "window.scrollBy(0,300);";
		((JavascriptExecutor) driver).executeScript(script1);

		// Locate the templates container
		WebElement templatesContainer1 = pitchingsales.findElement(By.xpath("//*[@id=\"wrap\"]/div[2]/div[3]"));
		

		System.out.println("Pitching and sales URL: " + pitchingsales.getCurrentUrl());

		// Find all template elements within the container
		List<WebElement> templateElements1 = templatesContainer1.findElements(By.className("card-body"));
		
		//List<WebElement> templateElements1 = templatesContainer1.findElements(By.xpath("//*[@id=\"wrap\"]/div[2]/div[3]/div/div[1]/div[1]"));
		

		// Print the number of templates
		System.out.println("Number of templates: " + templateElements1.size());
		System.out.println("-----------------------------------------------");

		// Print the names and URLs of the templates
		for (WebElement template : templateElements1) {
			// Find the element containing the template name
			WebElement nameElement = template.findElement(By.className("card-title"));
			String templateName = nameElement.getText();

			// Find the element containing the template URL
			WebElement urlElement = template.findElement(By.tagName("a"));
			String templateURL = urlElement.getAttribute("href");

			System.out.println("Template Name: " + templateName);
			System.out.println("Template URL: " + templateURL);
			System.out.println("-----------------------------------------------");
		}

		// Close the WebDriver instance
		pitchingsales.quit();

//-----------Meetings----------------

		WebDriverManager.chromedriver().setup();
		WebDriver Meetings = new ChromeDriver();
		Meetings.get("https://beta.drawify.com/templates/meetings");
		Meetings.manage().window().maximize();

		// Wait for the page to load
		Thread.sleep(2000);

		// Scroll
		String script11 = "window.scrollBy(0,300);";
		((JavascriptExecutor) driver).executeScript(script11);

		// Locate the templates container
		WebElement templatesContainer11 = Meetings.findElement(By.xpath("//*[@id=\"wrap\"]/div[2]/div[3]/div"));

		System.out.println("Meetings URL: " + Meetings.getCurrentUrl());

		// Find all template elements within the container
		List<WebElement> templateElements11 = templatesContainer11.findElements(By.className("card-body"));

		// Print the number of templates
		System.out.println("Number of templates: " + templateElements11.size());
		System.out.println("-----------------------------------------------");

		// Print the names and URLs of the templates
		for (WebElement template : templateElements11) {
			// Find the element containing the template name
			WebElement nameElement = template.findElement(By.className("card-title"));
			String templateName = nameElement.getText();

			// Find the element containing the template URL
			WebElement urlElement = template.findElement(By.tagName("a"));
			String templateURL = urlElement.getAttribute("href");

			System.out.println("Template Name: " + templateName);
			System.out.println("Template URL: " + templateURL);
			System.out.println("-----------------------------------------------");
		}

		// Close the WebDriver instance
		Meetings.quit();
		
		
		//-----------Strategy and planning----------------

				WebDriverManager.chromedriver().setup();
				WebDriver Strategyplanning = new ChromeDriver();
				Strategyplanning.get("https://beta.drawify.com/templates/strategy-and-planning");
				Strategyplanning.manage().window().maximize();

				// Wait for the page to load
				Thread.sleep(2000);

				// Scroll
				String script111 = "window.scrollBy(0,300);";
				((JavascriptExecutor) driver).executeScript(script111);

				// Locate the templates container
				WebElement templatesContainer111 = Strategyplanning.findElement(By.xpath("//*[@id=\"wrap\"]/div[2]/div[3]"));
				
				

				System.out.println("Strategy and planning: " + Strategyplanning.getCurrentUrl());

				// Find all template elements within the container
				List<WebElement> templateElements111 = templatesContainer111.findElements(By.className("card-body"));

				// Print the number of templates
				System.out.println("Number of templates: " + templateElements111.size());
				System.out.println("-----------------------------------------------");

				// Print the names and URLs of the templates
				for (WebElement template : templateElements111) {
					// Find the element containing the template name
					WebElement nameElement = template.findElement(By.className("card-title"));
					String templateName = nameElement.getText();

					// Find the element containing the template URL
					WebElement urlElement = template.findElement(By.tagName("a"));
					String templateURL = urlElement.getAttribute("href");

					System.out.println("Template Name: " + templateName);
					System.out.println("Template URL: " + templateURL);
					System.out.println("-----------------------------------------------");
				}

				// Close the WebDriver instance
				Strategyplanning.quit();
		
				
				//-----------Research and design----------------

				WebDriverManager.chromedriver().setup();
				WebDriver Researchdesign = new ChromeDriver();
				Researchdesign.get("https://beta.drawify.com/templates/research-and-design");
				Researchdesign.manage().window().maximize();

				// Wait for the page to load
				Thread.sleep(2000);

				// Scroll
				String script1111 = "window.scrollBy(0,300);";
				((JavascriptExecutor) driver).executeScript(script1111);

				// Locate the templates container
				WebElement templatesContainer1111 = Researchdesign.findElement(By.xpath("//*[@id=\"wrap\"]/div[2]/div[3]"));
				
				

				System.out.println("Research and design: " + Researchdesign.getCurrentUrl());

				// Find all template elements within the container
				List<WebElement> templateElements1111 = templatesContainer1111.findElements(By.className("card-body"));

				// Print the number of templates
				System.out.println("Number of templates: " + templateElements1111.size());
				System.out.println("-----------------------------------------------");

				// Print the names and URLs of the templates
				for (WebElement template : templateElements1111) {
					// Find the element containing the template name
					WebElement nameElement = template.findElement(By.className("card-title"));
					String templateName = nameElement.getText();

					// Find the element containing the template URL
					WebElement urlElement = template.findElement(By.tagName("a"));
					String templateURL = urlElement.getAttribute("href");

					System.out.println("Template Name: " + templateName);
					System.out.println("Template URL: " + templateURL);
					System.out.println("-----------------------------------------------");
				}

				// Close the WebDriver instance
				Researchdesign.quit();
				
				
				//-----------Agile and teams----------------

				WebDriverManager.chromedriver().setup();
				WebDriver Agileteams = new ChromeDriver();
				Agileteams.get("https://beta.drawify.com/templates/agile-and-teams");
				Agileteams.manage().window().maximize();

				// Wait for the page to load
				Thread.sleep(2000);

				// Scroll
				String script11111 = "window.scrollBy(0,300);";
				((JavascriptExecutor) driver).executeScript(script11111);

				// Locate the templates container
				WebElement templatesContainer11111 = Agileteams.findElement(By.xpath("//*[@id=\"wrap\"]/div[2]/div[3]"));
				
				

				System.out.println("Agile and teams: " + Agileteams.getCurrentUrl());

				// Find all template elements within the container
				List<WebElement> templateElements11111 = templatesContainer11111.findElements(By.className("card-body"));

				// Print the number of templates
				System.out.println("Number of templates: " + templateElements11111.size());
				System.out.println("-----------------------------------------------");

				// Print the names and URLs of the templates
				for (WebElement template : templateElements11111) {
					// Find the element containing the template name
					WebElement nameElement = template.findElement(By.className("card-title"));
					String templateName = nameElement.getText();

					// Find the element containing the template URL
					WebElement urlElement = template.findElement(By.tagName("a"));
					String templateURL = urlElement.getAttribute("href");

					System.out.println("Template Name: " + templateName);
					System.out.println("Template URL: " + templateURL);
					System.out.println("-----------------------------------------------");
				}

				// Close the WebDriver instance
				Agileteams.quit();
				
				
				//-----------Infographics----------------

				WebDriverManager.chromedriver().setup();
				WebDriver Infographics = new ChromeDriver();
				Infographics.get("https://beta.drawify.com/templates/infographics");
				Infographics.manage().window().maximize();

				// Wait for the page to load
				Thread.sleep(2000);

				// Scroll
				String script111111 = "window.scrollBy(0,300);";
				((JavascriptExecutor) driver).executeScript(script111111);

				// Locate the templates container
				WebElement templatesContainer111111 = Infographics.findElement(By.xpath("//*[@id=\"wrap\"]/div[2]/div[3]"));
				
				

				System.out.println("Infographics: " + Infographics.getCurrentUrl());

				// Find all template elements within the container
				List<WebElement> templateElements111111 = templatesContainer111111.findElements(By.className("card-body"));

				// Print the number of templates
				System.out.println("Number of templates: " + templateElements111111.size());
				System.out.println("-----------------------------------------------");

				// Print the names and URLs of the templates
				for (WebElement template : templateElements111111) {
					// Find the element containing the template name
					WebElement nameElement = template.findElement(By.className("card-title"));
					String templateName = nameElement.getText();

					// Find the element containing the template URL
					WebElement urlElement = template.findElement(By.tagName("a"));
					String templateURL = urlElement.getAttribute("href");

					System.out.println("Template Name: " + templateName);
					System.out.println("Template URL: " + templateURL);
					System.out.println("-----------------------------------------------");
				}

				// Close the WebDriver instance
				Infographics.quit();
		
				
				//-----------Social media----------------

				WebDriverManager.chromedriver().setup();
				WebDriver Socialmedia = new ChromeDriver();
				Socialmedia.get("https://beta.drawify.com/templates/social-media");
				Socialmedia.manage().window().maximize();

				// Wait for the page to load
				Thread.sleep(2000);

				// Scroll
				String script1111111 = "window.scrollBy(0,300);";
				((JavascriptExecutor) driver).executeScript(script1111111);

				// Locate the templates container
				WebElement templatesContainer1111111 = Socialmedia.findElement(By.xpath("//*[@id=\"wrap\"]/div[2]/div[3]"));
				
				

				System.out.println("Social media: " + Socialmedia.getCurrentUrl());

				// Find all template elements within the container
				List<WebElement> templateElements1111111 = templatesContainer1111111.findElements(By.className("card-body"));

				// Print the number of templates
				System.out.println("Number of templates: " + templateElements1111111.size());
				System.out.println("-----------------------------------------------");

				// Print the names and URLs of the templates
				for (WebElement template : templateElements1111111) {
					// Find the element containing the template name
					WebElement nameElement = template.findElement(By.className("card-title"));
					String templateName = nameElement.getText();

					// Find the element containing the template URL
					WebElement urlElement = template.findElement(By.tagName("a"));
					String templateURL = urlElement.getAttribute("href");

					System.out.println("Template Name: " + templateName);
					System.out.println("Template URL: " + templateURL);
					System.out.println("-----------------------------------------------");
				}

				// Close the WebDriver instance
				Socialmedia.quit();
				
				
				//-----------Change and transformation----------------

				WebDriverManager.chromedriver().setup();
				WebDriver Changetransformation = new ChromeDriver();
				Changetransformation.get("https://beta.drawify.com/templates/change-and-transformation");
				Changetransformation.manage().window().maximize();

				// Wait for the page to load
				Thread.sleep(2000);

				// Scroll
				String script11111111 = "window.scrollBy(0,300);";
				((JavascriptExecutor) driver).executeScript(script11111111);

				// Locate the templates container
				WebElement templatesContainer11111111 = Changetransformation.findElement(By.xpath("//*[@id=\"wrap\"]/div[2]/div[3]"));
				
				

				System.out.println("Change and transformation: " + Changetransformation.getCurrentUrl());

				// Find all template elements within the container
				List<WebElement> templateElements11111111 = templatesContainer11111111.findElements(By.className("card-body"));

				// Print the number of templates
				System.out.println("Number of templates: " + templateElements11111111.size());
				System.out.println("-----------------------------------------------");

				// Print the names and URLs of the templates
				for (WebElement template : templateElements11111111) {
					// Find the element containing the template name
					WebElement nameElement = template.findElement(By.className("card-title"));
					String templateName = nameElement.getText();

					// Find the element containing the template URL
					WebElement urlElement = template.findElement(By.tagName("a"));
					String templateURL = urlElement.getAttribute("href");

					System.out.println("Template Name: " + templateName);
					System.out.println("Template URL: " + templateURL);
					System.out.println("-----------------------------------------------");
				}

				// Close the WebDriver instance
				Changetransformation.quit();

				
				//-----------Coaching and performance----------------

				WebDriverManager.chromedriver().setup();
				WebDriver Coachingperformance = new ChromeDriver();
				Coachingperformance.get("https://beta.drawify.com/templates/coaching-and-performance");
				Coachingperformance.manage().window().maximize();

				// Wait for the page to load
				Thread.sleep(2000);

				// Scroll
				String script111111111 = "window.scrollBy(0,300);";
				((JavascriptExecutor) driver).executeScript(script111111111);

				// Locate the templates container
				WebElement templatesContainer111111111 = Coachingperformance.findElement(By.xpath("//*[@id=\"wrap\"]/div[2]/div[3]"));
				
				

				System.out.println("Coaching and performance: " + Coachingperformance.getCurrentUrl());

				// Find all template elements within the container
				List<WebElement> templateElements111111111 = templatesContainer111111111.findElements(By.className("card-body"));

				// Print the number of templates
				System.out.println("Number of templates: " + templateElements111111111.size());
				System.out.println("-----------------------------------------------");

				// Print the names and URLs of the templates
				for (WebElement template : templateElements111111111) {
					// Find the element containing the template name
					WebElement nameElement = template.findElement(By.className("card-title"));
					String templateName = nameElement.getText();

					// Find the element containing the template URL
					WebElement urlElement = template.findElement(By.tagName("a"));
					String templateURL = urlElement.getAttribute("href");

					System.out.println("Template Name: " + templateName);
					System.out.println("Template URL: " + templateURL);
					System.out.println("-----------------------------------------------");
				}

				// Close the WebDriver instance
				Coachingperformance.quit();

				
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

		
		// Locate the dropdown menu element
        WebElement dropdownElement = driver.findElement(By.xpath("//*[@id=\"dropdown-community\"]"));

        // Using Select class for <select> elements
        Select dropdown = new Select(dropdownElement);
        
        // Select option by visible text
        dropdown.selectByVisibleText("Webinars");
        
        // Using Actions class for other dropdown menus
        Actions actions = new Actions(driver);
        
        // Perform mouse over action to open the dropdown menu
        actions.moveToElement(dropdownElement).perform();
        
        // Locate and click on the desired dropdown menu item
        WebElement dropdownItem = driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[5]/div/a[1]"));
        dropdownItem.click();
		
		
     // Get the current URL of the page after navigating
     		String currentUrl16 = driver.getCurrentUrl();
     		System.out.println("Current URL after navigating: " + currentUrl16);
     		driver.get(homePageUrl); // Navigate back to the home page
		
     		  WebElement dropdownElement1 = driver.findElement(By.xpath("//*[@id=\"dropdown-community\"]"));

     	        // Using Select class for <select> elements
     	        Select dropdown11 = new Select(dropdownElement1);
     	        
     	        // Select option by visible text
     	        dropdown11.selectByVisibleText("Webinars");
     	        
     	        // Using Actions class for other dropdown menus
     	        Actions actions1 = new Actions(driver);
     	        
     	        // Perform mouse over action to open the dropdown menu
     	        actions1.moveToElement(dropdownElement1).perform();
     	        
     	        // Locate and click on the desired dropdown menu item
     	        WebElement dropdownItem1 = driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[5]/div/a[2]"));
     	        dropdownItem1.click();
     			
     			
     	     // Get the current URL of the page after navigating
     	     		String currentUrl161 = driver.getCurrentUrl();
     	     		System.out.println("Current URL after navigating: " + currentUrl161);
     	     		driver.get(homePageUrl); // Navigate back to the home page
		
		
     	     		
     	     		
     	     		
     	     		
//		
//		// Locate the dropdown menu and click on it to expand it
//		WebElement dropdown2 = driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[5]"));
//		dropdown2.click();
//
//		// Locate the Webinar within the dropdown and click on it
//		WebElement specificOptionD2o1 = driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[5]/div/a[1]"));
//		specificOptionD2o1.click();
//
//		// Get the current URL of the page after navigating
//		String currentUrl15 = driver.getCurrentUrl();
//		System.out.println("Current URL after navigating: " + currentUrl15);
//		driver.get(homePageUrl); // Navigate back to the home page
//
//		// .....................Tutorials.................................
//		// Locate the dropdown menu and click on it to expand it
//		WebElement dropdown2o1 = driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[5]"));
//		dropdown2o1.click();
//
//		System.out.println("test1");
//		// Locate the Tutorial within the dropdown and click on it
//		WebElement specificOptionD2O2 = driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[5]/div/a[2]"));
//		specificOptionD2O2.click();
//
//		// Get the current URL of the page after navigating
//		String currentUrl16 = driver.getCurrentUrl();
//		System.out.println("Current URL after navigating: " + currentUrl16);
//		driver.get(homePageUrl); // Navigate back to the home page
//
//		// .....................ebook.................................
//		// Locate the dropdown menu and click on it to expand it
//		WebElement dropdown2o3 = driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[5]"));
//		dropdown2o3.click();
//
//		// Locate the ebook within the dropdown and click on it
//		WebElement specificOptionD2O3 = driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[5]/div/a[3]"));
//		specificOptionD2O2.click();
//		
//		driver.findElement(By.xpath("//*[@id=\"wrap\"]/div[2]/div/div/div[3]/div/div")).click();
//		//System.out.println("e book has been download successfully:");)
//
//		// Get the current URL of the page after navigating
//		String currentUrl161 = driver.getCurrentUrl();
//		System.out.println("Current URL after navigating: " + currentUrl161);
//		driver.get(homePageUrl); // Navigate back to the home page

		
		
		
		// ...........Support.................................
		driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[6]/a")).click();
		String currentUrl8 = driver.getCurrentUrl();
		System.out.println("Current URL after navigating: " + currentUrl8);
		driver.get(homePageUrl); // Navigate back to the home page

		// ...........Services.................................
		driver.findElement(By.xpath("//*[@id=\"navbarCollapse\"]/ul/li[7]/a")).click();
		String currentUrl9 = driver.getCurrentUrl();
		System.out.println("Current URL after navigating: " + currentUrl9);
		driver.get(homePageUrl); // Navigate back to the home page

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
