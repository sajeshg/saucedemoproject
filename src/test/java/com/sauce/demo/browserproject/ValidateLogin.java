package com.sauce.demo.browserproject;

import org.openqa.selenium.WebDriver;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProductsListingPage;
import resources.BaseClass;

/**
 * This class validates the login functionality
 * 
 * @author Sajesh Govindarajan
 * 22-May-2022
 */
public class ValidateLogin extends BaseClass
{
	
	public WebDriver driver;
		
	 public static Logger log =LogManager.getLogger(ValidateLogin.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 
	}

//This method loads the URL, validates the logo and gets the username and password from data provider and click on login button
	@Test(dataProvider="getData")
	public void validateUserLogin(String Username,String Password) throws IOException
	{

			LoginPage lp=new LoginPage(driver);
			driver.get(prop.getProperty("url"));
			Assert.assertTrue(lp.getLogo().isDisplayed());
			log.info("Logo is displayed on the login page!");
			lp.getUsername().sendKeys(Username);
			lp.getPassword().sendKeys(Password);
			lp.getLoginButton().click();
			log.info("Login Button Clicked!!");	
			//To validate the successful loading of products page.
			ProductsListingPage pl =new ProductsListingPage(driver);
			Assert.assertTrue(pl.getProductsTitle().isDisplayed());
			log.info("Login Successful!!");		
			
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
