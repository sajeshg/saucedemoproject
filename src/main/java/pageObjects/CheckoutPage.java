package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contains the locators of Checkout information page
 * 
 * @author Sajesh Govindarajan
 * 22-May-2022
 */

public class CheckoutPage 
{
	public WebDriver driver;
	private By checkoutTitle = By.xpath("//*[text()='Checkout: Your Information']");
	private By checkoutBadge = By.xpath("//*[@id='shopping_cart_container']/a/span");
	private By checkoutFirstName = By.xpath("//*[@id='first-name']");
	private By checkoutLastName = By.xpath("//*[@id='last-name']");
	private By checkoutPostalCode = By.xpath("//*[@id='postal-code']");
	private By checkoutCancel = By.xpath("//*[@id='cancel']");
	private By checkoutContinue = By.xpath("//*[@id='continue']");
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public WebElement getCheckoutContinue()
	{
		return driver.findElement(checkoutContinue);
	}
	
	public WebElement getCheckoutCancel()
	{
		return driver.findElement(checkoutCancel);
	}
	
	public WebElement getCheckoutPostalCode()
	{
		return driver.findElement(checkoutPostalCode);
	}
	
	public WebElement getCheckoutLastName()
	{
		return driver.findElement(checkoutLastName);
	}
	
	public WebElement getCheckoutFirstName()
	{
		return driver.findElement(checkoutFirstName);
	}
	
	public WebElement getCheckoutBadge()
	{
		return driver.findElement(checkoutBadge);
	}
	
	public WebElement getCheckoutTitle()
	{
		return driver.findElement(checkoutTitle);
	}
}
