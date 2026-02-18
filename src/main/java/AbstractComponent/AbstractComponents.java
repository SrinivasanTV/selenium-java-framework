package AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.Cart;
import PageObjects.Orders;

public class AbstractComponents {
	WebDriver driver;
	WebDriverWait wait;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	}
	
	@FindBy(xpath="//button[contains(@routerlink,'cart')]")
	WebElement cart;
	
	@FindBy(xpath="//button[contains(@routerlink,'myorders')]")
	WebElement orders;
	
	@FindBy(xpath="//button[contains(@routerlink,'dashboard')]")
	WebElement home;
	
	@FindBy(id = "toast-container")
	WebElement Notification;
	
	public void waituntilElementIsInVisible(WebElement Element) {
		wait.until(ExpectedConditions.invisibilityOf(Element));
		
	}
	
	public void waitUntilElementIsVisible(WebElement Element) {
		wait.until(ExpectedConditions.visibilityOf(Element));
	}
	
	public void waitUnitElementPresence(By Element) {
		wait.until(ExpectedConditions.presenceOfElementLocated(Element));
	}
	
	public Cart goToCart(){
		
		cart.click();
		Cart cart = new Cart(driver);
		return cart;
	}
	public Orders goToOrders(){
//		waituntilElementIsInVisible(Notification);
		orders.click();
		Orders order = new Orders(driver);
		return order;
	}
	
	public void goToHome() {
		home.click();
	}
}
