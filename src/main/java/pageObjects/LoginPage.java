package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * This class contains the locators of login page
 * 
 * @author Sajesh Govindarajan
 * 22-May-2022
 */

public class LoginPage 
{
	public WebDriver driver;
	
	private By logoSwaglabs = By.cssSelector("[class='login_logo']");
	private By userName = By.cssSelector("[id='user-name']");
	private By password = By.cssSelector("[id='password']");
	private By loginButton = By.cssSelector("[id='login-button']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getLogo()
	{
		return driver.findElement(logoSwaglabs);
	}
	
	public WebElement getUsername()
	{
		return driver.findElement(userName);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getLoginButton()
	{
		return driver.findElement(loginButton);
	}
	
}
