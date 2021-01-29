package resource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public WebDriver driver;
    public Properties prop;
    public FileInputStream fis;
   
	@SuppressWarnings("deprecation")
	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		fis = new FileInputStream(
				"D:\\Documents\\Selenium by Rahul\\eclipse-workspace\\E2EProject1\\src\\main\\java\\resource\\data.properties");
		prop.load(fis);
		String browsername = prop.getProperty("browser");
			if (browsername.equals("chrome")) {
			// execute in chrome driver
			System.out.println(browsername);
			System.setProperty("webdriver.chrome.driver", "D:\\Documents\\Selenium by Rahul\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsername.equals("firefox")) {

			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	
}
