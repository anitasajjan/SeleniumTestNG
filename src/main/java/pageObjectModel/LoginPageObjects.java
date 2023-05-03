package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {
	public WebDriver driver;
	By username = By.xpath("//input[@id='username']");
	By password = By.xpath("//input[@id='password']");
	By login = By.xpath("//input[@id='Login']");
	By tryForFree = By.xpath("//a[@id='signup_link']");

	public LoginPageObjects(WebDriver driver2) {
		this.driver=driver2;
	}

	public WebElement enterUsername() {
		return driver.findElement(username);
	}

	public WebElement enterPassword() {
		return driver.findElement(password);
	}

	public WebElement clickLogin() {
		return driver.findElement(login);
	}

	public WebElement tryForFree() {
		return driver.findElement(tryForFree);
	}
}
