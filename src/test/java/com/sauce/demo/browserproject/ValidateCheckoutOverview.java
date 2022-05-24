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

import pageObjects.CheckoutOverviewPage;
import pageObjects.CheckoutPage;
import pageObjects.LoginPage;
import pageObjects.MyCartPage;
import pageObjects.ProductsListingPage;
import resources.BaseClass;

/**
 * This class validates the presence of locators and functionalities in the checkout overview page 
 * 
 * @author Sajesh Govindarajan
 * 22-May-2022
 */
public class ValidateCheckoutOverview extends BaseClass
{
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(ValidateCheckoutOverview.class.getName());
	 	
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 				 
	}
	
//This method validates the title, presence of web elements and product description text on the checkout overview page
	@Test(dataProvider="getData")
	public void validateCheckoutOverview(String Username,String Password,String firstName,String lastName,String postalCode) throws IOException
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
			cp.getCheckoutFirstName().sendKeys(firstName);
			cp.getCheckoutLastName().sendKeys(lastName);
			cp.getCheckoutPostalCode().sendKeys(postalCode);
			cp.getCheckoutContinue().click();
			CheckoutOverviewPage cop = new CheckoutOverviewPage(driver);
			Assert.assertTrue(cop.getCheckoutOverviewTitle().isDisplayed());
			log.info("Checkout Overview page title is displayed!");
			Assert.assertTrue(cop.getCheckoutOverviewQtyLabel().isDisplayed());
			Assert.assertEquals(cop.getCheckoutOverviewQty().getText().toString(), "1");
			Assert.assertTrue(cop.getCheckoutOverviewDescLabel().isDisplayed());
			Assert.assertTrue(cop.getCheckoutOverviewProductName().isDisplayed());
			Assert.assertEquals(cop.getCheckoutOverviewProductDesc().getText().toString(),prop.getProperty("prod_desc"));
			Assert.assertTrue(cop.getCheckoutOverviewProductPrice().isDisplayed());
			Assert.assertTrue(cop.getCheckoutOverviewPymtInfoLabel().isDisplayed());
			Assert.assertTrue(cop.getCheckoutOverviewPymtInfoValue().isDisplayed());
			Assert.assertTrue(cop.getCheckoutOverviewShippingInfoLabel().isDisplayed());
			Assert.assertTrue(cop.getCheckoutOverviewShippingInfoValue().isDisplayed());
			Assert.assertTrue(cop.getCheckoutOverviewItemSubTotal().isDisplayed());
			Assert.assertTrue(cop.getCheckoutOverviewTaxLabel().isDisplayed());
			Assert.assertTrue(cop.getCheckoutOverviewSummaryTotal().isDisplayed());
			Assert.assertTrue(cop.getCheckoutOverviewCancel().isDisplayed());
			Assert.assertTrue(cop.getCheckoutOverviewFinish().isDisplayed());
			cop.getCheckoutOverviewFinish().click();
			log.info("Finish button in the Checkout Overview is clicked!");	
			
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
