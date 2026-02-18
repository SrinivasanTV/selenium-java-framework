package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporter {

	public static ExtentReports reportconfig() {
		String path = System.getProperty("user.dir") + "\\reports\\report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Basic Test Report");
		reporter.config().setDocumentTitle("Test Result");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "s.t.v");
		return extent;
		
	}
	
}
