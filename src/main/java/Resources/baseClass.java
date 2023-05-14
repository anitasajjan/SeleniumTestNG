package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import Resources.extentManager;

public class baseClass {
	public static WebDriver driver;
	public Properties prop;

	public void initializeDriver() throws IOException {

		// This will access the properties file
		FileInputStream fis = new FileInputStream("\\Users\\91954\\eclipse-workspace\\SeleniumTestNg\\src\\main\\java\\Resources\\data.properties");

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

	@BeforeMethod
	public void launchBrowser() throws IOException {

		initializeDriver();

		String url = prop.getProperty("url");
		driver.get(url);

	}

	@AfterMethod
	public void quitBrowser() throws IOException {

		driver.quit();

	}

	@BeforeTest
	public void ExtentReport() {
		extentManager.setup();
	}

	@AfterTest
	public void endReport() {
		extentManager.endReport();
	}

	public static String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShot\\" + filename + "_" + dateName + ".png";
		// String destination =
		// System.getProperty("C:\\Users\\91954\\eclipse-workspace\\SeleniumTestNg\\ScreenShot\\"
		// + filename + "_" + dateName + ".png");
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}

}
