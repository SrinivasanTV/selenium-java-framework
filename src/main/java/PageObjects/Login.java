package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponent.AbstractComponents;

public class Login extends AbstractComponents {

	WebDriver driver;

	public Login(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Page Factory Model
	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement login;
	
	@FindBy(id = "toast-container")
	WebElement Notification;
	
	@FindBy(xpath="//div[@id='toast-container']//div[contains(@class,'flyInOut')]")
	WebElement errorNotification;
	
	@FindBy(xpath = "//i[contains(@class,'sign-out')]")
	WebElement logout;
	
	//i[contains(@class,'sign-out')]

	public ProductCatalogue loginApplication(String username, String password) {

		userEmail.sendKeys(username);
		userPassword.sendKeys(password);
		login.click();
//		waituntilElementIsInVisible(loginNotification);
		ProductCatalogue product = new ProductCatalogue(driver);
		return product;
	}

	public void goToPage() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	public String loginError()
	{
		waitUntilElementIsVisible(errorNotification);
		return errorNotification.getText();
	}
	public void waitForNotificationToBeVisible() {
		waitUntilElementIsVisible(Notification);
	}
	public void waitForNotificationToBeInVisible() {
		waituntilElementIsInVisible(Notification);
	}
	
	public void logout() {
		logout.click();
	}
	
}
