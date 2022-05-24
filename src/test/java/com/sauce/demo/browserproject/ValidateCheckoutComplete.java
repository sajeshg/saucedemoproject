package com.sauce.demo.browserproject;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.CheckOutConfirmationPage;
import pageObjects.CheckoutOverviewPage;
import pageObjects.CheckoutPage;
import pageObjects.LoginPage;
import pageObjects.MyCartPage;
import pageObjects.ProductsListingPage;
import resources.BaseClass;

/**
 * This class validates the presence of locators and functionalities in the checkout complete page 
 * 
 * @author Sajesh Govindarajan
 * 22-May-2022
 */

public class ValidateCheckoutComplete extends BaseClass
{
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(ValidateCheckoutComplete.class.getName());
	 	
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 				 
	}
	
 
 //This method validates the checkout title, header, text and click the back button on the checkout complete page 

	@Test(dataProvider="getData")
	public void validateCheckoutComplete(String Username,String Password,String firstName,String lastName,String postalCode) throws IOException
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
			cop.getCheckoutOverviewFinish().click();
			CheckOutConfirmationPage coc = new CheckOutConfirmationPage(driver);
			Assert.assertTrue(coc.getCheckoutConfirmationTitle().isDisplayed());
			log.info("Checkout Complete page title is displayed!");
			Assert.assertEquals(coc.getCheckoutConfirmationHeader().getText().toString(),prop.getProperty("confirmation_header"));
			Assert.assertEquals(coc.getCheckoutCompleteText().getText().toString(),prop.getProperty("confirmation_text"));
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(coc.getCheckoutCompleteImg()));
			Assert.assertTrue(coc.getCheckoutCompleteImg().isDisplayed());
			Assert.assertTrue(coc.getCheckoutCompleteBackButton().isDisplayed());
			coc.getCheckoutCompleteBackButton().click();
			js.executeScript("arguments[0].scrollIntoView();", pl.getProductsTitle());
			Assert.assertTrue(pl.getProductsTitle().isDisplayed());
			log.info("Clicked the back button on checkout complete page. Redirected successfully to products page!");	
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
