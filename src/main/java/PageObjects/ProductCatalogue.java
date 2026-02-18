package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{
	
	WebDriver driver;
	public ProductCatalogue (WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[contains(@class,'col-lg-4')]")
	List<WebElement> products;
	
	@FindBy(id = "toast-container")
	WebElement Notification;
	//div[contains(@class,'col-lg-4')]//div[@class='card-body']//button//i[contains(@class,'shopping-cart')]
	
//	By Cart = By.cssSelector(".card-body button:last-of-type");
	
	By Cart = By.xpath(".//div[@class='card-body']//button[last()]");
	
	public void addProductToCart(String productName) {
		
		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(Cart).click();
//		waitUntilElementIsVisible(Notification);
	}
	
	

}
