package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponents;

public class Checkout extends AbstractComponents {
	
	WebDriver driver;
	public Checkout(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="//section[contains(@class,'ta-results')]/button/span")
	List<WebElement> countries;
	
	@FindBy(xpath="//a[text()=\"Place Order \"]")
	WebElement placeorder;
	
	public void selectCountry(String countryName) {
		waitUntilElementIsVisible(country);
		country.sendKeys(countryName);
		WebElement ccountry = countries.stream().filter(result->result.getText().equalsIgnoreCase(countryName)).findFirst().orElse(null);
		ccountry.click();
	}
	
	public void placeOrder() {
		placeorder.click();
	}

}
