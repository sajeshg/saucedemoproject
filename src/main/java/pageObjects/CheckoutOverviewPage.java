package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contains the locators of Checkout Overview page
 * 
 * @author Sajesh Govindarajan
 * 22-May-2022
 */

public class CheckoutOverviewPage 
{
	
	public WebDriver driver;
	private By checkoutOverviewTitle = By.xpath("//*[text()='Checkout: Overview']");
	private By checkoutOverviewQtyLabel	 = By.xpath("//div[@class='cart_quantity_label']");
	private By checkoutOverviewDescLabel = By.xpath("//div[@class='cart_desc_label']");
	private By checkoutOverviewQty = By.xpath("//div[@class='cart_quantity']");
	private By checkoutOverviewProductName = By.xpath("//*[contains(text(),'Sauce Labs Fleece Jacket')]");
	private By checkoutOverviewProductDesc = By.xpath("//*[@class='inventory_item_desc']");
	private By checkoutOverviewProductPrice = By.xpath("//*[@class='inventory_item_price']");
	private By checkoutOverviewPymtInfoLabel = By.xpath("(//*[@class='summary_info_label'])[1]");
	private By checkoutOverviewShippingInfoLabel = By.xpath("(//*[@class='summary_info_label'])[2]");
	private By checkoutOverviewPymtInfoValue = By.xpath("(//*[@class='summary_value_label'])[1]");
	private By checkoutOverviewShippingInfoValue = By.xpath("(//*[@class='summary_value_label'])[1]");
	private By checkoutOverviewItemSubTotal = By.xpath("//*[@class='summary_subtotal_label']");
	private By checkoutOverviewTaxLabel = By.xpath("//*[@class='summary_tax_label']");
	private By checkoutOverviewSummaryTotal = By.xpath("//*[@class='summary_total_label']");
	private By checkoutOverviewCancel = By.xpath("//*[@id='cancel']");
	private By checkoutOverviewFinish = By.xpath("//*[@id='finish']");
	
	public CheckoutOverviewPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public WebElement getCheckoutOverviewTitle()
	{
		return driver.findElement(checkoutOverviewTitle);
	}
	
	public WebElement getCheckoutOverviewQtyLabel()
	{
		return driver.findElement(checkoutOverviewQtyLabel);
	}
	
	public WebElement getCheckoutOverviewDescLabel()
	{
		return driver.findElement(checkoutOverviewDescLabel);
	}
	
	public WebElement getCheckoutOverviewQty()
	{
		return driver.findElement(checkoutOverviewQty);
	}
	
	public WebElement getCheckoutOverviewProductName()
	{
		return driver.findElement(checkoutOverviewProductName);
	}
	
	public WebElement getCheckoutOverviewProductDesc()
	{
		return driver.findElement(checkoutOverviewProductDesc);
	}
	
	public WebElement getCheckoutOverviewProductPrice()
	{
		return driver.findElement(checkoutOverviewProductPrice);
	}
	
	public WebElement getCheckoutOverviewPymtInfoLabel()
	{
		return driver.findElement(checkoutOverviewPymtInfoLabel);
	}
	
	public WebElement getCheckoutOverviewShippingInfoLabel()
	{
		return driver.findElement(checkoutOverviewShippingInfoLabel);
	}
	
	public WebElement getCheckoutOverviewPymtInfoValue()
	{
		return driver.findElement(checkoutOverviewPymtInfoValue);
	}
	
	public WebElement getCheckoutOverviewShippingInfoValue()
	{
		return driver.findElement(checkoutOverviewShippingInfoValue);
	}
	
	public WebElement getCheckoutOverviewItemSubTotal()
	{
		return driver.findElement(checkoutOverviewItemSubTotal);
	}
	
	public WebElement getCheckoutOverviewTaxLabel()
	{
		return driver.findElement(checkoutOverviewTaxLabel);
	}
	
	public WebElement getCheckoutOverviewSummaryTotal()
	{
		return driver.findElement(checkoutOverviewSummaryTotal);
	}
	
	public WebElement getCheckoutOverviewCancel()
	{
		return driver.findElement(checkoutOverviewCancel);
	}
	
	public WebElement getCheckoutOverviewFinish()
	{
		return driver.findElement(checkoutOverviewFinish);
	}

}
