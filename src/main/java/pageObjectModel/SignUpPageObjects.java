package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPageObjects {
	public WebDriver driver;

	By firstname = By.xpath("//input[@name='UserFirstName']");
	By lastname = By.xpath("//input[@name='UserLastName']");
	By jobtitle = By.xpath("//input[@name='UserTitle']");
	By email = By.xpath("//input[@name='UserEmail']");
	By phone = By.xpath("//input[@name='UserPhone']");
	By employees = By.xpath("//select[@name='CompanyEmployees']");
	By company = By.xpath("//input[@name='CompanyName']");
	// By country = By.xpath("//select[@name='CompanyCountry']");

	public SignUpPageObjects(WebDriver driver2) {
		this.driver = driver2;
	}

	public WebElement enterFirstname() {
		return driver.findElement(firstname);
	}

	public WebElement enterLastname() {
		return driver.findElement(lastname);
	}

	public WebElement enterjobTitle() {
		return driver.findElement(jobtitle);
	}

	public WebElement enterEmail() {
		return driver.findElement(email);
	}

	public WebElement enterphoneNumber() {
		return driver.findElement(phone);
	}

	public WebElement enterEmployees() {
		return driver.findElement(employees);

	}

	public WebElement enterCompany() {
		return driver.findElement(company);
	}

}
