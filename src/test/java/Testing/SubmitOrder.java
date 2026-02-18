package Testing;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.Cart;
import PageObjects.Checkout;
import PageObjects.Orders;
import PageObjects.ProductCatalogue;
import Testcomponents.BaseTest;

public class SubmitOrder extends BaseTest {

	@Test(dataProvider="getData",groups= {"Purchase"})
	public void submitOrder(HashMap<String,String> input) {

		ProductCatalogue product = login.loginApplication(input.get("userName"), input.get("password"));
		login.waitForNotificationToBeVisible();
		product.addProductToCart(input.get("productname"));
		login.waitForNotificationToBeInVisible();
		Cart cart = product.goToCart();
		cart.checkAddedProduct(input.get("productname"));
		Checkout checkoutpage = cart.checkout();
		checkoutpage.selectCountry(input.get("country"));
		checkoutpage.placeOrder();
	}
	
	@Test(dependsOnMethods={"submitOrder"},dataProvider="getData")
	public void verifyOrderHistory(HashMap<String,String> input) {
		ProductCatalogue product = login.loginApplication(input.get("userName"), input.get("password"));
		Orders order = product.goToOrders();
		order.checkOrderedProduct(input.get("productname"));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException, Exception {
		
		List <HashMap<String,String>> data = getJsonData("S:\\eclipse\\SeleniumFramework\\src\\test\\java\\Data\\PurchaseData.json");
		return new Object[][] {{data.get(0)}, {data.get(1)}};
	}
	
//	@DataProvider
//	public Object[][] getData() {
//		return new Object[][] {{"ray@ben.com","RAYben123*","ZARA COAT 3","India"},{"hi@hello.com","RAYben123*","ADIDAS ORIGINAL","Australia"}};
//	}
	
	

}
