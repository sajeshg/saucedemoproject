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
import pageObjects.ProductsListingPage;
import resources.BaseClass;

/**
 * This class validates the presence of locators and functionalities in the products listing page 
 * 
 * @author Sajesh Govindarajan
 * 22-May-2022
 */
public class ValidateProducts extends BaseClass
{
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(ValidateProducts.class.getName());
	 	
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 				 
	}
	
//This method validates the web elements, scroll & search the particular product, and adds the product to cart
	@Test(dataProvider="getData")
	public void addProductToCart(String Username,String Password) throws IOException
	{
			LoginPage lp=new LoginPage(driver);
			driver.get(prop.getProperty("url"));
			lp.getUsername().sendKeys(Username);
			lp.getPassword().sendKeys(Password);
			lp.getLoginButton().click();
			ProductsListingPage pl =new ProductsListingPage(driver);
			Assert.assertTrue(pl.getProductsTitle().isDisplayed());
			log.info("Products Page is loaded!!");
			Assert.assertTrue(pl.getProductsFilter().isDisplayed());
			Assert.assertTrue(pl.getShoppingCartLink().isDisplayed());
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", pl.getProductName());
			pl.getAddToCartButton().click();
			Assert.assertTrue(pl.getShoppingCartBadge().getText().toString().trim().equals("1"));
			Assert.assertTrue(pl.getRemoveButton().isDisplayed());
			log.info("Product added to cart successfully!!");	
			
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
