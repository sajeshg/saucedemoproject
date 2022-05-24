package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contains the locators of Checkout Confirmation page
 * 
 * @author Sajesh Govindarajan
 * 22-May-2022
 */


public class CheckOutConfirmationPage 
{
	
	public WebDriver driver;
	private By checkoutConfirmationTitle = By.xpath("//*[text()='Checkout: Complete!']");
	private By checkoutConfirmationHeader = By.xpath("//*[text()='THANK YOU FOR YOUR ORDER']");
	private By checkoutCompleteText = By.xpath("//*[@class='complete-text']");
	private By checkoutCompleteImg = By.xpath("//img[@class='pony_express']");
	private By checkoutCompleteBackButton = By.xpath("//*[@id='back-to-products']");
	
	public CheckOutConfirmationPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public WebElement getCheckoutCompleteBackButton()
	{
		return driver.findElement(checkoutCompleteBackButton);
	}
	
	public WebElement getCheckoutCompleteImg()
	{
		return driver.findElement(checkoutCompleteImg);
	}
	
	public WebElement getCheckoutCompleteText()
	{
		return driver.findElement(checkoutCompleteText);
	}
	
	public WebElement getCheckoutConfirmationHeader()
	{
		return driver.findElement(checkoutConfirmationHeader);
	}
	
	public WebElement getCheckoutConfirmationTitle()
	{
		return driver.findElement(checkoutConfirmationTitle);
	}

}
