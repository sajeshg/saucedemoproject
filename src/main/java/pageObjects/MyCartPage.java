package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contains the locators of shopping cart page
 * 
 * @author Sajesh Govindarajan
 * 22-May-2022
 */

public class MyCartPage
{
public WebDriver driver;
	
	private By cartTitle = By.xpath("//*[text()='Your Cart']");
	private By cartQtyLabel	 = By.xpath("//*[@id='cart_contents_container']//div[@class='cart_quantity_label']");
	private By cartDescLabel = By.xpath("//*[@id='cart_contents_container']//div[@class='cart_desc_label']");
	private By cartQty = By.xpath("//*[@id='cart_contents_container']//div[@class='cart_quantity']");
	private By cartProductName = By.xpath("//*[contains(text(),'Sauce Labs Fleece Jacket')]");
	private By cartProductDesc = By.xpath("//*[@class='inventory_item_desc']");
	private By cartProductPrice = By.xpath("//*[@class='inventory_item_price']");
	private By cartRemoveButton = By.id("remove-sauce-labs-fleece-jacket");
	private By cartContinueShoppingButton = By.id("continue-shopping");
	private By cartCheckoutButton = By.id("checkout");
	
		
	public MyCartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getCartTitle()
	{
		return driver.findElement(cartTitle);
	}
	
	public WebElement getCartQtyLabel()
	{
		return driver.findElement(cartQtyLabel);
	}
	
	public WebElement getCartDescLabel()
	{
		return driver.findElement(cartDescLabel);
	}
	
	public WebElement getCartQty()
	{
		return driver.findElement(cartQty);
	}
	
	public WebElement getCartProductName()
	{
		return driver.findElement(cartProductName);
	}
	
	public WebElement getCartProductDesc()
	{
		return driver.findElement(cartProductDesc);
	}
	
	public WebElement getCartProductPrice()
	{
		return driver.findElement(cartProductPrice);
	}
	
	public WebElement getCartRemoveButton()
	{
		return driver.findElement(cartRemoveButton);
	}
	
	public WebElement getCartContinueShoppingButton()
	{
		return driver.findElement(cartContinueShoppingButton);
	}
	
	public WebElement getCartCheckoutButton()
	{
		return driver.findElement(cartCheckoutButton);
	}
}
