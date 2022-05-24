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

import pageObjects.CheckoutPage;
import pageObjects.LoginPage;
import pageObjects.MyCartPage;
import pageObjects.ProductsListingPage;
import resources.BaseClass;

/**
 * This class validates the presence of locators and functionalities in the checkout information page 
 * 
 * @author Sajesh Govindarajan
 * 22-May-2022
 */
public class ValidateCheckoutInformation extends BaseClass
{
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(ValidateCheckoutInformation.class.getName());
	 	
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 				 
	}
	
//This method fills the form with the required inputs and click on continue button on checkout information page
	@Test(dataProvider="getData")
	public void validateCheckoutInfo(String Username,String Password,String firstName,String lastName,String postalCode) throws IOException
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
			mcp.getCartCheckoutButton().click();
			CheckoutPage cp = new CheckoutPage(driver);
			Assert.assertTrue(cp.getCheckoutTitle().isDisplayed());
			log.info("Checkout Information page title is displayed!");
			cp.getCheckoutFirstName().sendKeys(firstName);
			cp.getCheckoutLastName().sendKeys(lastName);
			cp.getCheckoutPostalCode().sendKeys(postalCode);
			Assert.assertTrue(cp.getCheckoutCancel().isDisplayed());
			Assert.assertTrue(cp.getCheckoutContinue().isDisplayed());
			cp.getCheckoutContinue().click();
			log.info("Continue button on checkout your information page is clicked!");
			
	}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();	
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		
		Object[][] data=new Object[1][5];
		data[0][0]="standard_user";
		data[0][1]="secret_sauce";
		data[0][2]="Sam";
		data[0][3]="Billings";
		data[0][4]="75039";				
		return data;		
		
	}
}
