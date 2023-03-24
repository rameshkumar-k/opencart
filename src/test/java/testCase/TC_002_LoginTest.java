package testCase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.HomePage;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
	
	
	@Test(groups= {"Sanity","Master"})
	public void test_login()
	{
		try
		{
		logger.info("*** Starting TC_002_LoginTest ***");
		HomePage hp= new HomePage(driver);
		hp.click_MyAccount();
		logger.info("Clicked on My Account");
		hp.click_Login();
		logger.info("Clicked on Login");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(rb.getString("email"));
		logger.info("Entered Email...");
		lp.setPassword(rb.getString("password"));
		logger.info("Entered Password...");
		lp.clickLogin();
		logger.info("Clicked Login...");
		
		MyAccount mc=new MyAccount(driver);
		boolean targetPage=mc.isMyAccountDisplayed();
		Assert.assertEquals(targetPage, true);
		
		}
		
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*** Finished TC_002_LoginTest ***");
		
	}

}
