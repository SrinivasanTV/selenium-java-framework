package Testing;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Error {
	ExtentReports extent;
	
	@BeforeTest
	public void reportconfig() {
		String path = System.getProperty("user.dir") + "\\reports\\report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Basic Test Report");
		reporter.config().setDocumentTitle("Test Result");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "s.t.v");
		
	}
	
	@Test
	public void BasicTest() {

		ExtentTest test = extent.createTest("Error Validation");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("rayy@ben.com");
		driver.findElement(By.id("userPassword")).sendKeys("RAYben123*");
		driver.findElement(By.id("login")).click();
		WebElement notification = driver.findElement(By.xpath("//div[@id='toast-container']//div[contains(@class,'flyInOut')]"));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(notification));
		String notif = notification.getText();
		System.out.println(notif);
//		test.fail("Failed");
		extent.flush();

	}

}
