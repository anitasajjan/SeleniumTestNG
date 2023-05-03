package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baseClass {
	public WebDriver driver;
    public Properties prop;
	public void initializeDriver() throws IOException {

		// This will access the properties file
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\91954\\eclipse-workspace\\project_selenium_testng\\src\\main\\java\\Resources\\data.properties");

		// Read the file-

	    prop = new Properties();

		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();

		} else {
			System.out.println("please choose valid browser to run your scripts");
		}

	}

}
