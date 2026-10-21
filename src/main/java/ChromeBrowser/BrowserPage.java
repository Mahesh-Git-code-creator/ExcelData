package ChromeBrowser;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BrowserPage {

	public static WebDriver driver;

	public static FileInputStream fis;

	public static Properties prop;

	@BeforeClass

	public void Browser() throws IOException {

		fis = new FileInputStream("src\\test\\resources\\ChromeDetails\\chrome.properties");

		prop = new Properties();

		prop.load(fis);

	}

	@BeforeMethod

	public void Applaunch() {

		String browser = prop.getProperty("BrowserName");

		switch (browser.toLowerCase()) {
		case "chrome":

			driver = new ChromeDriver();

			break;

		case "firefox":

			driver = new FirefoxDriver();

			break;

		case "edge":

			driver = new EdgeDriver();

			break;

		default:

			try {

				throw new Exception("I think you are entered the wrong Browser Expecting Chrome/firefox/Edge..");

			} catch (Exception e) {

				System.out.println(e.getMessage());

			}
			break;
		}

		driver.get(prop.getProperty("url"));

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(prop.getProperty("implicitwait"))));

	}

	@AfterMethod

	public void tearDown() throws Exception {

		Thread.sleep(3000);

		driver.quit();

	}

}
