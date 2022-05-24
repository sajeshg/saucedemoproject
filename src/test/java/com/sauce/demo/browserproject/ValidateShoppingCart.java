package com.sauce.demo.browserproject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.MyCartPage;
import pageObjects.ProductsListingPage;
import resources.BaseClass;

/**
 * This class validates the presence of locators and functionalities in the shopping cart page 
 * 
 * @author Sajesh Govindarajan
 * 22-May-2022
 */
public class ValidateShoppingCart extends BaseClass
{
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(ValidateShoppingCart.class.getName());
	 	
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 				 
	}
	
/*This method validates the title, web elements on the shopping cart page and 
  compares the product name in the shopping cart with the name of the product added
  and click the checkout button 
*/
	@Test(dataProvider="getData")
	public void validateCartItems(String Username,String Password) throws IOException
	{
			LoginPage lp=new LoginPage(driver);
			driver.get(prop.getProperty("url"));
			lp.getUsername().sendKeys(Username);
			lp.getPassword().sendKeys(Password);
			lp.getLoginButton().click();
			ProductsListingPage pl =new ProductsListingPage(driver);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", pl.getProductName());
			pl.getAddToCartButton().click();
			js.executeScript("arguments[0].scrollIntoView();", pl.getShoppingCartBadge());
			pl.getShoppingCartBadge().click();
			MyCartPage mcp = new MyCartPage(driver);
			Assert.assertTrue(mcp.getCartTitle().isDisplayed());
			log.info("My Cart title is displayed!");
			Assert.assertTrue(mcp.getCartQtyLabel().isDisplayed());
			Assert.assertEquals(mcp.getCartQty().getText().toString().trim(),"1");
			Assert.assertTrue(mcp.getCartDescLabel().isDisplayed());
			Assert.assertTrue(mcp.getCartProductDesc().isDisplayed());
			Assert.assertTrue(mcp.getCartProductName().isDisplayed());
			Assert.assertEquals(pl.getProductName().getText().toString(),mcp.getCartProductName().getText().toString());
			log.info("Product in My Cart is matching with the item added from product listing!");
			Assert.assertEquals(mcp.getCartProductDesc().getText().toString(), prop.getProperty("prod_desc"));
			log.info("Product description in the cart is displayed as expected!");
			Assert.assertTrue(mcp.getCartRemoveButton().isDisplayed());
			Assert.assertTrue(mcp.getCartContinueShoppingButton().isDisplayed());
			Assert.assertTrue(mcp.getCartCheckoutButton().isDisplayed());
			mcp.getCartCheckoutButton().click();
			log.info("Checkout button on My Cart page is clicked!");	
			
	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();	
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		
		Object[][] data=new Object[1][2];
		data[0][0]="standard_user";
		data[0][1]="secret_sauce";
		return data;		
		
	}

}
