package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponent.AbstractComponents;

public class Cart extends AbstractComponents {
	
	WebDriver driver;
	
	public Cart(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartproducts;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkout;
	
	@FindBy(id = "toast-container")
	WebElement Notification;
	
	
	
	public void checkAddedProduct(String productname) {
		Boolean match = cartproducts.stream().anyMatch(cartprod->cartprod.getText().equalsIgnoreCase(productname));
		Assert.assertTrue(match);
	}
	
	public Checkout checkout() {
		checkout.click();
		Checkout checkoutpage = new Checkout(driver);
		return checkoutpage;
	}
}
