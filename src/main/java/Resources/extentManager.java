package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentManager {

	public static ExtentSparkReporter htmlReporter; // Responsible for look
	public static ExtentReports extent; // Responsible for entries
	public static ExtentTest test; // Responsible for test status pass/fail

	public static void setup() {

		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/myReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("hostname", "LocalHost");
		extent.setSystemInfo("os", "Windows 11");
		extent.setSystemInfo("testername", "Anita");
	}

	public static void endReport() {
		extent.flush();
	}

}
