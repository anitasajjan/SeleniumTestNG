package Testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import Resources.baseClass;
import pageObjectModel.LoginPageObjects;

public class VerifyLogin extends baseClass {

	@Test
	public void login() throws IOException {

		initializeDriver();
		driver.get("https://login.salesforce.com/");

		LoginPageObjects LPO = new LoginPageObjects(driver);
		LPO.enterUsername().sendKeys("Anita");
		LPO.enterPassword().sendKeys("test123");
		LPO.clickLogin().click();

	}

}
