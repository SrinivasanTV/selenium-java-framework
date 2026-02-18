package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponent.AbstractComponents;

public class Orders extends AbstractComponents {
	
	WebDriver driver;
	
	public Orders(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tr/td[2]")
	List<WebElement> orders;
	
	public void checkOrderedProduct(String productname) {
		Boolean match = orders.stream().anyMatch(cartprod->cartprod.getText().equalsIgnoreCase(productname));
		Assert.assertTrue(match);
	}
	
}