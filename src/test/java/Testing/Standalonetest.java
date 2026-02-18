package Testing;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PageObjects.Login;


public class Standalonetest {

	public static void main(String[] args) {
		
		String productname = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("ray@ben.com");
		driver.findElement(By.id("userPassword")).sendKeys("RAYben123*");
		driver.findElement(By.id("login")).click();
//		Assert.assertEquals(driver.findElements(By.id("toast-container")), "Login Successfully");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("toast-container")));
		List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));
		WebElement prod = products.stream().filter(product->
				product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		prod.findElement(By.xpath("//div[@class=\"card-body\"]/button/i[contains(@class,\"shopping-cart\")]")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("toast-container")));
//		Assert.assertEquals(driver.findElements(By.id("toast-container")), "Product Added To Cart");
		String Notification = driver.findElement(By.id("toast-container")).getText();
		System.out.println(Notification);
//		Assert.assertEquals(driver.findElements(By.id("toast-container")), "Product Added To Cart");
		driver.findElement(By.xpath("//button[contains(@routerlink,\"cart\")]")).click();
		List<WebElement> cartprods = driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match = cartprods.stream().anyMatch(cartprod->cartprod.getText().equalsIgnoreCase(productname));
		Assert.assertTrue(match);
		driver.findElement(By.xpath("//button[text()=\"Checkout\"]")).click();
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "India").build().perform();
		List<WebElement> results = driver.findElements(By.xpath("//section[contains(@class,'ta-results')]/button/span"));
		WebElement country = results.stream().filter(result->result.getText().equalsIgnoreCase("india")).findFirst().orElse(null);
		country.click();
		driver.findElement(By.xpath("//a[text()=\"Place Order \"]")).click();
		driver.close();
	}

}
