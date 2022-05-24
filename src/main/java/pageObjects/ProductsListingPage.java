package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contains the locators of products listing page
 * 
 * @author Sajesh Govindarajan
 * 22-May-2022
 */

public class ProductsListingPage 
{
	
	public WebDriver driver;
	
	private By productsTitle = By.xpath("//*[@id='header_container']/div[2]/span");
	private By productsFilter = By.xpath("//*[@id='header_container']/div[2]/div[2]/span/select");
	private By productName = By.xpath("//*[contains(text(),'Sauce Labs Fleece Jacket')]");
	private By addToCartButton	 = By.id("add-to-cart-sauce-labs-fleece-jacket");
	private By removeButton = By.id("remove-sauce-labs-fleece-jacket");
	private By shoppingCartLink = By.xpath("//*[@id='shopping_cart_container']/a");
	private By shoppingCartBadge = By.xpath("//*[@id='shopping_cart_container']/a/span");
	
	public ProductsListingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getProductsTitle()
	{
		return driver.findElement(productsTitle);
	}
	
	public WebElement getProductsFilter()
	{
		return driver.findElement(productsFilter);
	}
	
	public WebElement getProductName()
	{
		return driver.findElement(productName);
	}
	
	public WebElement getAddToCartButton()
	{
		return driver.findElement(addToCartButton);
	}
	
	public WebElement getRemoveButton()
	{
		return driver.findElement(removeButton);
	}
	
	public WebElement getShoppingCartLink()
	{
		return driver.findElement(shoppingCartLink);
	}
	
	public WebElement getShoppingCartBadge()
	{
		return driver.findElement(shoppingCartBadge);
	}

}
