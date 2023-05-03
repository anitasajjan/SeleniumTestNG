package Testcases;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Resources.baseClass;
import pageObjectModel.LoginPageObjects;
import pageObjectModel.SignUpPageObjects;

public class VerifySignup extends baseClass {
	@Test
	public void signup() throws IOException, InterruptedException {
		initializeDriver();
		driver.get("https://login.salesforce.com/");

		LoginPageObjects LPO = new LoginPageObjects(driver);
		LPO.tryForFree().click();

		SignUpPageObjects SPO = new SignUpPageObjects(driver);
		Thread.sleep(5000);
		SPO.enterFirstname().sendKeys("Anita");
		SPO.enterLastname().sendKeys("Shetkar");
		SPO.enterjobTitle().sendKeys("Engineer");
		SPO.enterEmail().sendKeys("anitasajjan@gmail.com");
		SPO.enterphoneNumber().sendKeys("123456789");

		Select s = new Select(SPO.enterEmployees());
		s.selectByIndex(1);

		SPO.enterCompany().sendKeys("WIPRO");
	}
}
