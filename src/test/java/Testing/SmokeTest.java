package Testing;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.ProductCatalogue;
import Testcomponents.BaseTest;

public class SmokeTest extends BaseTest {
	
	@Test(groups= {"Smoke Test"},dataProvider= "getData")
	public void StandardSmokeTest(HashMap<String,String> input) {
		login.loginApplication(input.get("userName"), input.get("password"));
		login.waitForNotificationToBeInVisible();
		login.goToHome();
		login.goToOrders();
		login.goToCart();
		login.waitForNotificationToBeInVisible();
		login.logout();
	}
	
//	@DataProvider
//	public Object[][] getData() {
//		return new Object[][] {{"ray@ben.com","RAYben123*"},{"hi@hello.com","RAYben123*"}};
//	}
	
	@DataProvider
	public Object[][] getData(){
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("userName", "ray@ben.com");
		map.put("password", "RAYben123*");
		
		HashMap<String,String> map1 = new HashMap<String,String>();
		map1.put("userName", "hi@hello.com");
		map1.put("password", "RAYben123*");
		
		return new Object[][] {{map},{map1}};
		
	}
	

}
