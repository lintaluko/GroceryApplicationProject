package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	public static final ExtentReports extentReports = new ExtentReports();// static instance of extentreports that can
	// be shared accross the application
	// ExtentReport is a predefined class

	public synchronized static ExtentReports createExtentReports() {
//using synchronized -safe for parallel execution(no two threads can run it at the same time.
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");// extent-reports
		// ExtentSparkReporter is pre defined class for creating folder //extent-reports
		// is name of folder // creates class
		reporter.config().setReportName("GroceryApplicationProject");
		extentReports.attachReporter(reporter);

		extentReports.setSystemInfo("Organization", "Obsqura");// additional informations
		extentReports.setSystemInfo("Name", " Linta"); // provides context of the report
		return extentReports;

	}
}
