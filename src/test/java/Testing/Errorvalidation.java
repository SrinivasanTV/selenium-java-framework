package Testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import Testcomponents.BaseTest;
import Testcomponents.Retry;

public class Errorvalidation extends BaseTest {

	@Test(retryAnalyzer=Retry.class)
	public void loginErrorvalidation() {

		String username = "rayy@ben.com";
		String password = "RAYben123*";
		login.loginApplication(username, password);
		String notification = login.loginError();
		Assert.assertEquals("Incorrect email or password.", notification);
	}

}
