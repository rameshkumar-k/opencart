package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage {
	
	
	public MyAccount(WebDriver driver)
	{
		super(driver);
	}

	
	@FindBy(xpath="//h2[text()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	WebElement logout;
	
	public boolean isMyAccountDisplayed()
	{
		try
		{
			return myAccount.isDisplayed();
		}
		
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickLogout()
	{
		logout.click();
	}
}
